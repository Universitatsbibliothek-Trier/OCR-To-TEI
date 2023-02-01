//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.mods.model.generated;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für Mods complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="Mods">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="identifier" type="{http://www.loc.gov/mods/v3}HbzIdentifier"/>
 *         <element name="originInfo" type="{http://www.loc.gov/mods/v3}OriginInfo"/>
 *         <element name="genre" type="{http://www.loc.gov/mods/v3}Genre"/>
 *         <element name="note" type="{http://www.loc.gov/mods/v3}Note" maxOccurs="unbounded"/>
 *         <element name="location" type="{http://www.loc.gov/mods/v3}Location"/>
 *         <element name="typeOfResource" type="{http://www.loc.gov/mods/v3}TypeofResource"/>
 *         <element name="subject" type="{http://www.loc.gov/mods/v3}Subject"/>
 *         <element name="name" type="{http://www.loc.gov/mods/v3}Name" maxOccurs="unbounded"/>
 *         <element name="recordInfo" type="{http://www.loc.gov/mods/v3}RecordInfo"/>
 *         <element name="physicalDescription" type="{http://www.loc.gov/mods/v3}PhysicalDescription"/>
 *         <element name="titleInfo" type="{http://www.loc.gov/mods/v3}TitleInfo"/>
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
@XmlType(name = "Mods", propOrder = {
    "identifier",
    "originInfo",
    "genre",
    "note",
    "location",
    "typeOfResource",
    "subject",
    "name",
    "recordInfo",
    "physicalDescription",
    "titleInfo"
})
public class Mods {

    @XmlElement(required = true)
    protected HbzIdentifier identifier;
    @XmlElement(required = true)
    protected OriginInfo originInfo;
    @XmlElement(required = true)
    protected Genre genre;
    @XmlElement(required = true)
    protected List<Note> note;
    @XmlElement(required = true)
    protected Location location;
    @XmlElement(required = true)
    protected String typeOfResource;
    @XmlElement(required = true)
    protected Subject subject;
    @XmlElement(required = true)
    protected List<Name> name;
    @XmlElement(required = true)
    protected RecordInfo recordInfo;
    @XmlElement(required = true)
    protected PhysicalDescription physicalDescription;
    @XmlElement(required = true)
    protected TitleInfo titleInfo;
    @XmlAttribute(name = "version")
    protected String version;
    @XmlAttribute(name = "ID")
    protected String id;

    /**
     * Ruft den Wert der identifier-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link HbzIdentifier }
     *     
     */
    public HbzIdentifier getIdentifier() {
        return identifier;
    }

    /**
     * Legt den Wert der identifier-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link HbzIdentifier }
     *     
     */
    public void setIdentifier(HbzIdentifier value) {
        this.identifier = value;
    }

    /**
     * Ruft den Wert der originInfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link OriginInfo }
     *     
     */
    public OriginInfo getOriginInfo() {
        return originInfo;
    }

    /**
     * Legt den Wert der originInfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link OriginInfo }
     *     
     */
    public void setOriginInfo(OriginInfo value) {
        this.originInfo = value;
    }

    /**
     * Ruft den Wert der genre-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Genre }
     *     
     */
    public Genre getGenre() {
        return genre;
    }

    /**
     * Legt den Wert der genre-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Genre }
     *     
     */
    public void setGenre(Genre value) {
        this.genre = value;
    }

    /**
     * Gets the value of the note property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the note property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getNote().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Note }
     * 
     * 
     * @return
     *     The value of the note property.
     */
    public List<Note> getNote() {
        if (note == null) {
            note = new ArrayList<>();
        }
        return this.note;
    }

    /**
     * Ruft den Wert der location-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Location }
     *     
     */
    public Location getLocation() {
        return location;
    }

    /**
     * Legt den Wert der location-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Location }
     *     
     */
    public void setLocation(Location value) {
        this.location = value;
    }

    /**
     * Ruft den Wert der typeOfResource-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getTypeOfResource() {
        return typeOfResource;
    }

    /**
     * Legt den Wert der typeOfResource-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setTypeOfResource(String value) {
        this.typeOfResource = value;
    }

    /**
     * Ruft den Wert der subject-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Subject }
     *     
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * Legt den Wert der subject-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Subject }
     *     
     */
    public void setSubject(Subject value) {
        this.subject = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the name property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getName().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Name }
     * 
     * 
     * @return
     *     The value of the name property.
     */
    public List<Name> getName() {
        if (name == null) {
            name = new ArrayList<>();
        }
        return this.name;
    }

    /**
     * Ruft den Wert der recordInfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link RecordInfo }
     *     
     */
    public RecordInfo getRecordInfo() {
        return recordInfo;
    }

    /**
     * Legt den Wert der recordInfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link RecordInfo }
     *     
     */
    public void setRecordInfo(RecordInfo value) {
        this.recordInfo = value;
    }

    /**
     * Ruft den Wert der physicalDescription-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link PhysicalDescription }
     *     
     */
    public PhysicalDescription getPhysicalDescription() {
        return physicalDescription;
    }

    /**
     * Legt den Wert der physicalDescription-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link PhysicalDescription }
     *     
     */
    public void setPhysicalDescription(PhysicalDescription value) {
        this.physicalDescription = value;
    }

    /**
     * Ruft den Wert der titleInfo-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link TitleInfo }
     *     
     */
    public TitleInfo getTitleInfo() {
        return titleInfo;
    }

    /**
     * Legt den Wert der titleInfo-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link TitleInfo }
     *     
     */
    public void setTitleInfo(TitleInfo value) {
        this.titleInfo = value;
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
