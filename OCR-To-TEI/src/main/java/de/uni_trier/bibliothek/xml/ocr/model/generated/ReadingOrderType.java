//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.ocr.model.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für readingOrderType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="readingOrderType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <all>
 *         <element name="OrderedGroup" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2019-07-15}orderedGroupType"/>
 *       </all>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "readingOrderType", propOrder = {

})
public class ReadingOrderType {

    @XmlElement(name = "OrderedGroup", required = true)
    protected OrderedGroupType orderedGroup;

    /**
     * Ruft den Wert der orderedGroup-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OrderedGroupType }
     *     
     */
    public OrderedGroupType getOrderedGroup() {
        return orderedGroup;
    }

    /**
     * Legt den Wert der orderedGroup-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OrderedGroupType }
     *     
     */
    public void setOrderedGroup(OrderedGroupType value) {
        this.orderedGroup = value;
    }

}
