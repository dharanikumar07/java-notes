`Optional<T>` is a container that may contain a value or be empty.

```java
Optional<String> name = Optional.of("Java");
```

### Why?

Mainly to handle **possible null values** safely.

```text
Value exists → Optional contains value
No value     → Optional.empty()
```

### Creating

```java
Optional.of(value)          // value must NOT be null
Optional.ofNullable(value)  // value may be null
Optional.empty()            // empty Optional
```

### Important Methods

|Method|Meaning|
|---|---|
|`isPresent()`|value exists?|
|`ifPresent()`|execute if value exists|
|`orElse(x)`|value or default|
|`orElseGet()`|value or lazy default|
|`orElseThrow()`|value or exception|
|`map()`|transform value|

### Example

```java
Optional<String> name = Optional.ofNullable(getName());

String result = name.orElse("Unknown");
```

### `map()`

```java
Optional<String> name = Optional.of("Java");

Optional<Integer> length =
        name.map(String::length);
```

```text
Optional<String>
      ↓ map()
Optional<Integer>
```

### Remember

```text
Optional = VALUE or EMPTY

of()         → cannot be null
ofNullable() → can be null
empty()      → no value
```

### Interview

> **Optional is a container object used to represent the presence or absence of a value and helps reduce direct null handling.**