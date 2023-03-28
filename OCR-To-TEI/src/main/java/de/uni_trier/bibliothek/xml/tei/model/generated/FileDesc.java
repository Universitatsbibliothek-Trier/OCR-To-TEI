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
 * <p>Java-Klasse für FileDesc complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="FileDesc">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="titleStmt" type="{http://www.tei-c.org/ns/1.0}TitleStmt"/>
 *         <element name="publicationStmt" type="{http://www.tei-c.org/ns/1.0}PublicationStmt"/>
 *         <element name="sourceDesc" type="{http://www.tei-c.org/ns/1.0}SourceDesc"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FileDesc", propOrder = {
    "titleStmt",
    "publicationStmt",
    "sourceDesc"
})
public class FileDesc {

    @XmlElement(required = true)
    protected TitleStmt titleStmt;
    @XmlElement(required = true)
    protected PublicationStmt publicationStmt;
    @XmlElement(required = true)
    protected SourceDesc sourceDesc;

    /**
     * Ruft den Wert der titleStmt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TitleStmt }
     *     
     */
    public TitleStmt getTitleStmt() {
        return titleStmt;
    }

    /**
     * Legt den Wert der titleStmt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TitleStmt }
     *     
     */
    public void setTitleStmt(TitleStmt value) {
        this.titleStmt = value;
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

    /**
     * Ruft den Wert der sourceDesc-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link SourceDesc }
     *     
     */
    public SourceDesc getSourceDesc() {
        return sourceDesc;
    }

    /**
     * Legt den Wert der sourceDesc-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link SourceDesc }
     *     
     */
    public void setSourceDesc(SourceDesc value) {
        this.sourceDesc = value;
    }

}
