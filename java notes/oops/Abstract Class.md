## 1. What is an Abstract Class?

An **abstract class** is a class that is **incomplete** and is designed to be extended by other classes.

It can contain:

- **Abstract methods** → declaration only
    
- **Concrete methods** → complete implementation
    
- Variables, constructors, and other members
    

### Simple meaning

> **Abstract class = Common structure + Common behavior + Rules for child classes**

---

## 2. Why Do We Need It?

Suppose every animal must eat, but each animal eats differently.

Instead of writing the same common structure in every class, we create a parent class.

```java
abstract class Animal {

    abstract void eat();  // Child must implement

    void sleep() {
        System.out.println("Sleeping");
    }
}
```

Here:

- `eat()` → **What every animal must do**
    
- `sleep()` → **Common behavior already implemented**
    

### Remember

> **Abstract class tells WHAT must be done and can also provide HOW to do common behavior.**

---

## 3. Abstract Method

An **abstract method** has **no body**.

```java
abstract void eat();
```

It ends with `;`.

### Example

```java
abstract class Animal {
    abstract void eat();
}
```

The child class must implement it:

```java
class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("Dog eats");
    }
}
```

### Important

> **If a class extends an abstract class, it must implement all abstract methods, unless the child is also abstract.**

---

## 4. Complete Example

```java
abstract class Animal {

    abstract void eat();

    void sleep() {
        System.out.println("Sleeping");
    }
}

class Dog extends Animal {

    @Override
    void eat() {
        System.out.println("Dog eats");
    }
}

class Main {
    public static void main(String[] args) {

        Dog d = new Dog();

        d.eat();
        d.sleep();
    }
}
```

### Output

```text
Dog eats
Sleeping
```

### What happens?

```text
Animal
   │
   ├── abstract eat()  → Child must implement
   └── sleep()         → Already implemented
   │
   ↓
Dog
   └── eat()           → Dog's implementation
```

---

## 5. Can We Create an Object of an Abstract Class?

**No.**

```java
Animal a = new Animal();  // ❌ Compilation error
```

Because the class is incomplete.

But we can create a **reference** of the abstract class:

```java
Animal a = new Dog();  // ✅
```

This is **upcasting**.

### Remember

> **Abstract class cannot be instantiated, but its reference can point to a child object.**

---

## 6. Abstract Class Can Have Constructors

Many beginners think abstract classes cannot have constructors.

That is **wrong**.

```java
abstract class Animal {

    Animal() {
        System.out.println("Animal constructor");
    }

    abstract void eat();
}

class Dog extends Animal {

    Dog() {
        System.out.println("Dog constructor");
    }

    void eat() {
        System.out.println("Dog eats");
    }
}
```

```java
Dog d = new Dog();
```

### Output

```text
Animal constructor
Dog constructor
```

### Why?

When a child object is created, the **parent constructor executes first**.

---

## 7. Abstract Class vs Normal Class

|Abstract Class|Normal Class|
|---|---|
|Declared using `abstract`|No `abstract` keyword|
|Cannot create object directly|Can create object|
|Can contain abstract methods|Cannot contain abstract methods unless class is abstract|
|Can contain concrete methods|Can contain concrete methods|
|Can have constructors|Can have constructors|
|Used as a base class|Can be used directly|

---

## 8. Abstract Class vs Interface

|Abstract Class|Interface|
|---|---|
|Can have constructors|Cannot have constructors|
|Can have instance variables|Mainly used to define a contract|
|Can have abstract + concrete methods|Can have abstract methods and also `default` / `static` methods|
|A class can extend only one class|A class can implement multiple interfaces|
|Used for common structure + behavior|Used mainly for common behavior / contract|

### Simple difference

> **Abstract class = "What you are" + common implementation**  
> **Interface = "What you can do"**

Example:

```text
Animal → Abstract class
        Common animal structure

Runnable → Interface
          Defines running behavior
```

---

## 9. Important Rules

### Rule 1

An abstract class **can contain zero abstract methods**.

```java
abstract class Animal {

    void sleep() {
        System.out.println("Sleeping");
    }
}
```

This is valid.

### Rule 2

An abstract method **cannot be private**.

```java
private abstract void eat();  // ❌
```

Because the child must override it, but private methods are not inherited.

### Rule 3

An abstract method **cannot be final**.

```java
final abstract void eat();  // ❌
```

Because `final` prevents overriding.

### Rule 4

An abstract method **cannot be static**.

```java
static abstract void eat();  // ❌
```

Because static methods belong to the class, not to an object.

---

## 10. One-Minute Revision

```text
Abstract Class
      ↓
Incomplete parent class
      ↓
Cannot create object directly
      ↓
Can contain abstract + concrete methods
      ↓
Abstract method = declaration only
      ↓
Child must implement abstract methods
      ↓
Can have constructors
      ↓
Used for common structure + common behavior
```

### Final Memory Line

> **Abstract class provides a common base for child classes and forces them to implement required behavior.**