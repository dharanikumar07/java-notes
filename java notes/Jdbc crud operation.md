CRUD = Create, Read, Update, Delete.

|Operation|SQL|JDBC method|
|---|---|---|
|Create|INSERT|`executeUpdate()`|
|Read|SELECT|`executeQuery()`|
|Update|UPDATE|`executeUpdate()`|
|Delete|DELETE|`executeUpdate()`|

## Example SQL

```
INSERT INTO students (name) VALUES ('Arun');

SELECT * FROM students;

UPDATE students SET name = 'Ravi' WHERE id = 1;

DELETE FROM students WHERE id = 1;
```

## Best Practice

Use `PreparedStatement` with parameters for values supplied by users.