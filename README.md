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

Before first attempt to use Babylon:

You need "credentials.json" for accessing google spreadsheet. This file must exists in same folder from where you running Babylon application.
This file can be generated for your google acount here: 
[ENABLE THE GOOGLE SHEETS API](https://developers.google.com/sheets/api/quickstart/java) When you are logged in 
on google account which you want to use, just click to "ENABLE THE GOOGLE SHEETS API" button and follow instructions.

#### Run Babylon as console application
Application needs this arguments:
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
    <version>1.0-SNAPSHOT</version>
    <configuration>
        <configFileName>{FILL ME UP}</configFileName>
        <googleSheetId>{FILL ME UP}</googleSheetId>
    </configuration>
</plugin>
```
Replace {FILL ME UP} placeholders by your values: 
- configFileName - path to translator-config.json file. This file serves as database for translation process.
- googleSheetId - ID of the google spreadsheet (e.g. 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc) 

After that this configured plugin is possible to use from terminal by this way: 
- "mvn babylon::export" for export translations from properties file to google spreadsheet
- "mvn babylon::import" for import translations from google spreadsheet back to properties files

Detailed description of this actions is provided in section above (see "Run Babylon as console application" section)
