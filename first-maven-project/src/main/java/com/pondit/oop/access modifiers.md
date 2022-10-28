## Access Modifiers
In java, we have 3 access modifier keywords. If we don't use any of them for a class or an instance variable or a method, it still has an access modifier, which we call package-protected. Which means, we can use that variable or class or method only within that specific package and not from outside.

Let's see the access modifiers and their accessibility levels.

| Access Modifier               | within class	 | within package	 | outside package by subclass only | Outdide package, by any non-subclass |
|-------------------------------|---------------|-----------------|----------------------------------|--------------------------------------|
| Private                       | Yes           | No              | No                               | No                                   |
| Default / Package-protected   | Yes           | Yes             | No                               | No                                   |
 | Protected                     | Yes           | Yes             | Yes                              | No                                   |
 | Public                        | Yes           | Yes             | Yes                              | Yes                                  |

#### Access modifiers - where we can apply
We can apply access modifiers for any class, any method, and any non-local scoped variable.

