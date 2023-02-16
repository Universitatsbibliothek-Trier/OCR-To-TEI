//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.tei.model.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für TeiHeader complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="TeiHeader">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="fileDesc" type="{http://www.tei-c.org/ns/1.0}FileDesc"/>
 *         <element name="sourceDesc" type="{http://www.tei-c.org/ns/1.0}SourceDesc"/>
 *       </sequence>
 *       <attribute name="version">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             <enumeration value="3.5"/>
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *       <attribute name="ID">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             <pattern value="merian\d{4}topographia"/>
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TeiHeader", propOrder = {
    "fileDesc",
    "sourceDesc"
})
public class TeiHeader {

    @XmlElement(required = true)
    protected FileDesc fileDesc;
    @XmlElement(required = true)
    protected SourceDesc sourceDesc;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "ID")
    protected String id;

    /**
     * Ruft den Wert der fileDesc-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link FileDesc }
     *     
     */
    public FileDesc getFileDesc() {
        return fileDesc;
    }

    /**
     * Legt den Wert der fileDesc-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link FileDesc }
     *     
     */
    public void setFileDesc(FileDesc value) {
        this.fileDesc = value;
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

    /**
     * Ruft den Wert der version-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getVersion() {
        return version;
    }

    /**
     * Legt den Wert der version-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setVersion(String value) {
        this.version = value;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getID() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setID(String value) {
        this.id = value;
    }

}
