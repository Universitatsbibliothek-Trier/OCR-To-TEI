package de.uni_trier.bibliothek;

import java.io.File;
import java.io.FileFilter;
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

import de.uni_trier.bibliothek.xml.XMLValidator;
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
		// parse command-line arguments
		CmdLineParser cmdLineParser = new CmdLineParser(args);
		String modsPath = cmdLineParser.getModsPath();
		String ocrFolderName = cmdLineParser.getOCRFolderName();
		String teiPathNameFile = cmdLineParser.getTEIPathNameFile();
		String parametersPath = "../parameters/parameters.xml";
	
		// create Java object with data from XML file after unmarshalling
		InputStream inputStream = new FileInputStream(modsPath);
		Reader xmlReader = new InputStreamReader(inputStream);
		ModsCollection modsCollection = ModsUnmarshaller.unmarshal(xmlReader);
		xmlReader.close();

		// get files from folder, check for ".xml-files" and sort them
		File ocrFile = new File(ocrFolderName);
		File[] ocrFiles = ocrFile.listFiles(new FileFilter() {
			public boolean accept(File ocrFolderName) {
				String fileName = ocrFolderName.getName().toLowerCase();
				return fileName.endsWith(".xml") && ocrFolderName.isFile();
			}
		});
		Arrays.sort(ocrFiles);

		// create csv with header and get path of inputted TEI filename
		String teiPathName = CSVCreator.createTEIPathName(teiPathNameFile);
		File file = CSVCreator.createFile();

		// create list of PcGts Objects from folder files
		ArrayList<PcGts> pcgtsList = new ArrayList<PcGts>();
		for (File fileName : ocrFiles) 
		{	
			InputStream inputStreamPcgts = new FileInputStream(fileName);
			xmlReader = new InputStreamReader(inputStreamPcgts);
			PcGts pcgtsObject = PcGtsUnmarshaller.unmarshal(xmlReader);
			String fileNameString = fileName.getName();
			OcrDataReader.csvPageNameComments(fileNameString, pcgtsObject, file);
			pcgtsList.add(pcgtsObject);
		}
		xmlReader.close();

		// create TEI from modsCollection-object and list of PcGts-objects
		TEI teiObject = TEICreator.createTEI(modsCollection, pcgtsList, parametersPath);
		String teiXmlString = TEIMarshaller.marshall(teiObject);
		
		// write TEI as file
		Path teiFilePath = Paths.get(teiPathNameFile);
		Files.writeString(teiFilePath, teiXmlString, StandardCharsets.UTF_8);	
		System.out.println("TEI and .csv created in:");	
		System.out.println(teiPathName);	
		System.out.println("-------");	
		System.out.println("Validation against tei_all.xsd:");	

		// validate against tei_all.xsd
		if (XMLValidator.validateXMLSchema("src/main/resources/officialTEI/tei_all.xsd", teiPathNameFile))
		{
			System.out.println("Validation of " + teiPathNameFile + " against " +"tei_all.xsd" + " is true.");
		}
		else
		{
			System.out.println("Validation of " + teiPathNameFile + " against " +"tei_all.xsd" + " is false.");
		}
		System.out.println("-------");	
		System.out.println("Validation of parameters-file against parameters.xsd:");	
		// validate against parameters.xsd
		if (XMLValidator.validateXMLSchema("src/main/resources/parameters.xsd", parametersPath))
		{
			System.out.println("Validation of " + parametersPath + " against " +"parameters.xsd" + " is true.");
		}
		else
		{
			System.out.println("Validation of " + parametersPath + " against " +"parameters.xsd" + " is false.");
		}
	}

}
