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