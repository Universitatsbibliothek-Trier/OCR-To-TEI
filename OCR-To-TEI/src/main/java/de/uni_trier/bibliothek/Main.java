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
import java.util.List;

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
		TEI teiObject = TEICreator.createTEI(modsCollection, pcgtsList);
		String teiXmlString = TEIMarshaller.marshall(teiObject);
		
		// write TEI as file
		List<String> teiLines = Arrays.asList(teiXmlString); 
		Path teiFilePath = Paths.get(teiPathNameFile);
		Files.write(teiFilePath, teiLines, StandardCharsets.UTF_8);	
		System.out.println("TEI and .csv created in: " + teiPathName);		
	}

}
