## 1. Spring Framework

Spring is a Java framework that provides features such as IoC, DI, AOP, and transaction management to build applications.

- Requires more configuration in traditional setups.
    
- Dependencies and server setup may need to be configured manually.
    
- Used to build enterprise Java applications.
    

## 2. Spring Boot

Spring Boot simplifies application development using Spring.

- Provides **auto-configuration**.
    
- Uses **starter dependencies** to simplify dependency management.
    
- Supports embedded servers such as Tomcat.
    
- Makes it easier to create standalone applications with less configuration.
    

## 3. Key Differences

|Spring|Spring Boot|
|---|---|
|Core application framework|Built on top of Spring|
|More manual configuration may be needed|Auto-configuration reduces setup|
|Server setup may be manual|Embedded server support|
|Dependencies configured individually as needed|Starter dependencies simplify setup|
|More setup in traditional projects|Faster application setup|

## 4. Example

**Traditional Spring:** You may need to configure the application context, dependencies, and deployment server.

**Spring Boot:** Add the required starter dependencies and run the application.

```
@SpringBootApplication
public class MyApplication {
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
}
```

This starts the Spring Boot application and its configured application context.

## Interview Answer

Spring is a framework used to build Java applications. Spring Boot is built on Spring and simplifies development through auto-configuration, starter dependencies, and embedded servers.

## Quick Revision

- Spring → Framework for building applications.
    
- Spring Boot → Simplifies Spring application setup.
    
- Auto-configuration → Configures components based on dependencies and settings.
    
- Starter dependencies → Convenient dependency bundles.
    
- Embedded server → Run the application without separately deploying it to an external server.