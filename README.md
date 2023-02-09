## Einlesen von Meta-Daten/OCR-Output von XML-Dateien

Mit diesem Java-Programm ist es möglich, XML-Dateien mit Mods oder OCR-Output einzulesen und in Java-Objekten zu speichern.
Dies ist nur mit den dazugehörigen `.xsd`-Dateien (XML-Schema) möglich, da aus ihnen die Java-Klassen erzeugt werden.
In Objekten dieser Klassen werden anschließend über einen Unmarshaller die jeweiligen Daten einer angegebenen XML gespeichert.
Im Falle eines angegebenen Pfades mit XML-Dateien mit OCR-Output können explizit die `TextLines` dieser Dateien ausgegeben werden.

## Ausführung

Zum Einlesen einer bestimmten XML-Datei mit Mods aus dem `resources`-Folder muss der String der Variable `modsPathreader` in der `Main`-Klasse angepasst werden. Bei einer XML-Datei mit OCR-Output kann man den String `ocrFolderName` entsprechend ändern. (relative Pfade)
Das Starten des Projektes ist über den *Run*-Button von Visual Studio Code möglich.

## Ordnerstruktur

**OCR-To-TEI/source/main/resources**  
Enthält `.xsd`-Dateien für XML-Dateien mit OCR-Output und für XML-Dateien mit Mods

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/**  
Enthält `Main`-Klasse des Java-Projektes

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/mods**  
Enthält `ModsUnmarshaller`, der aus einer angegebenen XML-Datei Java-Objekte generiert.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/mods/model/generated**  
Enthält automatisch generierte Java-Klassen

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/ocr**  
Enthält `PcGtsUnmarshaller`, der aus einer angegebenen XML-Datei Java-Objekte generiert.
Enthält außerdem einen `OcrDataLineReader`, der eine `ArrayList` der `TextLines` einer XML-Datei mit OCR-Output zurückgibt.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/ocr/model/generated**  
Enthält automatisch generierte Java-Klassen

**OCR-To-TEI/scripts**  
Enthält Skripte zum Generieren von Java-Klassen aus `.xsd`-Dateien. In diesem Fall von `xml_OCR_Output.xsd` und `mods.xsd`.

## Dependencies

Die Dependencies werden beim Starten des Projektes von Maven automatisch geladen und installiert.
Die Library `JAXB RI` von https://mvnrepository.com/artifact/com.sun.xml.bind/jaxb-ri/4.0.0 wird im Ordner **OCR-To-TEI/lib** benötigt, sodass die Struktur wie folgt aussieht:
**.../OCR-To-TEI/lib/jaxb-ri-4.0.0/jaxb-ri**
