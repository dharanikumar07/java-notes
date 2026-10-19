## What is Stream?

Stream = pipeline used to **process collection data**.

```text
SOURCE → INTERMEDIATE → TERMINAL
```

- Does not store data
    
- Does not modify source automatically
    
- Stream can be consumed only once
    
- Intermediate operations are lazy
    

---

## Important Operations

|Method|Type|Meaning|
|---|---|---|
|`filter()`|Intermediate|SELECT|
|`map()`|Intermediate|TRANSFORM|
|`sorted()`|Intermediate|SORT|
|`forEach()`|Terminal|PERFORM ACTION|
|`reduce()`|Terminal|COMBINE|

---

## filter()

Select elements based on condition.

```java
list.stream()
    .filter(n -> n > 10)
    .forEach(System.out::println);
```

```text
filter = SELECT
```

Uses `Predicate<T>` → `T → boolean`

---

## map()

Transforms each element.

```java
list.stream()
    .map(n -> n * 2)
    .forEach(System.out::println);
```

```text
map = TRANSFORM
```

Can change type:

```text
Stream<String>
     ↓ map()
Stream<Integer>
```

Uses `Function<T,R>` → `T → R`

---

## sorted()

Sorts elements.

```java
list.stream()
    .sorted()
    .forEach(System.out::println);
```

Descending:

```java
.sorted(Comparator.reverseOrder())
```

```text
sorted = SORT
```

---

## forEach()

Terminal operation.

Performs an action on each element.

```java
list.stream()
    .forEach(System.out::println);
```

```text
forEach = CONSUME / ACTION
```

Uses `Consumer<T>` → `T → void`

---

## reduce()

Combines multiple elements into one result.

```java
int sum = list.stream()
    .reduce(0, (a, b) -> a + b);
```

```text
Many values → One value
```

`0` = identity

`(a,b) -> a+b` = accumulator

---

## Common Pipelines

### Filter + ForEach

```java
list.stream()
    .filter(n -> n > 10)
    .forEach(System.out::println);
```

### Filter + Map

```java
list.stream()
    .filter(n -> n > 10)
    .map(n -> n * 2)
    .forEach(System.out::println);
```

### Filter + Map + Sorted

```java
list.stream()
    .filter(n -> n > 10)
    .map(n -> n * 2)
    .sorted()
    .forEach(System.out::println);
```

### Filter + Reduce

```java
int sum = list.stream()
    .filter(n -> n > 10)
    .reduce(0, (a,b) -> a+b);
```

---

## Mental Model

```text
filter  → SELECT
map     → TRANSFORM
sorted  → SORT
forEach → ACTION
reduce  → COMBINE
```

```text
Collection
    ↓
 stream()
    ↓
filter()
    ↓
map()
    ↓
sorted()
    ↓
forEach() / reduce()
```

### Remember

**Intermediate → returns Stream → lazy**

**Terminal → final operation → starts processing**