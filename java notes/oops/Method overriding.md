
**Method overriding** happens when a **child class provides its own implementation of a method that is already defined in the parent class.**

```
class A {
    void show() {
        System.out.println("A show");
    }
}

class B extends A {
    @Override
    void show() {
        System.out.println("B show");
    }
}
```

Here, `B` **overrides** the `show()` method of `A`.

---

### 2. Why do we use Method Overriding?

To achieve **runtime polymorphism**.

The child class can give its **own behavior** for a method inherited from the parent.