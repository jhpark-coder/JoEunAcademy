package WEEK02.DAY04;

import java.util.Scanner;

public class Q9086_String {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        while(n > 0)
        {
            String str = sc.next();
            char c1 = str.charAt(0);
            char c2 = str.charAt(str.length()-1);
            System.out.print(c1);
            System.out.print(c2);
            System.out.println();
            n--;
        }

    }
}
