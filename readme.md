# Readme

### Abstract
This document shows how to run this application and use it. The application reads from a text file and stores the file/folder structure into database. Then using the application the paths can be found by searching the name of the file/folder.

## Step1
Change the src/main/resources/fs1.txt file to any file you want to read the structure from.

## Step2
Run following command to build the application. Make sure java8 or higher version is installed, and maven is configured. Use eclipse/ intellij to import the project as existing maven project and run the file FilesystemApplication to start the web application. Else run the below command and move to step 2 to run the application.
mvn install 

## Step3
Run the jar file. Give the available port.
`java -jar filesystem-0.0.1-SNAPSHOT.jar --server.port=8080`

## Step4
Open `http://localhost:8080/` in a browser. 
 
The home page will appear. Put the search string and press search. It will show the result. I have made the search case insensitive. 
Output of the search will come in list structure. 
Error message will show if the input is blank.
Error page will be showed if page does not exist for url.
