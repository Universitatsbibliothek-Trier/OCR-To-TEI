package de.uni_trier.bibliothek.xml;

import java.util.ArrayList;
import java.util.List;

import de.uni_trier.bibliothek.xml.mods.model.generated.GenreValue;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.mods.model.generated.Name;
import de.uni_trier.bibliothek.xml.mods.model.generated.Note;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.tei.model.generated.FileDesc;
import de.uni_trier.bibliothek.xml.tei.model.generated.SourceDec;
import de.uni_trier.bibliothek.xml.tei.model.generated.TEI;
import de.uni_trier.bibliothek.xml.tei.model.generated.TeiHeader;
import de.uni_trier.bibliothek.xml.tei.model.generated.Text;
import de.uni_trier.bibliothek.xml.tei.model.generated.TitleStmt;

public class TEICreator extends TEI
{
	public static String teiVersion = "5.0";

	public static TEI createTEI(ModsCollection modsCollection, ArrayList<PcGts> pcgtsList)
	{
		TEI teiObject = new TEI();
		de.uni_trier.bibliothek.xml.mods.model.generated.Mods modsObject = modsCollection.getMods();
		de.uni_trier.bibliothek.xml.mods.model.generated.TitleInfo titleInfo = modsObject.getTitleInfo();
		de.uni_trier.bibliothek.xml.mods.model.generated.HbzIdentifier identifierObject = modsObject.getIdentifier();
		de.uni_trier.bibliothek.xml.mods.model.generated.OriginInfo originInfo = modsObject.getOriginInfo();
		de.uni_trier.bibliothek.xml.mods.model.generated.Place placeObject = originInfo.getPlace();
		de.uni_trier.bibliothek.xml.mods.model.generated.Place.PlaceTerm placeTerm = placeObject.getPlaceTerm();
		de.uni_trier.bibliothek.xml.mods.model.generated.Genre genreObject = modsObject.getGenre();
		List<de.uni_trier.bibliothek.xml.mods.model.generated.Note> noteObjectList = modsObject.getNote();
		de.uni_trier.bibliothek.xml.mods.model.generated.Location locationObject = modsObject.getLocation();
		de.uni_trier.bibliothek.xml.mods.model.generated.Subject subjectObject = modsObject.getSubject();
		List<de.uni_trier.bibliothek.xml.mods.model.generated.Name> nameList = modsObject.getName();
		de.uni_trier.bibliothek.xml.mods.model.generated.RecordInfo recordInfo = modsObject.getRecordInfo();
		de.uni_trier.bibliothek.xml.mods.model.generated.PhysicalDescription physicalDescription = modsObject.getPhysicalDescription();
		de.uni_trier.bibliothek.xml.mods.model.generated.Form physicalForm = physicalDescription.getForm();
		


		TeiHeader teiHeader = new TeiHeader();
		FileDesc fileDesc = new FileDesc();
		TitleStmt titleStmt = new TitleStmt();
		String titleInfoString = titleInfo.getTitle();
		titleStmt.setTitle(titleInfoString + " Grundstrukturierte TEI-Daten");
		SourceDec sourceDec = new SourceDec();
		
		String modsVersion = modsObject.getVersion();
		String modsID = modsObject.getID();
		
		de.uni_trier.bibliothek.xml.tei.model.generated.Mods teiMods = new de.uni_trier.bibliothek.xml.tei.model.generated.Mods();		

		de.uni_trier.bibliothek.xml.tei.model.generated.HbzIdentifier teiHbzIdentifier = new de.uni_trier.bibliothek.xml.tei.model.generated.HbzIdentifier();		
		teiHbzIdentifier.setType(identifierObject.getType());
		teiHbzIdentifier.setValue(identifierObject.getValue());
		de.uni_trier.bibliothek.xml.tei.model.generated.OriginInfo teiOriginInfo = new de.uni_trier.bibliothek.xml.tei.model.generated.OriginInfo();

		de.uni_trier.bibliothek.xml.tei.model.generated.Place teiPlace = new de.uni_trier.bibliothek.xml.tei.model.generated.Place();		
		de.uni_trier.bibliothek.xml.tei.model.generated.Place.PlaceTerm teiPlaceTerm = new de.uni_trier.bibliothek.xml.tei.model.generated.Place.PlaceTerm();
		teiPlace.setPlaceTerm(teiPlaceTerm);
		teiPlaceTerm.setType(placeTerm.getType());
		de.uni_trier.bibliothek.xml.mods.model.generated.PlaceTermValue placeTermValue = placeTerm.getValue();
		String placeTermValueString = placeTermValue.value();
		teiPlaceTerm.setValue(de.uni_trier.bibliothek.xml.tei.model.generated.PlaceTermValue.fromValue(placeTermValueString));

		de.uni_trier.bibliothek.xml.tei.model.generated.Genre teiGenre = new de.uni_trier.bibliothek.xml.tei.model.generated.Genre();
		GenreValue genreValue = genreObject.getValue();
		String genreString = genreValue.value();
		de.uni_trier.bibliothek.xml.tei.model.generated.GenreValue teiGenreValue = de.uni_trier.bibliothek.xml.tei.model.generated.GenreValue.fromValue(genreString);

		for(Note noteObject : noteObjectList)
		{
			de.uni_trier.bibliothek.xml.tei.model.generated.Note teiNote = new de.uni_trier.bibliothek.xml.tei.model.generated.Note();
			String typeAttribute = noteObject.getType();
			String noteValue = noteObject.getValue();
			if (!(typeAttribute==null))
			{
				teiNote.setType(typeAttribute);
			}
			teiNote.setValue(noteValue);
			teiMods.getNote().add(teiNote);
		}

		de.uni_trier.bibliothek.xml.tei.model.generated.Location teiLocation = new de.uni_trier.bibliothek.xml.tei.model.generated.Location();
		teiLocation.setPhysicalLocation(locationObject.getPhysicalLocation());

		String subjectString = subjectObject.getTopic();
		de.uni_trier.bibliothek.xml.tei.model.generated.Subject teiSubject = new de.uni_trier.bibliothek.xml.tei.model.generated.Subject();
		teiSubject.setTopic(subjectString);
		
		for(Name nameObject : nameList)
		{
			de.uni_trier.bibliothek.xml.tei.model.generated.Name teiName = new de.uni_trier.bibliothek.xml.tei.model.generated.Name();
			teiName.setNamePart(nameObject.getNamePart());
			teiMods.getName().add(teiName);
		}

		String recordContentString = recordInfo.getRecordContentSource();
		de.uni_trier.bibliothek.xml.tei.model.generated.RecordInfo teiRecordInfo = new de.uni_trier.bibliothek.xml.tei.model.generated.RecordInfo();
		teiRecordInfo.setRecordContentSource(recordContentString);

		String physicalDescriptionString = physicalDescription.getExtent();
		de.uni_trier.bibliothek.xml.tei.model.generated.PhysicalDescription teiPhysicalDescription = new de.uni_trier.bibliothek.xml.tei.model.generated.PhysicalDescription();
		teiPhysicalDescription.setExtent(physicalDescriptionString);
		String physicalFormAttribute = physicalForm.getAuthority();
		de.uni_trier.bibliothek.xml.tei.model.generated.Form teiPhysicalForm = new de.uni_trier.bibliothek.xml.tei.model.generated.Form();	
		String physicalFormValue = physicalForm.getValue();
		teiPhysicalForm.setValue(physicalForm.getValue());
		teiPhysicalForm.setAuthority(physicalForm.getAuthority());
		teiPhysicalDescription.setForm(teiPhysicalForm);
		
		de.uni_trier.bibliothek.xml.tei.model.generated.TitleInfo teiTitleInfo = new de.uni_trier.bibliothek.xml.tei.model.generated.TitleInfo();
		teiTitleInfo.setTitle(titleInfoString);	





		Text textObject = new Text();
		// List<Serializable> list = new List<Serializable>();
		// textObject.content =List<Serializable>;
		teiMods.setTitleInfo(teiTitleInfo);
		teiMods.setPhysicalDescription(teiPhysicalDescription);
		teiMods.setRecordInfo(teiRecordInfo);
		teiMods.setSubject(teiSubject);
		teiMods.setTypeOfResource(modsObject.getTypeOfResource());
		teiMods.setLocation(teiLocation);
		teiGenre.setValue(teiGenreValue);
		teiGenre.setAuthority(genreObject.getAuthority());
		teiMods.setGenre(teiGenre);
		teiOriginInfo.setDateIssued(originInfo.getDateIssued());
		teiOriginInfo.setPlace(teiPlace);
		teiOriginInfo.setPublisher(originInfo.getPublisher());
		teiMods.setIdentifier(teiHbzIdentifier);
		teiMods.setOriginInfo(teiOriginInfo);
		teiMods.setVersion(modsVersion);
		teiMods.setID(modsID);
		sourceDec.setMods(teiMods);
		teiHeader.setSourceDesc(sourceDec);	
		fileDesc.setTitleStmt(titleStmt);
		teiHeader.setFileDesc(fileDesc);	
		teiObject.setTeiHeader(teiHeader);
		teiObject.setVersion(teiVersion);
		teiObject.setText(textObject);
		return teiObject;
		
	}


}