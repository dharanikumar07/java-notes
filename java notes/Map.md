`Map` stores data as **key-value pairs**.

```java
Map<Integer, String> map = new HashMap<>();
```

```text
Key    → Value
101    → "Java"
102    → "Spring"
103    → "SQL"
```

### Key Rules

- Each **key must be unique**
    
- Values can be duplicated
    
- One key maps to one value
    
- Map is **not part of the `Collection` interface**
    
- Order depends on the implementation
    

---

## Basic Example

```java
Map<Integer, String> map = new HashMap<>();

map.put(101, "Java");
map.put(102, "Spring");
map.put(101, "Python");
```

Result:

```text
101 → Python
102 → Spring
```

When the same key is used again, the **old value is replaced**.

---

# Important Methods

```java
map.put(key, value);       // add/update
map.get(key);              // get value
map.remove(key);           // remove entry
map.containsKey(key);      // check key
map.containsValue(value);  // check value
map.size();                // number of entries
map.isEmpty();             // check empty
map.clear();               // remove all
```

### Example

```java
map.put(101, "Java");

map.get(101);              // Java
map.containsKey(101);      // true
map.remove(101);
```

---

# Key vs Value

```text
Map
 │
 ├── Key   → unique
 │
 └── Value → duplicates allowed
```

Example:

```text
101 → Java
102 → Java
103 → Java
```

This is valid because **values can duplicate**.

But:

```text
101 → Java
101 → Spring
```

The second `put()` replaces the first value.

---

# Map Implementations

```text
Map
 │
 ├── HashMap
 ├── LinkedHashMap
 ├── TreeMap
 └── Hashtable
```

### HashMap

```java
Map<Integer, String> map = new HashMap<>();
```

- No guaranteed order
    
- Allows one `null` key
    
- Allows multiple `null` values
    
- Fast average `put/get`
    

### LinkedHashMap

```java
Map<Integer, String> map = new LinkedHashMap<>();
```

- Maintains insertion order
    
- Allows `null` key/value
    
- Slightly more overhead than HashMap
    

### TreeMap

```java
Map<Integer, String> map = new TreeMap<>();
```

- Keys are sorted
    
- Uses tree structure
    
- `get/put/remove` → O(log n)
    
- Generally does not allow `null` keys
    

---

# HashMap vs LinkedHashMap vs TreeMap

```text
HashMap
→ key-value
→ no guaranteed order
→ hashing

LinkedHashMap
→ key-value
→ insertion order
→ hashing + linked structure

TreeMap
→ key-value
→ sorted by key
→ tree
```

---

# Iterating a Map

### Keys

```java
for (Integer key : map.keySet()) {
    System.out.println(key);
}
```

### Values

```java
for (String value : map.values()) {
    System.out.println(value);
}
```

### Key + Value

Most common:

```java
for (Map.Entry<Integer, String> entry : map.entrySet()) {
    System.out.println(entry.getKey());
    System.out.println(entry.getValue());
}
```

```text
entrySet()
→ gives each key-value pair
```

---

# Map vs Collection

```text
Collection
   ↓
stores individual elements

Map
   ↓
stores key-value pairs
```

Example:

```text
List
[Java, Spring, SQL]

Set
[Java, Spring, SQL]

Map
101 → Java
102 → Spring
103 → SQL
```

`Map` does **not** extend `Collection`.

---

# Time Complexity — HashMap

Average case:

|Operation|Complexity|
|---|--:|
|`put()`|O(1)|
|`get()`|O(1)|
|`remove()`|O(1)|
|`containsKey()`|O(1)|

Worst-case behavior can differ because of collisions/treeification.

---

# Remember

> **Map = key-value pairs**

> **Key = unique**

> **Value = duplicates allowed**

> **Same key + new value = old value replaced**

> **HashMap = no guaranteed order**

> **LinkedHashMap = insertion order**

> **TreeMap = sorted keys**

> **Map ≠ Collection**