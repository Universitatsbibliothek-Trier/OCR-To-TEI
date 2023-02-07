//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.mods.model.generated;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;
import jakarta.xml.bind.annotation.XmlValue;


/**
 * <p>Java-Klasse für Place complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="Place">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <all>
 *         <element name="placeTerm">
 *           <complexType>
 *             <simpleContent>
 *               <extension base="<http://www.loc.gov/mods/v3>PlaceTermValue">
 *                 <attribute name="type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
 *               </extension>
 *             </simpleContent>
 *           </complexType>
 *         </element>
 *       </all>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Place", propOrder = {

})
public class Place {

    @XmlElement(required = true)
    protected Place.PlaceTerm placeTerm;

    /**
     * Ruft den Wert der placeTerm-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Place.PlaceTerm }
     *     
     */
    public Place.PlaceTerm getPlaceTerm() {
        return placeTerm;
    }

    /**
     * Legt den Wert der placeTerm-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Place.PlaceTerm }
     *     
     */
    public void setPlaceTerm(Place.PlaceTerm value) {
        this.placeTerm = value;
    }


    /**
     * <p>Java-Klasse für anonymous complex type.
     * 
     * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
     * 
     * <pre>{@code
     * <complexType>
     *   <simpleContent>
     *     <extension base="<http://www.loc.gov/mods/v3>PlaceTermValue">
     *       <attribute name="type" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" />
     *     </extension>
     *   </simpleContent>
     * </complexType>
     * }</pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "value"
    })
    public static class PlaceTerm {

        @XmlValue
        protected PlaceTermValue value;
        @XmlAttribute(name = "type")
        @XmlSchemaType(name = "anySimpleType")
        protected String type;

        /**
         * Ruft den Wert der value-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link PlaceTermValue }
         *     
         */
        public PlaceTermValue getValue() {
            return value;
        }

        /**
         * Legt den Wert der value-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link PlaceTermValue }
         *     
         */
        public void setValue(PlaceTermValue value) {
            this.value = value;
        }

        /**
         * Ruft den Wert der type-Eigenschaft ab.
         * 
         * @return
         *     possible object is
         *     {@link String }
         *     
         */
        public String getType() {
            return type;
        }

        /**
         * Legt den Wert der type-Eigenschaft fest.
         * 
         * @param value
         *     allowed object is
         *     {@link String }
         *     
         */
        public void setType(String value) {
            this.type = value;
        }

    }

}
