#!/bin/bash
echo "Building...."
mvn clean install
STATUS=$?
if [ $STATUS -eq 0 ]; then
echo "Build Successful"
else
echo "Build Failed"
fi