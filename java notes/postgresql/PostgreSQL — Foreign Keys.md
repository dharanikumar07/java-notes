## 1. What is a Foreign Key?

A **Foreign Key (FK)** is a column (or combination of columns) that references a primary key or eligible unique key in another table.

**Purpose:** Establish relationships between tables and maintain **referential integrity**.

### Example

```
CREATE TABLE users (
    id BIGINT PRIMARY KEY,
    name VARCHAR(50)
);

CREATE TABLE posts (
    id BIGINT PRIMARY KEY,
    content TEXT,
    user_id BIGINT REFERENCES users(id)
);
```

Here:

- `users.id` → Primary Key (parent table).
    
- `posts.user_id` → Foreign Key (child table).
    
- Each non-NULL `user_id` must match an existing `users.id`.
    

## 2. Diagram

```
USERS (Parent)          POSTS (Child)
┌────┬───────┐          ┌────┬─────────┐
│ id │ name  │          │ id │ user_id │
├────┼───────┤          ├────┼─────────┤
│  1 │ Ravi  │◄─────────│ 10 │    1    │
│  2 │ Priya │◄─────────│ 11 │    1    │
└────┴───────┘          └────┴─────────┘
 Primary Key              Foreign Key
```

One user can have multiple posts (**one-to-many relationship**).

## 3. Referential Integrity

A foreign key constraint ensures that child records do not reference a nonexistent parent.

```
INSERT INTO posts (id, content, user_id)
VALUES (12, 'Hello', 999);
```

If user `999` does not exist, PostgreSQL rejects the insert.

**Important:** A foreign key can contain `NULL` by default. Use `NOT NULL` if every child row must reference a parent.

## 4. ON DELETE Behaviors

Defines what happens to child rows when their referenced parent row is deleted.

|Action|Behavior|
|---|---|
|`RESTRICT`|Prevents deleting a referenced parent|
|`CASCADE`|Deletes matching child rows automatically|
|`SET NULL`|Sets the child FK to `NULL`|
|`SET DEFAULT`|Sets the child FK to its default value|
|`NO ACTION`|Default; checks the constraint, usually at statement end|

### Syntax

```
user_id BIGINT REFERENCES users(id)
    ON DELETE CASCADE
```

Examples:

- `RESTRICT` → A user with posts cannot be deleted.
    
- `CASCADE` → Deleting a user deletes their posts.
    
- `SET NULL` → Posts remain, but `user_id` becomes `NULL`.
    
- `SET DEFAULT` → The default value must still satisfy the FK constraint.
    

**Best practice:** Choose the delete behavior based on the data's meaning. Use `CASCADE` carefully because one deletion can remove many related rows.

## 5. ON UPDATE

Defines what happens when the referenced key changes.

```
user_id BIGINT REFERENCES users(id)
    ON UPDATE CASCADE
```

`CASCADE` updates the matching child foreign keys automatically.

Primary keys are generally best kept stable, so updates to them should be uncommon.

## 6. Foreign Key vs Primary Key

|Primary Key|Foreign Key|
|---|---|
|Identifies a row|References a row|
|Must be unique|Values can repeat|
|Cannot be `NULL`|Can be `NULL` unless `NOT NULL`|
|One PK constraint per table|Multiple FK constraints allowed|

## 7. Important Points

- A foreign key enforces a relationship; the relationship itself is a database design concept.
    
- The referenced column(s) must have a suitable primary key or unique constraint/index.
    
- PostgreSQL does not automatically index the referencing FK column.
    
- Index FK columns when useful for joins, lookups, and parent deletes/updates.
    
- Foreign keys protect data integrity but require additional checks during writes.
    
- A foreign key can reference the same table (self-referencing relationship).
    

## Interview Revision

**Foreign Key** → References a key in another or the same table.

**Referential Integrity** → Prevents references to nonexistent parent rows.

**ON DELETE CASCADE** → Deletes matching child rows automatically.

**ON DELETE RESTRICT** → Prevents deleting a parent that has referencing rows.

**Remember:** Primary Key identifies; Foreign Key connects; Foreign Key Constraint enforces the relationship.