package de.uni_trier.bibliothek;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.XMLConstants;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.core.util.FileUtils;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.xml.sax.SAXException;

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
// import org.junit.Test;
// import org.junit.runners.MethodSorters;


public class InputOutput1Test extends XMLTestCase
{
	@BeforeEach
	public void setUp()
	{
		XMLUnit.setIgnoreWhitespace(true);
	}

	String createTEIandCSV(String teiPathNameFile, String ocrFolderPathString, String modsFilePath) throws JAXBException, IOException
	{
		// create modscollection
		InputStream modsFile = InputOutput1Test.class.getResourceAsStream(modsFilePath);
		Reader xmlReader = new InputStreamReader(modsFile);
		ModsCollection modsCollection = ModsUnmarshaller.unmarshal(xmlReader);

		// get xml files from folder
		URL ocrFolderPath = InputOutput1Test.class.getResource(ocrFolderPathString);
		File ocrFile = new File(ocrFolderPath.getPath());
		File[] ocrFiles = ocrFile.listFiles(new FileFilter() {
			public boolean accept(File ocrFolderName) {
				String fileName = ocrFolderName.getName().toLowerCase();
				return fileName.endsWith(".xml") && ocrFolderName.isFile();
			}
		});
		Arrays.sort(ocrFiles);

		String teiPathName = CSVCreator.createTEIPathName(teiPathNameFile);
		System.out.println("PathName of csv: " + teiPathName);
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
			System.out.println("pcgts object added");
			System.out.println(pcgtsObject.getPage().getImageHeight());
		}
		xmlReader.close();
		
		
		// create TEI from modsCollection-object and list of PcGts-objects
		TEI teiObject = TEICreator.createTEI(modsCollection, pcgtsList);
		String teiXmlString = TEIMarshaller.marshall(teiObject);
		System.out.println("TEI: "  + teiXmlString);
		Path teiFilePath = Paths.get(teiPathNameFile);
		Files.writeString(teiFilePath, teiXmlString, StandardCharsets.UTF_8);	
		System.out.println("TEI and .csv created in: " + teiPathName);	
		
		return teiXmlString;
		
	}

	public String createXMLfromFile(String teiPath) throws TransformerException, FileNotFoundException
	{
		XML xml = new XMLDocument(new File(teiPath));
        String xmlString = xml.toString();   
		return xmlString;
	}
	

	@Test
	void TEItestcase1Test() throws JAXBException, IOException, SAXException, TransformerException
	{
		String modsFilePath = "/testcase1/modsFiles/Testmods.xml";
		String ocrFolderPathString = "/testcase1/ocrOutputFiles/";
		String teiPathNameFile = "src/test/resources/testcase1/teiOutputFiles/TEI_created_TestBand1.xml";
		String tei = createTEIandCSV(teiPathNameFile, ocrFolderPathString, modsFilePath);
		// System.out.println((new XMLDocument(new File("src/test/resources/testcase1/teiOutputFiles/TEI_created_TestBand1.xml"))).toString());

		String xmlToString =createXMLfromFile("src/test/resources/testcase1/expectedTEIOutputFiles/TEI_created_TestBand1.xml");
		String expectedCSVFile = Files.readString(Paths.get("src/test/resources/testcase1/expectedTEIOutputFiles/TEI_created_TestBand1_page-numbers.csv"));
		String outputCSVFile = Files.readString(Paths.get("src/test/resources/testcase1/teiOutputFiles/TEI_created_TestBand1_page-numbers.csv"));
		// assertXMLEqual("xml not smiliar", xmlToString, tei);
		expectedCSVFile = expectedCSVFile.trim();
		outputCSVFile = outputCSVFile.trim();
		assertEquals("csv not smiliar", expectedCSVFile, outputCSVFile);
	}

	
	
}
