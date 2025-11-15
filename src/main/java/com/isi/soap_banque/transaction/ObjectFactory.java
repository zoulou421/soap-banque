//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.0 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2025.11.15 à 01:54:55 AM CET 
//


package com.isi.soap_banque.transaction;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.isi.soap_banque.transaction package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.isi.soap_banque.transaction
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AddClientRequest }
     * 
     */
    public AddClientRequest createAddClientRequest() {
        return new AddClientRequest();
    }

    /**
     * Create an instance of {@link ClientInfo }
     * 
     */
    public ClientInfo createClientInfo() {
        return new ClientInfo();
    }

    /**
     * Create an instance of {@link ClientResponse }
     * 
     */
    public ClientResponse createClientResponse() {
        return new ClientResponse();
    }

    /**
     * Create an instance of {@link ServiceStatus }
     * 
     */
    public ServiceStatus createServiceStatus() {
        return new ServiceStatus();
    }

    /**
     * Create an instance of {@link GetSoldeRequest }
     * 
     */
    public GetSoldeRequest createGetSoldeRequest() {
        return new GetSoldeRequest();
    }

    /**
     * Create an instance of {@link SoldeResponse }
     * 
     */
    public SoldeResponse createSoldeResponse() {
        return new SoldeResponse();
    }

    /**
     * Create an instance of {@link AddTransferRequest }
     * 
     */
    public AddTransferRequest createAddTransferRequest() {
        return new AddTransferRequest();
    }

    /**
     * Create an instance of {@link TransferInfo }
     * 
     */
    public TransferInfo createTransferInfo() {
        return new TransferInfo();
    }

    /**
     * Create an instance of {@link TransferResponse }
     * 
     */
    public TransferResponse createTransferResponse() {
        return new TransferResponse();
    }

    /**
     * Create an instance of {@link AddPaymentRequest }
     * 
     */
    public AddPaymentRequest createAddPaymentRequest() {
        return new AddPaymentRequest();
    }

    /**
     * Create an instance of {@link PaymentInfo }
     * 
     */
    public PaymentInfo createPaymentInfo() {
        return new PaymentInfo();
    }

    /**
     * Create an instance of {@link PaymentResponse }
     * 
     */
    public PaymentResponse createPaymentResponse() {
        return new PaymentResponse();
    }

}
