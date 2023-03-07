#!/bin/bash

# start java program with parameters from command line

if ! command -v mvn &> /dev/null
then
    echo "maven could not be found, please install maven first with: ""\"sudo apt install maven""\"!"
    exit
fi



script_dir=$(dirname $0)
cd "$script_dir/../"

modsPath=
ocrPath=
teiPathName=

selection=
until [ "$selection" = "0" ]; do
    echo "
    Run TEI converter
    1 - Absolute path with name to Mods-file
        (current path = $modsPath)
    2 - Absolute path of folder with OCR-Output
        (current path = $ocrPath)
    3 - Absolute path with filename for TEI-Output file
        (current path = $teiPathName)
    4 - run TEI converter
    0 - exit program
"
    echo -n "Enter selection number and confirm with "Enter": "
    read selection
    echo ""
    case $selection in
        1 ) read -p "Please enter absolute path to Mods-file (e.g. /Data/Mods/Band1.xml): " modsPath ;;
        2 ) read -p "Please enter absolute path to OCR-Output folder (e.g. /Data/OCR/): " ocrPath ;;
        3 ) read -p "Pleaser enter absolute path with filename for TEI-Output file (e.g. /Data/TEI/TEI_Band1.xml): " teiPathName;;
        4 ) echo "Conversion started!"
        mvn -q -e compile exec:java -Dexec.arguments="-m,$modsPath,-o,$ocrPath,-t,$teiPathName" 
        echo "Conversion ended!" ;;
        0 ) exit ;;
        * ) echo "Please enter 1, 2, 3, 4 or 0"; press_enter ;;
    esac
done






