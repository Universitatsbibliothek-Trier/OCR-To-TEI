#!/bin/bash

# start Java program with hard coded paths

script_dir=$(dirname $0)
cd "$script_dir/../"

modsPath="/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/main/resources/modsFiles/ah232-1_HT018899501_Helvetiae_Rhaetiae_1655"
ocrPath="/home/ackels/Dokumente/ocr-to-tei-pipeline-1/OCR-To-TEI/src/main/resources/ocrOutputFiles/"
teiPathName="/home/ackels/Dokumente/ocr-to-tei-pipeline-1/TEI_CSV_Output/TEI_created_Band1.xml"

mvn -q -e compile exec:java \
-Dexec.arguments="-m,$modsPath,-o,$ocrPath,-t,$teiPathName"