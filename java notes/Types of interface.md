
# 1. Normal Interface

### Meaning

An interface having **two or more abstract methods**.

```
interface Animal {
    void eat();
    void sleep();
}
```

A class implementing it must provide both:

```
class Dog implements Animal {

    public void eat() {
        System.out.println("Eating");
    }

    public void sleep() {
        System.out.println("Sleeping");
    }
}
```

**Idea:** Multiple behaviors/contract methods.

---

# 2. Functional Interface / SAM

**SAM = Single Abstract Method**

It has **exactly ONE abstract method**.

```
@FunctionalInterface
interface Calculator {
    int add(int a, int b);
}
```

Because there is only one abstract method, Java can use a **lambda expression**:

```
Calculator c = (a, b) -> a + b;
```

Important:

```
1 abstract method → Functional Interface
```

It **can still have** `default` and `static` methods because those aren't abstract methods.

```
@FunctionalInterface
interface Test {
    void run();              // abstract

    default void show() { } // not abstract
    static void print() { } // not abstract
}
```

So the rule is **exactly one abstract method**, not "only one method."

---

# 3. Marker Interface

A marker interface has **ZERO methods**.

It simply **marks/tags** a class.

```
interface Printable {
}
```

Then:

```
class Student implements Printable {
}
```

The interface is basically saying:

> "This class belongs to/has this special property."

A famous Java example is:

```
Serializable
```

It is used to indicate that an object can be serialized.

---

# 📝 VERY SHORT NOTES

```
TYPES OF INTERFACE
──────────────────

1. Normal Interface
→ 2 or more abstract methods.
→ Defines multiple behaviors.

2. Functional Interface / SAM
→ Exactly 1 abstract method.
→ Can use Lambda expression.
→ @FunctionalInterface

3. Marker Interface
→ 0 methods.
→ Used only to mark/tag a class.
→ Example: Serializable
```

