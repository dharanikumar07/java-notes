## Example

```
String sql = "SELECT id, name FROM students";

try (Connection con =
         DriverManager.getConnection(url, user, password);
     Statement st = con.createStatement();
     ResultSet rs = st.executeQuery(sql)) {

    while (rs.next()) {
        System.out.println(
            rs.getInt("id") + " " +
            rs.getString("name")
        );
    }
}
```

## Flow

SELECT → executeQuery() → ResultSet → rs.next() → Read each row

## Important

`rs.next()` returns `false` when no more rows are available.