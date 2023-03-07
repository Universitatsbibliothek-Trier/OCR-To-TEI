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
import jakarta.xml.bind.annotation.XmlElements;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Page complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="Page">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="ReadingOrder" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2019-07-15}ReadingOrder"/>
 *         <choice maxOccurs="unbounded">
 *           <element name="TextRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2019-07-15}TextRegion"/>
 *           <element name="ImageRegion" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2019-07-15}ImageRegion"/>
 *         </choice>
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
@XmlType(name = "Page", propOrder = {
    "readingOrder",
    "textRegionOrImageRegion"
})
public class Page {

    @XmlElement(name = "ReadingOrder", required = true)
    protected ReadingOrder readingOrder;
    @XmlElements({
        @XmlElement(name = "TextRegion", type = TextRegion.class),
        @XmlElement(name = "ImageRegion", type = ImageRegion.class)
    })
    protected List<Object> textRegionOrImageRegion;
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
     * Gets the value of the textRegionOrImageRegion property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the textRegionOrImageRegion property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTextRegionOrImageRegion().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImageRegion }
     * {@link TextRegion }
     * 
     * 
     * @return
     *     The value of the textRegionOrImageRegion property.
     */
    public List<Object> getTextRegionOrImageRegion() {
        if (textRegionOrImageRegion == null) {
            textRegionOrImageRegion = new ArrayList<>();
        }
        return this.textRegionOrImageRegion;
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
