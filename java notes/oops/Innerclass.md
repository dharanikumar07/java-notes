
## 1. What is an Inner Class?

An **inner class** is a class declared **inside another class**.

```java
class Outer {
    class Inner {
    }
}
```

### Simple meaning

> **Inner class = A class inside another class.**

---

## 2. Why Do We Need It?

Sometimes a class is useful **only inside another class**.

Instead of creating a separate class, we keep it inside the outer class.

```java
class Car {

    class Engine {
        void start() {
            System.out.println("Engine starts");
        }
    }
}
```

Here, `Engine` belongs to the concept of `Car`.

### Remember

> **Inner classes help group related classes together.**

---

## 3. How to Create an Inner Class Object?

For a **non-static inner class**, we need an outer class object first.

```java
class Outer {

    class Inner {
        void display() {
            System.out.println("Inner class");
        }
    }
}

class Main {
    public static void main(String[] args) {

        Outer o = new Outer();

        Outer.Inner i = o.new Inner();

        i.display();
    }
}
```

### Output

```text
Inner class
```

### Important syntax ⭐

```java
Outer.Inner i = o.new Inner();
```

### Meaning

```text
Outer object
     ↓
Create Inner object
     ↓
Access Inner methods
```

---

## 4. Why `o.new Inner()`?

A **non-static inner class belongs to an outer class object**.

So Java needs to know **which outer object** the inner object belongs to.

```java
Outer o = new Outer();
Outer.Inner i = o.new Inner();
```

### Remember

> **Non-static inner class → Outer object required.**

---

## 5. Static Nested Class

A class declared `static` inside another class is called a **static nested class**.

```java
class Outer {

    static class Inner {
        void display() {
            System.out.println("Static nested class");
        }
    }
}
```

### Object creation

```java
Outer.Inner i = new Outer.Inner();
```

### Important difference

|Non-static Inner Class|Static Nested Class|
|---|---|
|Requires outer object|Does not require outer object|
|`o.new Inner()`|`new Outer.Inner()`|
|Can access outer instance members|Cannot directly access outer instance members|

---

## 6. Types of Inner Classes

Java commonly has **4 types**:

```text
Inner Classes
     │
     ├── 1. Member Inner Class
     ├── 2. Static Nested Class
     ├── 3. Local Inner Class
     └── 4. Anonymous Inner Class
```

### 1. Member Inner Class

Declared directly inside a class.

```java
class Outer {
    class Inner {
    }
}
```

### 2. Static Nested Class

Declared using `static`.

```java
class Outer {
    static class Inner {
    }
}
```

### 3. Local Inner Class

Declared inside a method.

```java
class Outer {
    void display() {

        class Inner {
        }

    }
}
```

### 4. Anonymous Inner Class

A class **without a name**, created for one-time use.

```java
interface Animal {
    void sound();
}

class Main {
    public static void main(String[] args) {

        Animal a = new Animal() {
            public void sound() {
                System.out.println("Dog barks");
            }
        };

        a.sound();
    }
}
```

### Output

```text
Dog barks
```

---

## 7. Inner Class Can Access Outer Class Members

```java
class Outer {

    int x = 10;

    class Inner {

        void display() {
            System.out.println(x);
        }
    }
}
```

The inner class can access the outer class's instance variable.

### Remember

> **Inner class can access members of its outer class.**

---

## 8. One-Minute Revision

```text
Inner Class
     ↓
Class inside another class
     ↓
Used to group related classes
     ↓
Non-static inner class needs outer object
     ↓
Static nested class does not need outer object
     ↓
4 types:
Member, Static, Local, Anonymous
```