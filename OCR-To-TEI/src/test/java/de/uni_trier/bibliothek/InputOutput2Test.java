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

public class InputOutput2Test extends XMLTestCase
{
	@BeforeEach
	public void setUp()
	{
		XMLUnit.setIgnoreWhitespace(true);
	}


	@Test
	void TEItestcase2Test() throws JAXBException, IOException, TransformerException, SAXException
	{
		String modsFilePath = "/testcase2/modsFiles/Testmods.xml";
		String ocrFolderPathString = "/testcase2/ocrOutputFiles/";
		String teiPathNameFile = "src/test/resources/testcase2/teiOutputFiles/TEI_created_TestBand2.xml";
		String tei = TestHelperClass.createTEIandCSV(teiPathNameFile, ocrFolderPathString, modsFilePath, getClass());
		String xmlToString = TestHelperClass.createXMLfromFile("src/test/resources/testcase2/expectedTEIOutputFiles/TEI_created_TestBand2.xml");
		String expectedCSVFile = Files.readString(Paths.get("src/test/resources/testcase2/expectedTEIOutputFiles/TEI_created_TestBand2_page-numbers.csv"));
		String outputCSVFile = Files.readString(Paths.get("src/test/resources/testcase2/teiOutputFiles/TEI_created_TestBand2_page-numbers.csv"));
		assertXMLEqual("xml not smiliar", xmlToString, tei);
		expectedCSVFile = expectedCSVFile.trim();
		outputCSVFile = outputCSVFile.trim();
		assertEquals("csv not smiliar", expectedCSVFile, outputCSVFile);
	}
	
}
