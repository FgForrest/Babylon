# Babylon

## Tool to automate Java property file translation.

### Description and usage

Babylon is a tool to gather messages, and their translations from property files. It performs a round-trip consisting of 
two phases. In the export phase the messages are written to a [Google Sheets](https://www.google.com/sheets/about/) spreadsheet. 
A translation agency of your choice will fill in the missing translations. In the import phase, the filled out spreadsheet 
is examined, and the newly translated messages are written to respective translation property files. Also, the state 
of the translation is written out to a disk in the form of JSON file. This is called a snapshot as it contains 
the snapshot of the translated messages.

Babylon can be run as a Maven plugin or a standalone console application. 

To run Babylon:

1. It must be run in the root directory of the project to perform translation on.
2. A Json configuration file must exist (see the "Configuration" section).
3. A Google Sheets spreadsheet must exist (empty for the export phase).

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

### Parameterization and running of application

##### **Before first attempt to use Babylon**

Google sheets API must be enabled for your Google account.

##### **First attempt to access Google spreadsheet**

When you run Babylon first time, then in terminal this message will appear "Please open the following address in your browser:" 
followed by a link. Please click on this link and login into correct google account and on the next page click to "Allow" button. 
This action ensure access to Google spreadsheets. This is a one-time action only, and will not need to be repeated next time, 
unless you delete created "tokens" folder.

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

### Running Babylon as console application

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
