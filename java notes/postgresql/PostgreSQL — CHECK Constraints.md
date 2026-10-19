## 1. What is a CHECK Constraint?

- Enforces a condition on data before it is inserted or updated.
    
- Prevents invalid data from entering the database.
    
- Acts as a final safeguard alongside application validation.
    

## 2. Syntax

**Column-level constraint**

```
price NUMERIC CHECK (price >= 0)
```

**Table-level constraint**

```
CONSTRAINT sale_price_must_be_lower
CHECK (sale_price < price)
```

## 3. Examples

**Prevent negative prices**

```
CREATE TABLE products (
    price NUMERIC CHECK (price >= 0)
);
```

**Validate related columns**

```
CREATE TABLE products (
    price NUMERIC NOT NULL,
    sale_price NUMERIC,
    CONSTRAINT valid_sale_price
        CHECK (sale_price IS NULL OR sale_price < price)
);
```

**Restrict rating between 1 and 10**

```
rating INT CHECK (rating BETWEEN 1 AND 10)
```

**Validate date range**

```
CHECK (end_date > start_date)
```

## 4. Naming Constraints

```
CONSTRAINT age_must_be_valid
CHECK (age BETWEEN 0 AND 120)
```

Naming constraints makes database errors easier to understand.

## 5. Important Points

- `CHECK` conditions must evaluate to `TRUE` or `NULL` for a row to pass; `FALSE` causes rejection.
    
- Use `NOT NULL` separately when a value is mandatory.
    
- CHECK constraints can validate relationships between columns in the same row.
    
- Keep complex, frequently changing business rules in the application when appropriate.
    
- CHECK constraints do not enforce conditions across different rows.
    

**Remember:** `CHECK` = enforce valid data using a condition.