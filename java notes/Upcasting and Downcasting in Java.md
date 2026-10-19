**Casting** means converting a reference from one class type to another.

It is mainly used when **inheritance** is involved.

```java
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
```

### Memory Concept

```text
Animal
   ↑
  Dog
```

**Dog IS-A Animal.**

---

## 1. Upcasting

**Upcasting = Child object → Parent reference**

```java
Animal a = new Dog();
```

Here:

- `new Dog()` → Creates a **Dog object**
    
- `Animal a` → Parent reference points to that Dog object
    

```text
a ─────────→ Dog Object
             ├── Animal part
             └── Dog part
```

### Why is it called Upcasting?

Because we move **up the inheritance hierarchy**.

```text
Dog → Animal
```

### Example

```java
Animal a = new Dog();

a.eat();   // ✅ Allowed
// a.bark();  // ❌ Not allowed
```

**Why can't `a.bark()` be called?**

Because the **reference type is `Animal`**.

The compiler checks what methods are available in `Animal`.

```text
Reference type → Animal
Object type    → Dog
```

### Remember

**Upcasting = Child → Parent**

**Safe and automatic.**

---

## 2. Downcasting

**Downcasting = Parent reference → Child reference**

```java
Animal a = new Dog();

Dog d = (Dog) a;
```

Here:

```text
Animal reference
       ↓
   Dog reference
```

### Why is it called Downcasting?

Because we move **down the inheritance hierarchy**.

```text
Animal → Dog
```

### Example

```java
Animal a = new Dog();

Dog d = (Dog) a;

d.eat();   // ✅
d.bark();  // ✅
```

Now the reference is `Dog`, so we can access Dog-specific methods.

### Remember

**Downcasting = Parent → Child**

**Explicit casting is required.**

---

## 3. Most Important Interview Concept

### Reference Type vs Object Type

```java
Animal a = new Dog();
```

|Concept|Meaning|
|---|---|
|**Reference type**|`Animal`|
|**Object type**|`Dog`|

**Reference type** decides what methods the compiler allows you to call.

**Object type** decides which overridden method runs at runtime.

```java
Animal a = new Dog();
```

```text
Animal → Reference type
Dog    → Actual object type
```

---

## 4. Why Downcasting Can Be Dangerous

```java
Animal a = new Animal();

Dog d = (Dog) a;  // ❌ ClassCastException
```

Why?

Because the actual object is **Animal**, not Dog.

```text
Animal reference
       ↓
Animal Object

Cannot convert actual Animal object into Dog.
```

### Safe Downcasting

```java
Animal a = new Dog();

if (a instanceof Dog) {
    Dog d = (Dog) a;
    d.bark();
}
```

**Remember:** Check with `instanceof` before downcasting when the actual type is uncertain.

---

## Quick Interview Table

| Concept     | Upcasting               | Downcasting                    |
| ----------- | ----------------------- | ------------------------------ |
| **Meaning** | Child → Parent          | Parent → Child                 |
| **Example** | `Animal a = new Dog();` | `Dog d = (Dog) a;`             |
| **Casting** | Automatic               | Explicit                       |
| **Access**  | Parent methods          | Child-specific methods         |
| **Risk**    | Safe                    | Can cause `ClassCastException` |

### ⭐ Interview Answer

> **Upcasting is converting a child class reference into a parent class reference. It is automatic and safe. Downcasting is converting a parent class reference into a child class reference. It requires explicit casting and is safe only when the actual object is an instance of the child class.**

### One-Line Memory

**Upcasting → Child to Parent → Automatic**

**Downcasting → Parent to Child → Explicit**


## important 

```
Before:

a ─────────→ Dog Object
             ├── Animal part
             └── Dog part


After:

a ─────────→ Dog Object
             ├── Animal part
             └── Dog part
             
d ──────────┘
```

**Same object. Two references.**

---

### 3. Why do we need downcasting?

Before downcasting:

```
Animal a = new Dog();

a.bark();  // ❌
```

After downcasting:

```
Dog d = (Dog) a;

d.bark();  // ✅
```

Because now the **reference type is Dog**.

```
Reference type = Dog
        ↓
Can access Dog methods
```
