@echo off

SET modsPath=\home\ackels\Dokumente\ocr-to-tei-pipeline\mods1.xml
SET ocrPath=\home\ackels\Dokumente
SET teiPathName=\home\ackels\Dokumente\ocr-to-tei-pipeline-1\TEI_CSV_Output\TEI_created_Band1.xml
mvn "-q" "-e" "compile" "exec:java" "-Dexec.arguments="-m,%modsPath%,-o,%ocrPath%,-t,%teiPathName%""