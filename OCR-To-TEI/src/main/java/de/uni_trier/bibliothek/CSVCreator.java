// @author       René Ackels
// Copyright (c) 2023 René Ackels, Anne Königs

// This file is part of OCR-To-TEI.

// OCR-To-TEI is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// OCR-To-TEI is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.

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
		// replace blackslashes from windows paths
		teiPathFileName = teiPathFileName.replaceAll("[\\\\]", "/");
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
