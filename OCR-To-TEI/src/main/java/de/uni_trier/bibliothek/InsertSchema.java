// @author       René Ackels
// Copyright (c) 2023 Universität Trier

// This file is part of OCR-To-TEI.

// OCR-To-TEI is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// OCR-To-TEI is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.

package de.uni_trier.bibliothek;

public class InsertSchema {


	public static String insertSchema(String xmlFile)
	{
		// insert TEI-Schema for easier validation
		String xmlFileSchema = xmlFile.replaceAll("<TEI version=\"5.0\" xmlns=\"http://www.tei-c.org/ns/1.0\">", "<TEI version=\"5.0\" xmlns=\"http://www.tei-c.org/ns/1.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.tei-c.org/ns/1.0 https://www.tei-c.org/release/xml/tei/custom/schema/xsd/tei_all.xsd\">");
		return xmlFileSchema;
	}

}
