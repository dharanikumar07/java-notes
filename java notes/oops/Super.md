
`super` is a keyword used to refer to the immediate parent class. In constructors, `super()` is used to call the parent class constructor. It must be the first statement of the constructor. If no constructor call is explicitly written, Java implicitly inserts `super()`.

### 2. Your example

When we create:

```
B obj = new B(5);
```

Java enters:

```
B(int n1)
```

Inside it:

```
super(n1);
```

calls:

```
A(int n1)
```

So the constructor flow is:

```
B(5)
 ↓
super(5)
 ↓
A(5)
 ↓
return to B(5)
```

Output:

```
A constructor with: 5
B constructor with: 5
```

---

## 3. Most Important Rule ⭐

Every constructor must ultimately call a parent constructor.

If you don't explicitly write `super()` or `this()`, Java automatically inserts:

## 4. `super()` must be the first statement

```
B() {
    super();
    System.out.println("B");
}
```