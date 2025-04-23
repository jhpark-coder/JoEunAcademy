package WEEK01.DAY03;

import java.util.Scanner;

public class InputTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력해주세요 : ");
        String str1 = sc.nextLine(); //구분기준이 엔터
        System.out.print("입력해주세요 : ");
        String str2 = sc.next();//구분기준이 스페이스와 엔터


        System.out.println(str1);

        System.out.println(str2);
    }
}
