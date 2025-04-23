package WEEK03.DAY11;
/*

입력:
1122335*#66

출력:
BEHM*$Q

 */

import javax.swing.*;
import java.util.Scanner;

public class Q4 {
    public static void main(String[] args) {

        //1. 변수의 갯수를 센다.
        //2. 같으면 갯수에 1씩 더하고 아니면 변수갯수와 입력문자를 기반으로 출력한다.

        int count = 0; //같은 게 몇개인지 체크용
        //int checkindex = -1; // 몇번째 라인인지 체크(0~8)
        Scanner sc = new Scanner(System.in); // 입력 준비

        String[] numArr = new String[12];
        for(int i = 0 ; i < 8 ; i++){
            numArr[i] = "";
            for( int j = 0 ; j < 3 ; j++) {
                numArr[i] += (char) ('A'+(i*3)+j);
            }
            //System.out.println(numArr[i]);
        }

        numArr[8] = "Y";
        numArr[9] = "Z";
        numArr[10] = "*";
        numArr[11] = "#";
        //System.out.println(numArr[8]);
        /*

        char[] numberArr = new char[12];
        for(int i = 0 ; i < 10 ; i++){
            numberArr[i] = (char)i;
        }
        numberArr[10]='*';
        numberArr[11]='#';
        */
        String str = sc.next(); // 1~0,*,#중에 하나의 값만 들어옴
        char preChar;
        char nextChar;
        for(int t = 0 ; t < str.length() ; t++){
            if(t+1 == str.length()){
                System.out.print(numArr[numToChar(str.charAt(t))].charAt(count));
            }else {
                preChar = str.charAt(t);
                nextChar = str.charAt(t + 1);
                if (preChar == nextChar) {
                    count = (count + 1) % 3;
                } else {
                    System.out.print(numArr[numToChar(str.charAt(t))].charAt(count));
                    count = 0;
                }
            }
        }


    }


    static int numToChar(char c) {
        switch (c) {
            case '0':
                return 9;
            case '*':
                return 10;
            case '#':
                return 11;
            default:
                //System.out.println(c-49);
                return (c-49);
        }
    }
}
