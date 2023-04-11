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
 *         <element name="biblStruct" type="{http://www.tei-c.org/ns/1.0}BiblStruct"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourceDesc", propOrder = {
    "biblStruct"
})
public class SourceDesc {

    @XmlElement(required = true)
    protected BiblStruct biblStruct;

    /**
     * Ruft den Wert der biblStruct-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link BiblStruct }
     *     
     */
    public BiblStruct getBiblStruct() {
        return biblStruct;
    }

    /**
     * Legt den Wert der biblStruct-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link BiblStruct }
     *     
     */
    public void setBiblStruct(BiblStruct value) {
        this.biblStruct = value;
    }

}
