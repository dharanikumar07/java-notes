
# SQL — Aggregate Functions

## Aggregate Function

**Aggregate = summarize multiple rows into a result.**

```text
Many rows
    ↓
Aggregate Function
    ↓
One result
```

### Common Functions

```text
COUNT() → count
SUM()   → total
AVG()   → average
MIN()   → smallest
MAX()   → largest
```

Example:

```sql
SELECT COUNT(*)
FROM users;
```

---

## COUNT

```sql
COUNT(*)
```

→ counts all rows.

```sql
COUNT(phone)
```

→ counts only **non-NULL** phone values.

```text
COUNT(*)       → rows
COUNT(column)  → non-NULL values
```

`COUNT`, `SUM`, `AVG`, `MIN`, `MAX` ignore NULL values when aggregating.

---

## GROUP BY

`GROUP BY` creates groups and performs aggregation for each group.

```sql
SELECT country, COUNT(*)
FROM users
GROUP BY country;
```

```text
Users
  ↓
GROUP BY country
  ↓
India  → 25
USA    → 18
UK     → 12
```

### Important

When using `GROUP BY`, selected columns generally must be:

```text
GROUP BY column
       OR
Aggregate function
```

---

## WHERE vs HAVING

```text
WHERE  → filters ROWS
GROUP BY → creates GROUPS
HAVING → filters GROUPS
```

Example:

```sql
SELECT country, COUNT(*) AS total
FROM users
WHERE status = 'active'
GROUP BY country
HAVING COUNT(*) >= 10;
```

Execution idea:

```text
FROM
 ↓
WHERE
 ↓
GROUP BY
 ↓
HAVING
 ↓
SELECT
```

### Interview

**Aggregate function:**

> Performs a calculation over multiple rows and returns a summarized result.

**GROUP BY:**

> Groups rows so aggregate functions can calculate results per group.

**WHERE vs HAVING:**

```text
WHERE  → row filtering
HAVING → group filtering
```