package de.uni_trier.bibliothek.xml.ocr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import de.uni_trier.bibliothek.xml.ocr.model.generated.ImageRegion;
import de.uni_trier.bibliothek.xml.ocr.model.generated.OrderedGroup;
import de.uni_trier.bibliothek.xml.ocr.model.generated.Page;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.ocr.model.generated.RegionRefIndexed;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextEquiv;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextLine;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextRegion;
import jakarta.xml.bind.JAXBException;

public class OcrDataReader extends PcGts {

	public static ArrayList<String> getTextLines(PcGts pcgtsObject) throws IOException, JAXBException {
		ArrayList<String> ocrTextLineList = new ArrayList<String>();
		// read values from Java object
		Page page = pcgtsObject.getPage();
		String capital = "";
		boolean capitalExists = false;
		boolean firstImageRegionAppearance = false;
		List<Object> imageOrRegionList = getRegionOrTextRegionListOrdered(page);
		int regioncount = 0;
		// List<TextRegion> textRegionOrdered = sortOrder(page);
		for (Object textOrImageRegion : imageOrRegionList) {
			// regioncount++;
			// if(regioncount == firstImageRegionAppearance)
			// {
				// System.out.println("ImageRegion number is: " + firstImageRegionAppearance);
				// Fw ornamentFwElement;
			// }
			// check if drop-capital exists
			if(textOrImageRegion instanceof TextRegion)
			{
				TextRegion textRegion =  TextRegion.class.cast(textOrImageRegion);
				if (textRegion.getType().equals("drop-capital"))
				{	
					if (textRegion.getTextLine().isEmpty()) {
						for (TextEquiv TextEquiv : textRegion.getTextEquiv()) {
							if (TextEquiv.getUnicode() != null) {
								capitalExists = true;
								capital = TextEquiv.getUnicode();
							}
						}
				} else 
				{
					for (TextLine textLine : textRegion.getTextLine()) {
						List<TextEquiv> textEquivList = textLine.getTextEquiv();
						if (!textEquivList.isEmpty()) {
							for (TextEquiv TextEquiv : textEquivList) {
								if (TextEquiv.getUnicode() != null) {
									capitalExists = true;
									capital = TextEquiv.getUnicode();;
								}
							}
						}
					}
				}
				}
				else if (textRegion.getType().equals("paragraph")) {
					for (TextLine textLine : textRegion.getTextLine()) {
						List<TextEquiv> textEquivList = textLine.getTextEquiv();
						// get attribute "id" from textline
						String textLineID = textLine.getId();
						char l = 'l';
						// check if new line begins
						if (textLineID.charAt(0) == l && !textEquivList.isEmpty()) {
							for (TextEquiv TextEquiv : textEquivList) {
								String unicode = TextEquiv.getUnicode();
								if (TextEquiv.getIndex() != null && TextEquiv.getIndex().equals("0")) {
									if(capitalExists)
									{
										unicode = capital + unicode;
										capitalExists = false;
									}	
									// add text from Unicode to ArrayList
									ocrTextLineList.add(unicode);
									break; // sought index found
								}
							}
						}
					}
				}
			}
			else if((!firstImageRegionAppearance) && textOrImageRegion instanceof ImageRegion){
				System.out.println("image region added");
				// ocrTextLineList.add("textLineOrnament");
				firstImageRegionAppearance = true;
			}			
		}
		return ocrTextLineList;
	}

	public static void csvPageNameComments(String fileName, PcGts pcgtsObject, File csvFile) {
		String pageNumber = getSpecialElement(pcgtsObject, "page-number");
		String comment = "";
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(csvFile, true);
			CSVWriter writer = new CSVWriter(outputfile);
			// add data to csv
			if (!pageNumber.matches("[0-9]+")) {
				comment = "Seitenzahl nicht erkannt";
			}
			String[] data1 = { fileName, pageNumber, comment };
			writer.writeNext(data1);
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	// public static List<TextRegion> sortOrder(Page page) {
	// 	OrderedGroup orderedGroup = page.getReadingOrder().getOrderedGroup();
	// 	List<TextRegion> textRegionListOrdered = new ArrayList<TextRegion>();
	// 	List<Object> textRegionObjectList = page.getTextRegionOrImageRegion();
	// 	List<TextRegion> textRegionList = new ArrayList<TextRegion>();
	// 	for (Object textRegionOrImageRegion : textRegionObjectList) {
	// 		if(textRegionOrImageRegion instanceof TextRegion)
	// 		{
	// 			TextRegion textRegion =  TextRegion.class.cast(textRegionOrImageRegion);
	// 			textRegionList.add(textRegion);
	// 		}	
	// 	}
	// 	List<RegionRefIndexed> regionRefIndexedList = orderedGroup.getRegionRefIndexed();
	// 	for (int i = 0; i < regionRefIndexedList.size(); i++) {
	// 		String regionRefId = regionRefIndexedList.get(i).getRegionRef();
	// 		for (int y = 0; y < textRegionList.size(); y++) {
	// 			TextRegion textRegion = textRegionList.get(y);
	// 			if (textRegion.getId().equals(regionRefId)) {
	// 				textRegionListOrdered.add(textRegionList.get(y));
	// 				break; // found correct TextRegion
	// 			}
	// 		}
	// 	}
	// 	return textRegionListOrdered;
	// }

	public static String getSpecialElement(PcGts pcgtsObject, String elementType) {
		String specialElement = "";
		List<Object> textRegionObjectList = pcgtsObject.getPage().getTextRegionOrImageRegion();
		List<TextRegion> textRegionList = new ArrayList<TextRegion>();
		for (Object textRegionOrImageRegion : textRegionObjectList) {
			if(textRegionOrImageRegion instanceof TextRegion)
			{
				TextRegion textRegion =  TextRegion.class.cast(textRegionOrImageRegion);
				textRegionList.add(textRegion);
			}	
		}
		for (TextRegion textRegion : textRegionList) {
			if (textRegion.getType().equals(elementType)) {
				if (textRegion.getTextLine().isEmpty()) {
					for (TextEquiv TextEquiv : textRegion.getTextEquiv()) {
						if (TextEquiv.getUnicode() != null) {
							specialElement = TextEquiv.getUnicode();
						}
					}
				} else {
					for (TextLine textLine : textRegion.getTextLine()) {
						List<TextEquiv> textEquivList = textLine.getTextEquiv();
						if (!textEquivList.isEmpty()) {
							for (TextEquiv TextEquiv : textEquivList) {
								if (TextEquiv.getUnicode() != null) {
									specialElement = TextEquiv.getUnicode();
								}
							}
						}
					}
				}
			}
		}
		return specialElement;
	}

	public static List<Object> getRegionOrTextRegionListOrdered(Page page) {
		OrderedGroup orderedGroup = page.getReadingOrder().getOrderedGroup();
		List<Object> textRegionOrImageRegionListOrdered = new ArrayList<Object>();
		List<Object> textRegionObjectList = page.getTextRegionOrImageRegion();
		boolean imageRegionAppearance = false;
		List<TextRegion> textRegionList = new ArrayList<TextRegion>();
		boolean foundFirstImageRegion = false;
		int regionCount = 0;
		List<RegionRefIndexed> regionRefIndexedList = orderedGroup.getRegionRefIndexed();
		for (int i = 0; i < regionRefIndexedList.size(); i++) {
			String regionRefId = regionRefIndexedList.get(i).getRegionRef();
			for (Object textOrImageRegion : textRegionObjectList) {

				
				if(textOrImageRegion instanceof TextRegion)
				{
					TextRegion textRegion =  TextRegion.class.cast(textOrImageRegion);
					if (textRegion.getId().equals(regionRefId)) {
						// System.out.println("text region added");
						textRegionOrImageRegionListOrdered.add(textRegion);
						// break; // found correct TextRegion
					}	
				}
				if((!imageRegionAppearance) && textOrImageRegion instanceof ImageRegion){
					
					ImageRegion imageRegion =  ImageRegion.class.cast(textOrImageRegion);
					// System.out.println("image region added");
					
					System.out.println("image region added");
					textRegionOrImageRegionListOrdered.add(imageRegion);
					imageRegionAppearance = true;
					// break; // found correct TextRegion
					
				}				
			}
		}
		return textRegionOrImageRegionListOrdered;
	}
}