## 1. What Is a Generated Column?

A **generated column** is a column whose value is automatically calculated from other columns in the same row.

- PostgreSQL calculates and maintains the value.
    
- You cannot directly insert or update its value.
    
- Helps keep calculations consistent across applications.
    

**Analogy:** Like a formula in Excel that calculates a value from other cells.

## 2. Syntax

```
column_name data_type
GENERATED ALWAYS AS (expression) STORED
```

PostgreSQL 18 also supports `VIRTUAL` generated columns.

## 3. Example — Full Name

```
CREATE TABLE users (
    first_name VARCHAR(50),
    last_name VARCHAR(50),

    full_name VARCHAR(101)
    GENERATED ALWAYS AS (
        first_name || ' ' || last_name
    ) STORED
);
```

Insert:

```
INSERT INTO users (first_name, last_name)
VALUES ('Ravi', 'Kumar');
```

Result:

|first_name|last_name|full_name|
|---|---|---|
|Ravi|Kumar|Ravi Kumar|

`full_name` is calculated automatically.

**Important:** If either name is `NULL`, the concatenation using `||` becomes `NULL`. Use `COALESCE()` if you want to handle missing names.

## 4. What Happens When Data Changes?

```
UPDATE users
SET first_name = 'Arun'
WHERE first_name = 'Ravi';
```

The generated `full_name` is recalculated automatically.

```
first_name + last_name
          ↓
   Generated Column
          ↓
      full_name
```

You cannot directly assign a value to `full_name` in an `INSERT` or `UPDATE`; PostgreSQL controls it.

## 5. Types of Generated Columns

|Feature|STORED|VIRTUAL|
|---|---|---|
|Calculation|On insert/update|When queried|
|Stored on disk|Yes|No|
|Extra storage|Yes|No generated-value storage|
|Indexing|Supported|Supported in PostgreSQL 18|
|Best for|Repeated or costly calculations|Simple calculations|

**Note:** PostgreSQL 17 and earlier support stored generated columns only. PostgreSQL 18 introduced virtual generated columns.

## 6. Example — Email Domain

```
CREATE TABLE users (
    email TEXT,

    domain TEXT
    GENERATED ALWAYS AS (
        split_part(email, '@', 2)
    ) STORED
);
```

Insert:

```
INSERT INTO users (email)
VALUES ('ravi@example.com');
```

Result:

|email|domain|
|---|---|
|[ravi@example.com](mailto:ravi@example.com)|example.com|

Query users by domain:

```
SELECT *
FROM users
WHERE domain = 'example.com';
```

Index the generated column:

```
CREATE INDEX idx_users_domain
ON users(domain);
```

This can improve searches by domain when PostgreSQL chooses to use the index.

## 7. Important Rules

- Expression must use immutable functions and operators.
    
- Can reference only columns in the same row.
    
- Cannot use subqueries or calculations across multiple rows.
    
- Cannot directly insert or update the generated value.
    
- Generated columns can be used with indexes, subject to normal indexing rules.
    
- `STORED` uses additional disk space; `VIRTUAL` calculates the value when read.
    

## 8. Generated Column vs Normal Column

|Normal Column|Generated Column|
|---|---|
|Value supplied or updated directly|Value calculated automatically|
|Application may calculate the value|Database maintains the value|
|Can store independent input|Depends on its expression|

## 9. When Should You Use It?

- Full name from first and last name.
    
- Total price from quantity × unit price.
    
- Extracted email domain for searching.
    
- Repeated calculations that should remain consistent.
    

Avoid it when the calculation depends on other rows, external data, or changing business rules.

## Interview Revision

- **Generated column:** Automatically calculated from other columns.
    
- **STORED:** Calculated on write and stored on disk.
    
- **VIRTUAL:** Calculated when read; introduced in PostgreSQL 18.
    
- **Immutable expression:** Same inputs always produce the same result.
    
- **Main benefit:** Consistency and less repeated calculation logic.
    

**Remember:** A generated column is calculated and maintained by PostgreSQL, not manually supplied by the application.