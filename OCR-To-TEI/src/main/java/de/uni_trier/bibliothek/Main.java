package de.uni_trier.bibliothek;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
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

import com.opencsv.CSVWriter;

import de.uni_trier.bibliothek.xml.mods.ModsUnmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.OcrDataReader;
import de.uni_trier.bibliothek.xml.ocr.PcGtsUnmarshaller;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.tei.TEICreator;
import de.uni_trier.bibliothek.xml.tei.TEIMarshaller;
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

		// get files from folder and sort them
		String ocrFolderName = "OCR-To-TEI/src/main/resources/ocrOutputFiles/";
		File ocrFile = new File(ocrFolderName);
		File[] ocrFiles = ocrFile.listFiles();
		Arrays.sort(ocrFiles);

		// create csv and write header to csv file
		File file = new File("change_parameters/pageNumbersFileNames.csv");	
		file.delete();	
		FileWriter outputfile = new FileWriter(file, true);
		CSVWriter writer = new CSVWriter(outputfile);
		String[] header = { "Dateiname:", "Seitenzahl:", "Kommentar:" };
		writer.writeNext(header);
		writer.close();

		// create list of PcGts Objects from folder files
		ArrayList<PcGts> pcgtsList = new ArrayList<PcGts>();
		for (File fileName : ocrFiles) 
		{	
			InputStream inputStreamPcgts = new FileInputStream(fileName);
			inputStreamPcgts = new FileInputStream(fileName);
			xmlReader = new InputStreamReader(inputStreamPcgts);
			PcGts pcgtsObject = PcGtsUnmarshaller.unmarshal(xmlReader);
			String fileNameString = fileName.getName();
			OcrDataReader.csvPageNameComments(fileNameString, pcgtsObject, file);
			pcgtsList.add(pcgtsObject);
		}
		xmlReader.close();

		// create TEI from modsCollection-object and list of PcGts-objects
		TEI teiObject = TEICreator.createTEI(modsCollection, pcgtsList);
		String teiXmlString = TEIMarshaller.marshall(teiObject);
		
		// write TEI as file
		String modsFileName = modsPath.substring(modsPath.lastIndexOf("/") +1);
		String teiFileName = "TEI_" + modsFileName;
		List<String> teiLines = Arrays.asList(teiXmlString); 
		Path teiFilePath = Paths.get("OCR-To-TEI/src/main/resources/teiOutputFiles/" + teiFileName);
		Files.write(teiFilePath, teiLines, StandardCharsets.UTF_8);			
	}

}
