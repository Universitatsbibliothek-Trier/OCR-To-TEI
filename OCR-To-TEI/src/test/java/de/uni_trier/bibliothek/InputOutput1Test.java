package de.uni_trier.bibliothek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.xml.transform.TransformerException;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.xml.sax.SAXException;
import jakarta.xml.bind.JAXBException;

public class InputOutput1Test extends XMLTestCase
{
	@BeforeEach
	public void setUp()
	{
		XMLUnit.setIgnoreWhitespace(true);
		XMLUnit.setIgnoreAttributeOrder(false);
	}

	@Test
	void TEItestcase1Test() throws JAXBException, IOException, SAXException, TransformerException
	{
		String modsFilePath = "/testcase1/modsFiles/Testmods.xml";
		String ocrFolderPathString = "/testcase1/ocrOutputFiles/";
		String teiPathNameFile = "src/test/resources/testcase1/teiOutputFiles/TEI_created_TestBand1.xml";
		String parametersPath = "src/test/resources/testcase1/parameters.xml";
		String tei = TestHelperClass.createTEIandCSV(teiPathNameFile, ocrFolderPathString, modsFilePath, parametersPath, getClass());
		String xmlToString = TestHelperClass.createXMLfromFile("src/test/resources/testcase1/expectedTEIOutputFiles/TEI_created_TestBand1.xml");
		String expectedCSVFile = Files.readString(Paths.get("src/test/resources/testcase1/expectedTEIOutputFiles/TEI_created_TestBand1_page-numbers.csv"));
		String outputCSVFile = Files.readString(Paths.get("src/test/resources/testcase1/teiOutputFiles/TEI_created_TestBand1_page-numbers.csv"));
		assertXMLEqual("xml not smiliar", xmlToString, tei);
		expectedCSVFile = expectedCSVFile.trim();
		outputCSVFile = outputCSVFile.trim();
		assertEquals("csv not smiliar", expectedCSVFile, outputCSVFile);
	}	
}
