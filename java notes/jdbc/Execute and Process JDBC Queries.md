## Statement Methods

|Method|Purpose|
|---|---|
|`executeQuery()`|Executes SELECT; returns `ResultSet`|
|`executeUpdate()`|Executes INSERT, UPDATE, DELETE; returns affected row count|
|`execute()`|Executes SQL when the result type may vary|

## ResultSet

Used to read records returned by a query.

```
while (rs.next()) {
    System.out.println(rs.getInt("id"));
    System.out.println(rs.getString("name"));
}
```

- `rs.next()` → Moves to the next row.
    
- Column values can be read using methods such as `getInt()` and `getString()`.
    

## Remember

`executeUpdate()` does not return the updated records; it returns the number of affected rows.