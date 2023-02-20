//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.tei.model.generated;

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
 *         <element name="mods" type="{http://www.loc.gov/mods/v3}Mods"/>
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
@XmlRootElement(name = "modsCollection")
public class ModsCollection {

    @XmlElement(required = true)
    protected Mods mods;

    /**
     * Ruft den Wert der mods-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Mods }
     *     
     */
    public Mods getMods() {
        return mods;
    }

    /**
     * Legt den Wert der mods-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Mods }
     *     
     */
    public void setMods(Mods value) {
        this.mods = value;
    }

}
