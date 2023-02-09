package de.uni_trier.bibliothek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
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
import de.uni_trier.bibliothek.xml.ocr.GetFilesFromFolder;
import de.uni_trier.bibliothek.xml.ocr.OcrDataLineReader;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;

public class Main {

    public static void main(String[] args) throws Exception 
    {
        // read data of XML file with mods-collection 
        String modsPath ="OCR-To-TEI/src/main/resources/modsFiles/ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml";
        InputStream inputStream = new FileInputStream(modsPath);
        Reader xmlReader = new InputStreamReader(inputStream);
        // create Java object with data from XML file after unmarshalling
        ModsCollection modsCollection = ModsUnmarshaller.unmarshal(xmlReader);
        System.out.println("Inhalt von \"" + modsPath + "\" eingelesen");
        xmlReader.close();

        // read textlines of folder of XML files with OCR Output:
        // create ArrayList for TextLines
        ArrayList<String> ocrTextLines = new ArrayList<String>(); 

        // get file names from folder
        String ocrFolderName = "OCR-To-TEI/src/main/resources/ocrOutputFiles/";
        ArrayList<String> fileNames = GetFilesFromFolder.getFileNames(ocrFolderName);

        // iterate files from folder
        for (String fileName : fileNames) 
        {
            String relativeFileNamePath = ocrFolderName + fileName;
            System.out.println("Eingelesene Datei: " + relativeFileNamePath);
            ocrTextLines = OcrDataLineReader.getTextLines(relativeFileNamePath);
            for (int i = 0; i < ocrTextLines.size(); i++) 
            {
                // print TextLines from all XML files
                System.out.println("Zeile " + i + " von " + fileName + " ist: " + ocrTextLines.get(i));
            }

        }

    }

}
