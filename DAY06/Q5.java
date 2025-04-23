package WEEK02.DAY06;
/*
15-2
1 2 3 4 5
10 9 8 7 6
11 12 13 14 15
20 19 18 17 16
21 22 23 24 25

 */

public class Q5 {
    public static void main(String[] args) {



        //정수형 배열 5 x 5 크기 선언
        int[][] arr = new int[5][5];
        int count = 0;
        //스네이크식으로 값이 들어감
        for(int i = 0 ; i < arr.length ; i++)
        {
            for(int j = 0 ; j < arr[i].length ; j++)
            {
                count++;
                if(i % 2 == 0)//i가 홀수번째(index기준으로는 0,2,4) 행일때에는
                {
                    arr[i][j] = count; // 그냥넣음
                }
                else{
                    arr[i][(arr[i].length-1)-j] = count; // 짝수번째 행(index기준 1,3)일때에는 거꾸로 넣음
                }
            }
        }

        for(int i = 0 ; i < arr.length ; i++)
        {
            for(int j = 0 ; j < arr[i].length ; j++)
            {
                System.out.print(arr[i][j]+"\t");
            }
            System.out.println();
        }

    }
}
