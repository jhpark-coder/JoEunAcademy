package WEEK01.DAY03;

import java.util.Scanner;

/*
온도값이 없거나 계절의 월범위를 벗어나면 잘못된 입력이라고 출력

1. 월으르 입력받고 온도를 입력받습니다.
(3-5 봄, 6-8 여름, 9-11 가을, 12-2 겨울(단위 월)
3-15 봄, 18-37 여름, 3-15 가을, 2- -15 겨울(단위 온도)
 */
public class Q1 {
    public static void main(String[] args) {
        //월에 해당하는 계절 그리고 온도를 출력
        //1. 조건 안에 해당하지만(1~12월, -15~37도) 계절과 온도가 맞지 않는 경우는 계절과 온도가 맞지 않다 출력
        //2. 1의 조건에 해당하지 않는(범위를 벗어나는) 경우, 잘못된 입력이라고 출력
        //실제로 코드에서는 2를 먼저 체크하고 나머지 조건중에 세부조건으로 들어가는 것이 좋아보임

        int month;//월 선언해두기
        int temperature;//기온 선언해두기

        Scanner sc = new Scanner(System.in); // 입력 준비

        System.out.print("월 입력 : ");   //월을 입력 받기
        month = sc.nextInt();
        System.out.print("온도 입력 : ");  //온도를 입력 받기
        temperature = sc.nextInt();

        if(month > 12 || month < 1 || temperature < -15 || temperature > 37)//월, 온도 범위 조건을 벗어나는 경우
        {
            System.out.println("온도 값이나 계절의 월 범위를 벗어났으므로 잘못된 입력입니다.");
        }
        //월 온도 범위 조건에는 해당하는 경우 // 월을 확인, 온도를 확인. 봄, 여름, 가을, 겨울 총 4가지 경우가 있음.
        else if(month > 2 && month < 6){//월로는 봄에 해당(3~5월)
            if(temperature > 2 && temperature < 16)//온도도 봄에 해당(3~15도)
            {
                System.out.printf("계절은 봄입니다. 온도는 %d도입니다.",temperature);
            }
            else{//월로는 봄이지만 온도가 맞지 않는 경우
                System.out.println("계절과 온도가 맞지 않습니다.");
            }
        }
        else if(month > 5 && month < 9){//월로는 여름에 해당(6~8월)
            if(temperature > 17 && temperature < 38)//온도도 여름에 해당(18~37도)
            {
                System.out.printf("계절은 여름입니다. 온도는 %d도입니다.",temperature);
            }
            else{//월로는 여름이지만 온도가 맞지 않는 경우
                System.out.println("계절과 온도가 맞지 않습니다.");
            }
        }
        else if(month > 8 && month < 12){//월로는 가을에 해당(9~11월)
            if(temperature > 2 && temperature < 16)//온도도 가을에 해당(3~15도)
            {
                System.out.printf("계절은 가을입니다. 온도는 %d도입니다.",temperature);
            }
            else{//월로는 가을이지만 온도가 맞지 않는 경우
                System.out.println("계절과 온도가 맞지 않습니다.");
            }
        }
        else{//월로는 겨울에 해당(12~2월)
            if(temperature > -16 && temperature < 3)//온도도 겨울에 해당
            {
                System.out.printf("계절은 겨울입니다. 온도는 %d도입니다.",temperature);
            }
            else{//월로는 봄이지만 온도가 맞지 않는 경우
                System.out.println("계절과 온도가 맞지 않습니다.");
            }
        }

    }
}
