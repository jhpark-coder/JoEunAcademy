package WEEK02.DAY08;

import java.util.Scanner;

public class Q5597 {
    public static void main(String[] args) {
        int m = 30; //총 학생 수
        boolean[] hw = new boolean[m];

        int n = 28; //숙제한 학생수
        Scanner sc = new Scanner(System.in);
        for(int i = 0 ; i < n ; i++){
            hw[sc.nextInt()-1] = true;
        }

        //돌면서

        int num1 = 0;
        int num2 = 0;

        for(int i = 0 ; i < hw.length ; i++){
            if(!hw[i]){
                if(num1 == 0){
                    num1 = i+1;
                }else {
                    num2 = i + 1;
                    break;
                }
            }
        }

        if(num1 < num2) {
            System.out.println(num1);
            System.out.println(num2);
        }else{
            System.out.println(num2);
            System.out.println(num1);
        }



    }
}
