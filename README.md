## Erstellen einer TEI-Datei aus Meta-Daten und OCR-Output in Form von XML-Dateien

Mit diesem Java-Programm ist es möglich aus einem Dateiordner, in dem sich XML-Dateien mit OCR-Output befinden, und einer XML-Datei mit Metainformationen TEI-Dateien zu erzeugen.
Dazu werden über Unmarshaller die Daten aus den XML-Dateien in Objekten gespeichert. Anschließend werden die benötigten Informationen in einem weiteren Objekt, dessen benutzten Klassen über eine `.xsd`-Datei erzeugt wurden, zusammengeführt. Dieses Objekt wird über einen Marshaller in eine XML-Datei umgewandelt, die im letzten Schritt so abgeändert wird, dass die den Vorgaben der TEI entspricht. Dabei wird zusätzlich eine `.csv`-Datei erzeugt, die Informationen über von der OCR nicht erkannte Seitenzahlen enthält.

## Ausführung

Um das Programm auszuführen zu können müssen verschiedene Argumente mitgegeben werden. Da das Java-Programm von Maven zusammengebaut wird, sieht der Befehl zum Starten wie folgt aus:
`mvn -q compile exec:java -Dexec.arguments="-m,/PfadZurModsDatei.xml,-o,/PfadZumOCROrdner/,-t,/PfadFürTEIUndCSV/teiName.xml"`
Dieser Befehl muss vom Ordner aus gestartet werden, in dem sich die `pom.xml`-Datei von Maven befindet.
Alternativ dazu kann das Bash-Skript `startWithArguments.sh` ausgeführt werden, dass den Benutzer über ein Menü die benötigten Argumente eingeben lässt.
Als zusätzliche Eingabe kann in der `parameters.xml`-Datei ein String eingegeben werden, der dem Titel hinzugefügt wird.

## Ordnerstruktur

**parameters**  
Enthält `parameters.xml`-Datei, in der ein String eingegeben werden kann, der an den Titel konkateniert wird. 

**OCR-To-TEI/source/main/resources**  
Enthält `.xsd`-Dateien für XML-Dateien mit OCR-Output, für XML-Dateien mit Mods und für XML-Dateien mit TEI-Vorgaben. 

**OCR-To-TEI/source/main/java/de/uni_trier/bibliothek**  
Enthält `Main`-Klasse des Java-Projektes, den `CSVCreator` und den `CmdLineParser`, der die Kommandozeilenargumente enliest.

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
Enthält außerdem ein Skript zum Starten des Programmes.

## Dependencies

Die Dependencies werden beim Starten des Projektes von Maven automatisch geladen.
Die Libraries von `JAXB RI` von https://mvnrepository.com/artifact/com.sun.xml.bind/jaxb-ri/4.0.0 werden im Ordner **OCR-To-TEI/lib** benötigt, sodass die Struktur wie folgt aussieht:
**.../OCR-To-TEI/lib/jaxb-ri-4.0.0/jaxb-ri**
