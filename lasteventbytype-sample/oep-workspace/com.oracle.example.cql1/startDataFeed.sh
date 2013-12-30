#!/bin/sh

export OEP_HOME=/Users/Lloyd/Work/OEP_HOME/ps6_home
export WORKSPACE_HOME=/Volumes/LaCie/GitHub/Repositories/oep-demos/lasteventbytype-sample/oep-workspace

export PROJECT_HOME=$WORKSPACE_HOME/com.oracle.example.cql1

cd $PROJECT_HOME/loadgen

$OEP_HOME/ocep_11.1/utils/load-generator/runloadgen.sh vehicles.prop