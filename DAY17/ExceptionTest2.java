package WEEK04.DAY17;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ExceptionTest2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = 0;
        int flag = 0;
        while(flag == 0){
            flag = 1;
            try{
                System.out.print("숫자 입력 : ");
                num = sc.nextInt();
                System.out.println("입력 받은 숫자는 = "+num);
            }
            catch (InputMismatchException e){
                flag = 0;
                sc.nextLine();
                System.out.println("숫자를 올바르게 입력하세요.");
            }
        }
    }
}
