#!/bin/bash

# start java program with parameters from command line

script_dir=$(dirname $0)
cd "$script_dir/../"

modsPath=
ocrPath=
teiPathName=

selection=
until [ "$selection" = "0" ]; do
    echo "
    Run TEI converter
    1 - path with name to Mods-file
        (current path = $modsPath)
    2 - path of folder with OCR-Output
        (current path = $ocrPath)
    3 - absolute path with name for TEI-Output file
        (current path = $teiPathName)
    4 - run TEI converter
    0 - exit program
"
    echo -n "Enter selection: "
    read selection
    echo ""
    case $selection in
        1 ) read -p "Please enter path to Mods-file: " modsPath ;;
        2 ) read -p "Please enter path to OCR-Output folder " ocrPath ;;
        3 ) read -p "Pleaser enter path with file name for TEI-Output file: " teiPathName;;
        4 ) echo "Conversion started!"
        mvn -q -e compile exec:java -Dexec.arguments="$modsPath,$ocrPath,$teiPathName" 
        echo "Conversion ended!" ;;
        0 ) exit ;;
        * ) echo "Please enter 1, 2, or 0"; press_enter ;;
    esac
done






