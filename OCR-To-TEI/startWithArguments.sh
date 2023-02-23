#!/bin/bash

# start java program with paramters from command line

modsPath=
ocrPath=
teiPathName=

read -p "Pfad zur MODS-Datei: " modsPath
read -p "Pfad zum OCR-Ordner: " ocrPath
read -p "Pfad mit Namen der TEI: " teiPathName

mvn -q compile exec:java \
-Dexec.arguments="$modsPath $ocrPath $teiPathName"
