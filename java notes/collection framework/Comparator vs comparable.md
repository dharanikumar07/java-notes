Both are used to **sort objects**.

## Comparable

- Package: `java.lang`
    
- Method: `compareTo()`
    
- Defines **natural/default ordering**
    
- Sorting logic is written **inside the class**
    

```java
class Student implements Comparable<Student> {

    int age;

    Student(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student s) {
        return this.age - s.age;
    }
}
```

```java
Collections.sort(list);
```

```text
Student
   ↓
implements Comparable
   ↓
compareTo()
   ↓
natural sorting
```

---

## Comparator

- Package: `java.util`
    
- Method: `compare()`
    
- Defines **custom sorting**
    
- Sorting logic is written **outside the class**
    
- Allows multiple different sorting strategies
    

```java
Comparator<Student> byAge =
    (s1, s2) -> s1.age - s2.age;

list.sort(byAge);
```

Another sorting:

```java
Comparator<Student> byName =
    (s1, s2) -> s1.name.compareTo(s2.name);

list.sort(byName);
```

```text
Student
   │
   ├── Comparator → byAge
   ├── Comparator → byName
   └── Comparator → byMarks
```

---

## Difference

|Comparable|Comparator|
|---|---|
|`compareTo()`|`compare()`|
|`java.lang`|`java.util`|
|Natural/default order|Custom order|
|Logic inside class|Logic outside class|
|Usually one natural ordering|Multiple sorting strategies|

## Remember

```text
Comparable  → "How should I naturally sort myself?"
Comparator  → "How should I sort these objects this time?"
```