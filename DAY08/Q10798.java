package DAY08;

import java.util.Scanner;

public class Q10798 {
    public static void main(String[] args) {
        char[][] arr = new char[5][15];
        Scanner sc = new Scanner(System.in);

        for(int i = 0 ; i < arr.length ; i++)
        {
            for (int j = 0 ; j < arr[i].length ; j++){
                arr[i][j] = 'z'+1;
            }
        }

        for(int i = 0 ; i < 5 ; i++){
            String str = sc.next();
            for(int j = 0 ; j < str.length() ; j++){
                arr[i][j] = str.charAt(j);
            }
        }


        for(int i = 0 ; i < 15 ; i++){
            for(int j = 0 ; j < 5 ; j++){
              if(arr[j][i] <= 'z'){
                  System.out.print(arr[j][i]);
              }
            }
        }


    }
}
