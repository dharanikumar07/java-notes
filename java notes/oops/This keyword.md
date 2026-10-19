**`this` is a reference to the current object.**

## Why is `this` needed?

Without `this`:

```
class Student {

    private String name;

    Student(String name) {
        name = name;   // ❌ parameter assigned to itself
    }
}
```

The instance variable doesn't get the intended value.

With `this`:

```
Student(String name) {
    this.name = name;  // ✅
}
```

```
this.name = name
     │        │
     │        └── parameter
     │
     └── instance variable
```


## this in constructor

`this()` calls another constructor in the same class

class B
{
    B()
    {
        this(5);    // calls B(int)
    }

    B(int n)
    {
    }
}

this()  → same class constructor
super() → parent class constructor