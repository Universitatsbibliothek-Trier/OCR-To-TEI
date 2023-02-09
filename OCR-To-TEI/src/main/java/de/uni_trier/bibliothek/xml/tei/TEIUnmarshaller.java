package de.uni_trier.bibliothek.xml.tei;

import java.io.Reader;

import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
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