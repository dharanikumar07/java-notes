## 7. Autowire Field, Constructor, Setter

Spring supports dependency injection in three places.

### 1. Field Injection

```
@Autowired
private Address address;
```

- Injects directly into the field.
    
- Simple syntax.
    
- Not recommended for production because dependencies are harder to test and make immutable.
    

### 2. Constructor Injection

```
private final Address address;

@Autowired
public Student(Address address) {
    this.address = address;
}
```

- Injects through constructor.
    
- Recommended approach.
    
- Supports final fields and makes dependencies mandatory.
    
- If a class has only one constructor, `@Autowired` is optional.
    

### 3. Setter Injection

```
private Address address;

@Autowired
public void setAddress(Address address) {
    this.address = address;
}
```

- Injects through setter method.
    
- Useful for optional dependencies.
    

**Remember:**

|Type|Injection through|
|---|---|
|Field|Variable|
|Constructor|Constructor|
|Setter|Setter method|

**Interview:** Constructor injection is generally preferred for mandatory dependencies.

## 8. Primary Annotation

**Definition:** `@Primary` marks a bean as the preferred candidate when multiple beans of the same type are available for autowiring.

```
@Component
@Primary
public class Car implements Vehicle {
}

@Component
public class Bike implements Vehicle {
}
```

```
@Component
public class Student {

    @Autowired
    private Vehicle vehicle;
}
```

Spring injects Car because it is marked `@Primary`.

**Remember:** `@Primary` resolves ambiguity by giving preference to one bean.

**Important:** If `@Qualifier` explicitly selects another matching bean, that selection wins over `@Primary`.

## 9. Scope And Value Annotation

### A. @Scope

Defines the lifecycle/scope of a Spring bean.

```
@Component
@Scope("prototype")
public class Student {
}
```

- Singleton → One instance per container.
    
- Prototype → New instance per lookup.
    

### B. @Value

Injects values into fields, constructor parameters or setter parameters.

**Example:**

```
@Component
public class Student {

    @Value("John")
    private String name;

    @Value("22")
    private int age;
}
```

**Using properties file:**

```
student.name=John
student.age=22
```

```
@Value("${student.name}")
private String name;
```

**Remember:**

- `@Scope` → Controls bean scope.
    
- `@Value` → Injects values.
    
- `${...}` → Reads a property from the configured property source.
    
- `#{...}` → Evaluates a Spring Expression Language (SpEL) expression.