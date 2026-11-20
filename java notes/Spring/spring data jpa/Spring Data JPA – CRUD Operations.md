## 1. Creating a Database Table and Inserting Data

Spring Data JPA uses entity classes to map Java objects to database tables.

**Step 1: Create Entity**

```
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int marks;

    // Getters and Setters
}
```

**Step 2: Create Repository**

```
public interface StudentRepo
        extends JpaRepository<Student, Integer> {
}
```

Here:

- `Student` → Entity class.
    
- `Integer` → Primary key data type.
    

**Step 3: Insert Data**

```
@Autowired
StudentRepo repo;

public void addStudent() {

    Student s = new Student();
    s.setName("Arun");
    s.setMarks(90);

    repo.save(s);
}
```

`save()` inserts a new entity or updates an existing entity depending on its persistence state and identifier.

**How does the table get created?**

In Spring Boot, we can configure:

```
spring.jpa.hibernate.ddl-auto=update
```

This allows Hibernate to update the database schema based on entity mappings.

Common values:

- `create` – Creates the schema (can recreate tables).
    
- `update` – Updates the schema.
    
- `create-drop` – Creates schema and drops it when the application stops.
    
- `validate` – Checks schema compatibility.
    
- `none` – Does not manage the schema.
    

For production, database migration tools such as Flyway or Liquibase are generally preferred.

## 2. findAll()

Used to retrieve all records from the database.

```
List<Student> students = repo.findAll();
```

**SQL equivalent:**

```
SELECT * FROM student;
```

Return type: `List<Student>`

## 3. findById()

Used to retrieve a record using its primary key.

```
Optional<Student> student = repo.findById(1);
```

**SQL equivalent:**

```
SELECT * FROM student WHERE id = 1;
```

**Why Optional?**

Because the requested record may not exist.

```
repo.findById(1).ifPresent(System.out::println);
```

Or:

```
Student student = repo.findById(1)
        .orElseThrow(() ->
            new RuntimeException("Student not found"));
```

## 4. Update Operation

Spring Data JPA uses `save()` for inserting and updating entities.

```
Student student = repo.findById(1)
        .orElseThrow();

student.setMarks(95);

repo.save(student);
```

**SQL equivalent:**

```
UPDATE student
SET marks = 95
WHERE id = 1;
```

Note: When an entity is managed inside a transaction, JPA can automatically detect changes and update the database through dirty checking. An explicit `save()` is not always necessary in that situation.

## 5. Delete Operation

Delete a record using its ID:

```
repo.deleteById(1);
```

**SQL equivalent:**

```
DELETE FROM student WHERE id = 1;
```

Delete an entity:

```
Student student = repo.findById(1)
        .orElseThrow();

repo.delete(student);
```

## 6. Important JpaRepository Methods

|Method|Purpose|
|---|---|
|`save()`|Insert or update|
|`findAll()`|Retrieve all records|
|`findById()`|Find by primary key|
|`existsById()`|Check whether ID exists|
|`count()`|Count records|
|`deleteById()`|Delete by ID|
|`delete()`|Delete an entity|
|`deleteAll()`|Delete all records|

### Interview Quick Revision

1. What is JpaRepository? An interface providing ready-made database operations.
    
2. What is the purpose of `save()`? Insert or update an entity.
    
3. Why does `findById()` return Optional? Because a record might not exist.
    
4. Difference between `findAll()` and `findById()`? One retrieves all records; the other retrieves a record by primary key.
    
5. What is `ddl-auto`? A Hibernate configuration property controlling schema generation and management.
    
6. What is dirty checking? JPA automatically detects changes to managed entities and synchronizes them with the database during flush.