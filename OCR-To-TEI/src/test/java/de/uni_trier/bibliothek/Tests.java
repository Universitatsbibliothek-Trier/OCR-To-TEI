package de.uni_trier.bibliothek;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

import de.uni_trier.bibliothek.xml.mods.ModsUnmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.OcrDataReader;
import de.uni_trier.bibliothek.xml.ocr.PcGtsUnmarshaller;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import jakarta.xml.bind.JAXBException;

public class Tests 
{
	CSVCreator csvCreator;
	String teiPathFileName;
	String teiPathFileName2;
	String modsPath;
	String ocrFolderName;

	@BeforeEach
	void setUp() throws JAXBException, IOException
	{
		InputStream modsFile = Tests.class.getResourceAsStream("/modsFiles/ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml");
		Reader xmlReader = new InputStreamReader(modsFile);
		ModsCollection modsCollection = ModsUnmarshaller.unmarshal(xmlReader);

		URL ocrFolderPath = Tests.class.getResource("/ocrOutputFiles/");
		File ocrFile = new File(ocrFolderPath.getPath());
		File[] ocrFiles = ocrFile.listFiles();
		Arrays.sort(ocrFiles);

		String teiPathName = CSVCreator.createTEIPathName("/home/ackels/Dokumente/ocr-to-tei-pipeline-1/TEI_CSV_Output/TEI_created_Band1.xml");
		File file = CSVCreator.createFile();


		ArrayList<PcGts> pcgtsList = new ArrayList<PcGts>();
		for (File fileName : ocrFiles) 
		{	
			InputStream inputStreamPcgts = new FileInputStream(fileName);
			xmlReader = new InputStreamReader(inputStreamPcgts);
			PcGts pcgtsObject = PcGtsUnmarshaller.unmarshal(xmlReader);
			String fileNameString = fileName.getName();
			System.out.println(pcgtsObject.getPage().getImageHeight());
			pcgtsList.add(pcgtsObject);
		}
		xmlReader.close();
		
		
		teiPathFileName = "/home/ackels/Dokumente/ocr-to-tei-pipeline-1/TEI_CSV_Output/TEI_created_Band1.xml"; 
		teiPathFileName2 = "/home/ackels/Dokumente/TEI_created_Band1.xml"; 
	}
	
	@DisplayName("This is a sample test")
	@RepeatedTest(4)
	void demoTest() throws IOException
	{
		assertEquals(CSVCreator.createTEIPathName(teiPathFileName), "/home/ackels/Dokumente/ocr-to-tei-pipeline-1/TEI_CSV_Output/", "wrong pathname");
		assertEquals(CSVCreator.createTEIPathName(teiPathFileName2), "/home/ackels/Dokumente/", "wrong pathname");
	}
	
}
