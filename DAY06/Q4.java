package WEEK02.DAY06;
/*
배열의 크기가 10인 배열을 만드세요.
그리고 각각의 배열안에 값이 0~10까지 랜덤수를 추출하여 넣어줍니다.
배열값중에 가장 큰 값이 몇번째 index에 있는지 출력해주세요.
가장 큰 값이 여러개면 각각의 index를 모두 출력해주세요.
 */

import java.util.Random;

public class Q4 {
    public static void main(String[] args) {

        //크기 10짜리 배열 선언
        int[] arr = new int[10];

        Random r = new Random();

        //배열 안에 랜덤 수 넣기
        for(int i = 0 ; i < arr.length ; i++)
        {
            arr[i] = r.nextInt(11); //0~10
            System.out.print(arr[i]+" ");
        }
        System.out.println();


        //1. 배열 안에서 가장 큰 값 구하기
        int max = 0; //최대값 max
        for(int i = 0 ; i < arr.length ; i++)
        {
            if(arr[i] > max)
            {
                max = arr[i];
            }
        }
        System.out.println("MAX값은 : "+max);

        //2. 가장 큰 값과 같은 값의 index 구하기(여러개 일 수 있음) -> 배열로

        // 3. 출력해줌
        System.out.print("가장 큰 값의 index는 ");
        for(int i = 0 ; i < arr.length ; i++) {

            if (arr[i] == max) {
                System.out.printf("%d ",i);
            }
        }

    }
}
