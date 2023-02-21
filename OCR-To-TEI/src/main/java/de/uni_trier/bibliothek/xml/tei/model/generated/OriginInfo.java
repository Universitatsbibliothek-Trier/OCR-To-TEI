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
 * <p>Java-Klasse für OriginInfo complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="OriginInfo">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="dateIssued">
 *           <simpleType>
 *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               <pattern value="\d{4}"/>
 *             </restriction>
 *           </simpleType>
 *         </element>
 *         <element name="place" type="{http://www.loc.gov/mods/v3}Place"/>
 *         <element name="publisher">
 *           <simpleType>
 *             <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *               <enumeration value="[Meriansche Erben]"/>
 *             </restriction>
 *           </simpleType>
 *         </element>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "OriginInfo", propOrder = {
    "dateIssued",
    "place",
    "publisher"
})
public class OriginInfo {

    @XmlElement(required = true)
    protected String dateIssued;
    @XmlElement(required = true)
    protected Place place;
    @XmlElement(required = true)
    protected String publisher;

    /**
     * Ruft den Wert der dateIssued-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDateIssued() {
        return dateIssued;
    }

    /**
     * Legt den Wert der dateIssued-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDateIssued(String value) {
        this.dateIssued = value;
    }

    /**
     * Ruft den Wert der place-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Place }
     *     
     */
    public Place getPlace() {
        return place;
    }

    /**
     * Legt den Wert der place-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Place }
     *     
     */
    public void setPlace(Place value) {
        this.place = value;
    }

    /**
     * Ruft den Wert der publisher-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Legt den Wert der publisher-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPublisher(String value) {
        this.publisher = value;
    }

}
