// Copyright (c) 2023 René Ackels
// Permission is hereby granted, free of charge, to any person obtaining

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.


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
		XMLUnit.setIgnoreAttributeOrder(false);
	}

	@Test
	void TEItestcase2Test() throws JAXBException, IOException, TransformerException, SAXException
	{
		String modsFilePath = "/testcase2/modsFiles/Testmods.xml";
		String ocrFolderPathString = "/testcase2/ocrOutputFiles/";
		String teiPathNameFile = "src/test/resources/testcase2/teiOutputFiles/TEI_created_TestBand2.xml";
		String parametersPath = "src/test/resources/testcase2/parameters.xml";
		String tei = TestHelperClass.createTEIandCSV(teiPathNameFile, ocrFolderPathString, modsFilePath, parametersPath, getClass());
		String xmlToString = TestHelperClass.createXMLfromFile("src/test/resources/testcase2/expectedTEIOutputFiles/TEI_created_TestBand2.xml");
		String expectedCSVFile = Files.readString(Paths.get("src/test/resources/testcase2/expectedTEIOutputFiles/TEI_created_TestBand2_page-numbers.csv"));
		String outputCSVFile = Files.readString(Paths.get("src/test/resources/testcase2/teiOutputFiles/TEI_created_TestBand2_page-numbers.csv"));
		assertXMLEqual("xml not smiliar", xmlToString, tei);
		expectedCSVFile = expectedCSVFile.trim();
		outputCSVFile = outputCSVFile.trim();
		assertEquals("csv not smiliar", expectedCSVFile, outputCSVFile);
	}	
}
