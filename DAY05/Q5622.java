package WEEK02.DAY05;

import java.util.Scanner;

public class Q5622 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next(); // 알파벳으로 된 문자열 입력받음
        int time = 0;
        //다이얼 거는데 1은 2초 2는 3초 3은 4초 4는 5초... 9는 10초
        String[] NumArr = new String[9]; //9칸짜리 문자열배열 선언
        NumArr[1] = "ABC";
        NumArr[2] = "DEF";
        NumArr[3] = "GHI";
        NumArr[4] = "JKL";
        NumArr[5] = "MNO";
        NumArr[6] = "PQRS";
        NumArr[7] = "TUV";
        NumArr[8] = "WXYZ";
    }
}
