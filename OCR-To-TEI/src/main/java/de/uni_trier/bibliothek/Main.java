package de.uni_trier.bibliothek;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.uni_trier.bibliothek.xml.mods.ModsUnmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.GetFilesFromFolder;
import de.uni_trier.bibliothek.xml.ocr.PcGtsUnmarshaller;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.tei.TEICreator;
import de.uni_trier.bibliothek.xml.tei.TEIMarshaller;
import de.uni_trier.bibliothek.xml.tei.TEIStringManipulator;
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

		// create list of PcGts Objects from folder files
		ArrayList<PcGts> pcgtsList = new ArrayList<PcGts>();
		for (String fileName : relativeFileNames) 
		{	
			InputStream inputStreamPcgts = new FileInputStream(fileName);
			inputStreamPcgts = new FileInputStream(fileName);
			xmlReader = new InputStreamReader(inputStreamPcgts);
			PcGts pcgtsObject = PcGtsUnmarshaller.unmarshal(xmlReader);
			pcgtsList.add(pcgtsObject);
		}
		xmlReader.close();

		// create TEI from modsCollection-object and list of PcGts-objects
		TEI teiObject = TEICreator.createTEI(modsCollection, pcgtsList);
		String teiXmlString = TEIMarshaller.marshall(teiObject);

		// manipulate XML-String of TEI
        String teiXmlStringManipulated = TEIStringManipulator.manipulateTEI(teiXmlString);
		
		// write TEI as file
		String modsFileName = modsPath.substring(modsPath.lastIndexOf("/") +1);
		String teiFileName = "TEI_" + modsFileName;
		List<String> teiLines = Arrays.asList(teiXmlStringManipulated); 
		Path teiFilePath = Paths.get("OCR-To-TEI/src/main/resources/teiOutputFiles/" + teiFileName);
		Files.write(teiFilePath, teiLines, StandardCharsets.UTF_8);			
	}

}
