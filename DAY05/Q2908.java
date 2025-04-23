package WEEK02.DAY05;

import java.util.Scanner;

public class Q2908 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String a = sc.next();//첫 번째 수 a를 받음
        String b = sc.next();//두 번째 수 b를 받음

        String revA="";
        String revB="";

        for(int i = 0 ; i < a.length() ; i++)
        {
            revA+=""+a.charAt(a.length()-i-1);
        }

        for(int i = 0 ; i < b.length() ; i++)
        {
            revB+=""+b.charAt(b.length()-i-1);
        }

        if(Integer.parseInt(revA) > Integer.parseInt(revB))
        {
            System.out.println(revA);
        }
        else{
            System.out.println(revB);
        }

    }

}
