package de.uni_trier.bibliothek.xml.ocr;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
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
import de.uni_trier.bibliothek.xml.tei.TEIUnmarshaller;
import jakarta.xml.bind.JAXBException;

public class OcrDataLineReader extends PcGts 
{
	public static ArrayList<String> getTextLines(PcGts pcgtsObject) throws IOException, JAXBException 
	{
		ArrayList<String> ocrTextLineList = new ArrayList<String>();

		// read values from Java object
		Page page = pcgtsObject.getPage();
		List<TextRegion> textRegionList = page.getTextRegion();
		List<TextLine> textLineList;
		List<TextEquiv> textEquivList;
		for (TextRegion textRegion : textRegionList) 
		{
			textLineList = textRegion.getTextLine();

			for (TextLine textLine : textLineList) 
			{
				textEquivList = textLine.getTextEquiv();
				// get attribute "id" from textline
				String textLineID = textLine.getId();
				char l = 'l';

				// check if new line begins
				if (textLineID.charAt(0) == l) 
				{
					for (TextEquiv TextEquiv : textEquivList) 
					{
						Object unicode = TextEquiv.getUnicode();
						int indexTextEquiv;
						if (TextEquiv.getIndex() != null) 
						{
							indexTextEquiv = Integer.parseInt(TextEquiv.getIndex());
							if (indexTextEquiv == 0) 
							{
								// add text from Unicode to ArrayList
								ocrTextLineList.add(unicode.toString());
							}
						}

					}
				}

			}
		}
		return ocrTextLineList;
	}

}