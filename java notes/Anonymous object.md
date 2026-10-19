
> **An anonymous object is an object created without storing its reference in a variable.**

Normally:

```
Student s = new Student();
s.display();
```

Here `s` is a reference variable.

With an anonymous object:

```
new Student().display();
```

## 2. Memory

### Normal object

```
Student s = new Student();
```

```
STACK                    HEAP
─────                    ────

s ───────────────────→ Student Object
                         │
                         └── data
```

The reference `s` allows us to access the object again.

---

### Anonymous object

```
new Student().display();
```

```
STACK                    HEAP
─────                    ────

                         Student Object
                              │
                              └── data
```

No reference variable points to the object.

The object is created → `display()` is called → if no other reference exists, it becomes **eligible for garbage collection**.