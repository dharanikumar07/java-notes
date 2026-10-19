`Set` is a **Collection that does not allow duplicate elements**.

```java
Set<Integer> set = new HashSet<>();
```

## Key Properties

- ❌ No duplicates
    
- ✅ Allows `null` depending on implementation
    
- ❌ No index-based access
    
- Order depends on implementation
    
- Used when **uniqueness** is required
    

```text
Set → Unique elements
```

---

## Example

```java
Set<Integer> set = new HashSet<>();

set.add(10);
set.add(20);
set.add(10);
set.add(30);
```

Result:

```text
[10, 20, 30]
```

The second `10` is not added.

---

## Important Methods

```java
set.add(10);          // add element
set.remove(10);       // remove element
set.contains(10);     // check element
set.size();           // number of elements
set.isEmpty();        // check empty
set.clear();          // remove all
```

---

## No Index

Set does **not** support:

```java
set.get(0);    // ❌
```

Because Set is not index-based.

Use iteration:

```java
for (Integer n : set) {
    System.out.println(n);
}
```

---

# Set Implementations

```text
Set
 │
 ├── HashSet
 ├── LinkedHashSet
 └── TreeSet
```

### HashSet

```java
Set<Integer> set = new HashSet<>();
```

- No guaranteed order
    
- No duplicates
    
- Usually fastest for basic operations
    
- Uses hashing
    

### LinkedHashSet

```java
Set<Integer> set = new LinkedHashSet<>();
```

- No duplicates
    
- Maintains **insertion order**
    
- Uses hashing + linked structure
    

### TreeSet

```java
Set<Integer> set = new TreeSet<>();
```

- No duplicates
    
- Maintains **sorted order**
    
- Uses a tree structure
    
- `null` is generally not allowed
    

---

# Set vs List

||List|Set|
|---|---|---|
|Duplicates|✅|❌|
|Order|Yes|Depends on implementation|
|Index|✅|❌|
|`get(index)`|✅|❌|
|Main purpose|Ordered elements|Unique elements|

```text
List → duplicates allowed

Set  → duplicates NOT allowed
```

---

# Important Concept

When adding an element:

```java
set.add(10);
```

`add()` returns a boolean:

```text
true  → element was added
false → element already existed
```

Example:

```java
Set<Integer> set = new HashSet<>();

System.out.println(set.add(10)); // true
System.out.println(set.add(10)); // false
```

This is because the second `10` is a duplicate.

---

# HashSet vs LinkedHashSet vs TreeSet

```text
HashSet
→ unique
→ no guaranteed order
→ hashing

LinkedHashSet
→ unique
→ insertion order
→ hashing + linked structure

TreeSet
→ unique
→ sorted order
→ tree
```

### Remember

> **Set = unique elements.**

> **HashSet = unique + no guaranteed order**

> **LinkedHashSet = unique + insertion order**

> **TreeSet = unique + sorted order**