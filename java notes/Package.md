
### 1. What is a Package?

A **package** is used to group related **classes, interfaces, enums, etc.**

It helps in:

- Organizing code
- Avoiding name conflicts
- Providing access control

```
package com.example;
```

Think:

```
Package → folder/namespace for Java classes
```

---

### 2. How to Create a Package

```
package mypack;

public class A {
    public void show() {
        System.out.println("Hello");
    }
}
```

The `package` statement should be at the **top of the Java file**.

---

### 3. How to Use a Class from Another Package

Suppose:

```
package mypack;

public class A {
    public void show() {
        System.out.println("Hello");
    }
}
```

Another class:

```
import mypack.A;

class Test {
    public static void main(String[] args) {
        A obj = new A();
        obj.show();
    }
}
```

`import` is used to access a class from another package.


# 8. Important Interview Points 🔥

- A package is used to **organize related classes**.
- `package` statement defines the package.
- `import` allows us to use classes from another package.
- `java.lang` is automatically imported.
- Packages help avoid **class-name conflicts**.
- Packages provide **access control**.
- `public` classes can be accessed from other packages.
- A `.java` file can have **only one package declaration**.
- `package` declaration should come **before imports and class declarations**.