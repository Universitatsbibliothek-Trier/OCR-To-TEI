//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.mods;
import java.io.Reader;
import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.Mods;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


public class ModsUnmarshaller 
{
    private static final Unmarshaller<ModsCollection>  unmarshaller= new Unmarshaller<ModsCollection>(ModsCollection.class);
   
    public static final ModsCollection unmarshal(String xml) throws JAXBException
    {
        return unmarshaller.unmarshal(xml);
    }

    public static final ModsCollection unmarshal(Reader xmlReader) throws JAXBException
    {
        return unmarshaller.unmarshal(xmlReader);
    }
    

}


