## **1. What is @Autowired?**

`@Autowired` is a Spring annotation used to **automatically inject the required dependency (Bean) into another class.**

Instead of manually creating objects using `new`, Spring finds the required Bean and injects it.

## **2. Example**

```
@Component
class Engine {
    void start() {
        System.out.println("Engine started");
    }
}

@Component
class Car {

    @Autowired
    private Engine engine;

    void drive() {
        engine.start();
    }
}
```

**What happens?**

1. Spring creates the Engine Bean.
    
2. Spring creates the Car Bean.
    
3. `@Autowired` tells Spring to inject Engine into Car.
    
4. Car can use the Engine object.
    

## **3. Types of @Autowired Injection**

Spring supports three injection approaches:

**1. Field Injection**

```
@Autowired
private Engine engine;
```

- Injects directly into the field.
    
- Simple but not recommended for production code.
    

**2. Setter Injection**

```
private Engine engine;

@Autowired
public void setEngine(Engine engine) {
    this.engine = engine;
}
```

- Injects through setter method.
    
- Useful for optional dependencies.
    

**3. Constructor Injection (Recommended)**

```
private final Engine engine;

@Autowired
public Car(Engine engine) {
    this.engine = engine;
}
```

- Injects through constructor.
    
- Supports `final` fields.
    
- Easy to test.
    
- Recommended approach.
    

**Note:** If a class has only one constructor, `@Autowired` is optional in modern Spring.

## **4. How does @Autowired work internally?**

Spring uses dependency resolution to find the required Bean.

- By default, Spring searches by **type**.
    
- If multiple Beans of the same type exist, Spring may get confused.
    
- Use `@Qualifier` to specify which Bean to inject.
    

Example:

```
@Component("dieselEngine")
class DieselEngine implements Engine {
}

@Component("petrolEngine")
class PetrolEngine implements Engine {
}

@Component
class Car {

    @Autowired
    @Qualifier("dieselEngine")
    private Engine engine;
}
```

`@Qualifier` tells Spring which specific Bean to inject.

## **5. Important Annotations**

|Annotation|Purpose|
|---|---|
|`@Component`|Marks class as Spring Bean|
|`@Autowired`|Injects dependency|
|`@Qualifier`|Selects a specific Bean|
|`@Primary`|Gives preference to one Bean when multiple candidates exist|

## **6. Interview Quick Revision**

1. **What is @Autowired?** Automatically injects dependencies.
    
2. **How does Spring find a Bean?** Primarily by type.
    
3. **What if multiple Beans of the same type exist?** Use `@Qualifier` or `@Primary`.
    
4. **Which injection is recommended?** Constructor Injection.
    
5. **Is @Autowired mandatory on a single constructor?** No.
    
6. **Can @Autowired be used on fields?** Yes.
    
7. **Who performs dependency injection?** Spring IoC Container.
    

# **Handwritten Notes – Flowcharts**

### **1. Working of @Autowired**

**Spring IoC Container**

**Creates Beans**

Engine, Car

**Finds @Autowired**

Car requires Engine

**Searches Bean by Type**

**Injects Dependency**

Engine → Car

### **2. Multiple Beans Scenario**

**Car needs Engine**

**Spring searches by type**

**Multiple Engine Beans found?**

**No**

Inject Bean

**Yes**

Use @Qualifier / @Primary

**Final memory trick:**

- `@Component` → Create/manage a Bean.
    
- `@Autowired` → Inject a Bean.
    
- `@Qualifier` → Select a specific Bean.
    
- `@Primary` → Give one Bean priority.