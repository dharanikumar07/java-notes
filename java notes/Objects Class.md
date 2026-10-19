
## 1. What is Object Class?

**`Object` is the root (parent) class of all Java classes.**

It belongs to the `java.lang` package, which is automatically imported.

```java
class Dog {
}
```

Conceptually:

```text
Object
  ↑
Animal
  ↑
Dog
```

Even if you do not explicitly write `extends Object`, every normal Java class **directly or indirectly inherits from `Object`**.

```java
class Dog extends Object {
}
```

**Remember:** `Object` → Parent of every Java class.

---

## 2. Why is Object Class Important?

Because every class inherits from `Object`, every object gets common methods such as:

- `toString()`
    
- `equals()`
    
- `hashCode()`
    
- `getClass()`
    

These methods are useful for **printing, comparing, and identifying objects**.

---

## 3. Important Object Class Methods

|Method|Purpose|Remember|
|---|---|---|
|**`toString()`**|Returns a string representation of an object|Object → String|
|**`equals()`**|Checks whether two objects are equal|Compare|
|**`hashCode()`**|Returns a hash code for an object|Hash|
|**`getClass()`**|Returns the runtime class of an object|Class information|

### `toString()`

Used to get a **string representation** of an object.

```java
class Dog {
    String name = "Tommy";
}

Dog d = new Dog();

System.out.println(d.toString());
```

If you do not override `toString()`, it generally returns a string containing the **class name and hash-code-related information**.

**Remember:** `toString()` → Object → String.

---

### `equals()`

Used to compare two objects for **logical equality**.

```java
String s1 = new String("Java");
String s2 = new String("Java");

System.out.println(s1.equals(s2));  // true
```

For `String`, `equals()` is overridden to compare **content**.

**Remember:** `equals()` → Logical comparison.

> Important: The default `Object.equals()` compares object references (identity), unless the class overrides it.

---

### `hashCode()`

Returns an **integer hash code** for an object.

```java
Dog d = new Dog();

System.out.println(d.hashCode());
```

It is mainly used by **hash-based collections**, such as `HashMap` and `HashSet`.

**Remember:** `hashCode()` → Hash-based collections.

---

### `getClass()`

Returns the **runtime class** of an object.

```java
Dog d = new Dog();

System.out.println(d.getClass());
```

**Remember:** `getClass()` → Runtime class information.

---

## ⭐ Interview Answer

> **`Object` is the root class of Java. Every class directly or indirectly inherits from it. It provides common methods such as `toString()`, `equals()`, `hashCode()`, and `getClass()`, which are used for object representation, comparison, hashing, and runtime class information.**

### Quick Memory

**Object = Root class + Common methods + Parent of all classes**

## interview questions

# equals() and hashCode()

### equals()

Checks whether two objects are **logically equal**.

```java
s1.equals(s2) → true
```

**Meaning:** Both objects are considered equal.

### hashCode()

Returns an **integer hash code** for an object.

### Important Rule

If two objects are equal:

```java
s1.equals(s2) → true
```

Then their hash codes **must be the same**:

```java
s1.hashCode() == s2.hashCode() → true
```

But:

```text
Same hash code ≠ Always equal
```

**Remember:** Equal objects → Same hash code.

## Important  
### Same hash code ≠ Always equal

**Meaning:** Two objects can have the **same hash code**, but their values can still be **different**.

```
Object 1 → hashCode = 100
Object 2 → hashCode = 100
```

But:

```
Object 1 values = 10
Object 2 values = 20
```

So:

```
obj1.equals(obj2) → false
```

### Why?

Because **hashCode() is only a number**. Different objects can sometimes get the same number. This is called a **hash collision**.