//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.parameters.model.generated;

import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.uni_trier.bibliothek.xml.parameters.model.generated package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.uni_trier.bibliothek.xml.parameters.model.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Parameters }
     * 
     * @return
     *     the new instance of {@link Parameters }
     */
    public Parameters createParameters() {
        return new Parameters();
    }

    /**
     * Create an instance of {@link ReadingOrder }
     * 
     * @return
     *     the new instance of {@link ReadingOrder }
     */
    public ReadingOrder createReadingOrder() {
        return new ReadingOrder();
    }

    /**
     * Create an instance of {@link RespStmtElements }
     * 
     * @return
     *     the new instance of {@link RespStmtElements }
     */
    public RespStmtElements createRespStmtElements() {
        return new RespStmtElements();
    }

    /**
     * Create an instance of {@link PublicationStmt }
     * 
     * @return
     *     the new instance of {@link PublicationStmt }
     */
    public PublicationStmt createPublicationStmt() {
        return new PublicationStmt();
    }

    /**
     * Create an instance of {@link RespStmt }
     * 
     * @return
     *     the new instance of {@link RespStmt }
     */
    public RespStmt createRespStmt() {
        return new RespStmt();
    }

}
