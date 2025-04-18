package DAY08;

/*
문자 A(65)에 랜덤한 값 0~25값을 추출 (주고 안받고로)하여
더하기연산(주고 받고)해서 문자를 만듭니다.

위 작업을 10번하는 함수를 만들고(안주고 안받고)
10개 문자를 더하기 연산하여(주고받고)
문자 10개를 출력하세요(안주고 받고)

 */

import java.util.Random;

public class Q3 {
    public static void main(String[] args) {
        tenTimes();
    }

    //랜덤값 추출(주고 안받고)
    static int ranNum() {
        Random r = new Random();
        return r.nextInt(26);
    }

    //더하기연산(주고 받고)해서 문자를 만듭니다.
    static char ranChar(int ranNum){
        //System.out.println((char)('A'+ranNum));
        return (char)('A'+ranNum);
    }

    static void tenTimes(){ //10번 수행
        String str="";
        for(int i = 0 ; i < 10 ; i++){
            str+=charToString(ranChar(ranNum()));
        }
        printString(str);
    }

    //10개 문자를 더하기 연산하여(주고받고)
    static String charToString(char ch){
        return ""+ch;
    }
    //문자 10개를 출력하세요(안주고 받고)
    static void printString(String str){
        System.out.println(str);
    }



}
