package WEEK02.DAY07;

public class MethodTest {
    public static void main(String[] args) {

        int a = 10;
        int b = 5;
        System.out.println(plus(a,b));

        double c = 3.4;
        double d = 2.7;

        System.out.println(plus(c,d));

    }
    static int plus(int a, int b){
        return a+b;
    }
    static double plus(double a, double b)
    {
        return a+b;
    }
}
