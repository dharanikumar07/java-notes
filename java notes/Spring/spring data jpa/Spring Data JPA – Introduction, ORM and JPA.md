## 1. What is Spring Data JPA?

Spring Data JPA is a Spring module that simplifies database operations by reducing the amount of boilerplate code developers need to write.

Normally, JDBC requires us to write SQL queries and handle connections, statements and result sets.

With Spring Data JPA, we can perform database operations using repository interfaces without implementing every method manually.

**Example:**

```
public interface StudentRepo
        extends JpaRepository<Student, Integer> {
}
```

By extending `JpaRepository`, we automatically get methods like:

- `save()` – Insert or update data.
    
- `findAll()` – Retrieve all records.
    
- `findById()` – Retrieve a record by ID.
    
- `deleteById()` – Delete a record by ID.
    

**Remember:** Spring Data JPA reduces boilerplate code by providing ready-made repository methods.

## 2. What is ORM?

ORM stands for Object Relational Mapping.

It is a technique that maps Java objects to relational database tables.

It allows developers to work with Java objects instead of manually mapping every database row.

**Example:**

Java Class:

```
class Student {
    int id;
    String name;
}
```

Database Table:

|id|name|
|---|---|
|1|Arun|
|2|Kumar|

Here:

- Java class → Database table
    
- Java object → Database row
    
- Java field → Database column
    

**Purpose:** ORM reduces manual SQL and object-to-table mapping work.

## 3. What is JPA?

JPA stands for Java Persistence API (now Jakarta Persistence).

It is a specification that defines how Java objects should be mapped to relational databases and how persistence operations should work.

JPA itself is not an implementation. It defines rules and interfaces.

**Popular JPA implementations:**

- Hibernate
    
- EclipseLink
    

Hibernate is the commonly used JPA implementation in Spring Boot applications.

## 4. Difference Between JPA, Hibernate and Spring Data JPA

|Technology|Purpose|
|---|---|
|JPA|Specification / standard|
|Hibernate|ORM implementation of JPA|
|Spring Data JPA|Simplifies repository and database operations|

**Remember this relationship:**

Spring Data JPA → Uses JPA → Implemented commonly by Hibernate → Communicates with Database.

## 5. Important JPA Annotations

|Annotation|Purpose|
|---|---|
|`@Entity`|Marks a Java class as a database entity|
|`@Table`|Specifies the database table name|
|`@Id`|Specifies the primary key|
|`@GeneratedValue`|Generates primary key values|
|`@Column`|Configures a database column|
|`@Transient`|Excludes a field from persistence|

Example:

```
@Entity
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "student_name")
    private String name;

}
```

### Interview Quick Revision

1. **What is ORM?** Mapping Java objects to relational database tables.
    
2. **What is JPA?** A specification for object-relational persistence.
    
3. **Is Hibernate JPA?** No. Hibernate is an implementation of the JPA specification.
    
4. **Is Spring Data JPA an ORM?** No. It simplifies data access using JPA.
    
5. **Can we use JPA without Hibernate?** Yes, using another JPA implementation such as EclipseLink.