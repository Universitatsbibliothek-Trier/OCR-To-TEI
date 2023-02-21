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

	public static TEI createTEI(ModsCollection modsCollection, ArrayList<PcGts> pcgtsList)
			throws IOException, JAXBException {
		TEI teiObject = new TEI();		
		// take objects from Mods XML file
		de.uni_trier.bibliothek.xml.tei.model.generated.ModsCollection teiModsCollection = new de.uni_trier.bibliothek.xml.tei.model.generated.ModsCollection();
		de.uni_trier.bibliothek.xml.mods.model.generated.Mods mods = modsCollection.getMods();

		// create objects for TEI
		TeiHeader teiHeader = new TeiHeader();
		FileDesc fileDesc = new FileDesc();
		TitleStmt titleStmt = new TitleStmt();
		SourceDesc sourceDesc = new SourceDesc();
		Mods teiMods = new Mods();
		HbzIdentifier teiHbzIdentifier = new HbzIdentifier();
		OriginInfo teiOriginInfo = new OriginInfo();
		Place teiPlace = new Place();
		PlaceTerm teiPlaceTerm = new PlaceTerm();
		Genre teiGenre = new Genre();
		Location teiLocation = new Location();
		Subject teiSubject = new Subject();
		RecordInfo teiRecordInfo = new RecordInfo();
		PhysicalDescription teiPhysicalDescription = new PhysicalDescription();
		Form teiPhysicalForm = new Form();
		TitleInfo teiTitleInfo = new TitleInfo();
		Text teiText = new Text();
		
		for (de.uni_trier.bibliothek.xml.mods.model.generated.Note noteObject : mods.getNote()) {
			Note teiNote = new Note();
			String typeAttribute = noteObject.getType();
			if (!(typeAttribute == null)) {
				teiNote.setType(typeAttribute);
			}
			teiNote.setValue(noteObject.getValue());
			teiMods.getNote().add(teiNote);
		}

		for (de.uni_trier.bibliothek.xml.mods.model.generated.Name nameObject : mods.getName()) {
			Name teiName = new Name();
			teiName.setNamePart(nameObject.getNamePart());
			teiMods.getName().add(teiName);
		}

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
		teiTitleInfo.setTitle(mods.getTitleInfo().getTitle());
		teiPhysicalForm.setValue(mods.getPhysicalDescription().getForm().getValue());
		teiPhysicalForm.setAuthority(mods.getPhysicalDescription().getForm().getAuthority());
		teiPhysicalDescription.setForm(teiPhysicalForm);
		teiPhysicalDescription.setExtent(mods.getPhysicalDescription().getExtent());
		teiRecordInfo.setRecordContentSource(mods.getRecordInfo().getRecordContentSource());
		teiSubject.setTopic(mods.getSubject().getTopic());
		teiLocation.setPhysicalLocation(mods.getLocation().getPhysicalLocation());
		teiPlaceTerm.setValue(PlaceTermValue.fromValue(mods.getOriginInfo().getPlace().getPlaceTerm().getValue().value()));
		teiPlace.setPlaceTerm(teiPlaceTerm);
		teiPlaceTerm.setType(mods.getOriginInfo().getPlace().getPlaceTerm().getType());
		teiHbzIdentifier.setType(mods.getIdentifier().getType());
		teiHbzIdentifier.setValue(mods.getIdentifier().getValue());
		titleStmt.setTitle(mods.getTitleInfo().getTitle() + " Grundstrukturierte TEI-Daten");
		teiObject.setText(teiText);
		teiMods.setTitleInfo(teiTitleInfo);
		teiMods.setPhysicalDescription(teiPhysicalDescription);
		teiMods.setRecordInfo(teiRecordInfo);
		teiMods.setSubject(teiSubject);
		teiMods.setTypeOfResource(mods.getTypeOfResource());
		teiMods.setLocation(teiLocation);
		teiGenre.setValue(GenreValue.fromValue(mods.getGenre().getValue().value()));
		teiGenre.setAuthority(mods.getGenre().getAuthority());
		teiMods.setGenre(teiGenre);
		teiOriginInfo.setDateIssued(mods.getOriginInfo().getDateIssued());
		teiOriginInfo.setPlace(teiPlace);
		teiOriginInfo.setPublisher(mods.getOriginInfo().getPublisher());
		teiMods.setIdentifier(teiHbzIdentifier);
		teiMods.setOriginInfo(teiOriginInfo);
		teiMods.setVersion(mods.getVersion());
		teiMods.setID(mods.getID());
		teiModsCollection.setMods(teiMods);
		sourceDesc.setModsCollection(teiModsCollection);
		teiHeader.setSourceDesc(sourceDesc);
		fileDesc.setTitleStmt(titleStmt);
		teiHeader.setFileDesc(fileDesc);
		teiObject.setTeiHeader(teiHeader);
		teiObject.setVersion(TEIVERSION);
		return teiObject;
	}

}