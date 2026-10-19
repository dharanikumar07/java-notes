## Statement

`Statement` executes SQL strings directly.

## Problems

- SQL injection risk when user input is concatenated into SQL.
    
- Manual handling of quotes and special characters.
    
- Repeatedly constructing SQL strings is inconvenient.
    

## Solution

Use `PreparedStatement` for parameterized queries.

## Remember

Never build SQL by concatenating untrusted user input.|

## 1. Statement — Input becomes SQL code

Suppose your Java program receives an ID from the user.

```
String id = "1 OR 1=1";

String sql =
    "SELECT * FROM students WHERE id = " + id;

Statement st = con.createStatement();
ResultSet rs = st.executeQuery(sql);
```

Because Java joins the input directly into the SQL string, the final query becomes:

```
SELECT * FROM students WHERE id = 1 OR 1=1;
```

Look what happened:

```
SQL code                 User input
   |                         |
   └──────────┬──────────────┘
              v
       Combined SQL
              |
              v
  WHERE id = 1 OR 1=1
              |
              v
       Condition is TRUE
```

The user's input introduced a new SQL condition, `OR 1=1`. Since that condition is always true, the query can return all students.

This is SQL injection: user input changes the meaning of your SQL query.

## 2. PreparedStatement — Input is treated as data

Now write the same query using `PreparedStatement`.

```
String id = "1 OR 1=1";

String sql =
    "SELECT * FROM students WHERE id = ?";

PreparedStatement ps = con.prepareStatement(sql);

ps.setString(1, id);

ResultSet rs = ps.executeQuery();
```

Here, the database receives the SQL structure with a parameter placeholder. The JDBC driver binds the input as a value, not as SQL syntax.

```
SQL template
WHERE id = ?
       |
       v
Bind user input as one value
       |
       v
Value: "1 OR 1=1"
       |
       v
Database searches for that value
as an ID; it does NOT execute OR 1=1
as SQL code.
```

In this example, `setString()` binds the input as text. If `id` is an integer column, the database may reject the value because it isn't a valid integer, or simply find no match depending on the query and database behavior. It will not turn the text into an SQL `OR` condition.