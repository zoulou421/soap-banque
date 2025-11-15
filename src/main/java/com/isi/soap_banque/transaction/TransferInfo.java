//
// Ce fichier a été généré par Eclipse Implementation of JAXB, v3.0.0 
// Voir https://eclipse-ee4j.github.io/jaxb-ri 
// Toute modification apportée à ce fichier sera perdue lors de la recompilation du schéma source. 
// Généré le : 2025.11.15 à 01:54:55 AM CET 
//


package com.isi.soap_banque.transaction;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java pour transferInfo complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="transferInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numberSender" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="numberReceive" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="amountSent" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transferInfo", propOrder = {
    "numberSender",
    "numberReceive",
    "amountSent"
})
public class TransferInfo {

    protected long numberSender;
    protected long numberReceive;
    protected long amountSent;

    /**
     * Obtient la valeur de la propriété numberSender.
     * 
     */
    public long getNumberSender() {
        return numberSender;
    }

    /**
     * Définit la valeur de la propriété numberSender.
     * 
     */
    public void setNumberSender(long value) {
        this.numberSender = value;
    }

    /**
     * Obtient la valeur de la propriété numberReceive.
     * 
     */
    public long getNumberReceive() {
        return numberReceive;
    }

    /**
     * Définit la valeur de la propriété numberReceive.
     * 
     */
    public void setNumberReceive(long value) {
        this.numberReceive = value;
    }

    /**
     * Obtient la valeur de la propriété amountSent.
     * 
     */
    public long getAmountSent() {
        return amountSent;
    }

    /**
     * Définit la valeur de la propriété amountSent.
     * 
     */
    public void setAmountSent(long value) {
        this.amountSent = value;
    }

}
