package WEEK01.DAY03;

import java.util.Scanner;

/*
숫자를 하나 입력 받습니다.
입력받은 숫자의 약수를 출력하는 프로그램을 만들어주세요.
예)
(8의 약수는 1, 2, 4, 8 이므로)
8의 약수는 1, 2, 4, 8입니다.
 */
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);//스캐너 선언(입력준비)

        System.out.print("숫자 입력 : ");
        int inputNum = sc.nextInt();// 숫자 하나를 입력 받습니다.

        //입력받은 약수 출력
        System.out.printf("%d의 약수는 ",inputNum);//콤마는 약수의 갯수 n개보다 하나 작은 n-1개가 출력되어야합니다.
        for(int i = 1; i < inputNum; i++) // 1부터 iN까지 돌면서 약수체크를 합니다.
        {
            if(inputNum % i == 0) { // i가 0이라면 약수이므로 출력합니다.
                System.out.printf("%d, ",i); //배열등의 사용이 금지되어있으며, 약수의 갯수는 유동적으로 변할 수 있기에 바로 출력해야함
            }
        }
        System.out.printf("%d입니다.",inputNum); //마무리
    }
}
