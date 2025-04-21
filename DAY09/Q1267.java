package WEEK03.DAY09;

import java.util.Scanner;

public class Q1267 {
    public static void main(String[] args) {
     //두가지 요금제
     //1. 영식요금제(30초당 10원)
     //2. 민식요금제(60초당 15원)

     //n번만큼 입력 // 시간배열 -> 이건 배열로 안해도 될듯
     //영식배열 // 민식배열

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int Y = 0;
        int M = 0;

        int num = 0;
        for(int i = 0 ; i < n; i++){
            num = sc.nextInt();
            if(num / 30 == 0){ // 30이하
                Y += 10;
            }else { // 아닌 경우
                Y += ((num / 30) * 10 ) + 10;
            }
            if(num / 60 == 0) { // 60이하
                M += 15;
            }else { // 아닌 경우
                M += ((num / 60) * 15 ) + 15;
            }
        }

        if(Y < M)
            System.out.println("Y "+Y);
        else if(Y > M)
            System.out.println("M "+M);
        else System.out.println("Y M "+Y);

    }
}
