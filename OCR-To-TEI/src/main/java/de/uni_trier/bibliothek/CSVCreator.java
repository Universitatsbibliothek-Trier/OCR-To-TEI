package de.uni_trier.bibliothek;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import com.opencsv.CSVWriter;

public class CSVCreator {
	static String csvPathFileName = "";

	public static String createTEIPathName(String teiPathFileName) throws IOException
	{
		// create TEI pathname and .csv path with filename
		int lastSlash = teiPathFileName.lastIndexOf('/');
		String csvFileName = teiPathFileName.substring(lastSlash+1,teiPathFileName.length());
		csvFileName = csvFileName.substring(0,csvFileName.length()-4);
		csvFileName = csvFileName + "_page-numbers.csv";
		String teiPathName = teiPathFileName.substring(0,lastSlash+1);
		csvPathFileName = teiPathName + csvFileName;
		return teiPathName;
	}
	public static File createFile() throws IOException
	{
		// create .csv file with header
		File file = new File(csvPathFileName);	
		file.delete();	
		FileWriter outputfile = new FileWriter(file, true);
		CSVWriter writer = new CSVWriter(outputfile);
		String[] header = { "Dateiname:", "Seitenzahl:", "Kommentar:" };
		writer.writeNext(header);
		writer.close();
		return file;
	}

}
