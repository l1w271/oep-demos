set CEP_HOME=G:\11gR1PS1\CEP
set WORKSPACE_HOME=G:\11gR1PS1\WORKSPACE

set PROJECT_HOME=%WORKSPACE_HOME%\com.oracle.cep.healthcare
set JAVA_HOME=%CEP_HOME%\jrockit_160_14_R27.6.5-32

cd "%PROJECT_HOME%\loadgen"

"%CEP_HOME%\ocep_11.1\utils\load-generator\runloadgen.cmd" bmi.prop

pause