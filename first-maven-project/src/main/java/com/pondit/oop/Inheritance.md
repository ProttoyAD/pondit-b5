## Inheritance
When a class extends another class, we call it inheritance.

## Why is it really necessary?
Inheritance mainly focuses on reusing. Also, another purpose is bringing on an order of hierarchy. 

- One class can inherit one parent class only
- Child class can access only public and protected properties and methods of a parent class
- ```this``` and ```super``` keywords are considered as reference variables in inheritance context
- ```this``` refers to the property or method of child class, where ```super``` refers to the properties and definitions of parent class
- ```this``` and ```super``` cannot be used inside ``static`` context
- Upcasting is possible in inheritance scenario, but downcasting is not.
- If parent class is abstract, and has abstract method, and child class is not an abstract class, child class must implement those abstract methods.
- One class can implement multiple interfaces
- One interface can extend multiple interfaces