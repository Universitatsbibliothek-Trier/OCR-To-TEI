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
                System.out.println("Path to mods file entered: " + modsPath);
            }

            if (commandLine.hasOption("ocr"))
            {
                ocrFolderName = commandLine.getOptionValue("ocr");
                System.out.println("Path to OCR folder entered: " + ocrFolderName);
            }

            if (commandLine.hasOption("tei"))
            {
                teiPathNameFile = commandLine.getOptionValue("tei");
                System.out.println("Path with TEI filename entered: " + teiPathNameFile);
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