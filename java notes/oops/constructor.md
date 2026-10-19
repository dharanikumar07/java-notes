
A constructor is a special member of a class that is automatically called when an object is created using `new`.

## What happens behind the scenes?

new
 ↓
Memory allocated in Heap
 ↓
Instance variables get default values
 ↓
Constructor executes
 ↓
Values are initialized
 ↓
Reference is returned
 ↓
s1 points to the object

### Memory

```
STACK                         HEAP
─────                         ────

s1 ───────────────────────→ Student Object
                              │
                              ├── name = "Dharani"
                              └── age  = 25
```


example : 

class Student {

    String name;
    int age;

    Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
}