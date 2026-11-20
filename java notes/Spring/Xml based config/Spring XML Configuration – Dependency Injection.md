## 5. Ref Attribute

**Definition:**  
`ref` is used to inject one Spring bean into another Spring bean.

**Example:**

```
public class Address {
}

public class Student {
    private Address address;

    public void setAddress(Address address) {
        this.address = address;
    }
}
```

**XML:**

```
<bean id="address" class="com.example.Address"/>

<bean id="student" class="com.example.Student">
    <property name="address" ref="address"/>
</bean>
```

- `value` → Injects a simple value.
    
- `ref` → Injects another Spring bean.
    

**Remember:** `ref` connects one bean with another bean.

## 6. Constructor Injection

**Definition:**  

Constructor injection means injecting dependencies through a class constructor.

Spring XML supports three ways to identify constructor arguments:

### 1. Index

Uses the parameter position (starts from 0).

```
<bean id="student" class="Student">
    <constructor-arg index="0" value="John"/>
    <constructor-arg index="1" value="22"/>
</bean>
```

### 2. Name

Uses the constructor parameter name.

```
<bean id="student" class="Student">
    <constructor-arg name="name" value="John"/>
    <constructor-arg name="age" value="22"/>
</bean>
```

### 3. Type

Uses the constructor parameter data type.

```
<bean id="student" class="Student">
    <constructor-arg type="java.lang.String" value="John"/>
    <constructor-arg type="int" value="22"/>
</bean>
```

**Remember:**

- `index` → Parameter position (0, 1, 2...)
    
- `name` → Parameter name
    
- `type` → Parameter data type
    

All three help Spring identify which constructor parameter should receive which value.

## 7. Creating Interface

**Definition:**  
Spring can inject an implementation class into a variable declared using an interface.

**Java:**

```
public interface Vehicle {
    void drive();
}

public class Car implements Vehicle {
    public void drive() {
        System.out.println("Car driving");
    }
}

public class Person {
    private Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
```

**XML:**

```
<bean id="car" class="com.example.Car"/>

<bean id="person" class="com.example.Person">
    <property name="vehicle" ref="car"/>
</bean>
```

**Remember:**

- Interface provides abstraction.
    
- Implementation class provides functionality.
    
- Spring injects the implementation into the interface reference.
    

## 8. Autowiring

**Definition:**  
Autowiring means Spring automatically injects dependencies without explicitly specifying the dependency using `ref`.

**XML:**

```
<bean id="address" class="com.example.Address"/>

<bean id="student"
      class="com.example.Student"
      autowire="byType"/>
```

**Autowiring types:**

|Type|Meaning|
|---|---|
|no|No automatic injection (default)|
|byName|Matches property name with bean ID|
|byType|Matches property type with bean class|
|constructor|Matches constructor parameter types|

**Remember:**

- byName → Matches bean ID.
    
- byType → Matches class/type.
    
- constructor → Matches constructor parameters.
    

**Important:** If multiple beans of the same type exist, `byType` can cause ambiguity.