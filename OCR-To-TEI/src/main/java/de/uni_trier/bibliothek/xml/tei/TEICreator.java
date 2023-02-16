package de.uni_trier.bibliothek.xml.tei;

import java.io.IOException;
import java.util.ArrayList;

import de.uni_trier.bibliothek.xml.tei.model.generated.GenreValue;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.tei.model.generated.Name;
import de.uni_trier.bibliothek.xml.ocr.OcrDataLineReader;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.tei.model.generated.FileDesc;
import de.uni_trier.bibliothek.xml.tei.model.generated.Form;
import de.uni_trier.bibliothek.xml.tei.model.generated.HbzIdentifier;
import de.uni_trier.bibliothek.xml.tei.model.generated.Lb;
import de.uni_trier.bibliothek.xml.tei.model.generated.Location;
import de.uni_trier.bibliothek.xml.tei.model.generated.Mods;
import de.uni_trier.bibliothek.xml.tei.model.generated.OriginInfo;
import de.uni_trier.bibliothek.xml.tei.model.generated.Pb;
import de.uni_trier.bibliothek.xml.tei.model.generated.PhysicalDescription;
import de.uni_trier.bibliothek.xml.tei.model.generated.Place;
import de.uni_trier.bibliothek.xml.tei.model.generated.Place.PlaceTerm;
import de.uni_trier.bibliothek.xml.tei.model.generated.PlaceTermValue;
import de.uni_trier.bibliothek.xml.tei.model.generated.RecordInfo;
import de.uni_trier.bibliothek.xml.tei.model.generated.SourceDesc;
import de.uni_trier.bibliothek.xml.tei.model.generated.Subject;
import de.uni_trier.bibliothek.xml.tei.model.generated.TEI;
import de.uni_trier.bibliothek.xml.tei.model.generated.TeiHeader;
import de.uni_trier.bibliothek.xml.tei.model.generated.Text;
import de.uni_trier.bibliothek.xml.tei.model.generated.TitleInfo;
import de.uni_trier.bibliothek.xml.tei.model.generated.TitleStmt;
import de.uni_trier.bibliothek.xml.tei.model.generated.Genre;
import de.uni_trier.bibliothek.xml.tei.model.generated.Note;
import de.uni_trier.bibliothek.xml.tei.model.generated.ObjectFactory;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;

public class TEICreator extends TEI {
	public static final String TEIVERSION = "5.0";

	public static TEI createTEI(ModsCollection modsCollection, ArrayList<PcGts> pcgtsList, String title)
			throws IOException, JAXBException {
		// take object from Mods XML file
		TEI teiObject = new TEI();
		de.uni_trier.bibliothek.xml.mods.model.generated.Mods mods = modsCollection.getMods();

		// create new objects for TEI
		TeiHeader teiHeader = new TeiHeader();
		FileDesc fileDesc = new FileDesc();
		TitleStmt titleStmt = new TitleStmt();
		String titleInfoString = title;
		titleStmt.setTitle(titleInfoString + " Grundstrukturierte TEI-Daten");
		SourceDesc sourceDesc = new SourceDesc();

		String modsVersion = mods.getVersion();
		String modsID = mods.getID();

		Mods teiMods = new Mods();
		HbzIdentifier teiHbzIdentifier = new HbzIdentifier();
		teiHbzIdentifier.setType(mods.getIdentifier().getType());
		teiHbzIdentifier.setValue(mods.getIdentifier().getValue());
		OriginInfo teiOriginInfo = new OriginInfo();

		Place teiPlace = new Place();
		PlaceTerm teiPlaceTerm = new PlaceTerm();
		teiPlace.setPlaceTerm(teiPlaceTerm);
		teiPlaceTerm.setType(mods.getOriginInfo().getPlace().getPlaceTerm().getType());
		String placeTermValueString = mods.getOriginInfo().getPlace().getPlaceTerm().getValue().value();
		teiPlaceTerm.setValue(PlaceTermValue.fromValue(placeTermValueString));

		Genre teiGenre = new Genre();
		String genreString = mods.getGenre().getValue().value();
		GenreValue teiGenreValue = GenreValue.fromValue(genreString);

		for (de.uni_trier.bibliothek.xml.mods.model.generated.Note noteObject : mods.getNote()) {
			Note teiNote = new Note();
			String typeAttribute = noteObject.getType();
			String noteValue = noteObject.getValue();
			if (!(typeAttribute == null)) {
				teiNote.setType(typeAttribute);
			}
			teiNote.setValue(noteValue);
			teiMods.getNote().add(teiNote);
		}

		Location teiLocation = new Location();
		teiLocation.setPhysicalLocation(mods.getLocation().getPhysicalLocation());

		String subjectString = mods.getSubject().getTopic();
		Subject teiSubject = new Subject();
		teiSubject.setTopic(subjectString);

		for (de.uni_trier.bibliothek.xml.mods.model.generated.Name nameObject : mods.getName()) {
			Name teiName = new Name();
			String namePart = nameObject.getNamePart();
			teiName.setNamePart(namePart);
			teiMods.getName().add(teiName);
		}

		String recordContentString = mods.getRecordInfo().getRecordContentSource();
		RecordInfo teiRecordInfo = new RecordInfo();
		teiRecordInfo.setRecordContentSource(recordContentString);

		String physicalDescriptionString = mods.getPhysicalDescription().getExtent();
		PhysicalDescription teiPhysicalDescription = new PhysicalDescription();
		teiPhysicalDescription.setExtent(physicalDescriptionString);
		Form teiPhysicalForm = new Form();
		teiPhysicalForm.setValue(mods.getPhysicalDescription().getForm().getValue());
		teiPhysicalForm.setAuthority(mods.getPhysicalDescription().getForm().getAuthority());
		teiPhysicalDescription.setForm(teiPhysicalForm);

		TitleInfo teiTitleInfo = new TitleInfo();
		teiTitleInfo.setTitle(titleInfoString);

		Text teiText = new Text();

		// add lines from files with OCR-Output
		ObjectFactory teiObjectFactory = new ObjectFactory();
		ArrayList<String> lineStrings = new ArrayList<>();
		JAXBElement<Lb> lb = teiObjectFactory.createTextLb(new Lb());
		JAXBElement<Pb> pb = teiObjectFactory.createTextPb(new Pb());
		for (PcGts pcgtsObject : pcgtsList) {
			teiText.getContent().add(pb);
			lineStrings = OcrDataLineReader.getTextLines(pcgtsObject);
			for (String textLineStrings : lineStrings) {
				teiText.getContent().add(lb);
				teiText.getContent().add(textLineStrings);
			}
		}

		// map data from modsCollection onto TEI object
		teiObject.setText(teiText);
		teiMods.setTitleInfo(teiTitleInfo);
		teiMods.setPhysicalDescription(teiPhysicalDescription);
		teiMods.setRecordInfo(teiRecordInfo);
		teiMods.setSubject(teiSubject);
		teiMods.setTypeOfResource(mods.getTypeOfResource());
		teiMods.setLocation(teiLocation);
		teiGenre.setValue(teiGenreValue);
		teiGenre.setAuthority(mods.getGenre().getAuthority());
		teiMods.setGenre(teiGenre);
		teiOriginInfo.setDateIssued(mods.getOriginInfo().getDateIssued());
		teiOriginInfo.setPlace(teiPlace);
		teiOriginInfo.setPublisher(mods.getOriginInfo().getPublisher());
		teiMods.setIdentifier(teiHbzIdentifier);
		teiMods.setOriginInfo(teiOriginInfo);
		teiMods.setVersion(modsVersion);
		teiMods.setID(modsID);
		sourceDesc.setMods(teiMods);
		teiHeader.setSourceDesc(sourceDesc);
		fileDesc.setTitleStmt(titleStmt);
		teiHeader.setFileDesc(fileDesc);
		teiObject.setTeiHeader(teiHeader);
		teiObject.setVersion(TEIVERSION);
		return teiObject;
	}

}