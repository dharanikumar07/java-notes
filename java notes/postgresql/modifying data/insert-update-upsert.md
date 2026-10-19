
# Modify Data

## INSERT

Add new rows.

```sql
INSERT INTO users (name, email)
VALUES ('Arun', 'arun@gmail.com');
```

**Bulk insert** → multiple rows in one request → fewer network round trips.

```sql
INSERT INTO users (name, email)
VALUES
('Arun','a@gmail.com'),
('Priya','p@gmail.com');
```

**DEFAULT** → PostgreSQL fills the value automatically.

**RETURNING** → get inserted row/data immediately.

```sql
INSERT ...
RETURNING id;
```

---

## UPDATE

Modify existing rows.

```sql
UPDATE users
SET email = 'new@gmail.com'
WHERE id = 301;
```

⚠️ **No WHERE → ALL rows can be updated.**

### Golden Rule

```text
SELECT → Verify → UPDATE
```

PostgreSQL:

```sql
UPDATE ...
RETURNING *;
```

---

## UPSERT

**INSERT + UPDATE**

Used when record may already exist.

```sql
INSERT INTO preferences (user_id, theme)
VALUES (301, 'dark')
ON CONFLICT (user_id)
DO UPDATE
SET theme = EXCLUDED.theme;
```

```text
Try INSERT
    ↓
Conflict?
 ┌──┴──┐
NO    YES
 ↓      ↓
INSERT UPDATE
```

### ON CONFLICT options

```text
DO UPDATE   → update existing row
DO NOTHING  → ignore conflict
EXCLUDED    → value attempted in INSERT
```

### Remember

```text
INSERT → Add
UPDATE → Change
UPSERT → Add OR Change
```

**Interview:** UPSERT avoids the separate SELECT → INSERT/UPDATE flow and handles the conflict in one database operation.

# FULL PICTURE

```
                 MODIFY DATA
                      │
        ┌─────────────┼─────────────┐
        ↓             ↓             ↓
      INSERT        UPDATE        UPSERT
        │             │             │
     New row      Change row     Insert or Update
        │             │             │
        ↓             ↓             ↓
    RETURNING      RETURNING    ON CONFLICT
                                  │
                           ┌──────┼──────┐
                           ↓      ↓      ↓
                       UPDATE  NOTHING  CALCULATE
```

