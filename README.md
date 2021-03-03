# DeeceApp
An app that aims to make the Vassar dining experience more predictable. Currently a WIP.

DeeceApp currently only contains the core logic, written purely in Java. Java was chosen as it's a language familiar to those who have taken CMPU 102.

## Maven
This app uses Maven. If you do not have it installed (check with `mvn --version`), install it from https://maven.apache.org/.

### Useful Maven commands
Use the following commands in the folder containing the `pom.xml` (navigate to within the `deece-app` folder, not the folder containing it):

Compile: `mvn compile`
- This will compile the Java classes in the `target/` folder. However, this will not run the app (use the Run command to do so).

Run: `mvn exec:java`
- This will run the Java classes in the `target/` folder. This will fail if nothing has been compiled yet.

Clean: `mvn clean`
- Deletes the `target/` folder, requiring the app to be recompiled.

Test: `mvn test`
- Runs the tests located in `src/test/`.

You can chain commands. `mvn clean compile exec:java` will recompile and run the app, for example.

## Future Plans
We are planning on making an iOS app, an Android app, a chatbot, and potentially a web app as well. These will most likely be developed on different repositories and will borrow the logic used here.

iOS app link: to be added

Android app link: to be added

Chatbot link: to be added

Web app link: to be added
