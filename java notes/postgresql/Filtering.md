`WHERE` → filters rows based on conditions.

## Operators

|Operator|Meaning|
|---|---|
|`=`|Equal|
|`<>` / `!=`|Not equal|
|`>`|Greater than|
|`<`|Less than|
|`>=`|Greater/equal|
|`<=`|Less/equal|

```sql
WHERE id > 50
WHERE country = 'India'
WHERE status <> 'inactive'
```

## AND / OR

```text
AND → both conditions must be true
OR  → at least one condition must be true
```

### Important

`AND` has **higher precedence** than `OR`.

So:

```sql
A AND B OR C
```

means:

```sql
(A AND B) OR C
```

### Best Practice

When mixing `AND` + `OR`, use `()`:

```sql
WHERE country = 'India'
AND (status = 'active' OR status = 'pending')
```

**Why?**

- Clearer
    
- Prevents logic mistakes
    
- No meaningful performance penalty
    

## Remember

```text
WHERE → filter rows
= <> != > < >= <= → comparison
AND → both
OR → either
() → make logic explicit
```