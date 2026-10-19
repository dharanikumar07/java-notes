## 3 Rules for Table Design

1. **Smallest suitable type** → Choose a type that supports the expected data range.
    
2. **Simplest suitable type** → Use native types; don't store numbers as strings or simple fields as JSON.
    
3. **Realistic representation** → Use `NOT NULL` when data is required; allow `NULL` when it can be missing.
    

## Why?

- Smaller data types can reduce storage, RAM usage and index size.
    
- Smaller indexes can improve cache efficiency and query performance.
    
- Correct data types avoid unnecessary conversions.
    
- Correct constraints maintain data integrity.
    

## Example

```
CREATE TABLE employees (
    id BIGINT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    age SMALLINT NOT NULL,
    salary NUMERIC(10,2) NOT NULL,
    phone VARCHAR(20)
);
```

- `BIGINT` → large ID range.
    
- `SMALLINT` → suitable for a limited age range.
    
- `NUMERIC(10,2)` → precise decimal values such as salary.
    
- `phone` allows `NULL` because it may be missing; phone numbers are text, not numbers.
    

## Remember

**Smallest + Simplest + Realistic = Better schema design.**

Developers are responsible for understanding and reviewing generated SQL, migrations and constraints.