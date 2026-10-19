
# PostgreSQL JSON & JSONB

## 1. Introduction to JSON

- **JSON** = JavaScript Object Notation; stores structured data as key-value pairs.
    
- **JSON** preserves the original JSON text, including whitespace and duplicate keys.
    
- **JSONB** stores parsed binary data; better for querying, updating and indexing.
    
- **Best practice:** Use normal columns for frequently accessed, important fields; use JSONB for flexible metadata.
    

|JSON|JSONB|
|---|---|
|Stores text|Stores parsed binary representation|
|Preserves input formatting|Does not preserve formatting|
|Preserves duplicate keys|Keeps the last duplicate key|
|Limited indexing options|Supports GIN indexing|
|Useful for preserving original input|Best for most queryable JSON data|

**Remember:** JSON = preserve input. JSONB = query and manipulate efficiently.

Both JSON and JSONB support basic extraction operators in PostgreSQL.

---

## 2.
---

## 3. Accessing JSONB Data

### `->` — Return JSONB

Use when extracting a key or continuing through nested JSON.

```
SELECT name, metadata->'brand' AS brand
FROM products;
```

Result for Laptop: `"Dell"` — the extracted value remains JSONB, so the string is quoted in its representation.

### `->>` — Return text

Use when you want the extracted value as text.

```
SELECT name, metadata->>'brand' AS brand
FROM products;
```

Result for Laptop: `Dell`

**Remember:** `->` returns JSON/JSONB; `->>` returns text.

### Access nested JSON

```
SELECT
    name,
    metadata->'specs'->>'ram' AS ram
FROM products
WHERE id = 1;
```

Output: Laptop, 16GB.

### Path operators: `#>` and `#>>`

These provide an alternative to chaining arrows.

```
-- Returns JSONB
SELECT metadata #> '{specs,ram}'
FROM products
WHERE id = 1;

-- Returns text
SELECT metadata #>> '{specs,ram}'
FROM products
WHERE id = 1;
```

**Remember:** `#>` = JSONB path; `#>>` = text path.

### Missing keys

```
SELECT metadata->>'warranty'
FROM products
WHERE id = 1;
```

If the key does not exist, PostgreSQL returns `NULL` rather than raising an error.

---

## 4. Filtering and Type Casting

Because `->>` returns text, cast numeric values before performing numeric comparisons.

### Find products costing more than 20,000

```
SELECT name, (metadata->>'price')::integer AS price
FROM products
WHERE (metadata->>'price')::integer > 20000;
```

### Filter using a JSON string

```
SELECT name
FROM products
WHERE metadata->>'brand' = 'Samsung';
```

### Filter a nested value

```
SELECT name
FROM products
WHERE metadata->'specs'->>'ram' = '8GB';
```

**Remember:** `->>` gives text; use `::integer`, `::numeric`, or another suitable type when the operation requires it.

---

## 5. Updating JSONB

### A. Merge operator `||`

Adds or replaces top-level keys.

```
UPDATE products
SET metadata = metadata || '{"price":80000}'
WHERE id = 1
RETURNING *;
```

The price becomes 80000; other top-level keys are preserved.

**Important:** `||` is a shallow merge. It does not recursively merge nested objects.

### B. Delete a JSON key using `-`

```
UPDATE products
SET metadata = metadata - 'brand'
WHERE id = 1
RETURNING *;
```

Removes the top-level `brand` key.

### C. Update nested data using `jsonb_set()`

Syntax:

```
jsonb_set(target, path, new_value)
```

Update only the RAM value:

```
UPDATE products
SET metadata = jsonb_set(
    metadata,
    '{specs,ram}',
    '"32GB"'::jsonb
)
WHERE id = 1
RETURNING *;
```

The `cpu` key remains unchanged.

**Remember:** Use `jsonb_set()` to update a particular nested path without replacing its surrounding object.

### D. Add a new nested key

```
UPDATE products
SET metadata = jsonb_set(
    metadata,
    '{specs,storage}',
    '"1TB"'::jsonb,
    true
)
WHERE id = 1
RETURNING *;
```

The final `true` allows creation of the target key when its parent path exists. `jsonb_set()` does not automatically create missing intermediate parent objects.

### E. Relative update

Increase a product's price by 500 without first fetching the JSON into Java.

```
UPDATE products
SET metadata = jsonb_set(
    metadata,
    '{price}',
    to_jsonb((metadata->>'price')::integer + 500)
)
WHERE id = 1
RETURNING *;
```

Steps:

1. Extract price using `->>`.
    
2. Cast text to integer.
    
3. Add 500.
    
4. Convert the result to JSONB using `to_jsonb()`.
    
5. Update the key using `jsonb_set()`.
    

**Remember:** Read, calculate and update inside one SQL statement to avoid application-side read-modify-write race conditions.

---

## 6. Generated Columns from JSONB

A generated column extracts an important JSON value into a regular database column automatically.

### Create a generated price column

```
ALTER TABLE products
ADD COLUMN price INTEGER
GENERATED ALWAYS AS (
    (metadata->>'price')::integer
) STORED;
```

### Read the generated column

```
SELECT id, name, price
FROM products
WHERE price > 20000;
```

### Update the JSON source

```
UPDATE products
SET metadata = metadata || '{"price":90000}'
WHERE id = 1
RETURNING id, name, price, metadata;
```

The generated `price` column automatically reflects the new JSON price.

### Important rules

- `GENERATED ALWAYS AS` defines the calculation.
    
- `STORED` saves the calculated value on disk.
    
- You cannot manually assign a value to a generated column.
    
- The expression must be immutable and can reference only the current row.
    
- You can index a stored generated column.
    

### Create an index

```
CREATE INDEX idx_products_price
ON products(price);
```

**Remember:** JSONB stores flexible data; a generated column makes important JSON fields easier to query and index.

---

## 7. Indexing JSONB

GIN indexes can speed up supported JSONB containment and key-existence queries.

```
CREATE INDEX idx_products_metadata
ON products USING GIN (metadata);
```

Example containment query:

```
SELECT name
FROM products
WHERE metadata @> '{"brand":"Samsung"}'::jsonb;
```

**Remember:** JSONB + GIN can speed up suitable queries. Indexes have storage and write costs, so use them for real query patterns.

---

## 8. Final Interview Revision

|Concept|Remember|
|---|---|
|JSON|Preserves original JSON text|
|JSONB|Parsed binary representation; usually preferred for querying|
|`->`|Extract JSON/JSONB|
|`->>`|Extract text|
|`#>` / `#>>`|Extract by path|
|`::integer`|Cast extracted text to integer|
|`||`|Merge/replace top-level keys|
|`-`|Remove a top-level key|
|`jsonb_set()`|Update a specific JSON path|
|`to_jsonb()`|Convert a value to JSONB|
|Generated column|Automatically derive a column from JSON|
|GIN index|Helps supported JSONB searches|

### Best practice

**Keep frequently filtered, sorted, constrained or joined business fields in regular columns. Use JSONB for flexible metadata, and consider generated columns or expression indexes when JSON fields become important to query performance.**