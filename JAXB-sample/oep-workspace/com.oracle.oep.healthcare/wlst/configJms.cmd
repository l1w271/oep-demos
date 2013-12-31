call ..\setEnv.cmd

set CLASSPATH=%WLS_HOME%\server\lib\weblogic.jar

%JAVA_HOME%\bin\java weblogic.WLST initJms.py
