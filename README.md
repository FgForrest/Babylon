# Babylon

## Project that provides support for Java property file translation.

### Description and usage 
Babylon is standalone console application. Conditions for usage is: 
1. You must run it in root directory of your project.
2. You must have prepared your Json configuration file (see [Configuration](###Configuration) section).
3. You must have prepared Google spreadsheet with 

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

Application needs this arguments:
1. expected action (export, import)
* export - takes all properties files specified in configuration file and export their properties into specified google spreadsheet. Each properties 
  bundle (primary properties file and its mutation) is exported into sheet labeled with primary properties file name + # + unique number of file.
* import - takes all translated values from google spreadsheet specified in configuration file and import them back into target properties files. 
  Format of the mutation properties files is taken from primary mutation properties file. All properties which isn't present in primary 
  properties file (are present only in concrete mutation properties file) is placed at the end of the target mutation file.
2. path to translator-config.json file. This file serves as database for translation process.
3. ID of the google spreadsheet (e.g. 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc) 

You need "credentials.json" for accessing google spreadsheet. This file must exists in same folder from where you running Babylon application.
This file can be generated for your google acount here: 
[https://developers.google.com/sheets/api/quickstart/java](ENABLE_THE_GOOGLE_SHEETS_API) When you are logged in 
on google account which you want to use, just click to "ENABLE THE GOOGLE SHEETS API" button and follow instructions.

Cmd line examples:

java -jar babylon-1.0-SNAPSHOT.jar export test-config.json 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc 

java -jar babylon-1.0-SNAPSHOT.jar import test-config.json 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc
