

## 1. Why do we use them?

`String` is **immutable**.

If we repeatedly modify a `String`, new `String` objects are created.

```
String s = "Java";
s = s + " Developer";
```

### Memory

```
HEAP
│
├── STRING POOL
│     │
│     └── "Java"                 ← old String object
│
└── NORMAL HEAP
      │
      └── "Java Developer"       ← new String object
                              ↑
                              │
                              s
```

The old `"Java"` object is **not modified**.

For frequent modifications:

```
StringBuilder → Mutable + Faster + Not Thread-safe
StringBuffer  → Mutable + Synchronized + Thread-safe
```

---

# 2. StringBuilder

`StringBuilder` is a **mutable sequence of characters**.

```
StringBuilder sb = new StringBuilder("Java");
```

## Memory

```
                    JVM MEMORY
                         │
             ┌───────────┴───────────┐
             │                       │
           STACK                    HEAP
             │                       │
             │              ┌────────┴────────┐
             │              │                 │
             │         STRING POOL       NORMAL HEAP
             │              │                 │
             │              │          ┌──────┴──────┐
             │              │          │             │
             │           "Java"    StringBuilder   ...
             │              │          object
             │              │             │
       sb ───┼──────────────┼─────────────┘
             │                            │
             │                            └── "Java"
```

### Important

```
"Java"               → String Pool
StringBuilder object → Normal Heap
sb                   → Reference to StringBuilder object
```

> The String Pool does **not** contain the `StringBuilder` object.

---

# 3. StringBuilder — append()

```
StringBuilder sb = new StringBuilder("Java");

sb.append(" Developer");
```

## Before `append()`

```
STACK                         HEAP
─────                         ────

sb ────────────────────────→ StringBuilder
                               │
                               └── "Java"
```

## After `append()`

```
STACK                         HEAP
─────                         ────

sb ────────────────────────→ StringBuilder
                               │
                               └── "Java Developer"
```

### What happened?

The **same StringBuilder object** is modified.

```
sb.append(" Developer")
          │
          ▼
StringBuilder's internal character storage
          │
          ▼
"Java" + " Developer"
          │
          ▼
"Java Developer"
```

### String Pool

```
STRING POOL

"Java"
  │
  └── UNCHANGED
```

`append()` does **not** modify the String Pool object.

> The pooled `"Java"` is a `String`, and `String` is immutable.

---

# 4. StringBuilder — Thread

`StringBuilder` is **not synchronized**.

```
                 StringBuilder
                      │
             ┌────────┴────────┐
             │                 │
          Thread 1          Thread 2
             │                 │
             └───────┬─────────┘
                     │
              No built-in
              synchronization
```

### Properties

```
StringBuilder
      │
      ├── Mutable
      ├── Not synchronized
      ├── Not thread-safe
      └── Generally faster
```

### Use

Use `StringBuilder` when **thread synchronization is not required**.

---

# 5. StringBuffer

`StringBuffer` is also a **mutable sequence of characters**.

```
StringBuffer sb = new StringBuffer("Java");
```

## Memory

```
                    JVM MEMORY
                         │
             ┌───────────┴───────────┐
             │                       │
           STACK                    HEAP
             │                       │
             │              ┌────────┴────────┐
             │              │                 │
             │         STRING POOL       NORMAL HEAP
             │              │                 │
             │              │          ┌──────┴──────┐
             │              │          │             │
             │           "Java"    StringBuffer    ...
             │              │          object
             │              │             │
       sb ───┼──────────────┼─────────────┘
             │                            │
             │                            └── "Java"
```

### Important

```
"Java"               → String Pool
StringBuffer object  → Normal Heap
sb                   → Reference to StringBuffer object
```

> The String Pool does **not** contain the `StringBuffer` object.

---

# 6. StringBuffer — append()

```
StringBuffer sb = new StringBuffer("Java");

sb.append(" Developer");
```

### same like the string builder it works 

---

# 7. StringBuffer — Thread

`StringBuffer` methods are **synchronized**.

```
                    StringBuffer
                         │
                ┌────────┴────────┐
                │                 │
             Thread 1          Thread 2
                │                 │
                ▼                 │
          ┌─────────────┐         │
          │ synchronized│         │
          │  operation  │         │
          └──────┬──────┘         │
                 │                 │
                 └────────┬────────┘
                          ▼
                       Thread 2
```

Only one thread can execute a synchronized operation on the same object at a time.

### Properties

```
StringBuffer
      │
      ├── Mutable
      ├── Synchronized
      ├── Thread-safe
      └── Generally slower than StringBuilder
```

---

# 8. StringBuilder vs StringBuffer

|Feature|StringBuilder|StringBuffer|
|---|---|---|
|Mutable|✅|✅|
|Object location|Normal Heap|Normal Heap|
|String Pool object|❌|❌|
|`append()`|Modifies same object|Modifies same object|
|Synchronized|❌|✅|
|Thread-safe|❌|✅|
|Performance|Generally faster|Generally slower|
|Use|No synchronization required|Thread-safe shared mutable data|

---

# 9. Final Memory Concept

```
                         JVM MEMORY
                              │
               ┌──────────────┴──────────────┐
               │                             │
             STACK                          HEAP
               │                             │
               │                 ┌───────────┴───────────┐
               │                 │                       │
               │            STRING POOL             NORMAL HEAP
               │                 │                       │
               │                 │              ┌────────┴────────┐
               │                 │              │                 │
               │              "Java"      StringBuilder     StringBuffer
               │                 │            object            object
               │                 │               │                 │
               │                 │               │                 │
      sb ──────┼─────────────────┼───────────────┘                 │
               │                                                 │
               │                              sb ─────────────────┘
```

---

# ⭐ Final Remember

### String

```
String
  ↓
Immutable
  ↓
Modification
  ↓
New String object
```

### StringBuilder

```
StringBuilder
  ↓
Mutable
  ↓
Same object is modified
  ↓
Not synchronized
  ↓
Not thread-safe
  ↓
Generally faster
```

### StringBuffer

```
StringBuffer
  ↓
Mutable
  ↓
Same object is modified
  ↓
Synchronized
  ↓
Thread-safe
  ↓
Generally slower
```

## ⭐ Most Important Memory Rule

> **String Pool stores `String` objects, not `StringBuilder` or `StringBuffer` objects.**

```
"Java"
   ↓
String Pool
   ↓
Immutable String


StringBuilder
   ↓
Normal Heap
   ↓
Mutable


StringBuffer
   ↓
Normal Heap
   ↓
Mutable + Synchronized
```