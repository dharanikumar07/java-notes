
An **array of objects** is an array that stores **references to objects** instead of primitive values.

class Student {
    String name;
    int age;
}

Student[] students = new Student[3];

This creates 3 references, NOT 3 Student objects.

Create objects separately:

students[0] = new Student();
students[1] = new Student();
students[2] = new Student();

Access:
students[0].name

Enhanced for:
for (Student s : students) {
    System.out.println(s.name);
}

Remember:
Array creation → creates references
`new Student()` → creates actual object



|Drawback|Meaning|
|---|---|
|**Fixed Size**|Size cannot be changed after creation.|
|**Same Data Type**|Can store only one data type.|
|**Insertion Difficult**|May require shifting elements.|
|**Deletion Difficult**|May require shifting elements.|
|**Memory Wastage**|Unused spaces may remain.|
|**Not Dynamic**|Cannot easily grow or shrink.|

### Remember

**Array = Fixed size + Same type + Shifting required**