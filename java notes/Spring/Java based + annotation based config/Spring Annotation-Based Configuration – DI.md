## 4. Autowire

**Definition:** Autowiring means Spring automatically injects the required dependency into a bean without manually connecting beans using XML `ref`.

**Example:**

```
@Component
class Address {
}

@Component
class Student {

    @Autowired
    private Address address;
}
```

Spring finds the Address bean and injects it into Student.

**Remember:** `@Autowired` injects dependencies automatically, primarily by type.

## 5. Primary And Qualifier

**Problem:** What happens when multiple beans implement the same interface?

Spring gets confused about which bean to inject.

**Solution 1: @Primary**

Tells Spring which bean should be preferred by default.

```
@Component
@Primary
class Car implements Vehicle {
}

@Component
class Bike implements Vehicle {
}
```

Now Spring prefers Car when injecting Vehicle.

**Solution 2: @Qualifier**

Specifically selects the bean by name.

```
@Component
class Student {

    @Autowired
    @Qualifier("bike")
    private Vehicle vehicle;
}
```

**Difference:**

|@Primary|@Qualifier|
|---|---|
|Gives default preference|Selects a specific bean|
|Used at bean definition|Used at injection point|
|One preferred bean|Explicit bean selection|

**Remember:**

- `@Primary` → Default choice.
    
- `@Qualifier` → Specific choice.
    
- `@Qualifier` takes precedence over `@Primary` when selecting a matching bean.
    

## 6. Component Stereotype Annotations

**Definition:** Stereotype annotations tell Spring that a class should be detected and registered as a Spring bean through component scanning.

**Types:**

|Annotation|Purpose|
|---|---|
|`@Component`|General-purpose Spring bean|
|`@Service`|Service/business logic layer|
|`@Repository`|Database/DAO layer|
|`@Controller`|Spring MVC controller|

**Example:**

```
@Component
public class Address {
}

@Service
public class StudentService {
}

@Repository
public class StudentRepository {
}
```

**Remember:**

- `@Component` → General bean.
    
- `@Service` → Business logic.
    
- `@Repository` → Database operations.
    
- `@Controller` → Handles web requests.
    

**Important:** These annotations are detected through component scanning, such as `@ComponentScan` or Spring Boot's component scanning configuration.