@echo off

set modsPath=C:\TEIConverterTool\ocr-to-tei-pipeline\OCR-To-TEI\src\main\resources\modsFiles\ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml
set ocrPath=C:\TEIConverterTool\ocr-to-tei-pipeline\OCR-To-TEI\src\main\resources\ocrOutputFiles
set teiPathName=C:\TEIConverterTool\ocr-to-tei-pipeline\TEI_CSV_Output\TEI_created_Band1.xml
CALL mvn -q -e compile exec:java -Dexec.arguments="-m,%modsPath%,-o,%ocrPath%,-t,%teiPathName%"

pause