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
 * <p>Classe Java pour clientInfo complex type.
 * 
 * <p>Le fragment de schéma suivant indique le contenu attendu figurant dans cette classe.
 * 
 * <pre>
 * &lt;complexType name="clientInfo"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numeroTel" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="solde" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "clientInfo", propOrder = {
    "numeroTel",
    "solde"
})
public class ClientInfo {

    protected long numeroTel;
    protected long solde;

    /**
     * Obtient la valeur de la propriété numeroTel.
     * 
     */
    public long getNumeroTel() {
        return numeroTel;
    }

    /**
     * Définit la valeur de la propriété numeroTel.
     * 
     */
    public void setNumeroTel(long value) {
        this.numeroTel = value;
    }

    /**
     * Obtient la valeur de la propriété solde.
     * 
     */
    public long getSolde() {
        return solde;
    }

    /**
     * Définit la valeur de la propriété solde.
     * 
     */
    public void setSolde(long value) {
        this.solde = value;
    }

}
