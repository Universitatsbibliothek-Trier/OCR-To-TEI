package de.uni_trier.bibliothek;

import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.XMLValidator;
import de.uni_trier.bibliothek.xml.mods.ModsUnmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.HbzIdentifier;
import de.uni_trier.bibliothek.xml.mods.model.generated.Mods;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.OcrDataLineReader;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;


public class Main {

    public static void main(String[] args) throws Exception 
    {
        //read data of XML file with mods-collection with relative path
        String modsPathreader = "ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml";
        Reader xmlReader = new InputStreamReader(ClassLoader.getSystemResource(modsPathreader).openStream());
        // create Java object with data from XML file after unmarshalling
		ModsCollection modsc = ModsUnmarshaller.unmarshal(xmlReader);
        System.out.println("Inhalt von \"" + modsPathreader + "\" eingelesen");


        //read textlines of XML with OCR Output:
        //relative path to xml (Folder: resources)
        String ocrPathreader = "0029.xml";

        //create ArrayList with TextLines
        OcrDataLineReader  odlr = new OcrDataLineReader();
        ArrayList<String> ocrtextlines = new ArrayList<String>();
        ocrtextlines = odlr.getTextLines(ocrPathreader);

        for (int i = 0; i < ocrtextlines.size(); i++) 
        {
            //print TextLines from XML
            System.out.println("Inhalt von Zeile " + i + " ist: " + ocrtextlines.get(i));
        }
      
    }

}
