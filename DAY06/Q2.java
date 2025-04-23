package WEEK02.DAY06;
/*
크기가 5인 배열 1~9값을 랜덤하게 저장
같은 값이 들어갈 수 없다.
다른 랜덤한 5개의 랜덤한 값으로 채움
오름차순으로 정렬
 */


import java.util.Random;

public class Q2 {
    public static void main(String[] args) {
        Random r= new Random();//랜덤선언
        //크기가 5인 배열 선언
        int[] arr = new int[5];

        //랜덤으로 1~9까지 중복되지 않게 값을 넣어줌
        for(int i = 0 ; i < 5 ; i++) //넣어주려는 배열 arr[i]
        {
            arr[i]=r.nextInt(9)+1; // 값을 받아옴
            for(int j = 0 ; j < i; j++)// 이전에 저장해둔 기준이 되는 비교군 배열 arr[j]
            {
                if(arr[j] ==arr[i])
                {
                    i--;
                    break;
                }
            }
        }
        for(int i = 0 ; i < 5 ; i++)
        {
            System.out.printf("a[%d] = %d ",i,arr[i]);
        }

        System.out.println();

        //정렬해줌
        for(int i = 0 ; i < 4 ; i++) //최소값이 들어가야하는 곳
        {
            for(int j = i+1 ; j < 5 ; j++) // 비교군이 되는 곳
            {
                if(arr[i] > arr[j])
                {
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        for(int i = 0 ; i < 5 ; i++)
        {
            System.out.printf("a[%d] = %d ",i,arr[i]);
        }

        System.out.println();


    }
}
