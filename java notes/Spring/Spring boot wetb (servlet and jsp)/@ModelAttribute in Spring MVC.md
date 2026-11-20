## 1. Need for @ModelAttribute

`@ModelAttribute` is used to bind form data to a Java object automatically.

**Problem without @ModelAttribute:**

Normally, we need to accept each form field separately using `@RequestParam` and manually create an object.

**Solution:**

`@ModelAttribute` automatically:

- Creates a Java object.
    
- Takes form values from the request.
    
- Maps form fields to matching object properties.
    
- Makes the object available to the Controller.
    

**Remember:** @ModelAttribute = Form Data → Java Object.

## 2. Using @ModelAttribute

**Step 1: Create Student class**

```
public class Student {

    private int id;
    private String name;

    // Getters and Setters
}
```

**Step 2: Create JSP form**

```
<form action="addStudent" method="post">

    <input type="text" name="id">
    <input type="text" name="name">

    <button type="submit">Submit</button>

</form>
```

**Step 3: Controller**

```
@Controller
public class StudentController {

    @PostMapping("/addStudent")
    public String addStudent(
        @ModelAttribute Student student,
        Model model
    ) {

        model.addAttribute("student", student);

        return "result";
    }
}
```

**Step 4: Display in result.jsp**

```
<h2>Student Details</h2>

<p>ID: ${student.id}</p>
<p>Name: ${student.name}</p>
```

## 3. How @ModelAttribute Works

1. Spring creates a Student object.
    
2. Reads form parameters from the request.
    
3. Matches parameter names with Java properties.
    
4. Calls setters to populate the object.
    
5. Passes the populated object to the Controller.
    

**Flow:**

JSP Form → HTTP Request → @ModelAttribute → Student Object → Controller → JSP Result

## 4. Important Points

- Form field names should match Java property names.
    
- Java class should have accessible setters for binding.
    
- No need to manually create the object.
    
- Can be used with `@RequestParam` for individual parameters.
    
- Can also be used to add common model attributes using a method-level `@ModelAttribute`.
    

**Remember:** Always check field names, getters/setters, data types and URL mapping first.

## Interview Questions

1. What is @ModelAttribute?
    
2. Why do we use @ModelAttribute?
    
3. Difference between @RequestParam and @ModelAttribute?
    
4. How does Spring bind form data to a Java object?
    
5. Can @ModelAttribute be used at method level?