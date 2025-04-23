package WEEK02.DAY04;


/*
A에 0~25값을 더해서 문자 10개를 하나의 문자열로 만들어서 출력
 */

import java.util.Random;

public class Q5 {
    public static void main(String[] args) {

        char a = 'A'; // 문자A(65)선언
        String str = ""; //저장해둘 문자열 선언
        Random r = new Random(); //랜덤 객체 생성

        for(int i = 0 ; i < 10 ; i++) //10번 반복
        {                           // 26미만인 값 추출(0~25)
            str+=(char)(a+r.nextInt(26)); // char+int하면 int값이 나옴
            // 그걸 다시 char로 바꾸어서 저장해야 문자로 저장됨
        }

        System.out.println(str); // 문자열 출력
    }
}
