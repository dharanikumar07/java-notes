## 1. EXPLAIN

- Shows the execution plan PostgreSQL chooses for a query.
    
- SQL tells **what data** we need; PostgreSQL decides **how to fetch it**.
    
- Helps identify inefficient queries and understand index usage.
    

```
EXPLAIN
SELECT * FROM users WHERE email = 'a@gmail.com';
```

## 2. Reading the Plan

- **Seq Scan:** Reads the table row by row.
    
- **Index Scan:** Uses an index to find matching rows.
    
- **Cost:** Estimated work, NOT execution time.
    
- **Rows:** Estimated number of rows returned.
    
- **Indentation:** Shows the parent-child relationship between plan nodes.
    

## 3. EXPLAIN ANALYZE

- Executes the query and shows the actual execution statistics.
    
- Provides actual time and actual rows, alongside estimates.
    
- Helps compare the estimated plan with actual performance.
    

```
EXPLAIN ANALYZE
SELECT * FROM users WHERE email = 'a@gmail.com';
```

**Warning:** `EXPLAIN ANALYZE` executes the query, including `UPDATE` and `DELETE`. Use a transaction and `ROLLBACK` when appropriate to avoid keeping test changes.

## 4. Index Impact

- Without a suitable index → PostgreSQL may use `Seq Scan`.
    
- With a suitable index → PostgreSQL may use `Index Scan`.
    
- Indexes can improve selective searches, but PostgreSQL chooses the plan based on estimated cost.
    

## 5. Important Points

- `Seq Scan` is not always bad; it can be best for small tables or queries returning many rows.
    
- Lower estimated cost does not guarantee lower actual execution time.
    
- Use `EXPLAIN (ANALYZE, BUFFERS)` for deeper performance analysis.
    
- Don't create indexes blindly; check actual query plans.
    

**Interview line:** `EXPLAIN` shows the estimated execution plan; `EXPLAIN ANALYZE` executes the query and reports actual performance statistics.