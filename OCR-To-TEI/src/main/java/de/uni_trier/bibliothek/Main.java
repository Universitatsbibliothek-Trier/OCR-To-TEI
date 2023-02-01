package de.uni_trier.bibliothek;

import java.io.InputStreamReader;
import java.io.Reader;

import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.XMLValidator;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;

public class Main {

    public static void main(String[] args) throws Exception {
        // String xsdPath="OCR-To-TEI/src/resources/testfile.xsd";
        // String xmlPath="OCR-To-TEI/src/resources/testfile1_example.xml";
        // String xsdPath="OCR-To-TEI/src/resources/testfile.xsd";
        // String xmlPath="OCR-To-TEI/src/resources/testfile1_example.xml";
        // String xsdPath = "/home/ackels/Dokumente/ocr-to-tei-pipeline/example-data/mods.xsd";
        // String xmlPath = "/home/ackels/Dokumente/ocr-to-tei-pipeline/example-data/ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml";

        // System.out.println(
        //         "testfile xml validates against testfile.xsd " + XMLValidator.validateXMLSchema(xsdPath, xmlPath));

        // Reader xmlReader = new InputStreamReader(ClassLoader.getSystemResource("ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml").openStream());

        // Unmarshaller<ModsCollection> unmarshaller = new Unmarshaller<>(ModsCollection.class);
        // ModsCollection modsCollection = unmarshaller.unmarshal(xmlReader);

        Reader xmlReader = new InputStreamReader(ClassLoader.getSystemResource("0029.xml").openStream());

        Unmarshaller<PcGts> unmarshaller = new Unmarshaller<>(PcGts.class);
        PcGts pcGts = unmarshaller.unmarshal(xmlReader);

        System.out.println("eingelesen YAY ^^");
    }

}
