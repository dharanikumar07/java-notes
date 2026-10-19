
## quick reference 

private   → class
default   → package
protected → package + subclass
public    → everywhere

## Access Modifier Table ⭐⭐⭐

|Access Location|`private`|`default`|`protected`|`public`|
|---|---|---|---|---|
|**Same class**|✅ Yes|✅ Yes|✅ Yes|✅ Yes|
|**Same package – non-subclass**|❌ No|✅ Yes|✅ Yes|✅ Yes|
|**Same package – subclass**|❌ No|✅ Yes|✅ Yes|✅ Yes|
|**Different package – subclass**|❌ No|❌ No|✅ Yes*|✅ Yes|
|**Different package – non-subclass**|❌ No|❌ No|❌ No|✅ Yes|


---

# Easy Way to Remember 🧠

### `private`

> **Only inside the same class**

```
private → CLASS
```

---

### `default`

> **Only inside the same package**

```
default → PACKAGE
```

---

### `protected`

> **Same package + subclass in different package**

```
protected → PACKAGE + SUBCLASS
```

---

### `public`

> **Accessible from everywhere**

```
public → EVERYWHERE
```