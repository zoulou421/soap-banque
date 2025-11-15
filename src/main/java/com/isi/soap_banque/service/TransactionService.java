package com.isi.soap_banque.service;

import com.isi.soap_banque.exceptions.*;
import com.isi.soap_banque.transaction.*;

import com.isi.soap_banque.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionService {

    private final ClientRepository clientRepository;

    /**
     * Ajoute un nouveau client
     */
    public ClientInfo addClient(ClientInfo clientInfo) {
        log.info("Ajout d'un nouveau client avec le numéro: {}", clientInfo.getNumeroTel());

        // Vérifier si le client existe déjà
        if (clientRepository.existsByNumeroTel(clientInfo.getNumeroTel())) {
            throw new ClientAlreadyExistsException(
                    "Client avec le numéro " + clientInfo.getNumeroTel() + " existe déjà"
            );
        }

        ClientInfo savedClient = clientRepository.save(clientInfo);
        log.info("Client créé avec succès: {}", savedClient.getNumeroTel());

        return savedClient;
    }

    /**
     * Récupère le solde d'un client
     */
    public Long getSolde(Long numeroTel) {
        log.info("Récupération du solde pour le numéro: {}", numeroTel);

        ClientInfo client = clientRepository.findByNumeroTel(numeroTel)
                .orElseThrow(() -> new ClientNotFoundException("Client non trouvé: " + numeroTel));

        log.info("Solde récupéré: {} pour le client: {}", client.getSolde(), numeroTel);
        return client.getSolde();
    }

    /**
     * Effectue un transfert entre deux clients
     */
    public void addTransfer(TransferInfo transferInfo) {
        log.info("Transfert de {} de {} vers {}",
                transferInfo.getAmountSent(),
                transferInfo.getNumberSender(),
                transferInfo.getNumberReceive());

        // Vérifier l'expéditeur
        ClientInfo sender = clientRepository.findByNumeroTel(transferInfo.getNumberSender())
                .orElseThrow(() -> new ClientNotFoundException(
                        "Expéditeur non trouvé: " + transferInfo.getNumberSender()
                ));

        // Vérifier le destinataire
        ClientInfo receiver = clientRepository.findByNumeroTel(transferInfo.getNumberReceive())
                .orElseThrow(() -> new ClientNotFoundException(
                        "Destinataire non trouvé: " + transferInfo.getNumberReceive()
                ));

        // Vérifier le solde
        if (sender.getSolde() < transferInfo.getAmountSent()) {
            throw new InsufficientBalanceException(
                    "Solde insuffisant pour le client " + transferInfo.getNumberSender() +
                            ". Solde actuel: " + sender.getSolde() +
                            ", Montant demandé: " + transferInfo.getAmountSent()
            );
        }

        // Effectuer le transfert
        clientRepository.updateSolde(
                transferInfo.getNumberSender(),
                sender.getSolde() - transferInfo.getAmountSent()
        );
        clientRepository.updateSolde(
                transferInfo.getNumberReceive(),
                receiver.getSolde() + transferInfo.getAmountSent()
        );

        log.info("Transfert effectué avec succès");
    }

    /**
     * Effectue un paiement vers un client
     */
    public void addPayment(PaymentInfo paymentInfo) {
        log.info("Paiement de {} vers {}",
                paymentInfo.getAmountSent(),
                paymentInfo.getNumberReceive());

        // Vérifier le destinataire
        ClientInfo receiver = clientRepository.findByNumeroTel(paymentInfo.getNumberReceive())
                .orElseThrow(() -> new ClientNotFoundException(
                        "Destinataire non trouvé: " + paymentInfo.getNumberReceive()
                ));

        // Ajouter le montant au solde
        clientRepository.updateSolde(
                paymentInfo.getNumberReceive(),
                receiver.getSolde() + paymentInfo.getAmountSent()
        );

        log.info("Paiement effectué avec succès");
    }
}