# Babylon

## Project that provides support for Java property file translation.

### Description and usage 
Babylon is standalone console application. Conditions for usage is: 
1. You must run it in root directory of your project.
2. You must have prepared your Json configuration file (see [Configuration](###Configuration) section).
3. You must have prepared Google sheet with 

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

### Parameterization and running of application

Application needs this arguments:
1. expected action (import, export)
2. path to translator-config.json file
3. ID of the google sheet (e.g. 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc)

You need "credentials.json" for accessing google sheet. This file must exists in same folder from where you running Babylon application.
This file can be generated for your google acount here: 
[https://developers.google.com/sheets/api/quickstart/java](ENABLE_THE_GOOGLE_SHEETS_API) When you are logged in 
on google account which you want to use, just click to "ENABLE THE GOOGLE SHEETS API" button and follow instructions.
