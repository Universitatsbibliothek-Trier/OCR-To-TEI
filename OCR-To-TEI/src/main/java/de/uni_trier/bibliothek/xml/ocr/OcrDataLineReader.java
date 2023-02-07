package de.uni_trier.bibliothek.xml.ocr;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.model.generated.Page;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextEquiv;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextLine;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextRegion;
import jakarta.xml.bind.JAXBException;

public class OcrDataLineReader extends PcGts {

	public ArrayList<String> getTextLines(String filepath) {
		ArrayList<String> ocrtextlines = new ArrayList<String>();
		try (Reader xmlReader = new InputStreamReader(ClassLoader.getSystemResource(filepath).openStream())) 
		{
			//create Java object with data from XML file after unmarshalling
			PcGts pcgts = PcGtsUnmarshaller.unmarshal(xmlReader);
			//read values from Java object
			Page page = pcgts.getPage();
			List<TextRegion> textreg = page.getTextRegion();
			List<TextLine> textl;
			List<TextEquiv> textequiv;
			for (TextRegion tr : textreg) {
				textl = tr.getTextLine();

				for (TextLine tl : textl) {
					textequiv = tl.getTextEquiv();
					// get attribute "id" from textline
					String tlid = tl.getId();					
					char l = 'l';

					// check if new line begins
					if (tlid.charAt(0) == l) {
						for (TextEquiv te : textequiv) {
							Object uc = te.getUnicode();
							int index = Integer.parseInt(te.getIndex());
							if (index == 0) {
								//add text from Unicode to ArrayList
								ocrtextlines.add(uc.toString());
							}
						}
					}

				}
			}
		} catch (JAXBException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ocrtextlines;
	}

}