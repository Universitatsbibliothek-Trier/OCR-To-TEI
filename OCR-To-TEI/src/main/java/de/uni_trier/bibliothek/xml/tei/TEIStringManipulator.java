package de.uni_trier.bibliothek.xml.tei;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TEIStringManipulator
{
	public static String teiVersion = "5.0";

	public static String manipulateTEI(String teiXML) 
	{
		String teiManipulatedString = teiXML;

		// remove unnecessary namespace declaration and attribute
		teiManipulatedString = teiManipulatedString.replaceAll("xsi:nil=\"true\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"", "");
		// add namespace declaration
		teiManipulatedString = teiManipulatedString.replaceAll("<TEI", "<TEI xmlns:mods=\"http://www.loc.gov/mods/v3\"");
		// put elements in mods-namespace
		teiManipulatedString = teiManipulatedString.replaceAll("<mods", "<mods:mods");
		teiManipulatedString = teiManipulatedString.replaceAll("/mods>", "/mods:mods>");
		teiManipulatedString = teiManipulatedString.replaceAll("<identifier", "<mods:identifier");
		teiManipulatedString = teiManipulatedString.replaceAll("/identifier>", "/mods:identifier>");
		teiManipulatedString = teiManipulatedString.replaceAll("<originInfo", "<mods:originInfo");
		teiManipulatedString = teiManipulatedString.replaceAll("/originInfo>", "/mods:originInfo>");
		teiManipulatedString = teiManipulatedString.replaceAll("<dateIssued", "<mods:dateIssued");
		teiManipulatedString = teiManipulatedString.replaceAll("/dateIssued>", "/mods:dateIssued>");
		teiManipulatedString = teiManipulatedString.replaceAll("<place", "<mods:place");
		teiManipulatedString = teiManipulatedString.replaceAll("/place>", "/mods:place>");
		teiManipulatedString = teiManipulatedString.replaceAll("<placeTerm", "<mods:placeTerm");
		teiManipulatedString = teiManipulatedString.replaceAll("/placeTerm>", "/mods:placeTerm>");
		teiManipulatedString = teiManipulatedString.replaceAll("<publisher", "<mods:publisher");
		teiManipulatedString = teiManipulatedString.replaceAll("/publisher>", "/mods:publisher>");
		teiManipulatedString = teiManipulatedString.replaceAll("<genre", "<mods:genre");
		teiManipulatedString = teiManipulatedString.replaceAll("/genre>", "/mods:genre>");
		teiManipulatedString = teiManipulatedString.replaceAll("<note", "<mods:note");
		teiManipulatedString = teiManipulatedString.replaceAll("/note>", "/mods:note>");
		teiManipulatedString = teiManipulatedString.replaceAll("<location", "<mods:location");
		teiManipulatedString = teiManipulatedString.replaceAll("/location>", "/mods:location>");
		teiManipulatedString = teiManipulatedString.replaceAll("<physicalLocation", "<mods:physicalLocation");
		teiManipulatedString = teiManipulatedString.replaceAll("/physicalLocation>", "/mods:physicalLocation>");
		teiManipulatedString = teiManipulatedString.replaceAll("<typeOfResource", "<mods:typeOfResource");
		teiManipulatedString = teiManipulatedString.replaceAll("/typeOfResource>", "/mods:typeOfResource>");
		teiManipulatedString = teiManipulatedString.replaceAll("<subject", "<mods:subject");
		teiManipulatedString = teiManipulatedString.replaceAll("/subject>", "/mods:subject>");
		teiManipulatedString = teiManipulatedString.replaceAll("<topic", "<mods:topic");
		teiManipulatedString = teiManipulatedString.replaceAll("/topic>", "/mods:topic>");
		teiManipulatedString = teiManipulatedString.replaceAll("<name", "<mods:name");
		teiManipulatedString = teiManipulatedString.replaceAll("/name>", "/mods:name>");
		teiManipulatedString = teiManipulatedString.replaceAll("<namePart", "<mods:namePart");
		teiManipulatedString = teiManipulatedString.replaceAll("/namePart>", "/mods:namePart>");
		teiManipulatedString = teiManipulatedString.replaceAll("<recordInfo", "<mods:recordInfo");
		teiManipulatedString = teiManipulatedString.replaceAll("/recordInfo>", "/mods:recordInfo>");
		teiManipulatedString = teiManipulatedString.replaceAll("<physicalDescription", "<mods:physicalDescription");
		teiManipulatedString = teiManipulatedString.replaceAll("/physicalDescription>", "/mods:physicalDescription>");
		teiManipulatedString = teiManipulatedString.replaceAll("<extent", "<mods:extent");
		teiManipulatedString = teiManipulatedString.replaceAll("/extent>", "/mods:extent>");
		teiManipulatedString = teiManipulatedString.replaceAll("<form", "<mods:form");
		teiManipulatedString = teiManipulatedString.replaceAll("/form>", "/mods:form>");
		teiManipulatedString = teiManipulatedString.replaceAll("<titleInfo", "<mods:titleInfo");
		teiManipulatedString = teiManipulatedString.replaceAll("/titleInfo>", "/mods:titleInfo>");
		teiManipulatedString = replaceOccurrence(teiManipulatedString, "<title", "<mods:title", 3);
		teiManipulatedString = replaceOccurrence(teiManipulatedString, "/title>", "/mods:title>", 2);
		teiManipulatedString = teiManipulatedString.replaceAll("<recordContentSource", "<mods:recordContentSource");
		teiManipulatedString = teiManipulatedString.replaceAll("/recordContentSource>", "/mods:recordContentSource>");
		return teiManipulatedString;		
	}

	private static String replaceOccurrence(String text, String replaceFrom, String replaceTo, int occurrenceIndex)
	{
		// method to replace Strings with certain occurence
   	 	StringBuffer sb = new StringBuffer();
    	Pattern p = Pattern.compile(replaceFrom);
    	Matcher m = p.matcher(text);
   	    int count = 0;
        while (m.find())
        {
            if (count++ == occurrenceIndex - 1)
            {
                m.appendReplacement(sb, replaceTo);
            }
        }
        m.appendTail(sb);
   	    return sb.toString();
	}


}