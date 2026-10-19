
````
# Exploring Data

## SELECT *


SELECT * FROM users;
````

- `*` → all columns
- Good for exploration
- Production → select only needed columns

## LIMIT

```
SELECT * FROM users LIMIT 10;
```

- Restricts number of rows
- Useful when exploring large tables

## Alias

```
SELECT created_at AS registration_date
FROM users;
```

- `AS` → renames output column
- Doesn't rename actual DB column

## ORDER BY

```
ORDER BY name ASC;
ORDER BY age DESC;
```

- `ASC` → ascending
- `DESC` → descending
- Use `ORDER BY` for deterministic ordering

### Multiple columns

```
ORDER BY name ASC, id DESC;
```

- First column → primary sorting
- Second column → tie-breaker

## Core Pattern

```
SELECT columns
FROM table
WHERE conditions
ORDER BY column ASC/DESC
LIMIT n;
```

**SELECT → FROM → WHERE → ORDER BY → LIMIT**

````

### 🎯 What you actually need to remember

SELECT *     → explore
LIMIT        → don't fetch huge data
AS           → rename output
ORDER BY     → control order
ASC/DESC     → sorting direction
Multiple ORDER BY → handle ties
````