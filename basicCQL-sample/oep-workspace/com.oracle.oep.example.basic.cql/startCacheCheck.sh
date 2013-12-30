#!/bin/sh

export OEP_HOME=/Users/Lloyd/Work/OEP_HOME/ps6_home
export WORKSPACE_HOME=/Volumes/LaCie/GitHub/Repositories/oep-demos/basicCQL-sample/oep-workspace

export PROJECT_HOME=$WORKSPACE_HOME/com.oracle.oep.example.basic.cql

cd $PROJECT_HOME/util

$OEP_HOME/ocep_11.1/utils/load-generator/runloadgen.sh cache_check.prop
