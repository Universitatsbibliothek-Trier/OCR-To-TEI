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
 * <p>Java-Klasse für orderedGroupType complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="orderedGroupType">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="RegionRefIndexed" type="{http://schema.primaresearch.org/PAGE/gts/pagecontent/2019-07-15}regionRefIndexedType" maxOccurs="unbounded"/>
 *       </sequence>
 *       <attribute name="id">
 *         <simpleType>
 *           <restriction base="{http://www.w3.org/2001/XMLSchema}string">
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
@XmlType(name = "orderedGroupType", propOrder = {
    "regionRefIndexed"
})
public class OrderedGroupType {

    @XmlElement(name = "RegionRefIndexed", required = true)
    protected List<RegionRefIndexedType> regionRefIndexed;
    @XmlAttribute(name = "id")
    protected String id;

    /**
     * Gets the value of the regionRefIndexed property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the regionRefIndexed property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRegionRefIndexed().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RegionRefIndexedType }
     * 
     * 
     * @return
     *     The value of the regionRefIndexed property.
     */
    public List<RegionRefIndexedType> getRegionRefIndexed() {
        if (regionRefIndexed == null) {
            regionRefIndexed = new ArrayList<>();
        }
        return this.regionRefIndexed;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getId() {
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
    public void setId(String value) {
        this.id = value;
    }

}
