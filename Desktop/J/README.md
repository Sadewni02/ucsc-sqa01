# Simple Java Maven Project

This is a basic Java project using Maven. It includes a simple `Main` class and a placeholder test.

## Structure
- `pom.xml`: Maven configuration
- `src/main/java/com/example/Main.java`: Main application entry point
- `src/test/java/com/example/MainTest.java`: Basic test class

## Build and Run
To compile and run the project:

```
mvn compile
mvn exec:java -Dexec.mainClass="com.example.Main"
```

To run tests:

```
mvn test
```
