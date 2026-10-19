### Why JOIN?

Data is usually stored in multiple tables.

```text
users                posts
─────                ─────
id                   id
name                 user_id
                     title
```

Relationship:

```text
users.id  ← PK
    ↑
    │
posts.user_id ← FK
```

---

### INNER JOIN

**Returns ONLY matching rows from both tables.**

```text
        users                 posts
     ┌────────┐            ┌────────┐
     │ 1 ─────┼────────────┼── 1    │
     │ 2 ─────┼────────────┼── 2    │
     │ 3      │            │ 5      │
     │ 4      │            │        │
     └────────┘            └────────┘

              ↓
         INNER JOIN
              ↓
          1 ↔ 1
          2 ↔ 2

        ONLY MATCHES
```

---

### Syntax

```sql
SELECT u.name, p.title
FROM users u
INNER JOIN posts p
    ON u.id = p.user_id;
```

### Remember

```text
JOIN  → connect tables
ON    → tell how they are related
PK    → uniquely identifies row
FK    → references another table
INNER → only matching rows
```

### Interview Definition

> INNER JOIN returns rows where the join condition matches in both tables.

**Most important line:**

```text
INNER JOIN = ONLY MATCHING DATA
```