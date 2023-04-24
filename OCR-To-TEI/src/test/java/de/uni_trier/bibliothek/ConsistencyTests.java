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
