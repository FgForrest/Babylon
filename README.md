# Babylon

## Tool to automate translation files.

### Description and usage

Babylon is a tool to gather messages, and their translations from translation files. It performs a round-trip consisting of 
two phases: *export* phase and *import* phase. 

In the export phase the messages are written to a [Google Sheets](https://www.google.com/sheets/about/) spreadsheet. 
A translator will then fill in the missing translations. 

In the import phase, the spreadsheet (with the missing translations filled out by a translator) is examined, and the 
newly translated messages are used to update the respective translation files. Also, the state of the translation,
*snapshot*,  is written out to a disk in the form of JSON file.

Babylon can be run as a Maven plugin or as a standalone console application. 

To run Babylon:

- It must be run in the root directory of the project to perform translation on.
- A `credentials.json` file with Google Cloud user credentials must exist in the current directory 
  (root directory of the project to translate).
- Sheets API must be enabled for your Google account.
- A Json configuration file must exist (see the "Configuration" section).
- A Google Sheets spreadsheet must exist (empty for the export phase).

Currently only supported file types are **.properties** and **.ts**

### Google Cloud user credentials

You need a Google Cloud project with Sheets API enabled. Also, you need to download the `credentials.json` client 
secrets file from the Cloud Console. Alternatively, you can use the Java Quickstart to perform all these actions using a wizard.

#### Using quickstart wizard to obtain the credentials file

Using [Google Sheets Java Quickstart](https://developers.google.com/sheets/api/quickstart/java), you can create
a new Google Cloud project with Sheets API enabled and download the `credentials.json` client secrets file in a few steps
with the help of a wizard. 

Go to the link a press the *Enable the Google Sheets API* button.

- Name the new Google Cloud project (e.g. Babylon)
- Click *Next*
- Select *Desktop app* from the dropdown menu (it's the default choice)
- Click *Create*
- Click *Download client configuration* to obtain the `credentials.json` file
- Store the file as `credentials.json` in the directory where you will run Babylon from
  - Do not commit the `credentials.json` as part of the project you use Babylon to translate!
  - The `credentials.json` file should be kept privately.

#### Obtaining existing credentials file from Google Cloud Console

- Go to Google Cloud Console
- Select the project that you will use to grant Babylon access to the Sheets API
  - Be advised that the client secrets file enables access to the Cloud APIs.
  - It is a good idea to create a new Google Cloud project that does not contain any sensitive data apart from translations.
- Select *APIs & Services* from the Console menu
- Select *Credentials* from the *APIs & Services* menu
- Download the file in section *OAuth 2.0 client IDs*
- Store the file as `credentials.json` in the directory where you will run Babylon from 
  - Do not commit the `credentials.json` as part of the project you use Babylon to translate!
  - The `credentials.json` file should be kept privately.  
- [see also the SO answer here](https://stackoverflow.com/questions/58460476/where-to-find-credentials-json-for-google-api-client)   

You need "credentials.json" for accessing google spreadsheet.
This file must exists in same folder from where you running Babylon application. This file can be generated for your google account here:
[ENABLE THE GOOGLE SHEETS API](https://developers.google.com/sheets/api/quickstart/java) When you are logged in
on google account which you want to use, just click to "ENABLE THE GOOGLE SHEETS API" button and follow instructions.

#### Giving Babylon access to the Sheets API 

When you run Babylon for the first time, a *Please open the following address in your browser* message will appear in the terminal
followed by a link. Open the link and login using the Google account used to create `credentials.json` and on the next page click the
"Allow" button. This is a one-time action only and will not need to be repeated next time, unless you delete created "tokens" folder.


### Configuration
Configuration is a JSON file with following structure: 

```json
{
  "path" : [ 
  "src/test/resources/META-INF/lib_eshop_edee/country.properties",
  "src/test/resources/META-INF/09_mail_form/messages.properties",
  "src/test/resources/META-INF/goPayGate/*.properties" ],
  "dataFileName" : "translation-db.json",
  "mutations" : [ "en", "de" ],
  "lockedCellEditors": ["kosar@fg.cz", "kamenik@fg.cz"]
}
```

You can use the * wildcard to specify multiple files/directories on the path.

Forward slashes in paths(`/`) are preferred to double backslashes (`\ \`) as it works on both Windows and Unix platforms.

### Running Babylon as a Maven plugin

Add babylon to the `plugins` section of your POM.xml file.

```xml
<plugin>
    <groupId>one.edee</groupId>
    <artifactId>babylon-maven-plugin</artifactId>
    <version>2.0.0</version>
</plugin>
```

The two translation phases are run by invoking the respective Maven goals:
- `mvn babylon:export` for export translations from properties file to google spreadsheet
- `mvn babylon:import` for import translations from google spreadsheet back to properties files

Parameters are:

- `config.file` - path to translator-config.json file.
- `google.sheet.id` - ID of the Google spreadsheet to write translations when exporting
  or to load translation from when importing (e.g. 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc)

e.g.

``` 
mvn babylon:import -Dconfig.file=test-config.json -Dgoogle.sheet.id=1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc
```

### Running Babylon as a console application

Application needs the following arguments: 1.action 2.config.json 3.google sheet id

1. expected action (export, import)
* `export` - takes all properties files specified in configuration file and export their properties into specified the Google spreadsheet. Each property 
  bundle (primary properties file and its mutation) is exported into sheet labeled with primary properties file name + # + unique number of file.
* `import` - takes all translated values from the Google spreadsheet specified in configuration file and import them back into target properties files. 
  Format of the mutation properties files is taken from primary mutation properties file. All properties which isn't present in primary 
  properties file (are present only in concrete mutation properties file) is placed at the end of the target mutation file.
2. path to translator-config.json file. This file serves as database for translation process.
3. ID of the Google spreadsheet (e.g. 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc) 

Command line examples:

``` shell
java -jar babylon-1.0-SNAPSHOT.jar export test-config.json 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc 
java -jar babylon-1.0-SNAPSHOT.jar import test-config.json 1xhnBAOpy8-9KWhl8NP0ZIy6mhlgXKnKcLJwKcIeyjPc
```
