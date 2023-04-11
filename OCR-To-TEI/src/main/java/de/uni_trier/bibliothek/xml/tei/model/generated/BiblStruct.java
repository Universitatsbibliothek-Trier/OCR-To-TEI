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
 * <p>Java-Klasse für BiblStruct complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="BiblStruct">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <all>
 *         <element name="monogr" type="{http://www.tei-c.org/ns/1.0}Monogr"/>
 *         <element name="series" type="{http://www.tei-c.org/ns/1.0}Series"/>
 *       </all>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BiblStruct", propOrder = {

})
public class BiblStruct {

    @XmlElement(required = true)
    protected Monogr monogr;
    @XmlElement(required = true)
    protected Series series;

    /**
     * Ruft den Wert der monogr-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Monogr }
     *     
     */
    public Monogr getMonogr() {
        return monogr;
    }

    /**
     * Legt den Wert der monogr-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Monogr }
     *     
     */
    public void setMonogr(Monogr value) {
        this.monogr = value;
    }

    /**
     * Ruft den Wert der series-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Series }
     *     
     */
    public Series getSeries() {
        return series;
    }

    /**
     * Legt den Wert der series-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Series }
     *     
     */
    public void setSeries(Series value) {
        this.series = value;
    }

}
