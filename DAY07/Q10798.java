package DAY07;

import java.util.Scanner;

public class Q10798 {
    public static void main(String[] args) {
        //세로읽기
        //문자열 5개 빈칸없이 주어짐

        char[][] str = new char[5][];
        Scanner sc = new Scanner(System.in);


        for(int i = 0 ; i < 5 ; i++){
            String tempStr = sc.next(); //ABCDE
            str[i] = new char[tempStr.length()]; //5
            for(int j = 0 ; j < str[i].length ; j++) {
                str[i][j] = tempStr.charAt(j);
            }
        }

        int i = 0;

        while(i < str[i].length){
            System.out.println(str[i].length);
            for(int j = 0 ; j < 5 ; j++){
                System.out.printf("str[%d][%d]\n",j,i);
                System.out.print(str[j][i]);
            }
            i++;
            //System.out.println();
        }
    }
}
