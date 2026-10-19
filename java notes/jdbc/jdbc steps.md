## Steps to Connect Java with Database

1. Add the JDBC driver dependency.
    
2. Establish a database connection.
    
3. Create a statement.
    
4. Execute the SQL query.
    
5. Process the result if returned.
    
6. Close database resources.
    

## Modern Java

The PostgreSQL JDBC driver is normally auto-loaded when its JAR is on the classpath. Explicit `Class.forName()` is usually unnecessary.

## Best Practice

Use try-with-resources to close JDBC resources automatically.