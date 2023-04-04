package de.uni_trier.bibliothek.xml.tei;

import java.io.IOException;
import java.util.ArrayList;

import de.uni_trier.bibliothek.ParametersProvider;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.OcrDataReader;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.parameters.model.generated.Parameters;
import de.uni_trier.bibliothek.xml.parameters.model.generated.ReadingOrder;
import de.uni_trier.bibliothek.xml.tei.model.generated.BiblStruct;
import de.uni_trier.bibliothek.xml.tei.model.generated.FileDesc;
import de.uni_trier.bibliothek.xml.tei.model.generated.Fw;
import de.uni_trier.bibliothek.xml.tei.model.generated.Imprint;
import de.uni_trier.bibliothek.xml.tei.model.generated.Lb;
import de.uni_trier.bibliothek.xml.tei.model.generated.Mods;
import de.uni_trier.bibliothek.xml.tei.model.generated.Monogr;
import de.uni_trier.bibliothek.xml.tei.model.generated.Pb;
import de.uni_trier.bibliothek.xml.tei.model.generated.PublicationStmt;
import de.uni_trier.bibliothek.xml.tei.model.generated.RespStmt;
import de.uni_trier.bibliothek.xml.tei.model.generated.Series;
import de.uni_trier.bibliothek.xml.tei.model.generated.SourceDesc;
import de.uni_trier.bibliothek.xml.tei.model.generated.TEI;
import de.uni_trier.bibliothek.xml.tei.model.generated.TeiHeader;
import de.uni_trier.bibliothek.xml.tei.model.generated.Text;
import de.uni_trier.bibliothek.xml.tei.model.generated.TitleInfo;
import de.uni_trier.bibliothek.xml.tei.model.generated.TitleStmt;
import de.uni_trier.bibliothek.xml.tei.model.generated.ObjectFactory;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.JAXBException;

public class TEICreator extends TEI {
	public static final String TEIVERSION = "5.0";

	// create objects for TEI
	public static TeiHeader teiHeader = new TeiHeader();
	public static FileDesc fileDesc = new FileDesc();
	public static TitleStmt titleStmt = new TitleStmt();
	public static PublicationStmt publicStmt = new PublicationStmt();
	public static SourceDesc sourceDesc = new SourceDesc();
	public static Mods teiMods = new Mods();
	public static BiblStruct biblStruct = new BiblStruct();
	public static Monogr monogr = new Monogr();
	public static Series series = new Series();
	public static Imprint imprint = new Imprint();
	public static TitleInfo teiTitleInfo = new TitleInfo();
	public static Text teiText = new Text();
	public static TEI teiObject = new TEI();

	// create objects for special information elements
	public static Pb pb;
	public static Fw signatureFwElement;
	public static Fw pageFwElement;
	public static Fw headerFwElement;
	public static Fw catchWordFwElement;
	public static Fw ornamentFwElement;

	// create jaxb objects for special information elements
	public static ObjectFactory teiObjectFactoryParameters = new ObjectFactory();
	public static JAXBElement<Lb> jaxbLb;	
	public static JAXBElement<Fw> jaxbFwSignature;		
	public static JAXBElement<Fw> jaxbFwPageNumber;	
	public static JAXBElement<Fw> jaxbFwHeader;	
	public static JAXBElement<Fw> jaxbFwCatchWord;
	public static JAXBElement<Fw> jaxbFwOrnament;
	public static JAXBElement<Pb> jaxbPb;


	public static TEI createTEI(ModsCollection modsCollection, ArrayList<PcGts> pcgtsList, String parametersPath)
			throws IOException, JAXBException {
		// take objects from Mods XML file
		de.uni_trier.bibliothek.xml.mods.model.generated.Mods mods = modsCollection.getMods();

		// add Lines with special information elements
		addLines(pcgtsList, parametersPath);
		
		// add Names
		addAuthors(mods);

		// add respStmt element
		addRespStmt(parametersPath);

		// get info from parameters.xml
		Parameters parameters = ParametersProvider.getParameters(parametersPath);
		// map data from modsCollection onto TEI object
		teiTitleInfo.setTitle(mods.getTitleInfo().getTitle());
		titleStmt.setTitle(mods.getTitleInfo().getTitle() + " " + parameters.getTitleAddition() + ".");
		teiObject.setText(teiText);		
		sourceDesc.setBiblStruct(biblStruct);
		biblStruct.setMonogr(monogr);
		series.setBiblScope("Band XX");
		series.setTitle(parameters.getTitle());
		biblStruct.setSeries(series);
		monogr.setEdition(mods.getOriginInfo().getEdition());
		if(mods.getTitleInfo().getSubTitle() != null){
			monogr.setTitle(mods.getTitleInfo().getTitle() + ": " + mods.getTitleInfo().getSubTitle());
		}
		else{
			monogr.setTitle(mods.getTitleInfo().getTitle());
		}
		imprint.setPubPlace(mods.getOriginInfo().getPlace().getPlaceTerm().getValue());
		imprint.setPublisher(mods.getOriginInfo().getPublisher());
		imprint.setDate(mods.getOriginInfo().getDateIssued());
		monogr.setImprint(imprint);
		fileDesc.setTitleStmt(titleStmt);
		teiHeader.setFileDesc(fileDesc);
		publicStmt.setP(parameters.getPublicationStmt().getP());
		fileDesc.setPublicationStmt(publicStmt);
		fileDesc.setSourceDesc(sourceDesc);
		teiObject.setTeiHeader(teiHeader);
		teiObject.setVersion(TEIVERSION);
		return teiObject;
	}


	public static void addRespStmt(String parametersPath) throws JAXBException, IOException
	{
		titleStmt.getRespStmt().clear();
		Parameters parameters = ParametersProvider.getParameters(parametersPath);
		ArrayList<de.uni_trier.bibliothek.xml.parameters.model.generated.RespStmt> respStmtParameters = new ArrayList<>(parameters.getRespStmtElements().getRespStmt());
		for (de.uni_trier.bibliothek.xml.parameters.model.generated.RespStmt respStmt : respStmtParameters)
		{
			RespStmt respStmtObject = new RespStmt();
			respStmtObject.setName(respStmt.getName());
			respStmtObject.setResp(respStmt.getResp());
			titleStmt.getRespStmt().add(respStmtObject);
		}	
	}

	public static void addLines(ArrayList<PcGts> pcgtsList, String parametersPath) throws IOException, JAXBException
	{
		// add lines and special elements from files with OCR-Output
		teiText.getContent().clear();
		int ipageCount = 0;
		for (PcGts pcgtsObject : pcgtsList) {	
			jaxbPb = teiObjectFactoryParameters.createTextPb(new Pb());
			jaxbLb = teiObjectFactoryParameters.createTextLb(new Lb());	
			jaxbFwSignature = teiObjectFactoryParameters.createTextFw(new Fw());		
			jaxbFwPageNumber = teiObjectFactoryParameters.createTextFw(new Fw());	
			jaxbFwHeader = teiObjectFactoryParameters.createTextFw(new Fw());	
			jaxbFwCatchWord = teiObjectFactoryParameters.createTextFw(new Fw());
			jaxbFwOrnament = teiObjectFactoryParameters.createTextFw(new Fw());
			ipageCount++;
			pb = new Pb();
			signatureFwElement = new Fw();
			pageFwElement  = new Fw();
			headerFwElement = new Fw();
			catchWordFwElement = new Fw();
			ornamentFwElement = new Fw();
			signatureFwElement.setType("sig");
			ornamentFwElement.setType("ornament");
			headerFwElement.setType("header");
			pageFwElement.setType("pageNum");
			catchWordFwElement.setType("catch");
			ArrayList<String> lineStrings = OcrDataReader.getTextLines(pcgtsObject);
			// with ImageRegion
			ArrayList<String> parametersList = getReadingOrderList(parametersPath);
			String pageNumberOCR = Integer.toString(ipageCount);
			pageNumberOCR = "[" + pageNumberOCR + "]";	
			// remove square brackets if logic page number equals OCR page number
			if (!OcrDataReader.getSpecialElement(pcgtsObject, "page-number").isEmpty())
			{
				String pageNumber = OcrDataReader.getSpecialElement(pcgtsObject, "page-number").replaceAll("[\\D]", "");
				if(ipageCount==Integer.parseInt(pageNumber))
				{
					pageNumberOCR = pageNumberOCR.substring(1, pageNumberOCR.length()-1);		
				}	
			}
			
			jaxbFwOrnament.setValue(ornamentFwElement);
			teiText.getContent().add(jaxbFwOrnament);

			pb.setN(pageNumberOCR);
			jaxbPb.setValue(pb);
			teiText.getContent().add(jaxbPb);
			addParameterElements(lineStrings, parametersList, pcgtsObject);				
		}
	}

	public static void addAuthors(de.uni_trier.bibliothek.xml.mods.model.generated.Mods mods)
	{
		monogr.getAuthor().clear();
		for (de.uni_trier.bibliothek.xml.mods.model.generated.Name nameObject : mods.getName()) {
			String nameObjectString = nameObject.getNamePart();
			monogr.getAuthor().add(nameObjectString);
		}
	}

	public static ArrayList<String> getReadingOrderList(String parametersPath) throws JAXBException, IOException
	{
		ArrayList<String> parametersList = new ArrayList<String>();
		Parameters parameters = ParametersProvider.getParameters(parametersPath);
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
						for (String textLineString : lineStrings) {
							// test auf imageregionelement
							// System.out.println(textLineString);
							if(textLineString.equals("textLineOrnament"))
							{
								System.out.println("ornament");
								teiText.getContent().add(jaxbFwOrnament);
							}
							teiText.getContent().add(jaxbLb);
							teiText.getContent().add(textLineString);
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