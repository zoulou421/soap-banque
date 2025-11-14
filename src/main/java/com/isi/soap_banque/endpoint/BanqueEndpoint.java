package com.isi.soap_banque.endpoint;

import com.isi.soap_banque.generated.GetAccountRequest;
import com.isi.soap_banque.generated.GetAccountResponse;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class BanqueEndpoint {

    private static final String NAMESPACE_URI = "http://isi.com/banque";

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "getAccountRequest")
    @ResponsePayload
    public GetAccountResponse getAccount(@RequestPayload GetAccountRequest request) {
        GetAccountResponse response = new GetAccountResponse();

        // Logique métier - exemple simple
        String accountNumber = request.getAccountNumber();

        // Simuler une récupération de solde
        double balance = calculateBalance(accountNumber);

        response.setBalance(balance);
        return response;
    }

    // Méthode d'exemple pour calculer le solde
    private double calculateBalance(String accountNumber) {
        // Logique métier réelle ici (base de données, etc.)
        // Pour l'exemple, on retourne un solde fictif
        return switch (accountNumber) {
            case "12345" -> 5000.50;
            case "67890" -> 15000.75;
            default -> 1000.00;
        };
    }
}
