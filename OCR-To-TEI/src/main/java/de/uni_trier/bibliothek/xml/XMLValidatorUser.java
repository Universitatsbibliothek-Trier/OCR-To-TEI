package de.uni_trier.bibliothek.xml;

import java.net.MalformedURLException;
import java.net.URL;

public class XMLValidatorUser
{

	public void validateXML() throws MalformedURLException
	{
		URL urlmods = new URL("http://www.loc.gov/standards/mods/v3/mods-3-5.xsd");
		URL urlocr = new URL("http://schema.primaresearch.org/PAGE/gts/pagecontent/2019-07-15/pagecontent.xsd");
	}
	
	// xsi:schemaLocation="http://www.loc.gov/mods/v3 http://www.loc.gov/standards/mods/v3/mods-3-5.xsd"

	



	// xsi:schemaLocation="http://schema.primaresearch.org/PAGE/gts/pagecontent/2019-07-15 http://schema.primaresearch.org/PAGE/gts/pagecontent/2019-07-15/pagecontent.xsd"

}