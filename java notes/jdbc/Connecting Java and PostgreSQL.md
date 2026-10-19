## Example

```
String url = "jdbc:postgresql://localhost:5432/mydb";
String user = "postgres";
String password = "your_password";

try (Connection con =
         DriverManager.getConnection(url, user, password)) {
    System.out.println("Connected!");
}
```

## Important Classes

- `DriverManager` → Establishes the connection.
    
- `Connection` → Represents the database connection.
    

## Interview Point

`DriverManager.getConnection()` returns a `Connection` object when the connection succeeds.