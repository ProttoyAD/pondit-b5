## Polymorphism
Polymorphism is of 2 Types

### 1. Method overloading / Static Polymorphism / Static Binding / Compile time polymorphism

#### Conditions

- Method overloading always works inside same class
- Multiple methods can have same name, but with different parameter counts or different parameter types of same parameter count
- We don't care about the return type in such case
- Constructors can also be overloaded

### 2. Method Overriding / Dynamic Polymorphism / Dynamic Binding / Runtime polymorphism
#### Conditions
- Always works in a parent child relationship
- Child class must have exactly the same method definition, including same type of parameter, same return type and same number of parameters
- If the parameter type or count is changed, it is no longer the example of overriding, rather it becomes an example of overloading
