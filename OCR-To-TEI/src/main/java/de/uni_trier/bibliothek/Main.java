package de.uni_trier.bibliothek;

import java.io.File;

import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.XMLValidator;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;

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

        Unmarshaller<ModsCollection> unmarshaller = new Unmarshaller<>(ModsCollection.class);
        ModsCollection modsCollection = unmarshaller.unmarshal(new File(
                "/home/ackels/Dokumente/ocr-to-tei-pipeline/OCR-To-TEI/src/main/resources/ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml"));

        System.out.println("eingelesen YAY ^^");
    }

}
