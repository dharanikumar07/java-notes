## 1. Java-Based Configuration

**Definition:** Java-based configuration means configuring Spring beans using Java classes instead of XML files.

- `@Configuration` → Marks a class as a Spring configuration class.
    
- `@Bean` → Creates and registers an object in the Spring container.
    

**Example:**

```
@Configuration
public class AppConfig {

    @Bean
    public Student student() {
        return new Student();
    }
}
```

**Get Bean:**

```
ApplicationContext context =
    new AnnotationConfigApplicationContext(AppConfig.class);

Student s = context.getBean(Student.class);
```

**Remember:**

- `@Configuration` → Configuration class.
    
- `@Bean` → Bean creation method.
    
- Spring manages the returned object.
    

## 2. Bean Name

**Definition:** Every Spring bean has a name used to identify and retrieve it from the container.

**Using @Bean:**

```
@Configuration
public class AppConfig {

    @Bean("myStudent")
    public Student student() {
        return new Student();
    }
}
```

**Get Bean by name:**

```
Student s = context.getBean("myStudent", Student.class);
```

**Important:**

- Default bean name = Method name.
    
- Custom bean name = Name specified inside `@Bean`.
    
- `@Bean({"student", "myStudent"})` → Multiple names (aliases).
    

**Remember:** Bean name identifies a bean in the Spring container.

## 3. Scope Annotation

**Definition:** `@Scope` defines how Spring creates and manages bean instances.

```
@Bean
@Scope("prototype")
public Student student() {
    return new Student();
}
```

**Scopes:**

|Scope|Meaning|
|---|---|
|singleton|One object per container (default)|
|prototype|New object for each lookup|
|request|One per HTTP request|
|session|One per HTTP session|
|application|One per ServletContext|
|websocket|One per WebSocket session|

**Remember:**

- `@Scope("singleton")` → Same instance.
    
- `@Scope("prototype")` → New instance per lookup.
    

**Important:** Singleton is the default Spring bean scope.