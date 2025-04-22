package WEEK03.DAY10;

import java.util.Scanner;

public class Q2083 {
    public static void main(String[] args) {
        //성인부 or 청소년부
        //나이 17 이상 or 몸무게 80이상 성인부
        String end = "#";
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            String temp = sc.next();
            if(temp.equals(end)){
                break;
            }else{
                temp+=" ";
                int age = sc.nextInt();
                int weight = sc.nextInt();
                if(age > 17 || weight >= 80 ){
                    System.out.println(temp+"Senior");
                }else{
                    System.out.println(temp+"Junior");
                }
            }

        }
    }
}
