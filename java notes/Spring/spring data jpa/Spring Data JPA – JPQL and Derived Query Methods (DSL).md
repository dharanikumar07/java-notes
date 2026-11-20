## 1. What is JPQL?

JPQL stands for Java Persistence Query Language.

It is a query language used to retrieve and manipulate data through JPA entities.

**Important:** JPQL works with entity class names and Java field names, not directly with database table and column names.

### SQL vs JPQL

**SQL:**

```
SELECT * FROM student
WHERE marks > 80;
```

**JPQL:**

```
@Query("SELECT s FROM Student s WHERE s.marks > 80")
List<Student> findTopStudents();
```

Here:

- `Student` → Entity class name.
    
- `s` → Alias.
    
- `s.marks` → Java entity field.
    

Spring Data JPA executes this JPQL query through the JPA provider.

## 2. Using JPQL in Repository

```
public interface StudentRepo
        extends JpaRepository<Student, Integer> {

    @Query("SELECT s FROM Student s WHERE s.marks > 80")
    List<Student> findTopStudents();
}
```

Calling:

```
repo.findTopStudents();
```

Retrieves students whose marks are greater than 80.

## 3. JPQL with Parameters

Use `@Param` to pass values into JPQL queries.

```
@Query("SELECT s FROM Student s WHERE s.name = :name")
List<Student> findByStudentName(
        @Param("name") String name);
```

Calling:

```
repo.findByStudentName("Arun");
```

`:name` is a named parameter.

**Why use parameters?**

- Avoid hardcoding values.
    
- Reuse queries with different inputs.
    
- Support safe parameter binding.
    

## 4. JPQL UPDATE and DELETE

For update and delete queries, use `@Modifying` along with `@Query`.

**Update:**

```
@Modifying
@Transactional
@Query("UPDATE Student s SET s.marks = :marks WHERE s.id = :id")
int updateMarks(@Param("id") int id,
                @Param("marks") int marks);
```

**Delete:**

```
@Modifying
@Transactional
@Query("DELETE FROM Student s WHERE s.id = :id")
int deleteStudent(@Param("id") int id);
```

- `@Modifying` tells Spring Data JPA that the query modifies data.
    
- `@Transactional` ensures the operation runs within a transaction.
    
- Return type `int` represents the number of affected records.
    

## 5. What is DSL / Derived Query Method?

DSL means Domain Specific Language.

In Spring Data JPA, derived query methods allow us to create database queries simply by defining method names in the repository interface.

Spring Data JPA analyzes the method name and generates the corresponding query.

**Example:**

```
List<Student> findByName(String name);
```

Spring Data JPA understands this as a query to find students by name.

Equivalent SQL:

```
SELECT * FROM student WHERE name = ?;
```

No need to write `@Query` for this method.

## 6. Common Derived Query Keywords

|Method Name|Purpose|
|---|---|
|`findByName()`|Find by name|
|`findByMarks()`|Find by marks|
|`findByMarksGreaterThan()`|Marks greater than|
|`findByMarksLessThan()`|Marks less than|
|`findByNameContaining()`|Name contains text|
|`findByNameStartingWith()`|Name starts with text|
|`findByNameEndingWith()`|Name ends with text|
|`findByMarksBetween()`|Marks within a range|
|`findByNameAndMarks()`|Both conditions|
|`findByNameOrMarks()`|Either condition|
|`countByMarksGreaterThan()`|Count matching records|
|`existsByName()`|Check whether matching record exists|

### Example

```
List<Student> findByMarksGreaterThan(int marks);

List<Student> findByNameAndMarks(
        String name, int marks);

List<Student> findByNameContaining(String keyword);
```

## 7. JPQL vs Derived Query Methods

|JPQL|Derived Query|
|---|---|
|Uses `@Query`|Uses method names|
|Write query manually|Query generated from method name|
|Suitable for complex queries|Suitable for simple queries|
|Uses entity and field names|Uses entity property names|

**When to use?**

- Simple queries → Derived query methods.
    
- Complex queries → JPQL using `@Query`.
    

### Interview Quick Revision

1. What is JPQL? Query language that works with JPA entities.
    
2. Difference between SQL and JPQL? SQL uses database tables and columns; JPQL uses entities and Java fields.
    
3. What is `@Query`? Defines a custom query in a repository.
    
4. What is `@Param`? Binds method parameters to named query parameters.
    
5. What is `@Modifying`? Marks JPQL update/delete queries as modifying operations.
    
6. What is a derived query? A query generated automatically from a repository method name.
    
7. Can we write complex queries using derived methods? Technically some complex combinations are possible, but JPQL or native SQL is usually more suitable.
    
8. What is DSL? A language designed for a specific domain or purpose.