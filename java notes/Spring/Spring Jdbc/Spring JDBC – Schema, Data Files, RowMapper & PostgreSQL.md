## 1. Schema.sql and Data.sql

Spring Boot supports SQL initialization files to prepare the database.

**schema.sql**

- Defines database structure.
    
- Creates tables.
    
- Defines columns and data types.
    

Example:

```
CREATE TABLE student (
    id INT PRIMARY KEY,
    name VARCHAR(100)
);
```

**data.sql**

- Inserts initial data into tables.
    
- Used to populate the database.
    

Example:

```
INSERT INTO student VALUES (1, 'John');
INSERT INTO student VALUES (2, 'David');
```

**Remember:**

|File|Purpose|
|---|---|
|schema.sql|Creates tables|
|data.sql|Inserts records|

Note: These are SQL initialization scripts. Their execution depends on Spring Boot configuration and database initialization settings.

## 2. RowMapper

RowMapper is an interface used to convert each database row into a Java object.

Package: `org.springframework.jdbc.core`

**Why RowMapper?**

When retrieving records from a database, JDBC returns data as ResultSet.

RowMapper helps convert ResultSet rows into Java objects.

**Important Method:**

```
mapRow(ResultSet rs, int rowNum)
```

**Example:**

```
public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum)
            throws SQLException {

        Student s = new Student();

        s.setId(rs.getInt("id"));
        s.setName(rs.getString("name"));

        return s;
    }
}
```

**Using RowMapper with JdbcTemplate:**

```
public List<Student> findAll() {

    String sql = "SELECT * FROM student";

    return jdbc.query(sql, new StudentRowMapper());
}
```

**Remember:**

- ResultSet → Contains database row data.
    
- RowMapper → Converts database row into Java object.
    
- JdbcTemplate → Uses RowMapper to map query results.
    

## 3. Spring JDBC with PostgreSQL

Spring JDBC can communicate with PostgreSQL using the PostgreSQL JDBC Driver.

**Required dependencies:**

- Spring JDBC
    
- PostgreSQL Driver
    

**Database configuration (Spring Boot):**

```
spring.datasource.url=jdbc:postgresql://localhost:5432/college
spring.datasource.username=postgres
spring.datasource.password=root

spring.datasource.driver-class-name=org.postgresql.Driver
```

**Configuration explanation:**

|Property|Purpose|
|---|---|
|datasource.url|Database location|
|datasource.username|Database username|
|datasource.password|Database password|
|driver-class-name|PostgreSQL JDBC driver|

**Working Flow:**

Java Application → JdbcTemplate → JDBC Driver → PostgreSQL Database

### Interview Questions

1. What is schema.sql?
    
2. What is data.sql?
    
3. What is RowMapper?
    
4. Why do we use RowMapper?
    
5. What is the difference between ResultSet and RowMapper?
    
6. How does Spring JDBC connect with PostgreSQL?
    
7. What is the role of the PostgreSQL JDBC Driver?