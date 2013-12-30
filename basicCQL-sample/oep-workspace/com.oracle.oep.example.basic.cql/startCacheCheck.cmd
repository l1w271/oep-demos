set CEP_HOME=D:\11gR1PS5\CEP
set WORKSPACE_HOME=D:\ECLIPSE\galileo\cep_ps5\workspaces\default

set PROJECT_HOME=%WORKSPACE_HOME%\com.oracle.oep.example.basic.cql
set JAVA_HOME=%CEP_HOME%\jrockit_160_20

cd "%PROJECT_HOME%\util"

"%CEP_HOME%\ocep_11.1\utils\load-generator\runloadgen.cmd" cache_check.prop

pause