# Babylon

## Tool to automate Java property file translation.

### Description and usage 
Babylon is a tool to gather messages and their translations from property files. Id performs a roundtrip consisting of 
two phases. In the export phase the messages are written to a Google Sheets spreadsheet. A translation agency 
will fill in the missing translations. In the import phase, the filled out spreadsheet is examined and the newly 
translated messages are written to respective translation property files. Also, the state of the translation is written 
out to a disk in the form of JSON file. This is called a snapshot as it contains the snapshot of the translated messages.

Babylon can be run as a Maven plugin or a standalone console application. 

To run Babylon: 
1. It must be run in the root directory of the project to perform translation on.
2. A Json configuration file must exist (see the "Configuration" section).
3. A Google Sheets spreadsheet must exist (empty for the export phase).

### Configuration
Configuration is a Json file wit h following structure: 
```json
{
  "path" : [ 
  "src/test/resources/META-INF/lib_eshop_edee/country.properties",
  "src/test/resources/META-INF/09_mail_form/messages.properties",
  "src/test/resources/META-INF/goPayGate/*.properties" ],
  "dataFileName" : "translation-db.json",
  "mutations" : [ "en", "de" ]
}
```
You can use the * wildcard to specify multiple files/directories on path.

Forward slashes in paths(`/`) are preferred to double backslashes (`\ \`) as it works on both Windows and Unix platforms.

### Parameterization and running of application

##### **Before first attempt to use Babylon**

**For access from FG Forrest company** Necessary "credentials.json" file is already included in application. 
All your Google spreadsheets must be created under the "analytics@fg.cz" google account or if you want to use 
Google spreadsheet created under your account, you can simply share it with account "analytics@fg.cz".

**For access by users outside of FG Forrest company** You need "credentials.json" for accessing google spreadsheet. 
This file must exists in same folder from where you running Babylon application. This file can be generated for your google account here: 
[ENABLE THE GOOGLE SHEETS API](https://developers.google.com/sheets/api/quickstart/java) When you are logged in 
on google account which you want to use, just click to "ENABLE THE GOOGLE SHEETS API" button and follow instructions.

##### **First attempt to access Google spreadsheet**
When you run Babylon first time, then in terminal this message will appear "Please open the following address in your browser:" 
followed by link. Please click on this link and login into correct google account and on the next page click to "Allow" button. 
This action ensure access to Google spreadsheets. This is a one-time action only, and will not need to be repeated next time, 
until you not delete created "tokens" folder.



### Running Babylon as a Maven plugin
Add babylon to the `plugins` section of your POM.xml file.
```xml
<plugin>
    <groupId>com.fg.util</groupId>
    <artifactId>babylon-maven-plugin</artifactId>
    <version>1.0.3</version>
</plugin>
```
The two translation phases are run by invoking the respective Maven goals:
- "mvn babylon::export" for export translations from properties file to google spreadsheet
- "mvn babylon::import" for import translations from google spreadsheet back to properties files

Parameters are:
- config.file - path to translator-config.json file.
- google.sheet.id - ID of the google spreadsheet to write translations when exporting
  or to load translation from when importing (e.g. 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc)

e.g.
``` 
mvn babylon:import -Dconfig.file=test-config.json -Dgoogle.sheet.id=1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc
```

### Running Babylon as console application
Application needs the following arguments: 1.action 2.config.json 3.google sheet id
1. expected action (export, import)
* export - takes all properties files specified in configuration file and export their properties into specified google spreadsheet. Each properties 
  bundle (primary properties file and its mutation) is exported into sheet labeled with primary properties file name + # + unique number of file.
* import - takes all translated values from google spreadsheet specified in configuration file and import them back into target properties files. 
  Format of the mutation properties files is taken from primary mutation properties file. All properties which isn't present in primary 
  properties file (are present only in concrete mutation properties file) is placed at the end of the target mutation file.
2. path to translator-config.json file. This file serves as database for translation process.
3. ID of the google spreadsheet (e.g. 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc) 

Command line line examples:

java -jar babylon-1.0-SNAPSHOT.jar export test-config.json 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc 

java -jar babylon-1.0-SNAPSHOT.jar import test-config.json 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc
