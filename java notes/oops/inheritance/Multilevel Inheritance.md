
When inheritance happens through **multiple levels**, it is called **multilevel inheritance**.

```
Grandparent
     │
     ▼
   Parent
     │
     ▼
    Child
```

Example:

```
class Animal {

    void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {

    void bark() {
        System.out.println("Barking");
    }
}

class Puppy extends Dog {

    void play() {
        System.out.println("Playing");
    }
}
```

Hierarchy:

```
Animal
  │
  ▼
Dog
  │
  ▼
Puppy
```

---

# 6. Important: `extends`

```
class Dog extends Animal
```

means:

```
Dog IS-A Animal
```

```
Dog
  ↓
IS-A
  ↓
Animal
```

Therefore inheritance represents an **IS-A relationship**.

Examples:

```
Dog IS-A Animal
Car IS-A Vehicle
Manager IS-A Employee
```

### Important

Constructors are **not inherited**.

```
Parent constructor
      ↓
NOT inherited by Child
```

However, when a child object is created, the **parent constructor is involved in object initialization** through `super()`.