// @author       René Ackels, Anne Königs
// Copyright (c) 2023 René Ackels, Anne Königs

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

package de.uni_trier.bibliothek.xml;

import java.io.IOException;
import java.net.URL;
import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.xml.sax.SAXException;

public class XMLValidator 
{
    public static boolean validateXMLSchema(String xsdPath, String xmlPath)
    {
        try
        {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdPath));
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));

        }
        catch (IOException | SAXException e)
        {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
            return true;
    }

    public static boolean validateXMLSchema(URL xsdPath, String xmlPath)
    {
        try
        {
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(xsdPath);
            Validator validator = schema.newValidator();
            validator.validate(new StreamSource(new File(xmlPath)));

        }
        catch (IOException | SAXException e)
        {
            System.out.println("Exception: " + e.getMessage());
            return false;
        }
            return true;
    }

}
