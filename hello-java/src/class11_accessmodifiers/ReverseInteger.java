package src.class11_accessmodifiers;

public class ReverseInteger {

    public static void main(String[] args) {
        System.out.println(reverse(1534236469));
        System.out.println(reverse(-123));
    }

    public static int reverse(int x) {
        StringBuffer sbuff = new StringBuffer(Integer.toString(x));
        String sign = "";
        if (sbuff.charAt(0) == '-') {
            sign = "-";
            sbuff.replace(0, 1, "");
        }
        String revStr = sign + sbuff.reverse().toString();
        if (Long.parseLong(revStr) > Integer.MAX_VALUE || Long.parseLong(revStr) < Integer.MIN_VALUE) return 0;
        return Integer.parseInt(revStr);
    }
}
