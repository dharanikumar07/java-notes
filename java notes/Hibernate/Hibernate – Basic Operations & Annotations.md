## 1. Entity Operations

- `**find()**` → Fetches an entity by primary key.
    
- `**persist()**` → Makes a new entity managed; INSERT occurs during flush/commit.
    
- `**merge()**` → Copies entity state into a managed entity; may INSERT or UPDATE.
    
- `**remove()**` → Marks a managed entity for deletion.
    

```
// Fetch
User user = entityManager.find(User.class, 1);

// Insert new entity
entityManager.persist(newUser);

// Insert or update
User managedUser = entityManager.merge(user);

// Delete
entityManager.remove(managedUser);
```

**Important:** `**merge()**`

- Existing entity → Typically UPDATE if its state differs.
    
- New entity → May INSERT.
    
- Returns the managed entity.
    
- Original object remains detached if it was detached.
    

> `merge()` does not simply reattach the original object; it copies its state to a managed instance.

## 2. Mapping Annotations

- `**@Table**` → Specifies the database table name.
    
- `**@Column**` → Configures column mapping (name, nullable, length, etc.).
    
- `**@Transient**` → Excludes a field from database persistence.
    
- `**@Embeddable**` → Defines a reusable class whose fields can be stored in an entity's table.
    
- `**@Embedded**` → Embeds an `@Embeddable` object's fields into an entity.
    

```
@Embeddable
class Address {
    private String city;
    private String state;
}

@Entity
@Table(name = "users")
class User {
    @Id
    private int id;

    @Column(name = "user_name")
    private String name;

    @Embedded
    private Address address;

    @Transient
    private int ageInMonths;
}
```

## Quick Revision

|Concept|Purpose|
|---|---|
|`find()`|Fetch|
|`persist()`|Insert a new entity|
|`merge()`|Copy state; may INSERT or UPDATE|
|`remove()`|Delete|
|`@Table`|Table mapping|
|`@Column`|Column mapping|
|`@Transient`|Exclude field from persistence|
|`@Embeddable`|Define reusable embedded fields|
|`@Embedded`|Embed fields into an entity|

**Remember:** SQL INSERT, UPDATE, and DELETE statements may execute during flush or transaction commit, not necessarily when the method is called.