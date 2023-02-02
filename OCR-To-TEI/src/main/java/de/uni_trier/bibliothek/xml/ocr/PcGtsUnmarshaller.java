package de.uni_trier.bibliothek.xml.ocr;

import java.io.Reader;

import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import jakarta.xml.bind.JAXBException;

public class PcGtsUnmarshaller 
{
    private static final Unmarshaller<PcGts>  unmarshaller= new Unmarshaller<PcGts>(PcGts.class);
   
    public static final PcGts unmarshal(String xml) throws JAXBException
    {
        return unmarshaller.unmarshal(xml);
    }

    public static final PcGts unmarshal(Reader xmlReader) throws JAXBException
    {
        return unmarshaller.unmarshal(xmlReader);
    }
    

}