package WEEK03.DAY10;

import java.util.Scanner;

public class Q1003 {
    static int ZERO_COUNT = 0;
    static int ONE_COUNT = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t= sc.nextInt();
        for(int i = 0 ; i < t ; i++){
            fibonacci(sc.nextInt());
            System.out.println(ZERO_COUNT+" "+ONE_COUNT);
            ZERO_COUNT = 0;
            ONE_COUNT = 0;
        }

    }

    static int fibonacci(int n) {
        if (n == 0) {
            ZERO_COUNT++;
            return 0;
        } else if (n == 1) {
            ONE_COUNT++;
            return 1;
        } else {
            return fibonacci(n-1) + fibonacci(n-2);
        }
    }
}
