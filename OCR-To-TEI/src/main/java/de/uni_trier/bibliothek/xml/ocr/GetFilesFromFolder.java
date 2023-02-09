package de.uni_trier.bibliothek.xml.ocr;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.model.generated.Page;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextEquiv;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextLine;
import de.uni_trier.bibliothek.xml.ocr.model.generated.TextRegion;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.JAXBException;

public class GetFilesFromFolder {

	public static ArrayList<String> getFileNames(String folderPathName) 
	{
		ArrayList<String> fileNames = new ArrayList<>();
		File ocrFile = new File(folderPathName);
		List<File> fileNameStrings = Arrays.asList(ocrFile.listFiles());
		for (File file : fileNameStrings)
		{
			fileNames.add(file.getName());
		}
		return fileNames;
	}
	

}