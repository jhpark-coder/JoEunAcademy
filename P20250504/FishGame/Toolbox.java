package P20250504.FishGame;

import java.util.Scanner;

public final class Toolbox {
    private Toolbox(){

    }
    public static int inputRightNumber(String temp, Scanner sc){
        System.out.println(temp);
        while(true) {
            if (sc.hasNextInt()) {
                return Integer.parseInt(sc.nextLine());
            }else{
                System.out.println("올바른 정수 값을 입력해주세요");
                sc.nextLine();
            }
        }

    }

    public static int inputRightNumber(String temp, int min, int max, Scanner sc){
        System.out.println(temp);
        while(true) {
            if (sc.hasNextInt()) {
                int num = Integer.parseInt(sc.nextLine());
                if(num >= min && num <= max){
                    return num;
                }else{
                    System.out.println(min + "이상" + max + "이하의 숫자를 입력해주세요");
                    sc.nextLine();
                }
            }else{
                System.out.println("올바른 정수 값을 입력해주세요");
                sc.nextLine();
            }
        }
    }

}
