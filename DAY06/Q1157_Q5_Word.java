package WEEK02.DAY06;

import java.util.Scanner;

public class Q1157_Q5_Word {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next(); // 문자열 하나를 받음
        //char 97 = 'a'
        //char 65 = 'A'
        //char값으로 97이상이면(96초과면) -32해줘야함

        int[] alpha = new int[26];//알파벳은 총 26개

        for(int i = 0 ; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c > 96) {
                c -= 32;
            }
            alpha[(c-65)]++;
        }

        int max = 0;
        int count = 0;
        int maxIndex = 0;
        for(int i = 0 ; i < alpha.length ; i++)
        {
            if(alpha[i] > max)
            {
                max = alpha[i];
            }
        }

        for(int i = 0 ; i < alpha.length ; i++)
        {
            if(max == alpha[i]) {
                maxIndex = i;
                count++;
            }
        }
        /*
        for(int i = 0 ; i < alpha.length ; i++)
        {
            System.out.print(alpha[i]+"\t");
        }

        System.out.println();
        System.out.println(max);
        System.out.println(count);
        System.out.println(maxIndex);
        */
        if(count == 1)
            System.out.println((char)(maxIndex+65));
        else System.out.println("?");
    }
}
