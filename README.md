Copyright (c) 2023 Universität Trier\
Permission is hereby granted, free of charge, to any person obtaining
This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

## Erstellen einer TEI-konformen XML-Datei aus Meta-Daten und OCR-Output

Mit diesem Java-Programm ist es möglich aus einem Dateiordner, in dem sich XML-Dateien, die von einem OCR4all-Server aus Textseiten erkannt und generiert wurden, und einer XML-Datei mit Metainformationen über ein entsprechendes Buch/Band eine XML-Datei zu erzeugen, die den Vorgaben/dem Schema der TEI entspricht. Dabei wird zusätzlich eine `.csv`-Datei erstellt, die Informationen über die von der OCR nicht erkannten Seitenzahlen enthält.

## Ausführung

Voraussetzungen:\
Voraussetzungen für das Ausführen des Programmes sind ein installiertes Java JDK und Apache Maven.\
Nötige Angaben:\
Vor dem Ausführen müssen bestimmte Angaben in der `parameters.xml`-Datei erfolgen: der Titel in `title`, ein Zusatz zum Titel in `titleAddition`, die Reihenfolge der vorkommenden Elemente (z.B Bogensignaturen, Kustoden) in `readingOrder`, ein statement of responsibility in `respStmt` und ein publication statement in `publicationStmt`.

Für Ubuntu:\
Um das Programm von einem Bash-Terminal aus auszuführen müssen verschiedene Argumente mitgegeben werden. Da das Java-Programm von Maven zusammengebaut wird, sieht der Befehl zum Starten wie folgt aus:\
`mvn -q compile exec:java -Dexec.arguments="-m,/PfadZurModsDatei.xml,-o,/PfadZumOCROrdner/,-t,/PfadFürTEIUndCSV/teiName.xml"`\
Dieser Befehl muss vom Ordner aus gestartet werden, in dem sich die `pom.xml`-Datei von Maven befindet.
Alternativ dazu kann das Bash-Skript `startWithArguments.sh` ausgeführt werden, dass den Benutzer über ein Menü die benötigten Argumente eingeben lässt.
Ein weiteres Skript zur Ausführung des Programmes ist die Datei `createteifile.sh`. Ein Beispiel zur Ausführung des Programmes über das Skript kann folgendermaßen aussehen:\
`./createteifile.sh -m /PfadZuMODSDatei.xml -o /PfadZuOCRDaten/ -t /PfadUndNameDerTEIDatei.xml`\
Dabei spielt die Reihenfolge der Pfade keine Rolle, sodass folgender Befehl ebenfalls möglich ist:\
`./createteifile.sh -t /PfadUndNameDerTEIDatei.xml -m /PfadZuMODSDatei.xml -o /PfadZuOCRDaten/` 

Für Windows:\
Zur Ausführung des Programmes kann die Datei `create_tei_paths.bat` ausgeführt werden. Diese Datei kann bearbeitet werden, um die benötigen Pfade je nach Bedarf anzupassen.

## Ordnerstruktur

**parameters**  
Enthält `parameters.xml`-Datei, in der bestimmte Angaben, zum Beispiel zur Reihenfolge der speziellen Elemente (z.B Bogensignaturen, Kustoden) gemacht werden können.

**TEI_CSV_Output**  
Enthält nach der Ausführung je nach angegebenen Pfaden die XML-Datei nach TEI-Vorgaben und eine `.csv`-Datei mit Angaben über nicht erkannte Seitenzahlen.

**OCR-To-TEI**  
Enthält die `pom.xml` für Maven und eine `.bat`-Datei zum Ausführen des Programmes unter Windows.

**OCR-To-TEI/source/main/resources**  
Enthält `.xsd`-Dateien für XML-Dateien mit OCR-Output, für XML-Dateien mit Mods, für XML-Dateien, die sich an offizielle TEI-Vorgaben halten, für XML-Dateien mit speziell ausgewählten TEI-Vorgaben und für die parameters-Datei.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek**  
Enthält `Main`-Klasse des Java-Projektes, den `CSVCreator`, den `CmdLineParser`, der die Kommandozeilenargumente einliest und den `ParametersProvider`, der ein `parameters`-Objekt zurückgibt. 

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml**  
Enthält eine Klasse um XML-Dateien gegen ein Schema zu validieren, eine Klasse um aus einer XML-Datei Java-Objekte zu erzeugen und umgekehrt.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/mods**  
Enthält `ModsUnmarshaller`, der aus einer angegebenen XML-Datei Java-Objekte generiert.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/mods/model/generated**  
Enthält automatisch generierte Java-Klassen.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/ocr**  
Enthält `PcGtsUnmarshaller`, der aus einer angegebenen XML-Datei Java-Objekte generiert.
Enthält außerdem einen `OcrDataReader`, der Funktionen zum Auslesen der XML-Dateien mit OCR-Output bereithält.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/ocr/model/generated**  
Enthält automatisch generierte Java-Klassen.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/parameters/model/generated**  
Enthält automatisch generierte Java-Klassen.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/tei**  
Enthält `TEIUnmarshaller`, der aus einer angegebenen XML-Datei Java-Objekte generiert und den entsprechenden `TEIMarshaller`.
Enthält außerdem einen `TEICreator`, der Daten aus OCR-Output und Metadaten zusammenführt und in ein neues Objekt speichert.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/tei/model/generated**  
Enthält automatisch generierte Java-Klassen.

**OCR-To-TEI/scripts**  
Enthält Skripte zum Generieren von Java-Klassen aus `.xsd`-Dateien. In diesem Fall von `xml_OCR_Output.xsd`,`mods.xsd`,`TEIxsd.xsd` und `parameters.xsd`.
Enthält außerdem zwei Skripte zum Starten des Programmes.

## Dependencies

Die Dependencies werden beim Starten des Projektes von Maven automatisch geladen und sind in der `pom.xml`-Datei zu finden.


