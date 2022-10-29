package com.pondit.oop.inheritance;

import com.pondit.oop.Parent;

class Child extends Parent {
    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void setA(int a) {
        this.a = a;
    }
    @Override
    public void printA() {
        System.out.println(a);
    }

    public void print() {
        System.out.println(" ============== Calling With super ================");
        super.printA();
        super.printB();
        super.printC();
        super.printD();

        System.out.println(" ============== Calling With this ================");
        this.printA();
        this.printB();
        this.printC();
        this.printD();

        System.out.println(" ============== Calling With super but direct access to variables ================");
        super.printA();
        System.out.println(super.a);
        // Private cannot be acessed
//        System.out.println(super.b);
        System.out.println(super.c);

        // Package-protected cannot be accessed due to being in different package
//        System.out.println(super.d);
    }
}

public class InheritanceTest {
    public static void main(String[] args) {
        // Upcasting, will work normally, but can't find child methods
        Parent obj = new Child();
        obj.printA();
        obj.printB();
        obj.printC();
        obj.printD();


        System.out.println(" =============== Printing for Child 1 ======================");
        Child c1 = new Child();
        c1.setA(100);
        c1.print();
        System.err.println("Child 1 Hash = "+ c1.hashCode());

        System.out.println(" =============== Printing for Child 2 ======================");
        Child c2 = new Child();
        c2.print();
        System.err.println("Child 2 Hash = "+ c2.hashCode());

        System.out.println(" =============== Printing for Child 3 ======================");
        // Downcasting, will lead to ClassCastException
        Child c3 = (Child) new Parent();
        c3.print();
    }
}
