// Copyright (c) 2023 René Ackels

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.

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
		Page page = pcgtsObject.getPage();
		String capital = "";
		boolean capitalExists = false;
		List<Object> imageOrRegionList = getRegionOrTextRegionListOrdered(page);
		for (Object textOrImageRegion : imageOrRegionList) {
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
						String textLineID = textLine.getId();
						char l = 'l';
						char r = 'r';
						if (textLineID.charAt(0) == l || textLineID.charAt(0) == r && !textEquivList.isEmpty()) {
							for (TextEquiv TextEquiv : textEquivList) {
								String unicode = TextEquiv.getUnicode();
								if (TextEquiv.getIndex() != null && TextEquiv.getIndex().equals("0")) {
									if(capitalExists)
									{
										unicode = capital + unicode;
										capitalExists = false;
									}	
									ocrTextLineList.add(unicode);
									break; // sought index found
								}
							}
						}
					}
				}
			}
			else if(textOrImageRegion instanceof ImageRegion){
				ocrTextLineList.add("textLineOrnament");
			}			
		}
		return ocrTextLineList;
	}

	public static void csvPageNameComments(String fileName, PcGts pcgtsObject, File csvFile) {
		String pageNumber = getSpecialElement(pcgtsObject, "page-number");
		String comment = "";
		try {
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

	public static List<Object> getRegionOrTextRegionListOrdered(Page page) 
	{
		OrderedGroup orderedGroup = page.getReadingOrder().getOrderedGroup();
		List<Object> textRegionOrImageRegionListOrdered = new ArrayList<Object>();
		List<Object> textRegionObjectList = page.getTextRegionOrImageRegion();
		boolean imageRegionAppearance = false;
		List<RegionRefIndexed> regionRefIndexedList = orderedGroup.getRegionRefIndexed();
		for (Object textOrImageRegion : textRegionObjectList){
			if((!imageRegionAppearance) && textOrImageRegion instanceof ImageRegion)
			{
				imageRegionAppearance = true;
				ImageRegion imageRegion =  ImageRegion.class.cast(textOrImageRegion);
				textRegionOrImageRegionListOrdered.add(imageRegion);
			}
		}
		for (int i = 0; i < regionRefIndexedList.size(); i++) {
			String regionRefId = regionRefIndexedList.get(i).getRegionRef();
			for (Object textOrImageRegion : textRegionObjectList) {	
				if(textOrImageRegion instanceof TextRegion)
				{
					TextRegion textRegion =  TextRegion.class.cast(textOrImageRegion);
					if (textRegion.getId().equals(regionRefId)) {
						textRegionOrImageRegionListOrdered.add(textRegion);
					}	
				}				
			}				
		}		
		return textRegionOrImageRegionListOrdered;
	}
}