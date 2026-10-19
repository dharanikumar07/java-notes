## 1. What is Fetching?

Fetching means loading data from the database into Java objects.

Example: An `Employee` has a `Department`.

- Employee data → `employee` table
    
- Department data → `department` table
    

Hibernate decides when to fetch the department based on the fetch strategy.

## 2. Eager Fetching

**EAGER = Fetch related data immediately.**

```
@ManyToOne(fetch = FetchType.EAGER)
private Department department;
```

### How it works

```
Employee emp = entityManager.find(Employee.class, 1);
```

1. Hibernate fetches the employee.
    
2. Hibernate also loads the associated department as part of satisfying the EAGER fetch requirement.
    
3. Accessing `emp.getDepartment()` does not need to initialize an unloaded department proxy.
    

Hibernate may use a JOIN or separate SELECT queries.

### Example

```
Employee emp = entityManager.find(Employee.class, 1);

System.out.println(emp.getName());
System.out.println(emp.getDepartment().getName());
```

**Remember:** EAGER requires the associated data to be fetched eagerly, but does not guarantee one SQL query.

## 3. Lazy Fetching

**LAZY = Fetch related data when it is accessed.**

```
@ManyToOne(fetch = FetchType.LAZY)
private Department department;
```

### How it works

```
Employee emp = entityManager.find(Employee.class, 1);
```

1. Hibernate fetches the employee.
    
2. The department may be represented by an uninitialized proxy.
    
3. When `emp.getDepartment().getName()` is called, Hibernate fetches the department if it has not already been loaded.
    

### Example

```
Employee emp = entityManager.find(Employee.class, 1);

System.out.println(emp.getName()); 
// Employee data is accessed

System.out.println(emp.getDepartment().getName());
// Department data may be fetched here
```

**Remember:** LAZY delays loading until the associated data is needed. If you access it after the persistence context is closed and it was never loaded, a `LazyInitializationException` may occur.

## 4. EAGER vs LAZY

|EAGER|LAZY|
|---|---|
|Loads related data eagerly|Loads related data on access|
|May load unnecessary data|Can avoid unnecessary loading|
|May use JOIN or SELECT|May use a later SELECT|
|Can increase query/data loading cost|Can cause extra queries (N+1 problem)|

## 5. Default Fetch Types

|Relationship|Default|
|---|---|
|`@ManyToOne`|EAGER|
|`@OneToOne`|EAGER|
|`@OneToMany`|LAZY|
|`@ManyToMany`|LAZY|

You can override defaults using `fetch = FetchType.LAZY` or `fetch = FetchType.EAGER` where supported.

## 6. When to Use?

- **LAZY:** Prefer for relationships when related data may not be needed.
    
- **EAGER:** Use when related data should always be loaded eagerly.
    
- Use fetch joins or entity graphs when you need to control which relationships are loaded for a particular query.
    

> Interview point: LAZY controls _when_ related data is loaded. EAGER requires it to be loaded eagerly. Neither guarantees a specific number of SQL queries.