## for memory difference diagram refer notes

## 1. What is a String?

A `String` is a sequence of characters.

String name = "Dharani";

Here:

String → data type/class
name   → reference variable
"Dharani" → String object

Example:

String message = "Hello Java";

# 4. String Pool

Consider:

```
String s1 = "Java";
String s2 = "Java";
```

Java doesn't need to create two separate `"Java"` String objects for these literals.

Conceptually:

```
                 STACK
        ┌────────────────────┐
        │ s1 ────────────────┼────┐
        │ s2 ────────────────┼──┐ │
        └────────────────────┘  │ │
                                │ │
                 STRING POOL     │ │
        ┌───────────────────────┘ │
        │                         │
        │     "Java"              │
        │                         │
        └─────────────────────────┘
```

Both `s1` and `s2` refer to the same pooled String object.

```
s1 ──┐
     ├──→ "Java"
s2 ──┘
```

This helps Java **reuse String literals** instead of unnecessarily creating duplicate objects.

---

# 5. String using `new`

You can also create a String using `new`:

```
String s1 = new String("Java");
String s2 = new String("Java");
```

Conceptually:

```
STACK

s1 ─────────→ String Object 1
s2 ─────────→ String Object 2


HEAP

┌─────────────────┐
│ String Object 1 │
│ "Java"          │
└─────────────────┘

┌─────────────────┐
│ String Object 2 │
│ "Java"          │
└─────────────────┘
```

These are separate String objects.

For normal String creation, prefer:

```
String s = "Java";
```

rather than:

```
String s = new String("Java");
```



## Short Explanation


```
String s1 = new String("Java");
String s2 = new String("Java");
```

There is **one `"Java"` String literal in the String Pool**, and `new` creates **two separate String objects**.

Conceptually:

```
                  STRING POOL
               ┌───────────────┐
               │    "Java"     │  ← 1 pooled object
               └───────────────┘


                     HEAP
               ┌───────────────┐
s1 ──────────→ │ String Object │  ← Object 1
               │    "Java"     │
               └───────────────┘

               ┌───────────────┐
s2 ──────────→ │ String Object │  ← Object 2
               │    "Java"     │
               └───────────────┘
```

### So remember:

```
"Java"                    → 1 String literal in String Pool
new String("Java")        → new object
new String("Java")        → another new object
```

Therefore:

**1 pooled String object + 2 separately created String objects = 3 String objects involved** (assuming `"Java"` wasn't already in the pool).

The key point is that **both `new String("Java")` calls use the same pooled `"Java"` literal, but each `new` creates its own separate String object.**

## normal string 

```
String s1 = "Java";
String s2 = "Java";
```

### Memory

```
STACK

s1 ──┐
     ├────→ "Java"
s2 ──┘      ↑
            │
       String Pool
```

So:

- **1 String Pool object** → `"Java"`
- `s1` and `s2` → both reference the **same object**
- No separate `new String()` objects are created.

### Compare

```
"Java"                    → 1 pooled object
new String("Java")        → 1 pooled literal + 1 new object
```

For:

```
String s1 = new String("Java");
String s2 = new String("Java");
```

```
String Pool → 1 "Java" object
Heap        → 2 new String objects
```

### 🧠 Easy rule

> **Normal literal → one shared Pool object**  
> **`new` → creates a new String object each time**


## strings notes

immutable - > unchanged -> java strings are immutable 
mutable -> changed -> (string buffer and string builder )