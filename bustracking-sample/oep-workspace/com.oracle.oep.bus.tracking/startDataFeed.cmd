set CEP_HOME=C:\CEP
set WORKSPACE_HOME=D:\JAVA.NET\cep-workspaces\samples-workspace

set PROJECT_HOME=%WORKSPACE_HOME%\com.oracle.cep.bus.tracking
set JAVA_HOME=%CEP_HOME%\jrockit_160_29

cd "%PROJECT_HOME%\loadgen"

"%CEP_HOME%\ocep_11.1\utils\load-generator\runloadgen.cmd" bus_positions.prop

pause