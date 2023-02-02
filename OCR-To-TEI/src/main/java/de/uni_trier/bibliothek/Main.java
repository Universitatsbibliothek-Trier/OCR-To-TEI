package de.uni_trier.bibliothek;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.XMLValidator;
import de.uni_trier.bibliothek.xml.mods.ModsCollectionManuell;
import de.uni_trier.bibliothek.xml.mods.ModsUnmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.HbzIdentifier;
import de.uni_trier.bibliothek.xml.mods.model.generated.Mods;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.PcGtsUnmarshaller;
import de.uni_trier.bibliothek.xml.ocr.model.generated.MetadataType;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;

public class Main {

    public static void main(String[] args) throws Exception {

        

        String xmlPathreader ="";
        // relativer Pfad der XML (Ordner: resources)
        xmlPathreader = "0029.xml";

        Reader xmlReader = new InputStreamReader(ClassLoader.getSystemResource(xmlPathreader).openStream());

        //alternativ: ModsUnmarshaller
        PcGtsUnmarshaller pcGtsUnmarshaller = new PcGtsUnmarshaller();

        PcGts pcgts = pcGtsUnmarshaller.unmarshal(xmlReader);

        System.out.println("eingelesen YAY ^^");
    }

}
