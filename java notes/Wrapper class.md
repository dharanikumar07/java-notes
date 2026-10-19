## 1. What is a Wrapper Class?

A **wrapper class** is a class that represents a primitive data type as an object.

Java has 8 primitive data types:

```text
byte    → Byte
short   → Short
int     → Integer
long    → Long
float   → Float
double  → Double
char    → Character
boolean → Boolean
```

### Simple meaning

```text
Primitive → int
Wrapper   → Integer
```

`int` stores a value directly.

`Integer` is an object that represents an integer value.

---

## 2. Why Do We Need Wrapper Classes?

Java has primitive types and objects.

Sometimes Java APIs require an **object**, not a primitive.

For example, a collection such as `ArrayList` stores objects.

```java
ArrayList<Integer> numbers = new ArrayList<>();
```

Here, `Integer` is used because `ArrayList` cannot directly store primitive `int` values.

```text
int       → Primitive
Integer   → Object
```

### Remember

> **Wrapper classes allow primitive values to be used where objects are required.**

---

## 3. Primitive vs Wrapper

|Primitive|Wrapper|
|---|---|
|`int`|`Integer`|
|Stores a value|Represents a value as an object|
|Not an object|Object|
|Cannot call methods directly|Can call methods|
|Used for efficient basic operations|Used when object behavior is needed|
|Default value of an instance field is `0`|Default value of an instance field is `null`|

### Example

```java
int a = 10;

Integer b = 10;
```

```text
a → 10

b → Integer object
       value = 10
```

**Important:** `Integer b = 10;` looks like a primitive assignment, but Java automatically converts the primitive into an `Integer` object.

---

## 4. Autoboxing

**Autoboxing** means automatically converting a primitive into its wrapper object.

```java
int a = 10;

Integer b = a;
```

Java automatically converts:

```text
int → Integer
```

### Example

```java
public class Main {
    public static void main(String[] args) {

        int a = 10;

        Integer b = a;  // Autoboxing

        System.out.println(b);
    }
}
```

### Output

```text
10
```

### What happens?

```text
a = 10
   ↓
Java converts int to Integer
   ↓
b = Integer object containing 10
```

You can also write:

```java
Integer b = Integer.valueOf(10);
```

This is the explicit form of boxing.

---

## 5. Unboxing

**Unboxing** means automatically converting a wrapper object into its primitive value.

```java
Integer a = 10;

int b = a;
```

Java automatically converts:

```text
Integer → int
```

### Example

```java
public class Main {
    public static void main(String[] args) {

        Integer a = 10;

        int b = a;  // Unboxing

        System.out.println(b);
    }
}
```

### Output

```text
10
```

### What happens?

```text
a → Integer object containing 10
                ↓
         Extract the int value
                ↓
b = 10
```

The explicit form is:

```java
int b = a.intValue();
```

---

## 6. Autoboxing + Unboxing Together

```java
public class Main {
    public static void main(String[] args) {

        int a = 10;

        Integer b = a;  // Autoboxing

        int c = b;      // Unboxing

        System.out.println(c);
    }
}
```

### Output

```text
10
```

### Flow

```text
int a = 10
    ↓
Autoboxing
    ↓
Integer b
    ↓
Unboxing
    ↓
int c = 10
```

---

## 7. Wrapper Classes Have Methods

Primitive types do not have methods.

```java
int a = 10;

// a.someMethod(); ❌
```

But wrapper classes have methods.

```java
Integer a = 10;

System.out.println(a.intValue());
```

### Output

```text
10
```

### Useful Integer Methods

|Method|Meaning|Example|
|---|---|---|
|`intValue()`|Converts Integer to int|`a.intValue()`|
|`parseInt()`|Converts String to primitive int|`Integer.parseInt("123")`|
|`valueOf()`|Converts String or int to Integer object|`Integer.valueOf("123")`|
|`compare()`|Compares two int values|`Integer.compare(10, 20)`|
|`max()`|Returns larger value|`Integer.max(10, 20)`|
|`min()`|Returns smaller value|`Integer.min(10, 20)`|

---

## 8. String to int vs String to Integer

This is important for Java DSA.

### `parseInt()`

Returns a **primitive int**.

```java
int a = Integer.parseInt("123");
```

```text
String → int
```

### `valueOf()`

Returns an **Integer object**.

```java
Integer b = Integer.valueOf("123");
```

```text
String → Integer
```

### Example

```java
public class Main {
    public static void main(String[] args) {

        String s = "123";

        int a = Integer.parseInt(s);

        Integer b = Integer.valueOf(s);

        System.out.println(a);
        System.out.println(b);
    }
}
```

### Output

```text
123
123
```

### Remember

> `parseInt()` → primitive `int`  
> `valueOf()` → `Integer` object

---

## 9. Important: Wrapper Objects Can Be null

A primitive cannot store `null`.

```java
int a = null;  // ❌ Compilation error
```

But a wrapper reference can be `null`.

```java
Integer a = null;  // ✅
```

### Why?

```text
int
 ↓
Must contain an integer value

Integer
 ↓
Can refer to an Integer object
 ↓
Can also refer to no object → null
```

### Example

```java
Integer a = null;

System.out.println(a);
```

### Output

```text
null
```

---

## 10. Important Danger: NullPointerException

If Java tries to unbox a `null` wrapper, it throws a `NullPointerException`.

```java
Integer a = null;

int b = a;  // ❌
```

### Why?

Java tries to convert:

```text
Integer → int
```

But there is no actual integer value because `a` is `null`.

### Remember

> **Unboxing null causes NullPointerException.**

---

## 11. Wrapper Classes and Method Overloading

This is directly connected to the question you recently learned.

```java
class Message {

    public void printMessage(int message) {
        System.out.println("Primitive");
    }

    public void printMessage(Integer message) {
        System.out.println("Wrapper");
    }
}
```

### Example

```java
Message ob = new Message();

ob.printMessage(5);
```

### Output

```text
Primitive
```

### Why?

`5` is an `int`.

Java prefers the exact match:

```text
int → int       ✅
int → Integer   🔄 Autoboxing
```

So the primitive method is selected.

### But:

```java
Integer a = 5;

ob.printMessage(a);
```

### Output

```text
Wrapper
```

Because the argument is already an `Integer`.

---

## 12. Wrapper Classes in Collections

This is one of the most important uses in DSA.

```java
ArrayList<Integer> numbers = new ArrayList<>();
```

You cannot write:

```java
ArrayList<int> numbers = new ArrayList<>();  // ❌
```

Because generics require reference types.

### Example

```java
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Integer> numbers = new ArrayList<>();

        numbers.add(10);
        numbers.add(20);

        System.out.println(numbers);
    }
}
```

### Output

```text
[10, 20]
```

### What happens?

```java
numbers.add(10);
```

Java automatically boxes:

```text
int 10 → Integer object
```

So the collection stores an `Integer` object.

### DSA Connection

You will commonly see:

```java
ArrayList<Integer>
HashMap<Integer, Integer>
HashSet<Integer>
PriorityQueue<Integer>
Stack<Integer>
```

These use wrapper classes because Java generics work with objects.

---

## 13. Wrapper Classes and Memory

A primitive variable stores a value directly.

```java
int a = 10;
```

A wrapper variable is a reference to an object.

```java
Integer b = 10;
```

Conceptually:

```text
Primitive:

a ─────→ 10


Wrapper:

b ─────→ Integer Object
             value = 10
```

### Important

Do not think:

> "Integer is just another name for int."

That is incorrect.

**`Integer` is a class. `int` is a primitive type.**

---

## 14. Integer Caching

Java may reuse certain `Integer` objects for commonly used values.

```java
Integer a = 100;
Integer b = 100;

System.out.println(a == b);
```

### Output

```text
true
```

Why? Java commonly caches Integer values from **-128 to 127**.

But:

```java
Integer a = 1000;
Integer b = 1000;

System.out.println(a == b);
```

The result is **not guaranteed to be `true`**.

### Important Rule

> **Use `.equals()` to compare wrapper values, not `==`.**

```java
Integer a = 1000;
Integer b = 1000;

System.out.println(a.equals(b));
```

### Output

```text
true
```

### Why?

|Operator|Meaning|
|---|---|
|`==`|Compares primitive values or object references|
|`.equals()`|Compares object values when implemented appropriately|

---

## 15. Wrapper Classes Are Immutable

Wrapper objects cannot be changed after creation.

```java
Integer a = 10;

a = 20;
```

This does **not** change the old Integer object.

Instead:

```text
a → Integer object containing 10

After a = 20:

a → Integer object containing 20
```

The reference now points to another value.

### Remember

> **Wrapper classes are immutable.**

---

## 16. Common Mistakes

### Mistake 1: Thinking Integer and int are the same

```java
int a = 10;
Integer b = 10;
```

They are different types.

---

### Mistake 2: Thinking wrapper objects cannot be null

```java
Integer a = null;
```

This is valid.

But:

```java
int b = a;
```

causes `NullPointerException`.

---

### Mistake 3: Using `==` to compare Integer values

```java
Integer a = 1000;
Integer b = 1000;

System.out.println(a == b);
```

Do not rely on this for value comparison.

Use:

```java
a.equals(b)
```

---

### Mistake 4: Thinking ArrayList can store int directly

```java
ArrayList<int> list;  // ❌
```

Use:

```java
ArrayList<Integer> list;  // ✅
```

---

## 17. Interview Questions

### Q1. What is a wrapper class?

A class that represents a primitive data type as an object.

### Q2. Why do we need wrapper classes?

To use primitive values where objects are required, especially in collections and generics.

### Q3. What is autoboxing?

Automatic conversion of a primitive into its wrapper object.

```java
int a = 10;
Integer b = a;
```

### Q4. What is unboxing?

Automatic conversion of a wrapper object into its primitive value.

```java
Integer a = 10;
int b = a;
```

### Q5. What is the difference between `parseInt()` and `valueOf()`?

```text
parseInt() → int
valueOf()  → Integer
```

### Q6. Can Integer be null?

Yes. `Integer` is an object reference, so it can be `null`.

### Q7. What happens when you unbox null?

`NullPointerException`.

### Q8. Why is `ArrayList<Integer>` used instead of `ArrayList<int>`?

Because Java generics require reference types, not primitives.

### Q9. How do you compare Integer values?

Use `.equals()`.

### Q10. Are wrapper classes mutable?

No. Wrapper classes are immutable.

---

## 18. One-Minute Revision

```text
Wrapper Class
     ↓
Primitive represented as an object
     ↓
int → Integer
     ↓
Autoboxing: int → Integer
     ↓
Unboxing: Integer → int
     ↓
Used in collections and generics
     ↓
Can store null
     ↓
Unboxing null → NullPointerException
     ↓
Use equals() for wrapper value comparison
```