package de.uni_trier.bibliothek.xml.ocr;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import de.uni_trier.bibliothek.xml.ocr.model.generated.Page;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextEquiv;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextLine;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextRegion;
import jakarta.xml.bind.JAXBException;

public class OcrDataLineReader extends PcGts {
	public static ArrayList<String> getTextLines(PcGts pcgtsObject) throws IOException, JAXBException {
		ArrayList<String> ocrTextLineList = new ArrayList<String>();
		// read values from Java object
		Page page = pcgtsObject.getPage();
		List<TextRegion> textRegionList = page.getTextRegion();
		List<TextLine> textLineList;
		List<TextEquiv> textEquivList;
		for (TextRegion textRegion : textRegionList) {
			textLineList = textRegion.getTextLine();
			if(textRegion.getType().equals("paragraph")){
				for (TextLine textLine : textLineList) {
					textEquivList = textLine.getTextEquiv();
					// get attribute "id" from textline
					String textLineID = textLine.getId();
					char l = 'l';
					// check if new line begins
					if (textLineID.charAt(0) == l && !textEquivList.isEmpty()) {
						for (TextEquiv TextEquiv : textEquivList) {
							String unicode = TextEquiv.getUnicode();
							if (TextEquiv.getIndex() != null && TextEquiv.getIndex().equals("0")) {
								// add text from Unicode to ArrayList
								ocrTextLineList.add(unicode);
								break; // sought index found
							}
						}
					}
				}
			}
			else if(textRegion.getType().equals("page-number")){
				// todo issue #8
			}	
		}
		return ocrTextLineList;
	}
}