package de.uni_trier.bibliothek;

import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "parameters")
public class Parameters {
	@XmlElement(name = "title")
    public String title;	
}