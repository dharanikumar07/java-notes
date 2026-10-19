## 1. Where Should We Add Indexes?

Choose indexes based on **how the application queries the data**, not just on the table structure.

Consider indexing columns frequently used in:

- `WHERE` — filtering rows.
    
- `JOIN` — matching rows between tables.
    
- `ORDER BY` — sorting results.
    
- `GROUP BY` — grouping rows.
    

### Example

```
SELECT *
FROM orders
WHERE customer_id = 10;
```

```
CREATE INDEX idx_orders_customer
ON orders(customer_id);
```

## 2. Indexing Best Practices

- Prioritize frequent and performance-critical queries.
    
- B-tree indexes work well for equality and range searches.
    
- Do not blindly index every column.
    
- Indexes consume storage and add write overhead.
    
- Use `EXPLAIN (ANALYZE, BUFFERS)` to investigate query performance.
    
- Review indexes as data and query patterns change.
    

**Remember:** Index according to query patterns, not just columns.

# PostgreSQL — Composite Indexes

## 1. What Is a Composite Index?

A **composite index** is a single index created on two or more columns.

```
CREATE INDEX idx_orders_country_status
ON orders(country, status);
```

The index is ordered by `country` first, then by `status` within each country.

## 2. Leftmost Prefix Rule

For an index on `(country, status, email)`:

|Query filters|Index usefulness|
|---|---|
|`country`|Yes|
|`country, status`|Yes|
|`country, status, email`|Yes|
|`status` only|Generally less efficient; PostgreSQL 18 may use skip scan|
|`status, email` only|Generally less efficient; skip scan may help in some cases|
|`country, email`|Can use `country`; `email` may not efficiently narrow the index scan|

**Rule:** Design the index around the columns your important queries filter and sort by.

## 3. Equality and Range

For a query filtering by country and then a date range:

```
SELECT *
FROM orders
WHERE country = 'US'
  AND created_at >= DATE '2026-01-01';
```

A suitable index is:

```
CREATE INDEX idx_orders_country_date
ON orders(country, created_at);
```

Equality on `country` comes first, followed by the range on `created_at`.

## 4. Single-Column vs Composite Index

- Single-column index: indexes one column.
    
- Composite index: indexes multiple columns in a defined order.
    
- A composite index may serve several query patterns, but it is not always better than separate indexes.
    
- PostgreSQL can combine separate indexes when appropriate.
    

## 5. Important Points

- Column order matters.
    
- Query predicate order does not determine index order.
    
- PostgreSQL 18 supports B-tree skip scans in suitable cases.
    
- An index does not guarantee PostgreSQL will use it.
    

**Remember:** Equality columns commonly come first, followed by range columns, but always design for actual query patterns.