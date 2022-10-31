## Constructors
- Constructors are special kind of methods, which are called with `new` keyword. When a constructor is called, a new instance of a class is created. Every class has a constructor by default, which does not have any parameter. But if we can override the default constructor and put some functionalities inside it.

- Constructors can be overloaded by putting some parameters inside it. We can refer to any constructor of a class with `this(...)` where, we can have 0 to multiple parameters.

    #### Example:
    ```
  class A {
      // Default no-arg constructor has been overriden
      public A() {
          System.out.println("Printing from 0-arg constructor of class A");
      }
  
      // Example of constructor overloading, with 1 argument
      public A(String message) {
          System.out.println("Printing from 1-arg constructor of class A");
          System.out.println("the parameter value is: " + message);
      }
  }
  ```
- In Parent-Child relationship, if we want to call any constructor of parent class, we call that specific constructor with `super(...)` keyword.

  #### Example:
    ```
  class B extends A {
      // Default no-arg constructor has been overriden
      public B() {
          super();
          System.out.println("Printing from 0-arg constructor of class B");
      }
  
      // Example of constructor overloading, with 1 argument
      public B(String message) {
          super(message);
          System.out.println("Printing from 1-arg constructor of class B");
          System.out.println("the parameter value is: " + message);
      }
  }
  ```
  
- When we call a constructor of a child class, the default constructor of parent class is automatically called. However, we can choose which constructor we want to call from the child class constructor.
- A constructor always returns an instance of the class it belongs to. But we never use the `return` keyword from inside the constructor.