package de.uni_trier.bibliothek.xml.tei;

import java.util.ArrayList;
import java.util.List;

import jakarta.xml.bind.JAXBException;
import de.uni_trier.bibliothek.xml.Marshaller;
import de.uni_trier.bibliothek.xml.tei.model.generated.TEI;

public class TEIMarshaller<T> 
{

    private static Marshaller<TEI> marshaller = new Marshaller<>(TEI.class);

    public static String marshall(TEI teiObject) throws JAXBException {
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
