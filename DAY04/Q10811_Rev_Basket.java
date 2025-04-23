package WEEK02.DAY04;

import java.util.Scanner;

public class Q10811_Rev_Basket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        //n 크기의 배열을 입력받음
        int n = sc.nextInt();
        int[] arr = new int[n];//

        for(int i = 0 ; i < n ; i++)
        {
            arr[i] = i+1; // 배열 초기화
        }

        //int[] revArr = new int[n]; // 뒤집을때 쓰는 임시배열

        int m = sc.nextInt(); // 몇 번 입력 받을 지

        while(m > 0)
        {
           // int i = sc.nextInt() - 1; //인덱스로 쓰기 편하게 하기 위해 -1해줌
           // int j = sc.nextInt() - 1;
            int i, j;
            int temp;

            for(i = sc.nextInt() - 1, j = sc.nextInt() - 1; i <= j ; i++,j--) //i~j까지 반복
            {
                temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

            m--; // m번만큼 반복해서 숫자를 입력받음
        }

        for(int i = 0 ; i < n ; i++)
        {
            System.out.println(arr[i]); // 배열 출력
        }
    }
}
