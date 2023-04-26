@REM @author       René Ackels
@REM Copyright (c) 2023 René Ackels

@REM This file is part of OCR-To-TEI.

@REM OCR-To-TEI is free software: you can redistribute it and/or modify
@REM it under the terms of the GNU General Public License as published by
@REM the Free Software Foundation, either version 3 of the License, or
@REM (at your option) any later version.

@REM OCR-To-TEI is distributed in the hope that it will be useful,
@REM but WITHOUT ANY WARRANTY; without even the implied warranty of
@REM MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
@REM GNU General Public License for more details.

@REM You should have received a copy of the GNU General Public License
@REM along with this program.  If not, see <http://www.gnu.org/licenses/>.

@echo off

set modsPath=C:\TEIConverterTool\ocr-to-tei-pipeline\OCR-To-TEI\src\main\resources\modsFiles\ah232-3_HT018907295_Moguntiensis_Trevirensis_1690.xml
set ocrPath=C:\TEIConverterTool\ocr-to-tei-pipeline\OCR-To-TEI\src\main\resources\ocrOutputFiles
set teiPathName=C:\TEIConverterTool\ocr-to-tei-pipeline\TEI_CSV_Output\TEI_created_Band1.xml
CALL mvn -q -e compile exec:java -Dexec.arguments="-m,%modsPath%,-o,%ocrPath%,-t,%teiPathName%"

pause