package DAY08;

import java.util.ArrayList;
import java.util.Scanner;

public class Q3052 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = 10; // 10개의 수 받아들임

        //int[] remainder = new int[10]; //

        /*
        for(int i = 0 ; i < n ; i++) {

            remainder[i] = -1; // 나머지는 0이상인경우만나오므로 아닌경우 빼기위해 초기화
        }

        int lastIndex = -1;//마지막에 remainder배열의 값을 바꿔준 index
        //10개를 돌면서 나머지를 계산하고 remainder에서 그 값이 있는지 체크
        //없으면 remainder에 값을 하나 바꿔줌
        for(int i = 0 ; i < n ; i++) {


        }

         */

        ArrayList<Integer> remainder = new ArrayList<Integer>();

        for(int i = 0 ; i < n ; i++){
            int temp = sc.nextInt() % 42;
            if(!(remainder.contains(temp))){
                remainder.add(temp);
            }
        }

        System.out.println(remainder.size());
    }
}
