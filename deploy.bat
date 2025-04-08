*@echo off
set APP_NAME=ETU003315
set SRC_DIR=src\main\java
set WEB_DIR=src\main\webapp
set BUILD_DIR=build
set LIB_DIR=lib
set TOMCAT_WEBAPPS=C:\"Program Files"\"Apache Software Foundation"\"Tomcat 11.0"\webapps
set SERVLET_API_JAR=%LIB_DIR%\servlet-api.jar

REM Suppression et recreation du dossier temporaire
if exist %BUILD_DIR% rmdir /s /q %BUILD_DIR%
mkdir %BUILD_DIR%\WEB-INF\classes

REM Compilation des fichiers Java avec le JAR des Servlets
dir /s /b %SRC_DIR%\*.java > sources.txt
javac -cp %SERVLET_API_JAR% -d %BUILD_DIR%\WEB-INF\classes @sources.txt
del sources.txt

REM Copier les fichiers web
xcopy %WEB_DIR% %BUILD_DIR% /E /I /Y

REM Creation du fichier .war dans le dossier build
cd %BUILD_DIR%
jar -cvf %APP_NAME%.war *
cd ..

REM Deploiement vers Tomcat
copy %BUILD_DIR%\%APP_NAME%.war %TOMCAT_WEBAPPS%

echo Deploiement termine. Redemarrez Tomcat si necessaire.

pause