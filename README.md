# Logging Parser App

## 1. Build application:
`run command - mvn assemlby:assembly`

## 2. Extract package
Use any windows tool to unzip.

## 3. Setup:

### application.properties configuration

###### Set database - Application has embeded database so to test you don't need to use your standalone version of db.

    db=jdbc:hsqldb:file:eventsDb
    user=SA
    password=
    driver=org.hsqldb.jdbc.JDBCDriver

###### Set your logfile name what the app will be looking for.
Name of reading file
    logfile=logfile.txt

### log4j.xml configuration
It is not neccessary to change this configuration. I suggest to change only log-path.



## 4. Paste your logfile which should be parsed to the folder with application

#### Example of logfile

    {"id":"scsmbstgra", "state":"STARTED", "type":"APPLICATION_LOG", "host":"12345", "timestamp":1491377495212}
    {"id":"scsmbstgrb", "state":"STARTED", "timestamp":1491377495213}
    {"id":"scsmbstgrc", "state":"FINISHED", "timestamp":1491377495218}
    {"id":"scsmbstgra", "state":"FINISHED", "type":"APPLICATION_LOG", "host":"12345", "timestamp":1491377495217}
    {"id":"scsmbstgrc", "state":"STARTED", "timestamp":1491377495210}
    {"id":"scsmbstgrb", "state":"FINISHED", "timestamp":1491377495216}

## 5. Run application:
`run command - java -Dlog4j.configurationFile=log4j2.xml -jar logging-parser-app-1.0-SNAPSHOT.jar`
