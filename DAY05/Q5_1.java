package WEEK02.DAY05;

import java.util.Random;

public class Q5_1 {
    public static void main(String[] args) {
        //숫자 3개 받기
        //단 중복값, 범위를 벗어나는 값은 빼야됨
        //배열로 받기

        int[] arr = new int[3]; // 3칸짜리 정수형 배열 생성

        Random r = new Random(); // 랜덤 객체 생성

        for(int i = 0 ; i < 3 ; i++)
        {
            arr[i] = r.nextInt(9)+1;
            for(int j = 0 ; j < i ; j++)
            {
                if(arr[i] == arr[j])
                {
                    i--;
                    break;
                }
            }
        }

    }
}
