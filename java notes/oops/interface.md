
## 1. What is an Interface?

An **interface is a contract**.

It tells a class:

> "If you implement me, you must provide these behaviors."

### Basic syntax

```
interface InterfaceName {
    // methods
    // constants
}

class MyClass implements InterfaceName {
    // implementation
}
```


# 2. `implements` vs `extends`

For an interface:

```
class Dog implements Animal
```

For a class:

```
class Dog extends Animal
```

So remember:

```
Class → extends → Class
Class → implements → Interface
Interface → extends → Interface
```

An interface **does not get implemented with `extends` by a class**.


# 3. Interface Variables

Variables declared inside an interface are automatically:

```
public static final
```


# Abstract Class vs Interface

This is the important interview/DSA/OOP comparison.

|Feature|Abstract Class|Interface|
|---|---|---|
|Keyword|`abstract class`|`interface`|
|Inheritance|`extends`|`implements`|
|Multiple inheritance|❌ No|✅ Multiple interfaces|
|Constructor|✅ Yes|❌ No|
|Instance variables|✅ Yes|❌ Normal instance variables|
|`static final` constants|Can have|Interface variables are automatically `public static final`|
|Abstract methods|✅ Yes|✅ Yes|
|Normal methods|✅ Yes|✅ `default`/`static` methods can have implementation|
|Object creation|❌ Directly no|❌ Directly no|
|Access modifiers|`private`, `protected`, `public`|Interface abstract methods are generally `public`|
|State|Can maintain object state|Mainly defines a contract|


# 🧠 Interview Revision — 10 Lines

```
1. Interface = contract
2. Class uses implements
3. Interface uses extends with another interface
4. Interface cannot be instantiated
5. Interface variables = public static final
6. Interface abstract methods are public
7. Interface can have default methods
8. Interface can have static methods
9. A class can implement multiple interfaces
10. Abstract class = shared base; Interface = capability/contract
```

### Abstract class = "What you ARE"
### Interface = "What you CAN DO"


## "abstract class is present in the memory but interface does not present in memory"