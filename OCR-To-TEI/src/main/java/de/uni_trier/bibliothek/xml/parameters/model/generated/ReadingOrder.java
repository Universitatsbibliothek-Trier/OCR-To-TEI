//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.parameters.model.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für ReadingOrder complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="ReadingOrder">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="first" type="{/OCR-To-TEI/src/main/resources}First"/>
 *         <element name="second" type="{/OCR-To-TEI/src/main/resources}Second"/>
 *         <element name="third" type="{/OCR-To-TEI/src/main/resources}Third"/>
 *         <element name="fourth" type="{/OCR-To-TEI/src/main/resources}Fourth"/>
 *         <element name="fifth" type="{/OCR-To-TEI/src/main/resources}Fifth"/>
 *         <element name="sixth" type="{/OCR-To-TEI/src/main/resources}Sixth"/>
 *         <element name="seventh" type="{/OCR-To-TEI/src/main/resources}Seventh"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ReadingOrder", propOrder = {
    "first",
    "second",
    "third",
    "fourth",
    "fifth",
    "sixth",
    "seventh"
})
public class ReadingOrder {

    @XmlElement(required = true)
    protected String first;
    @XmlElement(required = true)
    protected String second;
    @XmlElement(required = true)
    protected String third;
    @XmlElement(required = true)
    protected String fourth;
    @XmlElement(required = true)
    protected String fifth;
    @XmlElement(required = true)
    protected String sixth;
    @XmlElement(required = true)
    protected String seventh;

    /**
     * Ruft den Wert der first-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFirst() {
        return first;
    }

    /**
     * Legt den Wert der first-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFirst(String value) {
        this.first = value;
    }

    /**
     * Ruft den Wert der second-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSecond() {
        return second;
    }

    /**
     * Legt den Wert der second-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSecond(String value) {
        this.second = value;
    }

    /**
     * Ruft den Wert der third-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getThird() {
        return third;
    }

    /**
     * Legt den Wert der third-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setThird(String value) {
        this.third = value;
    }

    /**
     * Ruft den Wert der fourth-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFourth() {
        return fourth;
    }

    /**
     * Legt den Wert der fourth-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFourth(String value) {
        this.fourth = value;
    }

    /**
     * Ruft den Wert der fifth-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFifth() {
        return fifth;
    }

    /**
     * Legt den Wert der fifth-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFifth(String value) {
        this.fifth = value;
    }

    /**
     * Ruft den Wert der sixth-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSixth() {
        return sixth;
    }

    /**
     * Legt den Wert der sixth-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSixth(String value) {
        this.sixth = value;
    }

    /**
     * Ruft den Wert der seventh-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getSeventh() {
        return seventh;
    }

    /**
     * Legt den Wert der seventh-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setSeventh(String value) {
        this.seventh = value;
    }

}
