// Copyright (c) 2023 René Ackels
// Permission is hereby granted, free of charge, to any person obtaining

// This program is free software: you can redistribute it and/or modify
// it under the terms of the GNU General Public License as published by
// the Free Software Foundation, either version 3 of the License, or
// (at your option) any later version.

// This program is distributed in the hope that it will be useful,
// but WITHOUT ANY WARRANTY; without even the implied warranty of
// MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
// GNU General Public License for more details.

// You should have received a copy of the GNU General Public License
// along with this program.  If not, see <http://www.gnu.org/licenses/>.

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
	public static Parameters getParameters(String parametersPath) throws JAXBException, IOException
	{
		Unmarshaller<Parameters> unmarshallerParameters = new Unmarshaller<>(Parameters.class);
		InputStream inputStreamParameters = new FileInputStream(parametersPath);
		Reader xmlReaderParameters = new InputStreamReader(inputStreamParameters);
		Parameters parameters = unmarshallerParameters.unmarshal(xmlReaderParameters);
		xmlReaderParameters.close();
		inputStreamParameters.close();
		return parameters;
	}

}