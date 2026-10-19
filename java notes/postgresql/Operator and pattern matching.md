## 1. IN

`IN` checks whether a value exists in a list.

```sql
WHERE id IN (1, 2, 3)
```

Equivalent to:

```sql
WHERE id = 1
   OR id = 2
   OR id = 3
```

Example:

```sql
SELECT *
FROM users
WHERE country IN ('India', 'USA', 'UK');
```

**Remember:**

`IN` → value is one of these values.

---

## 2. NOT IN

`NOT IN` excludes values from a list.

```sql
SELECT *
FROM users
WHERE country NOT IN ('India', 'USA');
```

Meaning:

```text
country ≠ India
AND
country ≠ USA
```

**Important:** `NOT IN` can behave unexpectedly when the list/subquery contains `NULL`.

---

## 3. LIKE

`LIKE` is used for text pattern matching.

```sql
WHERE name LIKE 'A%'
```

### `%` wildcard

`%` → any number of characters.

```text
'A%'   → starts with A
'%A'   → ends with A
'%A%'  → contains A
```

Example:

```sql
WHERE name LIKE '%ar%'
```

→ name contains `ar`.

### Case sensitivity

PostgreSQL `LIKE` is **case-sensitive**.

```sql
WHERE name LIKE 'A%'
```

does not normally match `aaron`.

---

## 4. ILIKE

`ILIKE` performs **case-insensitive** pattern matching.

```sql
WHERE name ILIKE 'a%'
```

Can match:

```text
Aaron
aaron
Alice
alice
```

```text
LIKE  → case-sensitive
ILIKE → case-insensitive
```

> `ILIKE` is PostgreSQL-specific.

---

## 5. Exact Match vs Pattern Match

```sql
name = 'Aaron'
```

→ exact value.

```sql
name LIKE 'A%'
```

→ starts with A.

```sql
name ILIKE '%aar%'
```

→ contains `aar`, ignoring case.

---

## 6. Subquery

A **subquery** is a query inside another query.

```sql
SELECT *
FROM users
WHERE id IN (
    SELECT user_id
    FROM orders
);
```

Structure:

```text
Outer Query
     ↓
   uses
     ↓
Subquery
```

The subquery produces values that the outer query can use.

---

## 7. IN + Subquery

```sql
SELECT *
FROM users
WHERE id IN (
    SELECT user_id
    FROM orders
    WHERE amount > 1000
);
```

Conceptually:

```text
Subquery
   ↓
user IDs
   ↓
IN
   ↓
users
```

Useful when filtering one table based on data from another query.

---

## 8. Common Combination

```sql
SELECT *
FROM users
WHERE country IN ('India', 'USA')
  AND name ILIKE 'a%'
  AND status = 'active'
  AND id >= 10
  AND id < 100;
```

### Meaning

```text
country → India or USA
name    → starts with A (case-insensitive)
status  → exactly active
id      → 10 to 99
```

---

## Quick Revision

```text
=       → exact value
IN      → value from list
NOT IN  → exclude list
LIKE    → pattern, case-sensitive
ILIKE   → pattern, case-insensitive
%       → any number of characters
Subquery → query inside another query

IN (1,2,3)
LIKE 'A%'
LIKE '%A'
LIKE '%A%'
ILIKE 'a%'
```

### Remember

```text
IN      → Which values?
NOT IN  → Which values to exclude?
LIKE    → What pattern?
ILIKE   → What pattern, ignoring case?
Subquery → Get values from another query.
```