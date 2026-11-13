## **1. What is a Bean?**

A **Bean is an object that is created and managed by the Spring IoC Container.**

Normally, we create objects using `new`.

```
Engine engine = new Engine();
```

In Spring, we can let Spring create and manage the object.

## **2. What is @Component?**

`@Component` tells Spring that a class should be detected and registered as a Spring Bean.

```
@Component
class Engine {
}
```

Spring scans this class, creates its object and manages it as a Bean.

## **3. How does Spring create a Bean?**

**@Component**

Marks the class

**Component Scanning**

Spring detects the class

**Spring IoC Container**

Creates and manages the object

**Spring Bean**

Managed object

## **4. How does DI happen?**

```
@Component
class Engine {
}

@Component
class Car {

    private final Engine engine;

    Car(Engine engine) {
        this.engine = engine;
    }
}
```

**What happens?**

1. Spring creates the Engine Bean.
    
2. Spring creates the Car Bean.
    
3. Spring identifies that Car needs Engine.
    
4. Spring injects the Engine Bean into Car.
    

This is Dependency Injection.

## **5. Important Difference**

|Term|Meaning|
|---|---|
|`@Component`|Marks a class for Spring management|
|Bean|Object managed by Spring|
|IoC Container|Creates and manages Beans|
|DI|Injects required Beans into other objects|

## **6. Interview Questions**

1. **What is @Component?**  
    Annotation used to mark a class as a Spring-managed component.
    
2. **What is a Spring Bean?**  
    An object managed by the Spring IoC Container.
    
3. **Who creates Spring Beans?**  
    Spring IoC Container.
    
4. **How does Spring identify @Component classes?**  
    Through component scanning.
    
5. **What is Dependency Injection?**  
    Providing required dependencies from outside instead of creating them inside a class.
    

**Remember these three lines:**

- `@Component` → Marks the class.
    
- Bean → Spring-managed object.
    
- DI → Spring injects one Bean into another.