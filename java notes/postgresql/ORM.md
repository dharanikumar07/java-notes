**ORM = Object-Relational Mapping**

Connects **programming objects ↔ relational database tables**.

```text
Java Class   ↔   Table
Object       ↔   Row
Field        ↔   Column
```

### Why ORM?

Reduces manual SQL + object ↔ database mapping code.

```text
Java Object
    ↓
   ORM
    ↓
   SQL
    ↓
PostgreSQL
```

### Example

```java
class User {
    int id;
    String name;
}
```

```text
User → users table
id   → id column
name → name column
```

### Important

**ORM does NOT replace SQL.**

ORM generates/executes SQL behind the scenes.

### Java ORM

```text
JPA          → Specification
Hibernate    → ORM implementation
Spring Data JPA → Simplifies JPA usage
```

### Remember

> **ORM = Mapping objects in code to tables in a database.**