#!/bin/bash

# download the jaxb reference implementation here:
# https://eclipse-ee4j.github.io/jaxb-ri/

script_dir=$(dirname $0)
java_src="$script_dir/../src/main/java"
xjc="$script_dir/../lib/jaxb-ri-4.0.0/jaxb-ri/bin/xjc.sh"

$xjc \
  -extension \
  -d $java_src \
  -p "de.uni_trier.bibliothek.xml.parameters.model.generated" \
  "$java_src/../resources/parameters.xsd"
