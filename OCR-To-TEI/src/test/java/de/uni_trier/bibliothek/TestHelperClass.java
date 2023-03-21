package de.uni_trier.bibliothek;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.transform.TransformerException;
import org.custommonkey.xmlunit.XMLTestCase;

import com.jcabi.xml.XML;
import com.jcabi.xml.XMLDocument;

import de.uni_trier.bibliothek.xml.mods.ModsUnmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.OcrDataReader;
import de.uni_trier.bibliothek.xml.ocr.PcGtsUnmarshaller;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.tei.TEICreator;
import de.uni_trier.bibliothek.xml.tei.TEIMarshaller;
import de.uni_trier.bibliothek.xml.tei.model.generated.TEI;
import jakarta.xml.bind.JAXBException;


public class TestHelperClass extends XMLTestCase
{

	public static <T> String createTEIandCSV(String teiPathNameFile, String ocrFolderPathString, String modsFilePath, String parametersPath, Class<T> testClass) throws JAXBException, IOException
	{
		// create modscollection
		InputStream modsFile = testClass.getResourceAsStream(modsFilePath);
		Reader xmlReader = new InputStreamReader(modsFile);
		ModsCollection modsCollection = ModsUnmarshaller.unmarshal(xmlReader);

		// get xml files from folder
		URL ocrFolderPath = testClass.getResource(ocrFolderPathString);
		File ocrFile = new File(ocrFolderPath.getPath());
		File[] ocrFiles = ocrFile.listFiles(new FileFilter() {
			public boolean accept(File ocrFolderName) {
				String fileName = ocrFolderName.getName().toLowerCase();
				return fileName.endsWith(".xml") && ocrFolderName.isFile();
			}
		});
		Arrays.sort(ocrFiles);
		String teiPathName = CSVCreator.createTEIPathName(teiPathNameFile);
		File csvFile = CSVCreator.createFile();

		ArrayList<PcGts> pcgtsList = new ArrayList<PcGts>();
		for (File fileName : ocrFiles) 
		{	
			InputStream inputStreamPcgts = new FileInputStream(fileName);
			xmlReader = new InputStreamReader(inputStreamPcgts);
			PcGts pcgtsObject = PcGtsUnmarshaller.unmarshal(xmlReader);
			String fileNameString = fileName.getName();
			OcrDataReader.csvPageNameComments(fileNameString, pcgtsObject, csvFile);
			pcgtsList.add(pcgtsObject);
		}
		xmlReader.close();
		
		// create TEI from modsCollection-object and list of PcGts-objects
		TEI teiObject = TEICreator.createTEI(modsCollection, pcgtsList, parametersPath);
		String teiXmlString = TEIMarshaller.marshall(teiObject);
		Path teiFilePath = Paths.get(teiPathNameFile);
		Files.writeString(teiFilePath, teiXmlString, StandardCharsets.UTF_8);	
		System.out.println("TEI and .csv created in: " + teiPathName);	
		return teiXmlString;
	}

	public static String createXMLfromFile(String teiPath) throws TransformerException, FileNotFoundException
	{
		XML xml = new XMLDocument(new File(teiPath));
        String xmlString = xml.toString();   
		return xmlString;
	}
}
