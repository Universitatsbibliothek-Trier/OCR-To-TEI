//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.tei.model.generated;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the de.uni_trier.bibliothek.xml.tei.model.generated package. 
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

    private final static QName _TextPb_QNAME = new QName("http://www.tei-c.org/ns/1.0", "pb");
    private final static QName _TextLb_QNAME = new QName("http://www.tei-c.org/ns/1.0", "lb");
    private final static QName _TextFw_QNAME = new QName("http://www.tei-c.org/ns/1.0", "fw");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: de.uni_trier.bibliothek.xml.tei.model.generated
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TEI }
     * 
     * @return
     *     the new instance of {@link TEI }
     */
    public TEI createTEI() {
        return new TEI();
    }

    /**
     * Create an instance of {@link TeiHeader }
     * 
     * @return
     *     the new instance of {@link TeiHeader }
     */
    public TeiHeader createTeiHeader() {
        return new TeiHeader();
    }

    /**
     * Create an instance of {@link Text }
     * 
     * @return
     *     the new instance of {@link Text }
     */
    public Text createText() {
        return new Text();
    }

    /**
     * Create an instance of {@link Fw }
     * 
     * @return
     *     the new instance of {@link Fw }
     */
    public Fw createFw() {
        return new Fw();
    }

    /**
     * Create an instance of {@link Pb }
     * 
     * @return
     *     the new instance of {@link Pb }
     */
    public Pb createPb() {
        return new Pb();
    }

    /**
     * Create an instance of {@link Lb }
     * 
     * @return
     *     the new instance of {@link Lb }
     */
    public Lb createLb() {
        return new Lb();
    }

    /**
     * Create an instance of {@link FileDesc }
     * 
     * @return
     *     the new instance of {@link FileDesc }
     */
    public FileDesc createFileDesc() {
        return new FileDesc();
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
     * Create an instance of {@link TitleStmt }
     * 
     * @return
     *     the new instance of {@link TitleStmt }
     */
    public TitleStmt createTitleStmt() {
        return new TitleStmt();
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

    /**
     * Create an instance of {@link SourceDesc }
     * 
     * @return
     *     the new instance of {@link SourceDesc }
     */
    public SourceDesc createSourceDesc() {
        return new SourceDesc();
    }

    /**
     * Create an instance of {@link BiblStruct }
     * 
     * @return
     *     the new instance of {@link BiblStruct }
     */
    public BiblStruct createBiblStruct() {
        return new BiblStruct();
    }

    /**
     * Create an instance of {@link Monogr }
     * 
     * @return
     *     the new instance of {@link Monogr }
     */
    public Monogr createMonogr() {
        return new Monogr();
    }

    /**
     * Create an instance of {@link Imprint }
     * 
     * @return
     *     the new instance of {@link Imprint }
     */
    public Imprint createImprint() {
        return new Imprint();
    }

    /**
     * Create an instance of {@link Series }
     * 
     * @return
     *     the new instance of {@link Series }
     */
    public Series createSeries() {
        return new Series();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Pb }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Pb }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.tei-c.org/ns/1.0", name = "pb", scope = Text.class)
    public JAXBElement<Pb> createTextPb(Pb value) {
        return new JAXBElement<>(_TextPb_QNAME, Pb.class, Text.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Lb }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Lb }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.tei-c.org/ns/1.0", name = "lb", scope = Text.class)
    public JAXBElement<Lb> createTextLb(Lb value) {
        return new JAXBElement<>(_TextLb_QNAME, Lb.class, Text.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Fw }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link Fw }{@code >}
     */
    @XmlElementDecl(namespace = "http://www.tei-c.org/ns/1.0", name = "fw", scope = Text.class)
    public JAXBElement<Fw> createTextFw(Fw value) {
        return new JAXBElement<>(_TextFw_QNAME, Fw.class, Text.class, value);
    }

}
