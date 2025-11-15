package com.isi.soap_banque.repository;

import com.isi.soap_banque.generated.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import com.isi.soap_banque.transaction.*;

@Repository
public class ClientRepository {

    private final Map<Long,ClientInfo> clients = new HashMap<>();

    public ClientRepository() {
        // Données de test
        ClientInfo client1 = new ClientInfo();
        client1.setNumeroTel(221771234567L);
        client1.setSolde(50000L);
        clients.put(221771234567L, client1);

        ClientInfo client2 = new ClientInfo();
        client2.setNumeroTel(221775555555L);
        client2.setSolde(25000L);
        clients.put(221775555555L, client2);
    }

    public Optional<ClientInfo> findByNumeroTel(Long numeroTel) {
        return Optional.ofNullable(clients.get(numeroTel));
    }

    public ClientInfo save(ClientInfo client) {
        clients.put(client.getNumeroTel(), client);
        return client;
    }

    public boolean existsByNumeroTel(Long numeroTel) {
        return clients.containsKey(numeroTel);
    }

    public void updateSolde(Long numeroTel, Long newSolde) {
        ClientInfo client = clients.get(numeroTel);
        if (client != null) {
            client.setSolde(newSolde);
        }
    }
}