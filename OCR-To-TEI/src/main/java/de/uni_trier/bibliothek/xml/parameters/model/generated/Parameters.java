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
 *         <element name="title" type="{/OCR-To-TEI/src/main/resources}Title"/>
 *         <element name="titleAddition" type="{/OCR-To-TEI/src/main/resources}TitleAddition"/>
 *         <element name="readingOrder" type="{/OCR-To-TEI/src/main/resources}ReadingOrder"/>
 *         <element name="respStmtElements" type="{/OCR-To-TEI/src/main/resources}RespStmtElements"/>
 *         <element name="publicationStmt" type="{/OCR-To-TEI/src/main/resources}PublicationStmt"/>
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
    protected String title;
    @XmlElement(required = true)
    protected String titleAddition;
    @XmlElement(required = true)
    protected ReadingOrder readingOrder;
    @XmlElement(required = true)
    protected RespStmtElements respStmtElements;
    @XmlElement(required = true)
    protected PublicationStmt publicationStmt;

    /**
     * Ruft den Wert der title-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTitle() {
        return title;
    }

    /**
     * Legt den Wert der title-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTitle(String value) {
        this.title = value;
    }

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
     * Ruft den Wert der respStmtElements-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RespStmtElements }
     *     
     */
    public RespStmtElements getRespStmtElements() {
        return respStmtElements;
    }

    /**
     * Legt den Wert der respStmtElements-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RespStmtElements }
     *     
     */
    public void setRespStmtElements(RespStmtElements value) {
        this.respStmtElements = value;
    }

    /**
     * Ruft den Wert der publicationStmt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PublicationStmt }
     *     
     */
    public PublicationStmt getPublicationStmt() {
        return publicationStmt;
    }

    /**
     * Legt den Wert der publicationStmt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PublicationStmt }
     *     
     */
    public void setPublicationStmt(PublicationStmt value) {
        this.publicationStmt = value;
    }

}
