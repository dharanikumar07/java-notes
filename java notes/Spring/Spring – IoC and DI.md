## 1. IoC (Inversion of Control)

**Definition:** IoC means Spring manages object creation and the lifecycle of objects instead of us creating and managing them manually.

Without Spring:

```
Engine engine = new Engine();
Car car = new Car(engine);
```

With Spring, the container creates and manages the objects.

## 2. DI (Dependency Injection)

**Definition:** DI is a technique where Spring provides the required objects (dependencies) to another object instead of the class creating them itself.

```
@Component
class Engine { }

@Component
class Car {
    private final Engine engine;

    @Autowired
    Car(Engine engine) {
        this.engine = engine;
    }
}
```

Spring creates the `Engine` bean and injects it into `Car`.

## 3. Types of Dependency Injection

- **Constructor injection** – Dependency is provided through a constructor. Preferred for required dependencies.
    
- **Setter injection** – Dependency is provided through a setter method.
    
- **Field injection** – Dependency is injected directly into a field; generally less preferred.
    

## 4. IoC vs DI

- **IoC** → The broader principle: control is given to the Spring container.
    
- **DI** → A common way Spring implements IoC by providing dependencies.
    

## Interview Answer

IoC means Spring controls object creation and management. DI means Spring supplies the dependencies required by an object. For example, Spring creates an `Engine` bean and injects it into a `Car` bean using constructor injection.

## Quick Revision

IoC = Who manages objects? → Spring container.

DI = How are dependencies supplied? → Spring injects them.

Constructor injection = Preferred for required dependencies.