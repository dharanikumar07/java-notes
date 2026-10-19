## 1. `get()` vs `load()`

Both are used to fetch an entity using its primary key.

### `get()`

- Fetches the entity from the database if needed.
    
- Returns `null` if the record does not exist.
    
- Traditionally associated with immediate fetching.
    

```
Student s = session.get(Student.class, 1);
```

### `load()` (Legacy Hibernate API)

- Traditionally returns a proxy without immediately fetching the entity data.
    
- Fetches the data when the proxy is initialized, if needed.
    
- If the record does not exist, an exception may occur when the proxy is initialized.
    

```
Student s = session.load(Student.class, 1);
System.out.println(s.getName()); // May trigger SQL
```

### Difference

|`get()`|`load()`|
|---|---|
|Returns entity or `null`|Traditionally returns a proxy|
|Fetches immediately when needed|Can delay fetching|
|Missing row → `null`|Missing row → exception on initialization|

**Remember:** `load()` is a legacy API and its behavior depends on the Hibernate version. In modern Hibernate, prefer `find()` with JPA or `get()` with Hibernate where appropriate.

---

## 2. Level 2 Cache (L2 Cache)

**Definition:** Level 2 cache stores entity data beyond a single Hibernate Session, allowing other sessions to reuse cached data instead of querying the database.

### Cache Levels

- **L1 Cache:** Enabled by default; belongs to one Session.
    
- **L2 Cache:** Shared across Sessions through a configured cache provider.
    

### How it works

1. Session 1 fetches a Student.
    
2. Hibernate checks L1 cache first.
    
3. If not found, it checks L2 cache (when enabled and applicable).
    
4. If neither cache has the data, Hibernate queries the database.
    
5. The entity data may be stored in L2 cache for later sessions.
    

### Flow

```
Session 1 requests Student
          |
          v
       L1 Cache
          |
       Not found
          v
       L2 Cache
          |
       Not found
          v
       Database
          |
          v
      Cache result
```

### Ehcache

**Ehcache** is a caching provider that can be integrated with Hibernate to implement L2 caching.

Basic steps:

1. Add compatible Hibernate/Ehcache dependencies.
    
2. Configure Ehcache.
    
3. Enable Hibernate L2 caching.
    
4. Mark eligible entities as cacheable.
    

Example (JPA-style):

```
@Entity
@Cacheable
@org.hibernate.annotations.Cache(
    usage = CacheConcurrencyStrategy.READ_WRITE
)
class Student {
    @Id
    private int id;

    private String name;
}
```

Exact Ehcache configuration depends on the Hibernate version and whether you use Ehcache 2 or Ehcache 3 with a compatible integration.

### Benefits

- Reduces repeated database queries.
    
- Improves performance for frequently read data.
    
- Can be shared across multiple Sessions in the same configured cache environment.
    

### Important Points

- L1 cache is enabled by default.
    
- L2 cache must be configured and enabled.
    
- L2 cache is not the same as query cache.
    
- Cache consistency depends on the chosen concurrency strategy and configuration.
    

## Interview Quick Revision

|Concept|Remember|
|---|---|
|`get()`|Returns entity or `null`|
|`load()`|Legacy proxy-based loading behavior|
|L1 cache|Session-level cache|
|L2 cache|Shared across Sessions|
|Ehcache|Cache provider|
|Main benefit|Reduces database access|

**One-line interview answer:** Hibernate L2 cache stores entity data across Sessions. When enabled and applicable, Hibernate can reuse cached data rather than querying the database again.