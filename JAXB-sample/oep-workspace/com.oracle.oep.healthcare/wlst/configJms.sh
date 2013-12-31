#!/bin/bash

export MW_HOME=/Users/Lloyd/Work/WLS_HOME/wls12120

export WLS_HOME=$MW_HOME/wlserver

export CLASSPATH=$WLS_HOME/server/lib/weblogic.jar

$JAVA_HOME/bin/java weblogic.WLST initJms.py
