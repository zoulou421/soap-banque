package com.isi.soap_banque.endpoint;

import com.isi.soap_banque.exceptions.*;
import com.isi.soap_banque.transaction.*;
import com.isi.soap_banque.service.TransactionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@RequiredArgsConstructor
@Slf4j
public class TransactionEndpoint {

    private static final String NAMESPACE_URI = "http://www.esmt.com/banque";

    private final TransactionService transactionService;

    // ============= AJOUTER UN CLIENT =============
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addClientRequest")
    @ResponsePayload
    public ClientResponse addClient(@RequestPayload AddClientRequest request) {
        log.info("Requête SOAP: addClient");

        ClientResponse response = new ClientResponse();
        ServiceStatus status = new ServiceStatus();

        try {
            ClientInfo clientInfo = transactionService.addClient(request.getClient());

            status.setStatus("SUCCESS");
            status.setMessage("Client ajouté avec succès");

            response.setStatus(status);
            response.setClient(clientInfo);

        } catch (ClientAlreadyExistsException e) {
            log.error("Erreur: {}", e.getMessage());
            status.setStatus("ERROR");
            status.setMessage(e.getMessage());
            response.setStatus(status);
            response.setClient(request.getClient());
        }

        return response;
    }

    // ============= OBTENIR LE SOLDE =============
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getSoldeRequest")
    @ResponsePayload
    public SoldeResponse getSolde(@RequestPayload GetSoldeRequest request) {
        log.info("Requête SOAP: getSolde pour {}", request.getTel());

        SoldeResponse response = new SoldeResponse();

        try {
            Long solde = transactionService.getSolde(request.getTel());
            response.setSolde(solde);
        } catch (ClientNotFoundException e) {
            log.error("Erreur: {}", e.getMessage());
            response.setSolde(0L);
        }

        return response;
    }

    // ============= EFFECTUER UN TRANSFERT =============
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addTransferRequest")
    @ResponsePayload
    public TransferResponse addTransfer(@RequestPayload AddTransferRequest request) {
        log.info("Requête SOAP: addTransfer");

        TransferResponse response = new TransferResponse();
        ServiceStatus status = new ServiceStatus();

        try {
            transactionService.addTransfer(request.getTransfer());

            status.setStatus("SUCCESS");
            status.setMessage("Transfert effectué avec succès");

        } catch (ClientNotFoundException | InsufficientBalanceException e) {
            log.error("Erreur: {}", e.getMessage());
            status.setStatus("ERROR");
            status.setMessage(e.getMessage());
        }

        response.setTransfer(request.getTransfer());
        response.setStatus(status);

        return response;
    }

    // ============= EFFECTUER UN PAIEMENT =============
    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "addPaymentRequest")
    @ResponsePayload
    public PaymentResponse addPayment(@RequestPayload AddPaymentRequest request) {
        log.info("Requête SOAP: addPayment");

        PaymentResponse response = new PaymentResponse();
        ServiceStatus status = new ServiceStatus();

        try {
            transactionService.addPayment(request.getPayment());

            status.setStatus("SUCCESS");
            status.setMessage("Paiement effectué avec succès");

        } catch (ClientNotFoundException e) {
            log.error("Erreur: {}", e.getMessage());
            status.setStatus("ERROR");
            status.setMessage(e.getMessage());
        }

        response.setPayment(request.getPayment());
        response.setStatus(status);

        return response;
    }
}