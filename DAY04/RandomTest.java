package WEEK02.DAY04;

import java.util.Random;

public class RandomTest {
    public static void main(String[] args) {
        Random r = new Random();

        int num = r.nextInt(10);
        int num1 = r.nextInt(10)+1;
        int num2 = r.nextInt(16)+30;
        int num3 = r.nextInt(6)+1;

        System.out.println(num);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);

    }
}
