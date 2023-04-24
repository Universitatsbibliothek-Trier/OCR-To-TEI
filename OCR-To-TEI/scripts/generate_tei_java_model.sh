# Copyright (c) 2023 René Ackels
# Permission is hereby granted, free of charge, to any person obtaining

# This program is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.

# This program is distributed in the hope that it will be useful,
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
  -p "de.uni_trier.bibliothek.xml.tei.model.generated" \
  "$java_src/../resources/TEIxsd.xsd"
