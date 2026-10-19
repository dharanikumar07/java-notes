
## 1. What is Lambda?

A **Lambda Expression** is a short way to provide the implementation of a **functional interface's single abstract method**.

### Syntax

```
(parameters) -> { body }
```

Example:

```
interface Animal {
    void sound();
}

Animal a = () -> System.out.println("Dog barks");

a.sound();
```

Instead of writing:

```
Animal a = new Animal() {
    @Override
    public void sound() {
        System.out.println("Dog barks");
    }
};
```

Lambda gives the implementation in a shorter form:

```
Animal a = () -> System.out.println("Dog barks");
```

---

# 2. Functional Interface

Lambda works with a **functional interface**.

A functional interface must have **exactly one abstract method**.

```
@FunctionalInterface
interface Animal {
    void sound();
}
```

Common functional interfaces:

|Interface|Method|Purpose|
|---|---|---|
|`Predicate<T>`|`test()`|returns `boolean`|
|`Function<T,R>`|`apply()`|converts one value to another|
|`Consumer<T>`|`accept()`|consumes value, no return|
|`Supplier<T>`|`get()`|supplies a value|

---

# 3. How Lambda Works

Consider:

```
Animal a = () -> System.out.println("Dog barks");

a.sound();
```

Think:

```
Animal
   │
   └── sound()  ← abstract method

Lambda
   │
   └── provides implementation
          ↓
   System.out.println("Dog barks");
```

So:

> **Lambda does not create the interface itself. It provides the implementation of its single abstract method.**

---

# 4. Memory Allocation

This is the important part.

For:

```
Animal a = () -> System.out.println("Dog barks");
```

Conceptually:

```
STACK                         HEAP / JVM
─────                         ──────────

a ───────────────────────→  Lambda object/instance
                              │
                              └── sound()
                                   ↓
                              Dog barks
```

### Important

The exact JVM implementation is more complicated than a normal `new` object.

You should remember:

> **Lambda is implemented by the JVM using `invokedynamic` and a generated lambda implementation at runtime.**

# 🧠 Final Memory Diagram

```
Animal a = () -> System.out.println("Dog");

STACK                         JVM / HEAP
─────                         ──────────

a ───────────────────────→  Lambda instance
                              │
                              │ implements Animal
                              │
                              └── sound()
                                   │
                                   ↓
                              "Dog"
```

### Execution

```
a.sound()
   ↓
Lambda's sound() implementation
   ↓
System.out.println("Dog");
```

---

# ⭐ Remember These 5 Points

```
1. Lambda = short way to provide method implementation.

2. Lambda works with Functional Interface.

3. Functional Interface = exactly ONE abstract method.

4. Lambda is NOT simply an anonymous class.
   JVM implements it using invokedynamic.

5. Reference variable points to the runtime Lambda instance.
```

