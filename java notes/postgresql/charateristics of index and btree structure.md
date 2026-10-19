## 1. Characteristics of an Index

An **index** is a separate data structure that helps PostgreSQL find table rows faster.

### Three Main Characteristics

1. **Separate structure** — stored separately from the table.
    
2. **Indexed values** — stores indexed column values and row-location information.
    
3. **Pointers** — connects index entries to the corresponding table rows.
    

### Diagram

```
       INDEX (name)
     Sorted B-tree
           |
     Arun → Row 2
     Bala → Row 4
     Ravi → Row 1
           |
           ▼
      USERS TABLE
   ┌────┬────────┐
   │ id │ name   │
   ├────┼────────┤
   │  1 │ Ravi   │
   │  2 │ Arun   │
   │  3 │ Priya  │
   │  4 │ Bala   │
   └────┴────────┘
```

_Conceptual diagram: index entries point to table rows; the table itself is not automatically sorted._

### How an Index Works

```
CREATE INDEX idx_users_name ON users(name);

SELECT * FROM users WHERE name = 'Ravi';
```

1. PostgreSQL searches the index.
    
2. It locates the matching entry.
    
3. It follows the row reference to retrieve the table data.
    

### Index Trade-off

- **Reads:** Can become faster.
    
- **Writes:** `INSERT`, `UPDATE`, and `DELETE` may require index maintenance.
    
- **Storage:** Indexes consume additional disk space.
    

**Rule:** Create indexes where they benefit important queries, but avoid unnecessary indexes.

---

## 2. What Is a B-tree?

**B-tree (Balanced Tree)** is PostgreSQL's default index structure.

It organizes index entries in a balanced tree, allowing PostgreSQL to find values without scanning every index entry.

### Diagram

```
             [50]           ← Root
            /    \
       [20, 35]  [70, 90]   ← Internal nodes
        /   \     /   \
      [10] [25] [60] [80]   ← Leaf nodes
```

_Simplified illustration of a balanced search tree._

### How Searching Works

To find `60`:

```
Start at root [50]
       ↓
60 > 50 → Move right
       ↓
Follow the correct child
       ↓
Find 60 in a leaf entry
```

The tree helps reduce the number of entries examined compared with a full scan.

### Why Is B-tree Efficient?

- Balanced structure keeps search paths short.
    
- Supports exact-value lookups.
    
- Supports range queries and ordered retrieval.
    
- Works well for many common database queries.
    

---

## 3. When Is B-tree Useful?

|Query type|Example|
|---|---|
|Equality|`WHERE email = 'a@gmail.com'`|
|Range|`WHERE id BETWEEN 1 AND 10`|
|Greater/less than|`WHERE price > 100`|
|Sorting|`ORDER BY created_at`|
|Joins|Matching indexed key columns|

PostgreSQL can also use B-tree indexes to enforce **PRIMARY KEY** and **UNIQUE** constraints.

---

## 4. B-tree and LIKE

### Prefix search

```
WHERE name LIKE 'Dar%'
```

A B-tree index may support this search, depending on the database collation and operator class.

For some non-`C` collations, use:

```
CREATE INDEX idx_name_pattern
ON users (name text_pattern_ops);
```

For `VARCHAR`, use `varchar_pattern_ops`.

### Leading wildcard

```
WHERE name LIKE '%ani'
```

A normal B-tree generally cannot efficiently support this pattern because the beginning of the value is unknown.

For substring searches, PostgreSQL's `pg_trgm` extension with a suitable index is one alternative.

---

## 5. Important Interview Points

- An index is a separate structure from the table.
    
- A B-tree stores ordered index entries in a balanced tree.
    
- Index entries include indexed values and references to table rows.
    
- B-tree supports equality, range queries, and sorting.
    
- Primary keys and unique constraints use unique indexes in PostgreSQL.
    
- Indexes improve some reads but add storage and write overhead.
    
- PostgreSQL decides whether an index scan is worthwhile; an index is not used for every query.
    

**Remember:** An index helps locate rows; a B-tree organizes index entries to make searching efficient.


## Handwritten revision diagram

This is the simplest diagram to remember and reproduce in your notebook.

### Index → Table row

B-tree Index

Sorted indexed values

Arun · Bala · Ravi

Find the entry and follow its row reference

Main Table

Retrieve the matching row

One-line interview answer: A B-tree index is a balanced, ordered data structure that helps PostgreSQL find rows efficiently for equality, range, and sorting operations.