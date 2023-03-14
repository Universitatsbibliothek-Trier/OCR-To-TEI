package de.uni_trier.bibliothek.xml.tei;

import java.io.IOException;
import java.util.ArrayList;

import de.uni_trier.bibliothek.xml.tei.model.generated.GenreValue;
import de.uni_trier.bibliothek.ParametersProvider;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.tei.model.generated.Name;
import de.uni_trier.bibliothek.xml.ocr.OcrDataReader;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.parameters.model.generated.Parameters;
import de.uni_trier.bibliothek.xml.parameters.model.generated.ReadingOrder;
import de.uni_trier.bibliothek.xml.tei.model.generated.FileDesc;
import de.uni_trier.bibliothek.xml.tei.model.generated.Form;
import de.uni_trier.bibliothek.xml.tei.model.generated.Fw;
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

	// create objects for special information elements
	public static Pb pb;
	public static Fw signatureFwElement;
	public static Fw pageFwElement;
	public static Fw headerFwElement;
	public static Fw catchWordFwElement;

	// create jaxb objects for special information elements
	public static ObjectFactory teiObjectFactoryParameters = new ObjectFactory();
	public static JAXBElement<Lb> jaxbLb;	
	public static JAXBElement<Fw> jaxbFwSignature;		
	public static JAXBElement<Fw> jaxbFwPageNumber;	
	public static JAXBElement<Fw> jaxbFwHeader;	
	public static JAXBElement<Fw> jaxbFwCatchWord;
	public static JAXBElement<Pb> jaxbPb;


	public static TEI createTEI(ModsCollection modsCollection, ArrayList<PcGts> pcgtsList)
			throws IOException, JAXBException {
		// take objects from Mods XML file
		de.uni_trier.bibliothek.xml.tei.model.generated.ModsCollection teiModsCollection = new de.uni_trier.bibliothek.xml.tei.model.generated.ModsCollection();
		de.uni_trier.bibliothek.xml.mods.model.generated.Mods mods = modsCollection.getMods();

		// add Notes
		addNotes(mods);

		// add Lines with special information elements
		addLines(pcgtsList);
		
		// add Names
		addNames(mods);

		// get title appendage from parameters.xml
		Parameters parameters = ParametersProvider.getParameters();

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
		titleStmt.setTitle(mods.getTitleInfo().getTitle() + " " + parameters.getTitleAddition());
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
		// add lines and special elements from files with OCR-Output
		int ipageCount = 0;
		for (PcGts pcgtsObject : pcgtsList) {	
			jaxbPb = teiObjectFactoryParameters.createTextPb(new Pb());
			jaxbLb = teiObjectFactoryParameters.createTextLb(new Lb());	
			jaxbFwSignature = teiObjectFactoryParameters.createTextFw(new Fw());		
			jaxbFwPageNumber = teiObjectFactoryParameters.createTextFw(new Fw());	
			jaxbFwHeader = teiObjectFactoryParameters.createTextFw(new Fw());	
			jaxbFwCatchWord = teiObjectFactoryParameters.createTextFw(new Fw());
			ipageCount++;
			pb = new Pb();
			signatureFwElement = new Fw();
			pageFwElement  = new Fw();
			headerFwElement = new Fw();
			catchWordFwElement = new Fw();
			signatureFwElement.setType("sig");
			headerFwElement.setType("header");
			pageFwElement.setType("pageNum");
			catchWordFwElement.setType("catch");
			ArrayList<String> lineStrings = OcrDataReader.getTextLines(pcgtsObject);
			ArrayList<String> parametersList = getReadingOrderList();
			String pageNumberOCR = Integer.toString(ipageCount);
			pageNumberOCR = "[" + pageNumberOCR + "]";	
			if (!OcrDataReader.getSpecialElement(pcgtsObject, "page-number").isEmpty())
			{
				String pageNumber = OcrDataReader.getSpecialElement(pcgtsObject, "page-number").replaceAll("[\\D]", "");
				if(ipageCount==Integer.parseInt(pageNumber))
				{
					pageNumberOCR = pageNumberOCR.substring(1, pageNumberOCR.length()-1);		
				}	
			}
			pb.setN(pageNumberOCR);
			jaxbPb.setValue(pb);
			teiText.getContent().add(jaxbPb);
			addParameterElements(lineStrings, parametersList, pcgtsObject);				
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

	public static ArrayList<String> getReadingOrderList() throws JAXBException, IOException
	{
		ArrayList<String> parametersList = new ArrayList<String>();
		Parameters parameters = ParametersProvider.getParameters();
		ReadingOrder readingOrder = parameters.getReadingOrder();
		parametersList.add(readingOrder.getFirst());
		parametersList.add(readingOrder.getSecond());
		parametersList.add(readingOrder.getThird());
		parametersList.add(readingOrder.getFourth());
		parametersList.add(readingOrder.getFifth());
		parametersList.add(readingOrder.getSixth());
		parametersList.add(readingOrder.getSeventh());
		return parametersList;
	}


	public static void addParameterElements (ArrayList<String> lineStrings, ArrayList<String> parametersList, PcGts pcgtsObject)
	{
		// use order from parameters file
		for (String orderType : parametersList)
			{
				switch(orderType)
				{
					case "page_number":
						addSpecialElement(pcgtsObject, "page-number", pageFwElement, jaxbFwPageNumber);
						break;
					case "header":
						addSpecialElement(pcgtsObject, "header", headerFwElement, jaxbFwHeader);
						break;
					case "subheading":
						// marked as paragraph element
						break;
					case "drop_capital":
						// processed in method "getTextLines" from OcrDataReader
						break;
					case "paragraph":
						for (String textLineStrings : lineStrings) {
							teiText.getContent().add(jaxbLb);
							teiText.getContent().add(textLineStrings);
						}
						break;
					case "catch_word":
						addSpecialElement(pcgtsObject, "catch-word", catchWordFwElement, jaxbFwCatchWord);
						break;
					case "signature_mark":
						addSpecialElement(pcgtsObject, "signature-mark", signatureFwElement, jaxbFwSignature);
						break;
					default:
						System.out.println("Fehler bei der Angabe der Reading Order. Bitte in \"paramters.xml\" korrigieren.");
						break;
				}	
			}
	}

	public static void addSpecialElement(PcGts pcgtsObject, String elementType, Fw fwElement, JAXBElement<Fw> jaxbElement)
	{
		if(!OcrDataReader.getSpecialElement(pcgtsObject,elementType).isEmpty()) {
			fwElement.setValue(OcrDataReader.getSpecialElement(pcgtsObject,elementType));
			jaxbElement.setValue(fwElement);
			teiText.getContent().add(jaxbElement);
		}
	}
}