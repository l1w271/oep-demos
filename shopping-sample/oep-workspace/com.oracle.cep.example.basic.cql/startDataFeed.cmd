set CEP_HOME=D:\11gR1PS3\CEP
set WORKSPACE_HOME=D:\ECLIPSE\galileo\cep_ps3\workspaces\default

set PROJECT_HOME=%WORKSPACE_HOME%\com.oracle.cep.example.basic.cql
set JAVA_HOME=%CEP_HOME%\jrockit_160_20

cd "%PROJECT_HOME%\util"

"%CEP_HOME%\ocep_11.1\utils\load-generator\runloadgen.cmd" sample.prop

pause