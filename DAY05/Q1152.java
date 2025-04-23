package WEEK02.DAY05;

import java.util.Scanner;

public class Q1152 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();
        int count = 0;
        for(int i = 0 ; i < str.length() ; i++)
        {
            if(str.charAt(0) != ' ' && count == 0)
            {
                count++;
            }

            if(str.charAt(i) == ' ')
            {
               count++;
            }
        }

        if(str.charAt(str.length()-1)==' ')//공백으로 끝나면 카운트 빼줌
            count--;

        System.out.print(count);
    }
}
