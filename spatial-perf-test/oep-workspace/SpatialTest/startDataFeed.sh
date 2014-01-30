#!/bin/sh

OEP_HOME=/Users/Lloyd/Work/OEP_HOME/ps6_home
WORKSPACE_HOME=/Volumes/LaCie/GitHub/Repositories/oep-demos/spatial-perf-test/oep-workspace

PROJECT_HOME=$WORKSPACE_HOME/SpatialTest
#JAVA_HOME=$OEP_HOME/jrockit_160_33

cd "$PROJECT_HOME/loadgen"

"$OEP_HOME/ocep_11.1/utils/load-generator/runloadgen.sh" positions.prop