package WEEK02.DAY05;

public class TempTest {
    public static void main(String[] args) {
        int a = 100;
        int b = 200;


        int temp = b;
        b = a;
        a = temp;

        System.out.println(a);
        System.out.println(b);
    }
}
