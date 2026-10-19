# Maven Introduction

## Definition

Maven is a **Java build automation and dependency management tool**.

## Why Maven?

- Downloads required libraries automatically.
    
- Compiles Java source code.
    
- Runs tests and packages applications.
    
- Manages project dependencies.
    

## Important File

`pom.xml` — Project Object Model; stores project configuration, dependencies and build settings.

## Maven Workflow

`Write Code → Compile → Test → Package`

## Key Terms

- **Dependency:** External library required by a project.
    
- **Build:** Process of compiling, testing and packaging code.
    
- **Artifact:** A project output, such as a JAR file.
    

## Interview Point

Maven simplifies Java project builds and manages dependencies automatically.

# Maven in IDE

## Definition

An IDE (e.g., IntelliJ IDEA or Eclipse) can integrate with Maven to manage and build Java projects.

## How It Works

- Create or import a Maven project.
    
- IDE reads `pom.xml`.
    
- Maven resolves dependencies.
    
- IDE supports compiling, testing and running the project.
    

## Important

- `pom.xml` → project configuration.
    
- `src/main/java` → application code.
    
- `src/test/java` → test code.
    
- `target/` → generated build output.
    

## Interview Point

An IDE provides a convenient interface for Maven; Maven performs the underlying build and dependency-management tasks.

# Getting Dependencies in Maven

## Definition

A dependency is an external library required by a Java project.

## How Maven Gets Dependencies

1. Add dependency details to `pom.xml`.
    
2. Maven searches the local repository.
    
3. If unavailable locally, Maven downloads it from a remote repository, commonly Maven Central.
    
4. The library becomes available to the project.
    

## Repositories

- **Local:** Stored on your computer (`.m2/repository` by default).
    
- **Central:** Public repository containing many Java libraries.
    
- **Remote:** Other configured repositories.
    

## Example

Adding a library to `pom.xml` allows Maven to manage its download.

## Interview Point

Maven automatically resolves and downloads required dependencies instead of requiring manual JAR downloads.