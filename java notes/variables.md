
-> A **variable** is a named memory location used to **store a value** that can be used and changed while a program is running.

creating variable 

dataType variableName = value;

Java Variables
│
├── Local Variable
│   └── Inside method/block
│
├── Instance Variable
│   └── Inside class, outside method
│   └── Belongs to object
│
└── Static Variable
    └── Uses static
    └── Belongs to class


### 1. Local Variable

Declared **inside a method, constructor, or block**.

void display() {
    int age = 25;
}

- Belongs to the method/block.
- Can be used only within its scope.
- Must be initialized before use.

---

### 2. Instance Variable

Declared **inside a class but outside methods**, without `static`.

class Employee {
    String name;
    int age;
}

- Belongs to an **object**.
- Every object gets its own copy.
- Gets a default value if not explicitly initialized.

---

### 3. Static Variable

Declared using the `static` keyword.

class Employee {
    static String company = "ABC";
}

- Belongs to the **class**, not individual objects.
- Only one shared copy exists for the class.
- Shared by all objects.

