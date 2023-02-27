#!/bin/bash

# start Java program without arguments

script_dir=$(dirname $0)
cd "$script_dir/../"

mvn -q compile exec:java 
