## 1. What is Spring JDBC?

Spring JDBC is a module of the Spring Framework that simplifies database operations using JDBC.

**Problem with Traditional JDBC:**

- Manually create connections.
    
- Write PreparedStatement.
    
- Execute SQL queries.
    
- Handle exceptions.
    
- Close Connection, Statement and ResultSet.
    

**Spring JDBC Solution:**

- Reduces boilerplate code.
    
- Manages JDBC resources automatically.
    
- Handles exceptions using DataAccessException.
    
- Makes database operations easier.
    

**Remember:** Spring JDBC simplifies JDBC; it does not replace SQL or JDBC.

## 2. Creating a Spring JDBC Project

Required dependencies:

- Spring JDBC
    
- PostgreSQL Driver
    
- Spring Context (if required by the project)
    

**Purpose:**

- Spring JDBC → Database operations.
    
- PostgreSQL Driver → Connect Java application with PostgreSQL.
    
- Spring Context → Spring container and bean management.
    

## 3. Student Service and Repository

Spring applications commonly follow layered architecture.

|Layer|Responsibility|
|---|---|
|Controller|Handles user requests|
|Service|Contains business logic|
|Repository / DAO|Communicates with database|
|Database|Stores data|

**Example flow:**

Controller → Service → Repository → Database

**StudentService**

- Handles student-related business logic.
    
- Calls repository methods.
    

**StudentRepo**

- Executes database operations.
    
- Uses JdbcTemplate to communicate with the database.
    

**Remember:** Service handles business logic; Repository handles database logic.

## 4. JdbcTemplate

JdbcTemplate is a Spring JDBC class that simplifies database operations.

Package: `org.springframework.jdbc.core`

**Why JdbcTemplate?**

- Eliminates repetitive JDBC code.
    
- Manages connection and resource closing.
    
- Handles SQL exceptions.
    
- Executes SQL queries easily.
    

**Common Methods:**

|Method|Purpose|
|---|---|
|`update()`|INSERT, UPDATE, DELETE|
|`query()`|Retrieve multiple records|
|`queryForObject()`|Retrieve a single value or object|
|`execute()`|Execute SQL statements|

**Example:**

```
@Repository
public class StudentRepo {

    @Autowired
    private JdbcTemplate jdbc;

    public void save(Student student) {

        String sql = "INSERT INTO student(id, name) VALUES (?, ?)";

        jdbc.update(sql, student.getId(), student.getName());
    }
}
```

**Remember:**

- `?` represents a parameter placeholder.
    
- Values are passed separately.
    
- JdbcTemplate uses PreparedStatement internally for parameterized queries.
    

### Interview Questions

1. What is Spring JDBC?
    
2. Why do we use JdbcTemplate?
    
3. What is the difference between JDBC and Spring JDBC?
    
4. What is the responsibility of Service and Repository?
    
5. What is the purpose of `update()` in JdbcTemplate?