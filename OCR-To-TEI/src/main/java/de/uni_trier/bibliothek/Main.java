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
		ArrayList<String> argsList= new ArrayList<>(Arrays.asList(args));
		for(String argElement : argsList)
		{
			System.out.println(argElement);
			System.out.println("nächstes");
		}
		// read data of XML file with mods-collection 
		// String modsPath ="/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/main/resources/modsFiles/ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml";
		String modsPath = argsList.get(0);
		InputStream inputStream = new FileInputStream(modsPath);
		Reader xmlReader = new InputStreamReader(inputStream);
		System.out.println("KNALL1");
		// create Java object with data from XML file after unmarshalling
		ModsCollection modsCollection = ModsUnmarshaller.unmarshal(xmlReader);
		// System.out.println("Inhalt von \"" + modsPath + "\" eingelesen");
		xmlReader.close();

		// get files from folder and sort them
		// String ocrFolderName = "/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/main/resources/ocrOutputFiles/";
		String ocrFolderName = argsList.get(1);
		File ocrFile = new File(ocrFolderName);
		File[] ocrFiles = ocrFile.listFiles();
		Arrays.sort(ocrFiles);

		// create csv and write header to csv file
		String teiPathName = argsList.get(2);
		int lastSlash = teiPathName.lastIndexOf('/');
		System.out.println("last index of slash");
		String csvFileName = teiPathName.substring(lastSlash+1,teiPathName.length());
		System.out.println("filename got");
		csvFileName = csvFileName.substring(0,csvFileName.length()-4);
		System.out.println("filename got without extension");
		csvFileName = csvFileName + "_page-numbers.csv";
		System.out.println("Name der csv: " + csvFileName);

		teiPathName = teiPathName.substring(0,lastSlash+1);
		String csvPathFileName = teiPathName + csvFileName;
		System.out.println("csv Path AND Name: " + csvPathFileName);

		File file = new File(csvPathFileName);	
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
		// String teiFileName = "TEI_" + modsFileName;
		List<String> teiLines = Arrays.asList(teiXmlString); 
		// Path teiFilePath = Paths.get("/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/main/resources/teiOutputFiles/" + teiFileName);
		Path teiFilePath = Paths.get(argsList.get(2));
		Files.write(teiFilePath, teiLines, StandardCharsets.UTF_8);			
	}

}
