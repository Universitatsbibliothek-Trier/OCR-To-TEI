package de.uni_trier.bibliothek;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

import de.uni_trier.bibliothek.xml.Unmarshaller;
import de.uni_trier.bibliothek.xml.parameters.model.generated.Parameters;
import jakarta.xml.bind.JAXBException;

public class ParametersProvider
{
	public static Parameters getParameters() throws JAXBException, IOException
	{
		Unmarshaller<Parameters> unmarshallerParameters = new Unmarshaller<>(Parameters.class);
		InputStream inputStreamParameters = new FileInputStream("../parameters/parameters.xml");
		Reader xmlReaderParameters = new InputStreamReader(inputStreamParameters);
		Parameters parameters = unmarshallerParameters.unmarshal(xmlReaderParameters);
		xmlReaderParameters.close();
		inputStreamParameters.close();
		return parameters;
	}
}