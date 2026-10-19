**JRE = Java Runtime Environment**

The JRE provides everything needed to **run a Java application**, but not everything needed to **develop/compile** one.

conceptually 
JRE
├── JVM
└── Java Class Libraries

### What does JRE contain?

Two major things:

1. **JVM** — executes Java bytecode
2. **Java class libraries** — ready-made Java APIs/classes used by programs

For example, when you write:

`String name = "Dharani";`
`System.out.println(name);`

You're using Java's built-in classes/APIs such as `String` and `System`.

So yes:

More precisely, the JRE provides the **JVM + Java runtime libraries and supporting runtime components**.

conclusion:
JDK is used to develop and run Java applications. JRE provides the runtime environment required to run Java applications. JVM is the component that executes Java bytecode.


![[ChatGPT Image Aug 15, 2026, 11_21_35 AM.png]]