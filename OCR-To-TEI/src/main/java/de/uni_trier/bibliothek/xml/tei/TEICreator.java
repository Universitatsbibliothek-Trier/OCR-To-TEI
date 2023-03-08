package de.uni_trier.bibliothek.xml.tei;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.math.BigInteger;
import java.util.ArrayList;

import de.uni_trier.bibliothek.xml.tei.model.generated.GenreValue;
import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.Parameters;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.tei.model.generated.Name;
import de.uni_trier.bibliothek.xml.ocr.OcrDataReader;
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

	// create objects for TEI
	public static TeiHeader teiHeader = new TeiHeader();
	public static FileDesc fileDesc = new FileDesc();
	public static TitleStmt titleStmt = new TitleStmt();
	public static SourceDesc sourceDesc = new SourceDesc();
	public static Mods teiMods = new Mods();
	public static HbzIdentifier teiHbzIdentifier = new HbzIdentifier();
	public static OriginInfo teiOriginInfo = new OriginInfo();
	public static Place teiPlace = new Place();
	public static PlaceTerm teiPlaceTerm = new PlaceTerm();
	public static Genre teiGenre = new Genre();
	public static Location teiLocation = new Location();
	public static Subject teiSubject = new Subject();
	public static RecordInfo teiRecordInfo = new RecordInfo();
	public static PhysicalDescription teiPhysicalDescription = new PhysicalDescription();
	public static Form teiPhysicalForm = new Form();
	public static TitleInfo teiTitleInfo = new TitleInfo();
	public static Text teiText = new Text();
	public static TEI teiObject = new TEI();

	public static TEI createTEI(ModsCollection modsCollection, ArrayList<PcGts> pcgtsList)
			throws IOException, JAXBException {
		// take objects from Mods XML file
		de.uni_trier.bibliothek.xml.tei.model.generated.ModsCollection teiModsCollection = new de.uni_trier.bibliothek.xml.tei.model.generated.ModsCollection();
		de.uni_trier.bibliothek.xml.mods.model.generated.Mods mods = modsCollection.getMods();

		// add Notes
		addNotes(mods);

		// add Lines
		addLines(pcgtsList);
		
		// add Names
		addNames(mods);

		// map data from modsCollection onto TEI object
		// get title appendage from parameters.xml
		Unmarshaller<Parameters> unmarshallerParameters = new Unmarshaller<>(Parameters.class);
		InputStream inputStreamParameters = new FileInputStream("../parameters/parameters.xml");
		Reader xmlReaderParameters = new InputStreamReader(inputStreamParameters);
		Parameters parameters = unmarshallerParameters.unmarshal(xmlReaderParameters);
		xmlReaderParameters.close();
		inputStreamParameters.close();
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
		titleStmt.setTitle(mods.getTitleInfo().getTitle() + " " + parameters.title);
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

	public static void addLines(ArrayList<PcGts> pcgtsList) throws IOException, JAXBException
	{
		// add lines from files with OCR-Output
		ObjectFactory teiObjectFactory = new ObjectFactory();
		ArrayList<String> lineStrings = new ArrayList<>();
		JAXBElement<Lb> jaxbLb = teiObjectFactory.createTextLb(new Lb());
		for (PcGts pcgtsObject : pcgtsList) {
			JAXBElement<Pb> jaxbPb = teiObjectFactory.createTextPb(new Pb());
			Pb pb = new Pb();
			lineStrings = OcrDataReader.getTextLines(pcgtsObject);
			if (!OcrDataReader.getPageNumber(pcgtsObject).isEmpty()) {
				int pageNumber = Integer.parseInt(OcrDataReader.getPageNumber(pcgtsObject).replaceAll("[\\D]", ""));
				pb.setN(BigInteger.valueOf(pageNumber));
				jaxbPb.setValue(pb);
			} 
			teiText.getContent().add(jaxbPb);
			for (String textLineStrings : lineStrings) {
				teiText.getContent().add(jaxbLb);
				teiText.getContent().add(textLineStrings);
			}
		}
	}

	public static void addNotes(de.uni_trier.bibliothek.xml.mods.model.generated.Mods mods)
	{
		for (de.uni_trier.bibliothek.xml.mods.model.generated.Note noteObject : mods.getNote()) {
			Note teiNote = new Note();
			String typeAttribute = noteObject.getType();
			if (!(typeAttribute == null)) {
				teiNote.setType(typeAttribute);
			}
			teiNote.setValue(noteObject.getValue());
			teiMods.getNote().add(teiNote);
		}
	}

	public static void addNames(de.uni_trier.bibliothek.xml.mods.model.generated.Mods mods)
	{
		for (de.uni_trier.bibliothek.xml.mods.model.generated.Name nameObject : mods.getName()) {
			Name teiName = new Name();
			teiName.setNamePart(nameObject.getNamePart());
			teiMods.getName().add(teiName);
		}
	}

}