package de.uni_trier.bibliothek.xml.ocr;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;

import de.uni_trier.bibliothek.xml.ocr.model.generated.Page;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextEquiv;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextLine;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextRegion;
import jakarta.xml.bind.JAXBException;

public class OcrDataReader extends PcGts {

	public static ArrayList<String> getTextLines(PcGts pcgtsObject) throws IOException, JAXBException {
		ArrayList<String> ocrTextLineList = new ArrayList<String>();
		// read values from Java object
		Page page = pcgtsObject.getPage();
		for (TextRegion textRegion : page.getTextRegion()) {
			if (textRegion.getType().equals("paragraph")) {
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
								// add text from Unicode to ArrayList
								ocrTextLineList.add(unicode);
								break; // sought index found
							}
						}
					}
				}
			}
		}
		return ocrTextLineList;
	}

	public static String getPageNumber(PcGts pcgtsObject) {
		String pageNumber = "";
		// read values from Java object
		List<TextRegion> textRegionList = pcgtsObject.getPage().getTextRegion();
		for (TextRegion textRegion : textRegionList) {
			if (textRegion.getType().equals("page-number")) {
				if (textRegion.getTextLine().isEmpty()) {
					for (TextEquiv TextEquiv : textRegion.getTextEquiv()) {
						if (TextEquiv.getUnicode() != null) {
							pageNumber = TextEquiv.getUnicode();
						}
					}
				} else {
					for (TextLine textLine : textRegion.getTextLine()) {
						List<TextEquiv> textEquivList = textLine.getTextEquiv();
						// check if textEquiv exists
						if (!textEquivList.isEmpty()) {
							for (TextEquiv TextEquiv : textEquivList) {
								if (TextEquiv.getUnicode() != null) {
									pageNumber = TextEquiv.getUnicode();
								}
							}
						}
					}
				}
			}
		}
		return pageNumber;
	}

	public static void csvPageNameComments(String fileName, PcGts pcgtsObject, File csvFile) {
		String pageNumber = getPageNumber(pcgtsObject);
		String comment = "";
		try {
			// create FileWriter object with file as parameter
			FileWriter outputfile = new FileWriter(csvFile, true);
			CSVWriter writer = new CSVWriter(outputfile);
			// add data to csv
			if (!pageNumber.matches("[0-9]+"))
			{
				comment = "Seitenzahl nicht erkannt";
			}
			String[] data1 = { fileName, pageNumber, comment };
			writer.writeNext(data1);
			// closing writer connection
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}