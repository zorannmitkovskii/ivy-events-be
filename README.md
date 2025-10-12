# ivy-events-be

This is a minimal Maven Java project.

How to import in IntelliJ IDEA:
- From the Welcome screen: Open, select the project root folder (ivy-events-be). IntelliJ should detect pom.xml and import as a Maven project automatically.
- If it opens as a plain project, right-click pom.xml and select "Add as Maven Project" or use the Maven tool window and click the + to add the project.
- Ensure your Project SDK and language level are set to Java 21 (File > Project Structure > Project).

Build and run from command line:
- mvn -v
- mvn clean package
- Run the app: `java -cp target/ivy-events-be-1.0-SNAPSHOT.jar org.ivy.IveEventsApplication`

Alternatively, in IntelliJ:
- Open IveEventsApplication.java and click the green run icon next to the main method.