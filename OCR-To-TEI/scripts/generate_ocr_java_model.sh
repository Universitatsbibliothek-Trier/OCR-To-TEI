# @author       René Ackels
# Copyright (c) 2023 René Ackels, Anne Königs

# This file is part of OCR-To-TEI.

# OCR-To-TEI is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.

# OCR-To-TEI is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.

# You should have received a copy of the GNU General Public License
# along with this program.  If not, see <http://www.gnu.org/licenses/>.

#!/bin/bash

# download the jaxb reference implementation here:
# https://eclipse-ee4j.github.io/jaxb-ri/

script_dir=$(dirname $0)
java_src="$script_dir/../src/main/java"
xjc="$script_dir/../lib/jaxb-ri-4.0.0/jaxb-ri/bin/xjc.sh"

$xjc \
  -extension \
  -d $java_src \
  -p "de.uni_trier.bibliothek.xml.ocr.model.generated" \
  "$java_src/../resources/xml_OCR_Output.xsd"
