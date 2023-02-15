package de.uni_trier.bibliothek.xml.ocr;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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