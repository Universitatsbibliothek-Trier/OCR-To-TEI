//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.tei.model.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für SourceDesc complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="SourceDesc">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element ref="{http://www.loc.gov/mods/v3}modsCollection"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourceDesc", namespace = "http://www.tei-c.org/ns/1.0", propOrder = {
    "modsCollection"
})
public class SourceDesc {

    @XmlElement(namespace = "http://www.loc.gov/mods/v3", required = true)
    protected ModsCollection modsCollection;

    /**
     * Ruft den Wert der modsCollection-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ModsCollection }
     *     
     */
    public ModsCollection getModsCollection() {
        return modsCollection;
    }

    /**
     * Legt den Wert der modsCollection-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ModsCollection }
     *     
     */
    public void setModsCollection(ModsCollection value) {
        this.modsCollection = value;
    }

}
