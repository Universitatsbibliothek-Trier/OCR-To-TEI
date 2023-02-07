//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.ocr.model.generated;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für pageType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="pageType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReadingOrder" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2019-07-15}readingOrderType"/>
 *         <element name="TextRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2019-07-15}textRegionType" maxOccurs="unbounded"/>
 *       </sequence>
 *       <attribute name="imageFilename" use="required">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *       <attribute name="imageHeight" use="required">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             <pattern value="\d+"/>
 *           </restriction>
 *         </simpleType>
 *       </attribute>
 *       <attribute name="imageWidth" use="required">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *             <pattern value="\d+"/>
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
@XmlType(name = "pageType", propOrder = {
    "readingOrder",
    "textRegion"
})
public class PageType {

    @XmlElement(name = "ReadingOrder", required = true)
    protected ReadingOrderType readingOrder;
    @XmlElement(name = "TextRegion", required = true)
    protected List<TextRegionType> textRegion;
    @XmlAttribute(name = "imageFilename", required = true)
    protected String imageFilename;
    @XmlAttribute(name = "imageHeight", required = true)
    protected String imageHeight;
    @XmlAttribute(name = "imageWidth", required = true)
    protected String imageWidth;

    /**
     * Ruft den Wert der readingOrder-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link ReadingOrderType }
     *     
     */
    public ReadingOrderType getReadingOrder() {
        return readingOrder;
    }

    /**
     * Legt den Wert der readingOrder-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link ReadingOrderType }
     *     
     */
    public void setReadingOrder(ReadingOrderType value) {
        this.readingOrder = value;
    }

    /**
     * Gets the value of the textRegion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the textRegion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextRegion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TextRegionType }
     * 
     * 
     * @return
     *     The value of the textRegion property.
     */
    public List<TextRegionType> getTextRegion() {
        if (textRegion == null) {
            textRegion = new ArrayList<>();
        }
        return this.textRegion;
    }

    /**
     * Ruft den Wert der imageFilename-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageFilename() {
        return imageFilename;
    }

    /**
     * Legt den Wert der imageFilename-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageFilename(String value) {
        this.imageFilename = value;
    }

    /**
     * Ruft den Wert der imageHeight-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageHeight() {
        return imageHeight;
    }

    /**
     * Legt den Wert der imageHeight-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageHeight(String value) {
        this.imageHeight = value;
    }

    /**
     * Ruft den Wert der imageWidth-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageWidth() {
        return imageWidth;
    }

    /**
     * Legt den Wert der imageWidth-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageWidth(String value) {
        this.imageWidth = value;
    }

}