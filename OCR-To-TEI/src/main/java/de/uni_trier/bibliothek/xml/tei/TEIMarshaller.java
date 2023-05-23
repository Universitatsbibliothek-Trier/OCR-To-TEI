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

package de.uni_trier.bibliothek.xml.tei;

import java.util.ArrayList;
import java.util.List;

import org.glassfish.jaxb.runtime.marshaller.NamespacePrefixMapper;

import jakarta.xml.bind.JAXBException;
import de.uni_trier.bibliothek.xml.Marshaller;
import de.uni_trier.bibliothek.xml.tei.model.generated.TEI;

public class TEIMarshaller<T> 
{

    private static Marshaller<TEI> marshaller = new Marshaller<>(TEI.class);
    private static NamespacePrefixMapper namespacePrefixMapper = new NamespacePrefixMapper() {
       public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix) {
        if(namespaceUri.equals("http://www.loc.gov/mods/v3"))
        {
            return "mods";
        }
        return "";
       }
    };
    
    public static String marshall(TEI teiObject) throws JAXBException {
        marshaller.setNamespacePrefixMapper(namespacePrefixMapper);
        marshaller.setFormat(jakarta.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT);
        return marshaller.marshal(teiObject);
    }

    public static List<String> marshall(List<TEI> teiObjects) throws JAXBException {
        List<String> teiXmlStrings = new ArrayList<>(teiObjects.size());
        for (TEI teiObject : teiObjects) 
        {
            String teiXml = TEIMarshaller.marshall(teiObject);
            teiXmlStrings.add(teiXml);
        }
        return teiXmlStrings;
    }
}
