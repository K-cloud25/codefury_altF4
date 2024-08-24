# Haven Hive

## Description

Haven hive is used to manage meeting room bookings. Application can manage 3 types of users and credit management for the users.
Application also casts a thread in background for refreshing credits for each runs.

## Features

- User Management
- Credits Automatic Management
- Room meeting booking intuitive UI

## Project Structure

This project is structured into multiple modules:

- `Main` - Contains a Main file which showcases system
- `entitiesModule` - Exports POJOS for application
- `applicationExceptionsModule` - Exports Exception for inter application exception handling
- `utilsModule` - Exports set of Util Functions and Database connection faclicities for user
- `daoModule` - Exports Factory Class and Interfaces which are used by the enternal system to perform operations. Hides their implementations.
- `serviceModule` - Exports the primary handler for application and operates as a middle layer between the UI layer and DAO layer

### Prerequisites

Make sure you have the following installed:
- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (version 17 or later)
- [Maven](https://maven.apache.org/download.cgi) (version 3.9.8 or later)
- [IDE](https://www.jetbrains.com/idea/) (e.g., IntelliJ IDEA, Eclipse)

### Installation

1. Clone the repository:

    ```bash
    git clone https://github.com/K-cloud25/codefury_altF4
    ```

2. Navigate to the root project directory:

    ```bash
    cd application/backend
    ```

3. Build the entire project and all modules:

    ```bash
    mvn clean install
    ```

### Running the Project

To run specific modules or the entire project, you can use Maven commands from the root project directory. For example:

- To run a specific module:

    ```bash
    mvn -pl module-a exec:java
    ```

  Replace `module-a` with the desired module name and ensure the `exec-maven-plugin` is configured in that module's `pom.xml`.

### Running Tests

To run tests for the entire project:

```bash mvn test```

### Running Tests for specific Module

To run test on a specific module 

``` mvn -pl module-a test ```
