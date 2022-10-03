package src;

import java.text.DecimalFormat;

class HelloJava {
    public static void main (String [] args) {
        int i = 0;
        int len = args.length;
        while (i < len) {
            System.out.println(args[i++]);
        }
    }
}

class HelloJava2 {
    public static void main (String [] args) {
        byte b = 112 + (byte) 12;
        System.out.println(Byte.class.isInstance(b));
        
        short sh = 500;
        sh *= 5;
        System.out.println(sh);

        long l = 214_748_3649L;
        System.out.println(l);

        double d = 214748364777777.6575;
        System.out.println(d);

        char ch = 'a';
        System.out.println(ch);

        String name = "Siam";
        System.out.println("My name is " + name);

        System.out.println(50 + 30 + " + " + 50 + 30 / 2);

        double twoDecimalPoint = 1000.8376238d;
        
        System.out.println(String.format("%.2f", twoDecimalPoint));
        System.out.printf("%.3f\n", twoDecimalPoint);
        DecimalFormat df = new DecimalFormat("###.##");
        System.out.println(df.format(twoDecimalPoint));

        Integer i = 10;

        int i2 = 20;

        String ageString = "16";
        int ageValue = Integer.valueOf(ageString);
        ageValue = ageValue + i2;

        System.out.println(Integer.sum(i, i2));

        System.out.println(Math.round(123.50));

    }
}
