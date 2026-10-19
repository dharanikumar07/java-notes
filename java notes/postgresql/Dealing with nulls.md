## NULL

`NULL` = missing / unknown / no value.

```text
NULL ≠ 0
NULL ≠ ''
NULL ≠ false
```

---

## Checking NULL

❌ Wrong:

```sql
WHERE column = NULL
WHERE column != NULL
```

✅ Correct:

```sql
WHERE column IS NULL
WHERE column IS NOT NULL
```

```text
IS NULL     → value is missing
IS NOT NULL → value exists
```

---

## Why `= NULL` doesn't work

SQL uses three-valued logic:

```text
TRUE
FALSE
UNKNOWN
```

```sql
5 = NULL
```

→ `UNKNOWN`

Therefore:

```text
NULL → use IS NULL / IS NOT NULL
```

---

# COALESCE

`COALESCE` returns the **first non-NULL value**.

```sql
COALESCE(a, b, c)
```

Checks from **left → right**.

```text
a
↓
NULL? → yes → b
           ↓
        NULL? → yes → c
                    ↓
               first non-NULL
```

### Example

```sql
SELECT COALESCE(phone, email, 'No contact')
FROM users;
```

Meaning:

```text
phone exists → phone
phone NULL   → email
both NULL    → 'No contact'
```

### Difference

```text
IS NULL
→ checks whether NULL

COALESCE
→ returns a fallback value
```

---

## Quick Revision

```text
NULL = missing / unknown

❌ = NULL
❌ != NULL

✅ IS NULL
✅ IS NOT NULL

COALESCE(a,b,c)
→ first non-NULL value

IS NULL  → CHECK
COALESCE → FALLBACK
```