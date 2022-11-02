package com.pondit.oop.polymorphism;

class Car {
    Car getCar () {
        System.out.println("This can be any car of any body type");
        return this;
    }
}

class Sedan extends Car {

    @Override
    Sedan getCar () {
        System.out.println("This car is of Sedan body type");
        return this;
    }
}

class HatchBack extends Car {

    @Override
    HatchBack getCar () {
        System.out.println("This car is of HatchBack body type");
        return this;
    }
}

class SUV extends Car {

    @Override
    SUV getCar () {
        System.out.println("This car is of SUV body type");
        return new SUV();
    }
}

class Pickup {

    Pickup getCar () {
        System.out.println("This car is of Pickup body type");
        return this;
    }
}

public class CovariantReturnTypeTest {

}
