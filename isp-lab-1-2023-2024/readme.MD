# Java Lab 1: Introduction to Maven and Project Structure

## Overview
This lab introduces the basics of working with a Maven project in Java. Below is a brief explanation of Maven, the structure of a Maven project, and how IDEs simplify the process.

## What is Maven?
Maven is a build automation and project management tool used primarily for Java projects. It simplifies the build process by managing dependencies, compiling code, running tests, and packaging applications. Maven uses a Project Object Model (POM) file (`pom.xml`) to define the project's configuration, dependencies, and build settings.

Most modern Integrated Development Environments (IDEs) like IntelliJ IDEA, Eclipse, and Visual Studio Code come with built-in support for Maven. This means you don’t need to install Maven separately. These IDEs provide integrated plugins that allow you to:
- Create and manage Maven projects.
- Automatically download dependencies.
- Run Maven commands (e.g., `mvn clean`, `mvn install`) directly from the IDE.

## Creating Java Programs with Build Management Tools
While it is possible to create and compile Java programs without using build management tools like Maven, using such tools offers significant advantages:

1. **Dependency Management**:
    - Maven automatically downloads and manages external libraries (dependencies) required for your project. Without Maven, you would need to manually download and configure these libraries, which can be time-consuming and error-prone.

2. **Standardized Project Structure**:
    - Maven enforces a standard directory structure, making it easier to organize and maintain your code. This consistency is especially helpful when working in teams or on larger projects.

3. **Automated Build Process**:
    - Maven automates repetitive tasks like compiling code, running tests, and packaging the application. This reduces the risk of human error and saves time.

4. **Portability**:
    - Maven ensures that your project can be built consistently across different environments. This is particularly useful when collaborating with others or deploying your application to different systems.

5. **Integration with CI/CD Pipelines**:
    - Build tools like Maven integrate seamlessly with Continuous Integration/Continuous Deployment (CI/CD) pipelines, enabling automated testing and deployment.

While you can write and compile Java programs manually, using a build management tool like Maven makes the development process more efficient, scalable, and maintainable.

## General Structure of a Maven Project
A typical Maven project has the following directory structure:

```
my-maven-project/
├── src/
│ ├── main/
│ │ ├── java/ # Contains the main Java source code
│ │ └── resources/ # Contains configuration files and resources
│ └── test/
│ ├── java/ # Contains the test Java source code
│ └── resources/ # Contains test-specific resources
├── target/ # Contains compiled classes, JAR files, and build outputs
└── pom.xml # The Project Object Model (POM) file
```

- **`src/main/java`**: This is where your main application code resides.
- **`src/test/java`**: This is where your test code resides.
- **`pom.xml`**: This file defines the project's dependencies, plugins, and build configuration.

## Alternative Build Management Tools
While Maven is widely used, there are other build management tools available for Java projects, each with its own strengths and use cases. Here are a few popular alternatives:

1. **Gradle**:
   - Gradle is a modern build tool that combines the best features of Maven and Ant. It uses a Groovy or Kotlin-based DSL (Domain-Specific Language) for configuration, making it more flexible and expressive than Maven's XML-based approach.
   - Gradle is known for its performance, especially for large projects, due to its incremental build capabilities and caching mechanisms.
   - It is the default build tool for Android development and is gaining popularity in the Java ecosystem.

2. **Ant**:
   - Apache Ant is one of the earliest build tools for Java. It uses an XML-based configuration and is highly customizable.
   - Unlike Maven, Ant does not enforce a specific project structure or provide built-in dependency management. Instead, it relies on manual configuration, which can be both a strength and a weakness depending on the project's complexity.
   - Ant is often used in legacy projects or where fine-grained control over the build process is required.

Choosing the right tool depends on your project's requirements, team preferences, and ecosystem. Maven remains a solid choice for most Java projects, but exploring alternatives like Gradle or Bazel can be beneficial for specific use cases.

## Exercise

### Exercises 1

1. Load the project in your IDE.
2. Run the class containing the `main` method.
3. Run the provided tests.
4. Add a new feature to the `main` class.
5. Add a test to verify the new feature.
6. Push all your changes to the remote repository using `git add`, `git commit`, and `git push` commands.
7. Verify that your changes are reflected in the remote repository.
8. Add a new class containing a `main` method and run it.
9. push all your changes to the remote repository using `git add`, `git commit`, and `git push` commands.

**NOTE:** As part of this laboratory is importan to become familiar with IDE (IntelliJ IDEA), Maven, and Git. You will use these tools throughout the semester to work on your projects and assignments. Understand the structure of a Maven project and how to run Java programs. 
