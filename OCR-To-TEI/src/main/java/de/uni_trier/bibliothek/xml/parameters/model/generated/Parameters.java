//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.parameters.model.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für anonymous complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType>
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <all>
 *         <element name="titleAddition" type="{/OCR-To-TEI/src/main/resources}TitleAddition"/>
 *         <element name="readingOrder" type="{/OCR-To-TEI/src/main/resources}ReadingOrder"/>
 *         <element name="respStmt" type="{/OCR-To-TEI/src/main/resources}RespStmt"/>
 *       </all>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "parameters")
public class Parameters {

    @XmlElement(required = true)
    protected String titleAddition;
    @XmlElement(required = true)
    protected ReadingOrder readingOrder;
    @XmlElement(required = true)
    protected RespStmt respStmt;

    /**
     * Ruft den Wert der titleAddition-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitleAddition() {
        return titleAddition;
    }

    /**
     * Legt den Wert der titleAddition-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitleAddition(String value) {
        this.titleAddition = value;
    }

    /**
     * Ruft den Wert der readingOrder-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReadingOrder }
     *     
     */
    public ReadingOrder getReadingOrder() {
        return readingOrder;
    }

    /**
     * Legt den Wert der readingOrder-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadingOrder }
     *     
     */
    public void setReadingOrder(ReadingOrder value) {
        this.readingOrder = value;
    }

    /**
     * Ruft den Wert der respStmt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RespStmt }
     *     
     */
    public RespStmt getRespStmt() {
        return respStmt;
    }

    /**
     * Legt den Wert der respStmt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RespStmt }
     *     
     */
    public void setRespStmt(RespStmt value) {
        this.respStmt = value;
    }

}
