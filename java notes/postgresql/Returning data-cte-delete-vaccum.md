
# Modify Data — Part 2

## RETURNING

Returns affected rows immediately after `INSERT`, `UPDATE`, or `DELETE`.

```sql
INSERT ... RETURNING id;
UPDATE ... RETURNING *;
DELETE ... RETURNING *;
```

**Benefit:** avoids a separate SELECT.

### PostgreSQL 18

```text
OLD      → value before modification
NEW      → value after modification
EXCLUDED → attempted INSERT value during UPSERT
```

Example:

```sql
UPDATE users
SET email = 'new@gmail.com'
WHERE id = 301
RETURNING OLD.email, NEW.email;
```

---

## DELETE

Permanently removes rows.

```sql
DELETE FROM users
WHERE id = 301;
```

⚠️ No `WHERE` → can delete **all rows**.

### Safety

```text
SELECT → Verify → DELETE
```

### Soft Delete

Don't remove row:

```sql
UPDATE users
SET deleted_at = CURRENT_TIMESTAMP
WHERE id = 301;
```

```text
Hard delete → row removed
Soft delete → row preserved + marked deleted
```

---

## VACUUM

PostgreSQL uses **MVCC**.

```text
UPDATE
  ↓
new row version created
  ↓
old version becomes dead
  ↓
dead tuples accumulate
  ↓
VACUUM
  ↓
space becomes reusable
```

```sql
VACUUM users;
```

**VACUUM ≠ DELETE**

```text
DELETE  → removes row logically
VACUUM  → cleans old/dead row versions
```

Normal VACUUM generally **doesn't shrink the physical table file**; it makes space reusable.

# VACUUM / ANALYZE / AUTOVACUUM

### VACUUM

Cleans **dead tuples** and makes their space reusable.

```text
UPDATE/DELETE → dead tuples → VACUUM → reusable space
```

### ANALYZE

Updates **table statistics** used by the **query planner**.

```text
ANALYZE → statistics → Query Planner → better plan
```

Planner decides things like:

```text
INDEX scan  OR  TABLE scan
```

### VACUUM ANALYZE

```sql
VACUUM ANALYZE users;
```

→ VACUUM = cleanup  
→ ANALYZE = statistics

### AUTOVACUUM

PostgreSQL automatically performs routine vacuum/analyze maintenance based on activity and configuration.

```text
INSERT / UPDATE / DELETE
          ↓
     AUTOVACUUM
          ↓
   Cleanup + Statistics
```

### Remember

**VACUUM → Clean**

**ANALYZE → Statistics**

**AUTOVACUUM → Automatic maintenance**

