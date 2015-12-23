#!/bin/sh

mvn clean install
#mvnDebug jetty:run -pl ./GIS-Web
mvn jetty:run -pl ./GIS-Web
