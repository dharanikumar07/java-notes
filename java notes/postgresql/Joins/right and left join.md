
# LEFT JOIN

### Meaning

**LEFT JOIN = keep ALL rows from the left table + matching rows from right.**

```text
LEFT TABLE        RIGHT TABLE
   users             posts
     │                 │
     └────── JOIN ─────┘
             ↓
      ALL users kept
             +
       matching posts
             +
        no match → NULL
```

### Syntax

```sql
SELECT *
FROM users u
LEFT JOIN posts p
    ON u.id = p.user_id;
```

### Main use case

**Find records with NO related record:**

```sql
SELECT u.*
FROM users u
LEFT JOIN posts p
    ON u.id = p.user_id
WHERE p.id IS NULL;
```

→ users who have no posts.

### Orphaned posts

```sql
SELECT p.*
FROM posts p
LEFT JOIN users u
    ON p.user_id = u.id
WHERE u.id IS NULL;
```

→ posts with no matching user.

---

# RIGHT JOIN

**RIGHT JOIN = keep ALL rows from the right table + matching rows from left.**

```text
LEFT              RIGHT
users             posts
  │                 │
  └──── JOIN ───────┘
                    ↓
               ALL posts kept
```

Usually can rewrite:

```sql
RIGHT JOIN
```

as:

```sql
LEFT JOIN
```

by swapping table order.

---

# INNER vs LEFT

```text
INNER JOIN
→ ONLY matching rows

LEFT JOIN
→ ALL left rows
→ matching right rows
→ no match = NULL
```

### Interview

**INNER JOIN:**

> Returns only matching rows from both tables.

**LEFT JOIN:**

> Returns all rows from the left table and matching rows from the right table; unmatched right-side columns become NULL.

### Remember

```text
INNER → MATCH ONLY

LEFT  → KEEP LEFT

RIGHT → KEEP RIGHT
```