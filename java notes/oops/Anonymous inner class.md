Anonymous inner class = a class without a name, created and used at the same time.




```

abstract class Animal {

    abstract void sound();
}

class Main {

    public static void main(String[] args) {
        Animal a = new Animal() {
            @Override
            void sound() {
                System.out.println("Dog barks");
            }
        };
        a.sound();
    }
}

```

### What is happening?

```
Animal
  ↑
  │ extends
  │
Anonymous Child Class
(no name)
  │
  └── sound() → Dog barks
```

```
Animal a
   │
   └────────→ Anonymous Object
                  │
                  └── sound()
```

### Why `new Animal()`?

`Animal` is abstract, so you **cannot** do:

```
new Animal();       // ❌
```

But:

```
new Animal() {
    void sound() { ... }
}
```

creates an **unnamed child class of `Animal`** and an object of that child class.

### Simple breakdown

```
Animal a = new Animal() {
    void sound() {
        System.out.println("Dog barks");
    }
};
```

Means:

```
Create a child class of Animal
        ↓
Give it sound() implementation
        ↓
Don't give the class a name
        ↓
Create its object
        ↓
Store reference in a
```