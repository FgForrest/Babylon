# Babylon

## Project that provides support for Java property file translation.

### Description and usage 
Babylon is standalone console application in basic. Conditions for usage is: 
1. You must run it in root directory of your project.
2. You must have prepared your Json configuration file (see "Configuration" section).
3. You must have prepared target Google spreadsheet.

But primary use case is to run Babylon as Maven plugin "babylon-maven-plugin". For this case you must configure them as 
described below (see "Run Babylon as Maven plugin" section).

### Configuration
Configuration file is in Json format and have this structure: 
```json
{
  "path" : [ 
  "src\\test\\resources\\META-INF\\lib_eshop_edee\\country.properties",
  "src\\test\\resources\\META-INF\\09_mail_form\\messages.properties",
  "src\\test\\resources\\META-INF\\goPayGate\\*.properties" ],
  "dataFileName" : "translation-db.json",
  "mutations" : [ "en", "de" ]
}
```
You can use * convention to specify multiple files on path.

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

#### Run Babylon as console application
Application needs this arguments: 1.action 2.config.json 3.google sheet id
1. expected action (export, import)
* export - takes all properties files specified in configuration file and export their properties into specified google spreadsheet. Each properties 
  bundle (primary properties file and its mutation) is exported into sheet labeled with primary properties file name + # + unique number of file.
* import - takes all translated values from google spreadsheet specified in configuration file and import them back into target properties files. 
  Format of the mutation properties files is taken from primary mutation properties file. All properties which isn't present in primary 
  properties file (are present only in concrete mutation properties file) is placed at the end of the target mutation file.
2. path to translator-config.json file. This file serves as database for translation process.
3. ID of the google spreadsheet (e.g. 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc) 

Cmd line examples:

java -jar babylon-1.0-SNAPSHOT.jar export test-config.json 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc 

java -jar babylon-1.0-SNAPSHOT.jar import test-config.json 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc

#### Run Babylon as Maven plugin
To get it work put this XML structure into your build->plugins section of your POM.xml file: 
```xml
<plugin>
    <groupId>com.fg.util</groupId>
    <artifactId>babylon-maven-plugin</artifactId>
    <version>1.0.3-SNAPSHOT</version>
</plugin>
```
After that this configured plugin is possible to use from terminal by this way:
- "mvn babylon::export" for export translations from properties file to google spreadsheet
- "mvn babylon::import" for import translations from google spreadsheet back to properties files

Parameters is: 
- config.file - path to translator-config.json file. This file serves as database for translation process.
- google.sheet.id - ID of the google spreadsheet (e.g. 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc) 

e.g.
``` 
mvn babylon:import -Dconfig.file=test-config.json -Dgoogle.sheet.id=1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc
```
Detailed description of this actions is provided in section above (see "Run Babylon as console application" section)

###### Another use case
Parameters can be also set in POM.xml this way, if it is your use case:
```xml
<plugin>
    <groupId>com.fg.util</groupId>
    <artifactId>babylon-maven-plugin</artifactId>
    <version>1.0.3-SNAPSHOT</version>
    <configuration>
        <configFileName>{FILL ME UP}</configFileName>
        <googleSheetId>{FILL ME UP}</googleSheetId>
    </configuration>
</plugin>
```
Replace {FILL ME UP} placeholders by your values: 
- configFileName is same as parameter "config.file" described above.
- googleSheetId is same as parameter "google.sheet.id" described above.
