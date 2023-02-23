#!/bin/bash

# start Java program with precoded paths

modsPath="/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/main/resources/modsFiles/ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml"
ocrPath="/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/main/resources/ocrOutputFiles/"
teiPathName="/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/main/resources/teiOutputFiles/TEI_created_Band1.xml"

mvn -q compile exec:java \
-Dexec.arguments="$modsPath,$ocrPath,$teiPathName"
