# linear-macros
Macros used by the **Linear Framework**.

## Macro: nameOf
Returns the name of the object passed to it.
```scala
import com.linearframework.macros.NameOf

def nameOf(expr: Any): String = macro NameOf.nameOf

val steve = Person(name = "Steve", age = 18)

println(nameOf(steve)) // "steve"
println(nameOf(steve.name)) // "name"
println(nameOf(steve.age)) // "age"
```