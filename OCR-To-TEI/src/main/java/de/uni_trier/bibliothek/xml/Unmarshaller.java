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
