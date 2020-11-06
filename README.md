# logging-parser-app

1. Build application:
run command - mvn assemlby:assembly

2. Extract archive

3. Setup:

application.properties configuration

Set database - Application has embeded database so to test you don't need to use your standalone version of db.

# Database
db=jdbc:hsqldb:file:eventsDb
user=SA
password=
driver=org.hsqldb.jdbc.JDBCDriver

Set your logfile name what the app will be looking for.
# Name of reading domain
logfile=logfile.txt

log4j.xml configuration
It is not neccessary to change this configuration. I suggest to change only log-path.


4. Paste your logfile which should be parsed to the folder with application

5. Run application:
run command - java -Dlog4j.configurationFile=log4j2.xml -jar logging-parser-app-1.0-SNAPSHOT.jar
