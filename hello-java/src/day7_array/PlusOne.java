package src.day7_array;

import java.math.BigInteger;

public class PlusOne {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("7,2,8,5,0,9,1,2,9,5,3,6,6,7,3,2,8,4,3,7,9,5,7,7,4,7,4,9,4,7,0,1,1,1,7,4,0,0,6".replaceAll(",", ""));
        bi = bi.add(BigInteger.ONE);
        System.out.println(bi.toString().toCharArray());
    }
}
