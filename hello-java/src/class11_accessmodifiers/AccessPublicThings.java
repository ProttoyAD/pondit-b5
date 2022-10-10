package src.class11_accessmodifiers;

public class AccessPublicThings extends UnderstandingAccessModifiers {
    public static void main(String[] args) {
        UnderstandingAccessModifiers accessModifiers = new UnderstandingAccessModifiers();

        System.out.println(accessModifiers.publicField);
//        System.out.println(accessModifiers.privateField);
        System.out.println(accessModifiers.protectedField);
        System.out.println(accessModifiers.packageProtectedField);
    }

    public void testMethod() {
        UnderstandingAccessModifiers accessModifiers = new UnderstandingAccessModifiers();

        System.out.println(publicField);
//        System.out.println(privateField);
        System.out.println(this.protectedField);
        System.out.println(packageProtectedField);
    }
}