package WEEK03.DAY09;

import java.math.BigInteger;
import java.util.Scanner;

public class Q1247 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(int t = 0 ; t < 3 ; t++) {
            int n = sc.nextInt();
            BigInteger b = BigInteger.ZERO;
            for (int i = 0; i < n; i++) {
                b = b.add(sc.nextBigInteger());
            }

            if(b.compareTo(BigInteger.ZERO) > 0){
                System.out.println("+");
            }else if(b.compareTo(BigInteger.ZERO) < 0){
                System.out.println("-");
            }else{
                System.out.println("0");
            }

        }


    }
}
