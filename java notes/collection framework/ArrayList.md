`ArrayList` is a **resizable-array implementation of the `List` interface**.

It is used when we need an **ordered collection that can grow or shrink dynamically**.

---

## 1. Declaration

```java
ArrayList<Integer> list = new ArrayList<>();
```

More commonly, program to the interface:

```java
List<Integer> list = new ArrayList<>();
```

### Why `List` on the left?

`List` is an interface and `ArrayList` is its implementation.

```text
List<Integer>             ArrayList<Integer>
      │                         │
   reference ───────────────→ object
```

This gives flexibility to change the implementation later:

```java
List<Integer> list = new LinkedList<>();
```

---

## 2. Main Properties

### Maintains insertion order

Elements remain in the order in which they were added.

```java
list.add(30);
list.add(10);
list.add(20);
```

```text
[30, 10, 20]
```

ArrayList does not automatically sort elements.

---

### Allows duplicates

```java
list.add(10);
list.add(10);
list.add(20);
```

```text
[10, 10, 20]
```

---

### Allows null

```java
list.add(null);
```

Example:

```text
[10, null, 20]
```

---

### Index-based

Each element has an index starting from `0`.

```text
Index:    0     1     2
          ↓     ↓     ↓
        [10]  [20]  [30]
```

```java
list.get(0);  // 10
list.get(2);  // 30
```

---

### Dynamically resizable

Unlike a normal array:

```java
int[] arr = new int[5];
```

ArrayList can grow when more elements are added.

```text
Array
→ fixed size

ArrayList
→ dynamic size
```

Internally, ArrayList uses an array-like structure and may create a larger internal array when its current capacity is insufficient.

---

### Not synchronized by default

Multiple threads can access an ArrayList, but ArrayList does not automatically provide synchronization for concurrent modifications.

For normal single-threaded use, this is usually not a problem.

---

# 3. Size vs Capacity

These are different concepts.

### Size

Number of elements currently stored.

### Capacity

Amount of storage available internally before ArrayList needs to resize its internal array.

Example:

```text
Capacity = 10
Size     = 4

[10][20][30][40][ ][ ][ ][ ][ ][ ]
```

So:

```text
size     → 4
capacity → 10
```

When the internal capacity becomes insufficient, ArrayList grows its internal storage.

> Do not confuse `size` with internal `capacity`.

---

# 4. Common Methods

## add()

Adds an element at the end.

```java
list.add(10);
list.add(20);
```

Result:

```text
[10, 20]
```

---

## add(index, element)

Inserts an element at a specific index.

```java
list.add(1, 50);
```

Before:

```text
[10, 20, 30]
```

After:

```text
[10, 50, 20, 30]
```

Elements after the insertion point must be shifted.

---

## get(index)

Returns the element at the given index.

```java
int value = list.get(1);
```

```text
[10, 20, 30]
     ↑
   index 1
```

Result:

```text
20
```

---

## set(index, element)

Replaces an existing element.

```java
list.set(1, 100);
```

Before:

```text
[10, 20, 30]
```

After:

```text
[10, 100, 30]
```

`set()` does **not** increase the size.

---

## remove(index)

Removes the element at the specified index.

```java
list.remove(1);
```

Before:

```text
[10, 20, 30]
```

After:

```text
[10, 30]
```

Elements after the removed element shift left.

---

## contains(element)

Checks whether an element exists.

```java
list.contains(20);
```

Returns:

```text
true / false
```

---

## size()

Returns the number of elements.

```java
list.size();
```

Example:

```text
[10, 20, 30]

size() → 3
```

---

## isEmpty()

Checks whether the list contains zero elements.

```java
list.isEmpty();
```

---

## clear()

Removes all elements.

```java
list.clear();
```

```text
Before → [10, 20, 30]

After  → []
```

---

# 5. Internal Working

Conceptually, ArrayList stores elements in an internal array.

```text
ArrayList
    │
    ↓
Internal array

[10][20][30][40][ ][ ][ ]
 ↑   ↑   ↑   ↑
 0   1   2   3
```

When we use:

```java
list.get(2);
```

ArrayList can directly access the element at index `2`.

Therefore:

```text
get(index) → O(1)
```

---

## Adding at the end

```java
list.add(50);
```

Normally, the element is placed at the next available position.

```text
[10][20][30][40][50]
```

Appending is **O(1) amortized**.

Sometimes resizing is required, which takes O(n), but over many additions the average cost is O(1).

---

## Inserting in the middle

```java
list.add(1, 50);
```

Before:

```text
[10][20][30][40]
```

After:

```text
[10][50][20][30][40]
```

Elements have to shift.

Therefore:

```text
add(index, element) → O(n)
```

---

## Removing from the middle

```java
list.remove(1);
```

Before:

```text
[10][20][30][40]
```

After:

```text
[10][30][40]
```

Elements shift left.

Therefore:

```text
remove(index) → O(n)
```

---

# 6. Time Complexity

|Operation|Complexity|Reason|
|---|--:|---|
|`get(index)`|O(1)|Direct index access|
|`set(index, e)`|O(1)|Direct index replacement|
|`add(e)`|O(1) amortized|Usually adds at end|
|`add(index, e)`|O(n)|Elements may need shifting|
|`remove(index)`|O(n)|Elements may need shifting|
|`contains(e)`|O(n)|Searches elements|
|`indexOf(e)`|O(n)|Searches elements|

---

# 7. ArrayList vs Array

|Feature|Array|ArrayList|
|---|---|---|
|Size|Fixed|Dynamic|
|Index-based|Yes|Yes|
|Duplicates|Yes|Yes|
|Maintains order|Yes|Yes|
|Primitive types|Yes|No|
|Objects|Yes|Yes|
|`add()`|No|Yes|
|`remove()`|No|Yes|
|Dynamic resizing|No|Yes|

For collections, wrapper classes are used instead of primitives:

```java
ArrayList<Integer> list;
```

not:

```java
ArrayList<int> list;    // ❌
```

Java uses **autoboxing/unboxing** between `int` and `Integer`.

---

# 8. Interface Hierarchy

```text
Iterable
   │
Collection
   │
List
   │
ArrayList
```

Important relationship:

```text
Collection → general collection operations

List → ordered + index-based collection

ArrayList → implementation of List
```

Therefore:

```java
Collection<Integer> c = new ArrayList<>();
```

is valid.

But:

```java
c.get(0);     // ❌
```

because `get()` belongs to `List`, not `Collection`.

This works:

```java
List<Integer> list = new ArrayList<>();

list.get(0);  // ✅
```

---

# 9. Example

```java
List<Integer> list = new ArrayList<>();

list.add(10);
list.add(20);
list.add(30);

System.out.println(list);       // [10, 20, 30]

System.out.println(list.get(1)); // 20

list.set(1, 100);
System.out.println(list);       // [10, 100, 30]

list.remove(0);
System.out.println(list);       // [100, 30]
```

---

# 10. Remember

```text
ArrayList
    ↓
Resizable array
    ↓
Ordered
    ↓
Index-based
    ↓
Allows duplicates
    ↓
Allows null
    ↓
Fast get/set → O(1)
    ↓
Middle insertion/removal → O(n)
```

### One-line definition

> **ArrayList is a dynamically resizable, ordered, index-based List implementation that provides fast random access using an internal array-like structure.**