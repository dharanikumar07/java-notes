Method reference is a **shorter form of lambda expression** when an existing method can be used directly.

### Syntax

```java
ClassName::methodName
```

### Example

Lambda:

```java
list.forEach(x -> System.out.println(x));
```

Method reference:

```java
list.forEach(System.out::println);
```

### 4 Types

```text
1. Static method       → ClassName::staticMethod
2. Instance method     → object::method
3. Instance method     → ClassName::instanceMethod
4. Constructor         → ClassName::new
```

### Remember

```text
Lambda:
x -> System.out.println(x)

Method Reference:
System.out::println
```

**Interview:**

> Method reference is a shorthand syntax for a lambda expression when an existing method already matches the required functional interface.