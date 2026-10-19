# ORPHANED DATA

**Orphan = record whose referenced record doesn't exist.**

```text
posts.user_id = 999
        ↓
users.id = 999 ❌
        ↓
   ORPHAN POST
```

### Find orphaned posts

```sql
SELECT p.*
FROM posts p
LEFT JOIN users u
    ON p.user_id = u.id
WHERE u.id IS NULL;
```

### Why LEFT JOIN?

```text
INNER JOIN → orphan disappears
LEFT JOIN  → orphan remains
```

### With friendly output

```sql
COALESCE(u.name, 'Unknown Author')
```

**Remember:**

> If the main record must remain even when related data is missing → `LEFT JOIN`.

---

# UNION

**UNION = combine result sets vertically.**

```text
Table A       Table B
  ↓             ↓
  └──── UNION ──┘
         ↓
     one result
```

### JOIN vs UNION

```text
JOIN
→ side-by-side
→ wider result
→ combines RELATED data

UNION
→ over-under
→ more rows
→ combines SIMILAR result sets
```

### UNION rules

Both queries must have:

```text
1. Same number of columns
2. Compatible data types
3. Same column positions
```

### UNION vs UNION ALL

```text
UNION
→ removes duplicates

UNION ALL
→ keeps duplicates
→ usually faster
```

### Example

```sql
SELECT name FROM current_users
UNION ALL
SELECT name FROM former_users;
```

**Interview:**

> `UNION` combines result sets and removes duplicates.

> `UNION ALL` combines result sets without removing duplicates.

### One-line memory

```text
JOIN  = RELATED DATA → SIDE BY SIDE

UNION = SIMILAR DATA → STACK
```

### Conditions

1. **Same number of columns**
2. **Compatible data types**
3. **Columns matched by position**
4. Column names come from **first SELECT**