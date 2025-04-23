
package WEEK02.DAY05;

import java.util.Scanner;

public class Q10809 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next(); // 문자열 하나 입력받음

        int[] alpCheck = new int[26];
        for(int i = 0 ; i < 26 ; i++)
        {
            alpCheck[i] = -1; // alpcheck 초기화
        }

        for(int i = 0 ; i < str.length() ; i++) // 길이만큼 찾아봄
        {

            char charCheck = str.charAt(i); //  문자열의 i번째 글자는 charCheck
            if(alpCheck[charCheck-97] == -1) { //
                alpCheck[charCheck - 97] = i; //alpCheck가 처음으로 나온 거 저장하는 배열
            }

        }

        for(int i = 0 ; i < 26 ; i++){
            System.out.print(alpCheck[i]+" ");
        }




    //    char a= 'a';
        //   System.out.println(a-97); // = 0




    }
}
