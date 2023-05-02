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

package de.uni_trier.bibliothek.xml.tei;

import java.io.Reader;

import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.tei.model.generated.TEI;
import jakarta.xml.bind.JAXBException;

public class TEIUnmarshaller 
{
    private static final Unmarshaller<TEI>  unmarshaller= new Unmarshaller<TEI>(TEI.class);
   
    public static final TEI unmarshal(String xml) throws JAXBException
    {
        return unmarshaller.unmarshal(xml);
    }

    public static final TEI unmarshal(Reader xmlReader) throws JAXBException
    {
        return unmarshaller.unmarshal(xmlReader);
    }
    

}