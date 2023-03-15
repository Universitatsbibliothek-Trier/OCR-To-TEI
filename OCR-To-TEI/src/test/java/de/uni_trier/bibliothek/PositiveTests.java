package de.uni_trier.bibliothek;

import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import de.uni_trier.bibliothek.xml.mods.ModsUnmarshaller;
import de.uni_trier.bibliothek.xml.mods.model.generated.ModsCollection;
import de.uni_trier.bibliothek.xml.ocr.OcrDataReader;
import de.uni_trier.bibliothek.xml.ocr.PcGtsUnmarshaller;
import de.uni_trier.bibliothek.xml.ocr.model.generated.PcGts;
import de.uni_trier.bibliothek.xml.tei.TEICreator;
import de.uni_trier.bibliothek.xml.tei.TEIMarshaller;
import de.uni_trier.bibliothek.xml.tei.model.generated.TEI;
import jakarta.xml.bind.JAXBException;

public class PositiveTests 
{
	String createTEIandCSV(String teiPathNameFile, String ocrFolderPathString, String modsFilePath) throws JAXBException, IOException
	{
		// teiPathNameFile = "/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/test/TEIOutput/TEI_created_Band1.xml";
		// ocrFolderPathString = "/ocrOutputFiles/";
		// modsFilePath = "/modsFiles/ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml";

		// create modscollection
		InputStream modsFile = PositiveTests.class.getResourceAsStream(modsFilePath);
		Reader xmlReader = new InputStreamReader(modsFile);
		ModsCollection modsCollection = ModsUnmarshaller.unmarshal(xmlReader);

		// get xml files from folder
		URL ocrFolderPath = PositiveTests.class.getResource(ocrFolderPathString);
		File ocrFile = new File(ocrFolderPath.getPath());
		File[] ocrFiles = ocrFile.listFiles(new FileFilter() {
			public boolean accept(File ocrFolderName) {
				String fileName = ocrFolderName.getName().toLowerCase();
				return fileName.endsWith(".xml") && ocrFolderName.isFile();
			}
		});
		Arrays.sort(ocrFiles);

		String teiPathName = CSVCreator.createTEIPathName(teiPathNameFile);
		System.out.println("PathName of csv: " + teiPathName);
		File csvFile = CSVCreator.createFile();


		ArrayList<PcGts> pcgtsList = new ArrayList<PcGts>();
		for (File fileName : ocrFiles) 
		{	
			InputStream inputStreamPcgts = new FileInputStream(fileName);
			xmlReader = new InputStreamReader(inputStreamPcgts);
			PcGts pcgtsObject = PcGtsUnmarshaller.unmarshal(xmlReader);
			String fileNameString = fileName.getName();
			// System.out.println(pcgtsObject.getPage().getImageHeight());
			OcrDataReader.csvPageNameComments(fileNameString, pcgtsObject, csvFile);
			pcgtsList.add(pcgtsObject);
		}
		xmlReader.close();
		
		// create TEI from modsCollection-object and list of PcGts-objects
		TEI teiObject = TEICreator.createTEI(modsCollection, pcgtsList);
		String teiXmlString = TEIMarshaller.marshall(teiObject);

		Path teiFilePath = Paths.get(teiPathNameFile);
		Files.writeString(teiFilePath, teiXmlString, StandardCharsets.UTF_8);	
		System.out.println("TEI and .csv created in: " + teiPathName);	
		
		return teiXmlString;
		
	}
	
	@DisplayName("This is a sample test")
	@Test
	void teiPathNameTest() throws IOException
	{
		String teiPathFileName = "/home/ackels/Dokumente/ocr-to-tei-pipeline-1/TEI_CSV_Output/TEI_created_Band1.xml"; 
		String teiPathFileName2 = "/home/ackels/Dokumente/TEI_created_Band1.xml"; 
		assertEquals(CSVCreator.createTEIPathName(teiPathFileName), "/home/ackels/Dokumente/ocr-to-tei-pipeline-1/TEI_CSV_Output/", "wrong pathname");
		assertEquals(CSVCreator.createTEIPathName(teiPathFileName2), "/home/ackels/Dokumente/", "wrong pathname");
	}

	@Test
	void testcase1Test() throws JAXBException, IOException
	{
		// String teiPathNameFile = "/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/test/TEIOutput/TEI_created_Band1.xml";
		String modsFilePath = "/testcase1/modsFiles/ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml";
		String ocrFolderPathString = "/testcase1/ocrOutputFiles/";
		String teiPathNameFile = "src/test/resources/testcase1/teiOutputFiles/TEI_created_TestBand1.xml";
		String tei = createTEIandCSV(teiPathNameFile, ocrFolderPathString, modsFilePath);
		System.out.println("TEI sieht folgendermaßen aus: " + tei);
	}

	@Test
	void testcase2Test() throws JAXBException, IOException
	{
		// String teiPathNameFile = "/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/test/TEIOutput/TEI_created_Band1.xml";
		String modsFilePath = "/testcase2/modsFiles/ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml";
		String ocrFolderPathString = "/testcase2/ocrOutputFiles/";
		String teiPathNameFile = "src/test/resources/testcase2/teiOutputFiles/TEI_created_TestBand2.xml";
		String tei = createTEIandCSV(teiPathNameFile, ocrFolderPathString, modsFilePath);
		System.out.println("TEI sieht folgendermaßen aus: " + tei);
	}
	
}
