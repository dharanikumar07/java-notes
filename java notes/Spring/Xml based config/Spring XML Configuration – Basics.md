
## 1. Spring Bean XML Configuration

**Definition:**  
XML-based configuration means configuring Spring objects (beans) using an XML file instead of annotations or Java configuration.

**File:** `spring.xml`

```
<beans>
    <bean id="student" class="com.example.Student"/>
</beans>
```

- `<bean>` → Defines an object managed by Spring.
    
- `id` → Unique bean name.
    
- `class` → Fully qualified class name.
    

**Remember:** Spring creates and manages objects defined as beans.

## 2. Object Creation

Spring creates objects using the XML configuration.

```
<bean id="student" class="com.example.Student"/>
```

```
ApplicationContext context =
    new ClassPathXmlApplicationContext("spring.xml");

Student s = context.getBean("student", Student.class);
```

- `ApplicationContext` → Spring container.
    
- `getBean()` → Retrieves the Spring-managed object.
    

**Remember:** Instead of manually creating objects using `new`, Spring creates them.

## 3. Bean Scopes

Scope defines how many objects Spring creates for a bean.

|Scope|Meaning|
|---|---|
|singleton|One object per Spring container (default)|
|prototype|New object for each getBean() call|
|request|One object per HTTP request|
|session|One object per HTTP session|
|application|One object per ServletContext|
|websocket|One object per WebSocket session|

```
<bean id="student"
      class="com.example.Student"
      scope="prototype"/>
```

**Remember:**

- Singleton → Same object.
    
- Prototype → New object.
    

## 4. Setter Injection

**Definition:**  
Setter injection means injecting dependent objects or values through setter methods.

**Java:**

```
public class Student {
    private String name;

    public void setName(String name) {
        this.name = name;
    }
}
```

**XML:**

```
<bean id="student" class="com.example.Student">
    <property name="name" value="John"/>
</bean>
```

- `<property>` → Used for setter injection.
    
- `name` → Setter property name.
    
- `value` → Injects a simple value.
    

**Remember:** Setter injection uses setter methods to inject dependencies or values.