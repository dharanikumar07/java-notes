## 9. Primary Bean

**Definition:**  
`primary="true"` tells Spring which bean to prefer when multiple beans of the same type are available for autowiring.

**Example:**

```
<bean id="car" class="com.example.Car"
      primary="true"/>

<bean id="bike" class="com.example.Bike"/>

<bean id="person" class="com.example.Person"
      autowire="byType"/>
```

- Both beans implement the same interface.
    
- Spring prefers the primary bean when resolving the dependency.
    

**Remember:** Primary resolves ambiguity by giving preference to one bean.

## 10. Lazy Init Bean

**Definition:**  
Lazy initialization means Spring creates a bean only when it is first requested instead of creating it during container startup.

**XML:**

```
<bean id="student"
      class="com.example.Student"
      lazy-init="true"/>
```

**Difference:**

- `lazy-init="false"` → Bean is created during container startup (singleton).
    
- `lazy-init="true"` → Bean is created when first requested.
    

**Remember:** Lazy initialization delays object creation.

## 11. Get Bean By Type

Spring provides `getBean()` to retrieve beans from the container.

**By bean ID:**

```
Student s = context.getBean("student", Student.class);
```

**By type:**

```
Student s = context.getBean(Student.class);
```

**Important:**

- By ID → Retrieves using bean name.
    
- By Type → Retrieves using class type.
    
- If multiple matching beans exist, `getBean(Student.class)` throws `NoUniqueBeanDefinitionException`.
    

**Remember:** Use type-based retrieval when only one matching bean exists.

## 12. Inner Bean

**Definition:**  
An inner bean is a bean declared inside another bean's property or constructor argument.

It is used when a dependency is needed only by one particular bean.

**XML:**

```
<bean id="student" class="com.example.Student">

    <property name="address">
        <bean class="com.example.Address"/>
    </property>

</bean>
```

**Remember:**

- Inner bean has no independent bean ID.
    
- It is defined inside another bean.
    
- Mainly used for private, one-time dependencies.