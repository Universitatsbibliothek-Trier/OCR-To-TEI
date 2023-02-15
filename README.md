## Einlesen von Meta-Daten/OCR-Output von XML-Dateien

Mit diesem Java-Programm ist es möglich aus einem Dateiordner, in dem sich XML-Dateien mit OCR-Output befinden, und einer XML-Datei mit Metainformationen TEI-Dateien zu erzeugen.
Dazu werden über Unmarshaller die Daten aus den XML-Dateien in Objekten gespeichert. Anschließend werden die benötigten Informationen in einem weiteren Objekt, dessen benutzten Klassen über eine `.xsd`-Datei erzeugt wurden, zusammengeführt. Dieses Objekt wird über einen Marshaller in eine XML-Datei umgewandelt, die im letzten Schritt so abgeändert wird, dass die den Vorgaben der TEI entspricht.

## Ausführung

Zum Einlesen einer bestimmten XML-Datei mit Mods aus dem `resources`-Folder muss der String der Variable `modsPath` in der `Main`-Klasse angepasst werden. Für die Angabe eines Ordners mit mehreren Dateien aus dem OCR-Output kann man den String `ocrFolderName` entsprechend ändern. (relative Pfade)
Das Starten des Projektes ist über den *Run*-Button von Visual Studio Code möglich.
Die Ausgabe ist eine generierte XML-Datei im Ordner `teiOutputFiles`, die folgenden Namen trägt:
`TEI_NameDerXmlModDatei`

## Ordnerstruktur

**OCR-To-TEI/source/main/resources**  
Enthält `.xsd`-Dateien für XML-Dateien mit OCR-Output, für XML-Dateien mit Mods und für XML-Dateien mit TEI-Vorgaben

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

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/tei**  
Enthält `TEIUnmarshaller`, der aus einer angegebenen XML-Datei Java-Objekte generiert.
Enthält außerdem einen `TEICreator`, der Daten aus OCR-Output und Metadaten zusammenführt und in ein neues Objekt speichert. Enthält `TEIStringManipulator`, der das erzeugte TEI-Objekt anpasst.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/tei/model/generated**  
Enthält automatisch generierte Java-Klassen

**OCR-To-TEI/scripts**  
Enthält Skripte zum Generieren von Java-Klassen aus `.xsd`-Dateien. In diesem Fall von `xml_OCR_Output.xsd`,`mods.xsd` und `TEIxsd.xsd`.

## Dependencies

Die Dependencies werden beim Starten des Projektes von Maven automatisch geladen und installiert.
Die Library `JAXB RI` von https://mvnrepository.com/artifact/com.sun.xml.bind/jaxb-ri/4.0.0 wird im Ordner **OCR-To-TEI/lib** benötigt, sodass die Struktur wie folgt aussieht:
**.../OCR-To-TEI/lib/jaxb-ri-4.0.0/jaxb-ri**
