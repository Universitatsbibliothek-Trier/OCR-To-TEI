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

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.io.StringReader;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

public class Unmarshaller<T> {
    private jakarta.xml.bind.Unmarshaller unmarshaller;

    public Unmarshaller(Class<T> rootElementClass) throws RuntimeException {
        try {
            JAXBContext jaxb = JAXBContext.newInstance(rootElementClass);
            this.unmarshaller = jaxb.createUnmarshaller();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public T unmarshal(String xmlDocument) throws JAXBException {
        return this.unmarshal(new StringReader(xmlDocument));
    }

    @SuppressWarnings("unchecked")
    public T unmarshal(Reader xmlReader) throws JAXBException {
        return (T) this.unmarshaller.unmarshal(xmlReader);
    }

    public T unmarshal(File xmlFile) throws JAXBException, FileNotFoundException {
        return this.unmarshal(new BufferedReader(new FileReader(xmlFile)));
    }
}
