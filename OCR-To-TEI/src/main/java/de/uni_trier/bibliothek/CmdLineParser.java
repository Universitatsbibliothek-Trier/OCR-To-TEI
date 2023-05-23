// @author       René Ackels
// Copyright (c) 2023 Universität Trier

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

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.ParseException;

public class CmdLineParser
{
    String modsPath;
    String ocrFolderName;
    String teiPathNameFile;
    public CmdLineParser(String[] args)
    {
        // create options for arguments
        Options options = new Options();
        Option option_Mods = Option.builder("m")
            .longOpt("mods")
            .hasArg()
            .required(true)
            .desc("The path with file name to XML Mods-file")
            .build();
        Option option_OCR = Option.builder("o")
            .longOpt("ocr")
            .hasArg()
            .required(true)
            .desc("The path to the folder with XML files with OCR Output")
            .build();
        Option option_TEI = Option.builder("t")
            .longOpt("tei")
            .hasArg()
            .required(true)
            .desc("The path with file name for TEI destination")
            .build();

        options.addOption(option_Mods);
        options.addOption(option_OCR);
        options.addOption(option_TEI);
        parseCommandLine(options, args);
    }

    public void parseCommandLine(Options options, String[] args)
    {
        // parse inputted arguments
        CommandLineParser parser = new DefaultParser();
        CommandLine commandLine;
        try
        {
            commandLine = parser.parse(options, args);

            if (commandLine.hasOption("mods"))
            {
                modsPath = commandLine.getOptionValue("mods");
                System.out.println("Path to mods file:");
                System.out.println(modsPath);
            }

            if (commandLine.hasOption("ocr"))
            {
                ocrFolderName = commandLine.getOptionValue("ocr");
                System.out.println("Path to OCR folder:");
                System.out.println(ocrFolderName);
            }

            if (commandLine.hasOption("tei"))
            {
                teiPathNameFile = commandLine.getOptionValue("tei");
                System.out.println("Path with TEI filename:");
                System.out.println(teiPathNameFile);
            }
        }
        catch (ParseException exception)
        {
            System.out.print("Parse error: Please enter every option with an argument. ");
            System.out.println(exception.getMessage());
        }

    }        
    

    public String getModsPath()
    {
        return modsPath;
    }
	
    public String getOCRFolderName()
    {
        return ocrFolderName;
    }

    public String getTEIPathNameFile()
    {
        return teiPathNameFile;
    }
}