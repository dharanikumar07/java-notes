
> **Inheritance is a mechanism where one class acquires the properties and behaviors of another class.**

It promotes **code reusability** and represents an **IS-A relationship**.

```
Parent / Superclass
        │
        │ extends
        ▼
Child / Subclass
```

Java uses the `extends` keyword for class inheritance.

## example 

class Animal {

    String name;

    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Dog is barking");
    }
}


# 3. Memory Concept

```
Dog d = new Dog();
```

Conceptually:

```
STACK                         HEAP
─────                         ────

d ───────────────────────→ Dog Object
                             │
                             ├── Animal part
                             │     └── name
                             │
                             └── Dog part
                                   └── bark()
```