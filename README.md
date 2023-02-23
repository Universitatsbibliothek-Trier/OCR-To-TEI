## Einlesen von Meta-Daten/OCR-Output von XML-Dateien

Mit diesem Java-Programm ist es möglich aus einem Dateiordner, in dem sich XML-Dateien mit OCR-Output befinden, und einer XML-Datei mit Metainformationen TEI-Dateien zu erzeugen.
Dazu werden über Unmarshaller die Daten aus den XML-Dateien in Objekten gespeichert. Anschließend werden die benötigten Informationen in einem weiteren Objekt, dessen benutzten Klassen über eine `.xsd`-Datei erzeugt wurden, zusammengeführt. Dieses Objekt wird über einen Marshaller in eine XML-Datei umgewandelt, die im letzten Schritt so abgeändert wird, dass die den Vorgaben der TEI entspricht.

## Ausführung

Zum Einlesen einer bestimmten XML-Datei mit Mods muss der erste eingegebene Parameter einen absoluten Pfad mit Dateinamen besitzen.
Für die Angabe eines Ordners mit mehreren Dateien aus dem OCR-Output muss der zweite angegebene Paramter den Pfad zu einem Ordner enthalten, in dem sich die XML-Dateien vom OCR-Output befinden.
In den dritten Parameter muss der Pfad mit Dateinamen der auszugebenen TEI-Datei geschrieben werden. Eine `.csv`-Datei wird zusaätzlich nach Eingabe der Paramter im selben Ordner der TEI-Datei erzeugt.

## Ordnerstruktur

**OCR-To-TEI/source/main/resources**  
Enthält `.xsd`-Dateien für XML-Dateien mit OCR-Output, für XML-Dateien mit Mods und für XML-Dateien mit TEI-Vorgaben. 

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/**  
Enthält `Main`-Klasse des Java-Projektes

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/mods**  
Enthält `ModsUnmarshaller`, der aus einer angegebenen XML-Datei Java-Objekte generiert.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/mods/model/generated**  
Enthält automatisch generierte Java-Klassen

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/ocr**  
Enthält `PcGtsUnmarshaller`, der aus einer angegebenen XML-Datei Java-Objekte generiert.
Enthält außerdem einen `OcrDataReader`, der Funktionen zum Auslesen der XML-Dateien mit OCR-Output bereithält.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/ocr/model/generated**  
Enthält automatisch generierte Java-Klassen

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/tei**  
Enthält `TEIUnmarshaller`, der aus einer angegebenen XML-Datei Java-Objekte generiert.
Enthält außerdem einen `TEICreator`, der Daten aus OCR-Output und Metadaten zusammenführt und in ein neues Objekt speichert.

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek/xml/tei/model/generated**  
Enthält automatisch generierte Java-Klassen

**OCR-To-TEI/scripts**  
Enthält Skripte zum Generieren von Java-Klassen aus `.xsd`-Dateien. In diesem Fall von `xml_OCR_Output.xsd`,`mods.xsd` und `TEIxsd.xsd`.

**change_parameters**
Enthält eine `.csv`-Datei, die eine Liste von Dateinamen vom OCR-Output, deren Seitenzahlen und ein jeweiliger Kommentar, ob die Seitenzahl automatisch korrekt als Zahl erkannt wurde.  

## Dependencies

Die Dependencies werden beim Starten des Projektes von Maven automatisch geladen und installiert.
Die Libraries von `JAXB RI` von https://mvnrepository.com/artifact/com.sun.xml.bind/jaxb-ri/4.0.0 werden im Ordner **OCR-To-TEI/lib** benötigt, sodass die Struktur wie folgt aussieht:
**.../OCR-To-TEI/lib/jaxb-ri-4.0.0/jaxb-ri**
