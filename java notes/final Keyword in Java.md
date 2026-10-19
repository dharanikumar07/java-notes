
The final **keyword** is used to **restrict changes**.

It can be used with **variables, methods, and classes**.

## 1. final Variable → Cannot Reassign

A `final` variable can be assigned **only once**.

```
final int age = 25;

// age = 30;  // ❌ Cannot reassign
```

**Remember:** `final variable = constant reference/value`

> A `final` variable must be initialized before use. It can be initialized at declaration, in a constructor, or in an initializer block.

---

## 2. final Method → Cannot Override

A `final` method **cannot be overridden** by a subclass.

```
class Animal {
    final void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
    // void eat() { }  // ❌ Cannot override
}
```

**Remember:** `final method = No overriding`

> A `final` method can still be **inherited and called** by the subclass.

---

## 3. final Class → Cannot Inherit

A `final` class **cannot be extended** by another class.

```
final class Animal {
    void eat() {
        System.out.println("Eating");
    }
}

// class Dog extends Animal { }  // ❌ Cannot inherit
```

**Remember:** `final class = No inheritance`

---

## Quick Interview Table

|Used With|Meaning|Remember|
|---|---|---|
|**Variable**|Cannot reassign|Constant|
|**Method**|Cannot override|No overriding|
|**Class**|Cannot extend|No inheritance|