//
// Diese Datei wurde mit der Eclipse Implementation of JAXB, v4.0.0 generiert 
// Siehe https://eclipse-ee4j.github.io/jaxb-ri 
// Änderungen an dieser Datei gehen bei einer Neukompilierung des Quellschemas verloren. 
//


package de.uni_trier.bibliothek.xml.mods;
import java.io.Reader;
import java.util.List;

import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.Genre;
import de.uni_trier.bibliothek.xml.mods.model.generated.HbzIdentifier;
import de.uni_trier.bibliothek.xml.mods.model.generated.Location;
import de.uni_trier.bibliothek.xml.mods.model.generated.Mods;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.mods.model.generated.Name;
import de.uni_trier.bibliothek.xml.mods.model.generated.Note;
import de.uni_trier.bibliothek.xml.mods.model.generated.OriginInfo;
import de.uni_trier.bibliothek.xml.mods.model.generated.PhysicalDescription;
import de.uni_trier.bibliothek.xml.mods.model.generated.RecordInfo;
import de.uni_trier.bibliothek.xml.mods.model.generated.Subject;
import de.uni_trier.bibliothek.xml.mods.model.generated.TitleInfo;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.annotation.XmlAttribute;


public class ModsDataReader 
{
    private ModsCollection mc;
    Mods mods;
    HbzIdentifier modsidentifier;
    OriginInfo modsoriginInfo;
    Genre modsgenre;
    List<Note> modsnote;
    Location modslocation;
    String modstypeOfResource;
    Subject modssubject;
    List<Name> modsname;
    RecordInfo modsrecordInfo;
    PhysicalDescription modsphysicalDescription;
    TitleInfo modstitleInfo;
    String modsversionattr;
    String modidattr;
    
    public ModsDataReader(ModsCollection ms)
    {
        this.mc=mc;
    }

    public Mods getMods() {
        return mods;
    }

    public HbzIdentifier getHbzIdentifier()
    {
        return mods.getIdentifier();
    }

    public OriginInfo getOriginInfo()
    {
        return mods.getOriginInfo();
    }

    public Genre getGenre()
    {
        return mods.getGenre();
    }

    public List<Note> getNote()
    {
        return mods.getNote();
    }

    public Location getLocation()
    {
        return mods.getLocation();
    }

    public String getTypeOfResource()
    {
        return mods.getTypeOfResource();
    }

    public Subject getSubject()
    {
        return mods.getSubject();
    }

    public List<Name> getName()
    {
        return mods.getName();
    }

    public RecordInfo getRecordInfo()
    {
        return mods.getRecordInfo();
    }

    public PhysicalDescription getPhysicalDescription()
    {
        return mods.getPhysicalDescription();
    }

    public TitleInfo getTitleInfo()
    {
        return mods.getTitleInfo();
    }

    public String getVersion()
    {
        return mods.getVersion();
    }

    public String getID()
    {
        return mods.getID();
    }

   


   
    
    

}


