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
 *         <element name="teiHeader" type="{http://www.tei-c.org/ns/1.0}TeiHeader"/>
 *         <element name="text" type="{http://www.tei-c.org/ns/1.0}Text"/>
 *       </all>
 *       <attribute name="version">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             <pattern value="\d+.\d"/>
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
@XmlType(name = "", propOrder = {

})
@XmlRootElement(name = "TEI", namespace = "http://www.tei-c.org/ns/1.0")
public class TEI {

    @XmlElement(namespace = "http://www.tei-c.org/ns/1.0", required = true)
    protected TeiHeader teiHeader;
    @XmlElement(namespace = "http://www.tei-c.org/ns/1.0", required = true)
    protected Text text;
    @XmlAttribute(name = "version")
    protected String version;

    /**
     * Ruft den Wert der teiHeader-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TeiHeader }
     *     
     */
    public TeiHeader getTeiHeader() {
        return teiHeader;
    }

    /**
     * Legt den Wert der teiHeader-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TeiHeader }
     *     
     */
    public void setTeiHeader(TeiHeader value) {
        this.teiHeader = value;
    }

    /**
     * Ruft den Wert der text-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Text }
     *     
     */
    public Text getText() {
        return text;
    }

    /**
     * Legt den Wert der text-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Text }
     *     
     */
    public void setText(Text value) {
        this.text = value;
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

}
