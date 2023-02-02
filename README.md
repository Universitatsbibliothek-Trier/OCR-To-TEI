## Einlesen der Meta-Daten aus den XML-Dateien, die von OCR generiert werden

Mit diesem Java-Programm ist es möglich, XML-Dateien einzulesen und in Java-Objekten zu speichern.
Dies ist nur mit den passenden ".xsd"-Dateien (XML-Schema) möglich, da aus ihnen Java-Klassen erzeugt werden.
In Objekten dieser Klassen werden anschließend über einen Unmarshaller die jeweiligen Daten einer angegebenen XML gespeichert.

## Ausführung

Zum Einlesen einer bestimmten XML-Datei aus dem "resources"-Folder muss der String der Variable "xmlPathreader" in der "Main"-Klasse angepasst werden.
Anschließend muss der entsprechende UnMarshaller (ModsUnmarshaller/PcGtsUnmarshaller) benutzt werden, um das passende Java-Objekt zurückzugeben.
Das Starten der "Main"-Klasse erzeugt das erwähnte Java-Objekt, in dem alle Daten der dazugehörigen XML-Datei gespeichert werden.

## Ordnerstruktur

OCR-To-TEI/scripts
Enthält Skripte zum Generieren von Java-Klassen aus ".xsd"-Dateien. In diesem Fall von "xml_OCR_Output.xsd" und "mods.xsd".

OCR-To-TEI/source/main/resources
Enthält XML-Dateien mit den dazugehörigen ".xsd"-Dateien 

OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/
Enthält Main-Klasse des Java-Projektes

OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml
Enthält XMLValidator um XML-Dateien gegen ".xsd"-Dateien zu validieren

OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/mods
Enthält ModsUnmarshaller, der aus einer angegebenen XML-Datei Java-Objekte generiert.

OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/mods/model/generated
Enthält automatisch generierte Java-Klassen

OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/ocr
Enthält PcGtsUnmarshaller, der aus einer angegebenen XML-Datei Java-Objekte generiert.

OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/ocr/model/generated
Enthält automatisch generierte Java-Klassen

## Dependencies

Die Library "JAXB RI" von "https://mvnrepository.com/artifact/com.sun.xml.bind/jaxb-ri/4.0.0" wird im Ordner "OCR-To-TEI/lib" benötigt, sodass die Struktur wie folgt aussieht:
OCR-To-TEI/lib"/jaxb-ri-4.0.0/jaxb-ri
Damit können die Skripte unter "OCR-To-TEI/scripts" ausgeführt werden, um die Java-Klassen der XML zu generieren.