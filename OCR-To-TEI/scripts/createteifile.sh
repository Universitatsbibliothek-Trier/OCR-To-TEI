#!/bin/bash

# start Java program with hard coded paths

script_dir=$(dirname $0)
cd "$script_dir/../"

firstOption=$1
firstPath=$2
secondOption=$3
secondPath=$4
thirdOption=$5
thirdPathName=$6

mvn -q -e compile exec:java \
-Dexec.arguments="$1,$2,$3,$4,$5,$6"