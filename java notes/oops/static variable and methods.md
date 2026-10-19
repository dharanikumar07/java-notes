
A static variable belongs to the class rather than individual objects.

```
class Student {

    String name;             // instance variable
    static String college = "ABC College";
}
```

## behind the scene


                    Student CLASS
                         │
                  static college
                         │
                      "ABC"
                         │
                ┌────────┴────────┐
                │                 │
               s1                s2
                │                 │
                ▼                 ▼
         Student Object     Student Object
         name=Dharani       name=Rahul

## # 6. What happens when static variable changes?

```
Student.college = "XYZ College";
```

Because `college` is static, the **single shared value** changes.

```
Student.class
┌──────────────────────────┐
│ college = "XYZ College"  │
└──────────────────────────┘
       ▲              ▲
       │              │
      s1             s2
```

Both objects see:

```
XYZ College
```


STATIC VARIABLE
───────────────
belongs to CLASS
 ↓
one shared copy
 ↓
not one copy per object
 ↓
all objects can access the same variable


## static methods 

A static method belongs to the class, not to a particular object.

```
class Student {

    static void collegeName() {
        System.out.println("ABC College");
    }
}
```

Call it:

```
Student.collegeName();
```

---

## 2. Memory Concept

```
                 Student CLASS
              ┌─────────────────┐
              │                 │
              │ static method   │
              │ collegeName()   │
              │                 │
              └─────────────────┘
                       ▲
                       │
                Student.collegeName()
```

The static method is associated with the **class**, so you don't need:

```
Student s1 = new Student();
s1.collegeName();
```

Instead:

```
Student.collegeName();  // ✅
```

## 4. Important Rule

A static method **cannot directly access instance variables or instance methods**.

```
class Student {

    String name;

    static void display() {
        System.out.println(name);  // ❌
    }
}
```

Why?

```
name
 ↓
belongs to an object

static display()
 ↓
belongs to the class
```
