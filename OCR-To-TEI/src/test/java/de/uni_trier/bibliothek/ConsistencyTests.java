package de.uni_trier.bibliothek;

import java.io.IOException;
import org.custommonkey.xmlunit.XMLTestCase;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ConsistencyTests extends XMLTestCase
{
	@BeforeEach
	public void setUp()
	{
		XMLUnit.setIgnoreWhitespace(true);
	}

	@Test
	void teiPathNameTest() throws IOException
	{
		String teiPathFileName = "/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/test/resources/testcase1/teiOutputFiles/TEI_created_TestBand1.xml"; 
		assertEquals("wrong pathname",("/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/test/resources/testcase1/teiOutputFiles/"), CSVCreator.createTEIPathName(teiPathFileName));
	}
}
