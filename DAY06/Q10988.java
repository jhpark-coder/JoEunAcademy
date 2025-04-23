package WEEK02.DAY06;

import java.util.Scanner;

public class Q10988 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        int check = 1;
        for (int i = 0; i < str.length() / 2 + 1; i++) {
            if(str.charAt(i) != str.charAt((str.length()-1)-i)){
                check = 0;
            }
        }

        System.out.println(check);

    }
}
