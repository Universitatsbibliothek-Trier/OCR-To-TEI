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
 * <p>Java-Klasse für SourceDec complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="SourceDec">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="mods" type="{http://www.tei-c.org/ns/1.0}Mods"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourceDec", propOrder = {
    "mods"
})
public class SourceDec {

    @XmlElement(required = true)
    protected Mods mods;

    /**
     * Ruft den Wert der mods-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Mods }
     *     
     */
    public Mods getMods() {
        return mods;
    }

    /**
     * Legt den Wert der mods-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Mods }
     *     
     */
    public void setMods(Mods value) {
        this.mods = value;
    }

}
