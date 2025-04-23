package WEEK02.DAY06;

import java.util.Scanner;

public class Q5622_dial {
    public static void main(String[] args) {
      char[][] charArr = new char[8][];

      charArr[0] = new char[]{'A','B','C'};
      charArr[1] = new char[]{'D','E','F'};
      charArr[2] = new char[]{'G','H','I'};
      charArr[3] = new char[]{'J','K','L'};
      charArr[4] = new char[]{'M','N','O'};
      charArr[5] = new char[]{'P','Q','R','S'};
      charArr[6] = new char[]{'T','U','V'};
      charArr[7] = new char[]{'W','X','Y','Z'};

        Scanner sc = new Scanner(System.in); //스캐너 선언

        //문자열 받음
        String str = sc.next();
        int sum = 0;

        for(int t = 0 ; t < str.length() ; t++) {
            for (int i = 0; i < charArr.length; i++) {
                for (int j = 0; j < charArr[i].length; j++) {
                    if (charArr[i][j] == str.charAt(t)) // 문자열에서 찾은 경우
                    {
                        sum += (i + 3);
                    }
                }
            }
        }

        System.out.println(sum);


    }
}
