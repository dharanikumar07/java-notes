
## 1. Scanner

`Scanner` is used to **take input from the user**.

```
Scanner sc = new Scanner(System.in);

int age = sc.nextInt();
String name = sc.next();
```

**Remember:**  
👉 `Scanner` = **Easy + Direct input + Slower**

---

## 2. BufferedReader

`BufferedReader` reads input using a **buffer (temporary memory area)**.

```
BufferedReader br =
    new BufferedReader(new InputStreamReader(System.in));

String name = br.readLine();
int age = Integer.parseInt(br.readLine());
```

**Remember:**  
👉 `BufferedReader` = **Fast + Reads text + Needs conversion**

### Why is BufferedReader faster?

`BufferedReader` **reads a larger amount of data at once into a buffer**, instead of doing many small input operations.

`Scanner` also does **extra processing/parsing** to identify different data types such as `int`, `double`, etc.

```
Scanner
User Input → Scanner → Parse/Process → Variable
                         ↑
                    Extra processing

BufferedReader
User Input → Buffer → readLine() → String
              ↑
       Reads larger chunks
```

### 🧠 Remember

> **BufferedReader is faster because it uses buffering and does less parsing/processing than Scanner.**

---

# Scanner vs BufferedReader

|Scanner|BufferedReader|
|---|---|
|Easy to use|Slightly harder|
|Directly reads different types|Mainly reads `String`|
|`nextInt()`|`Integer.parseInt()`|
|Slower|Faster|
|More parsing/processing|Less processing|
|`java.util.Scanner`|`java.io.BufferedReader`|

**Interview point:**  
👉 **Scanner = convenience**  
👉 **BufferedReader = performance**