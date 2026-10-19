An **annotation** is **metadata about your code**.

Think:

> **Annotation = information/instruction about code, not the actual code logic.**

Example:

```
@Override
public void run() {
}
```

`@Override` tells the compiler:

> "I intend to override a method from the parent class."

It doesn't execute the method. It gives **information about the code**.

## short notes
```
ANNOTATION
──────────
• Annotation = metadata about code.
• Starts with @
• Gives information/instructions to compiler, JVM or tools.
• Does not represent normal program logic.

Common:
@Override        → checks overriding
@Deprecated      → marks old API
@SuppressWarnings → suppresses compiler warning
@FunctionalInterface → checks functional interface

• Can create custom annotations using @interface.
```

