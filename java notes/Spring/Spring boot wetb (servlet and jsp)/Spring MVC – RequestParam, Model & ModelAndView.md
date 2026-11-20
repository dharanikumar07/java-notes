## 1. @RequestParam

`@RequestParam` is used to directly accept request parameters in Controller method arguments.

Instead of manually using `request.getParameter()`, Spring handles parameter extraction and type conversion.

```
@RequestMapping("/add")
public String add(
    @RequestParam("num1") int a,
    @RequestParam("num2") int b
) {
    int result = a + b;
    return "result";
}
```

**Important:**

- `@RequestParam("num1")` – Reads the parameter named num1.
    
- Spring converts the String value into int.
    
- `required = false` – Makes the parameter optional.
    

## 2. Model Object

Model is used to send data from Controller to View (JSP).

```
@RequestMapping("/add")
public String add(
    @RequestParam int num1,
    @RequestParam int num2,
    Model model
) {
    int result = num1 + num2;

    model.addAttribute("result", result);

    return "result";
}
```

**JSP:**

```
<h1>Result: ${result}</h1>
```

**Remember:**

- `addAttribute()` – Adds data to Model.
    
- JSP accesses the data using `${result}`.
    
- Model separates data transfer from view rendering.
    

## 3. Setting Prefix and Suffix

Spring MVC uses ViewResolver to identify the actual view page.

Instead of writing the complete JSP path every time, we configure prefix and suffix.

**application.properties:**

```
spring.mvc.view.prefix=/WEB-INF/views/
spring.mvc.view.suffix=.jsp
```

Example:

Controller returns:

```
return "home";
```

Spring resolves it as:

`/WEB-INF/views/home.jsp`

**Remember:**

- Prefix = Folder location.
    
- Suffix = File extension.
    

## 4. ModelAndView

ModelAndView combines Model (data) and View (page name) into one object.

It is used to send data to the View and specify which View should be displayed.

```
@RequestMapping("/add")
public ModelAndView add(
    @RequestParam int num1,
    @RequestParam int num2
) {

    int result = num1 + num2;

    ModelAndView mv = new ModelAndView();

    mv.addObject("result", result);
    mv.setViewName("result");

    return mv;
}
```

**Important methods:**

- `addObject()` – Adds data.
    
- `setViewName()` – Sets JSP page name.
    
- `return mv` – Returns ModelAndView.
    

**Remember:** ModelAndView = Model + View.

## Quick Comparison

|Concept|Purpose|
|---|---|
|HttpServletRequest|Manually gets request data|
|@RequestParam|Directly accepts request data|
|Model|Sends data to View|
|ModelAndView|Sends data and View together|
|ViewResolver|Finds the actual JSP page|