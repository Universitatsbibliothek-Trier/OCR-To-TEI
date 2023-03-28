//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.parameters.model.generated;

import java.util.ArrayList;
import java.util.List;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für RespStmtElements complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>{@code
 * <complexType name="RespStmtElements">
 *   <complexContent>
 *     <restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       <sequence>
 *         <element name="respStmt" type="{/OCR-To-TEI/src/main/resources}RespStmt" maxOccurs="unbounded"/>
 *       </sequence>
 *     </restriction>
 *   </complexContent>
 * </complexType>
 * }</pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "RespStmtElements", propOrder = {
    "respStmt"
})
public class RespStmtElements {

    @XmlElement(required = true)
    protected List<RespStmt> respStmt;

    /**
     * Gets the value of the respStmt property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the Jakarta XML Binding object.
     * This is why there is not a {@code set} method for the respStmt property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getRespStmt().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link RespStmt }
     * 
     * 
     * @return
     *     The value of the respStmt property.
     */
    public List<RespStmt> getRespStmt() {
        if (respStmt == null) {
            respStmt = new ArrayList<>();
        }
        return this.respStmt;
    }

}
