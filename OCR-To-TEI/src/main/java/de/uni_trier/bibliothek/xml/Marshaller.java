package de.uni_trier.bibliothek.xml;

import java.io.StringWriter;
import java.io.Writer;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;

public class Marshaller<T> 
{
    private jakarta.xml.bind.Marshaller marshaller;

    /*
     * instead of the rootElementClass the ObjectFactory can be used.
     * I find the use of the rootElementClass is advantageous.
     * It is more explicit and does probably prevent name clashes.
     * We can also use generics this way to allow the java compiler to check types
     * at compile time.
     */
    public Marshaller(Class<T> rootElementClass) throws RuntimeException 
    {
        try 
        {
            JAXBContext jaxb = JAXBContext.newInstance(rootElementClass);
            this.marshaller = jaxb.createMarshaller();
        } 
        catch (Exception e) 
        {
            throw new RuntimeException(e);
        }
    }

    public String marshal(T object) throws JAXBException 
    {
        StringWriter writer = new StringWriter();
        this.marshaller.marshal(object, writer);
        return writer.toString();
    }

    public void marshal(T object, Writer writer) throws JAXBException 
    {
        this.marshaller.marshal(object, writer);
    }
}
