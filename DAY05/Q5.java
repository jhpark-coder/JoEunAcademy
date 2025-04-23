package WEEK02.DAY05;
/*
배열 문제 1
 */

import java.util.Random;

public class Q5 {
    public static void main(String[] args) {

        //3크기의 배열변수에 각각 다른 값 넣기
        //잘못된 입력 바로바로 체크하기

        Random r = new Random();
        int[] arr = new int[3];
        int[] tempArr = new int[3];
        while(arr[2] == 0) { //arr[2]에 값이 안들어간경우 계속 수행
            for (int i = 0; i < 3; i++) {
                tempArr[i] = r.nextInt(9) + 1;
            }
            if(tempArr[0] != tempArr[1] && tempArr[1] != tempArr[2] && tempArr[0] != tempArr[2])
            {
                for( int i = 0 ; i < 3 ; i++)
                {
                    arr[i] = tempArr[i];
                }
            }
        }
        for(int i = 0 ; i < 3; i++)
        {
            System.out.print(arr[i]+" ");
        }

    }
}
