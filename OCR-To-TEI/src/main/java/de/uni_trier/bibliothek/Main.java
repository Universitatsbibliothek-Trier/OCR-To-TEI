package de.uni_trier.bibliothek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

import de.uni_trier.bibliothek.xml.TEICreator;
import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.XMLValidator;
import de.uni_trier.bibliothek.xml.mods.ModsUnmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.HbzIdentifier;
import de.uni_trier.bibliothek.xml.mods.model.generated.Mods;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.GetFilesFromFolder;
import de.uni_trier.bibliothek.xml.ocr.OcrDataLineReader;
import de.uni_trier.bibliothek.xml.ocr.PcGtsUnmarshaller;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.tei.TEIMarshaller;
import de.uni_trier.bibliothek.xml.tei.TEIUnmarshaller;
import de.uni_trier.bibliothek.xml.tei.model.generated.TEI;

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

        // get file names from folder
        String ocrFolderName = "OCR-To-TEI/src/main/resources/ocrOutputFiles/";
        ArrayList<String> fileNames = GetFilesFromFolder.getFileNames(ocrFolderName);
        ArrayList<String> relativeFileNames = new ArrayList<String>();

        // iterate files from folder
        for (String fileName : fileNames) 
        {
            String relativeFileNamePath = ocrFolderName + fileName;
            relativeFileNames.add(relativeFileNamePath);  
        }

        ArrayList<PcGts> pcgtsList = new ArrayList<PcGts>();
        ArrayList<String> ocrTextLines = new ArrayList<String>(); 
        for (String fileName : relativeFileNames) 
        {
            //print out lines of ocr XML files
            InputStream inputStreamPcgts = new FileInputStream(fileName);
            inputStreamPcgts = new FileInputStream(fileName);
            xmlReader = new InputStreamReader(inputStreamPcgts);
            PcGts pcgtsObject = PcGtsUnmarshaller.unmarshal(xmlReader);
            ocrTextLines = OcrDataLineReader.getTextLines(pcgtsObject);
            for (int i = 0; i < ocrTextLines.size(); i++) 
            {
                // print TextLines from all XML files
                // System.out.println("Zeile " + (i+1) + " von " + fileName + " ist: " + ocrTextLines.get(i));
            }
            // create list of PcGts Objects
            pcgtsList.add(pcgtsObject);
        }
        xmlReader.close();

		// create TEI from modsCollection-object and list of PcGts-objects
        TEI teiObject = TEICreator.createTEI(modsCollection, pcgtsList);
        String teiXmlString = TEIMarshaller.marshall(teiObject);
        System.out.println(teiXmlString);

        //write TEI as file
        String modsFileName = modsPath.substring(modsPath.lastIndexOf("/") +1);
        String teiFileName = "TEI_" + modsFileName;
        List<String> lines = Arrays.asList(teiXmlString); 
        Path filePath = Paths.get("OCR-To-TEI/src/main/resources/teiOutputFiles/" + teiFileName);
        Files.write(filePath, lines, StandardCharsets.UTF_8);


        

    }

}
