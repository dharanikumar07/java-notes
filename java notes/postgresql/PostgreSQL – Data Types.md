## 1. String Types

- `TEXT` → Variable-length text; good default for names and descriptions.
    
- `VARCHAR(n)` → Text with a maximum length; use when a business rule requires it.
    
- PostgreSQL `TEXT` and `VARCHAR` have similar performance characteristics.
    

```
name TEXT,
state_code VARCHAR(2)
```

## 2. Integer Types

|Type|Range|Use|
|---|---|---|
|`SMALLINT`|-32,768 to 32,767|Age, ratings|
|`INTEGER`|About ±2.1 billion|Counts|
|`BIGINT`|About ±9.2 quintillion|Large IDs|

- PostgreSQL integers are **signed**; there is no unsigned integer type.
    
- Use `CHECK` to enforce positive values.
    

```
age SMALLINT CHECK (age >= 0),
id BIGINT
```

## 3. Decimal Types

- `NUMERIC(p,s)` → Exact decimal; use for money.
    
- `REAL` → Approximate floating-point; use for scientific calculations.
    

Example:

```
salary NUMERIC(10,2)
```

- `10` = total digits allowed.
    
- `2` = digits after the decimal point.
    
- Up to 8 digits before the decimal point.
    

## Remember

- **TEXT** → General text.
    
- **VARCHAR(n)** → Maximum length required.
    
- **SMALLINT / INTEGER / BIGINT** → Choose by expected range.
    
- **NUMERIC** → Exact decimal.
    
- **REAL** → Approximate decimal.
    

**Interview principle:** Choose the smallest suitable type that accurately represents the data and enforces the business rules.