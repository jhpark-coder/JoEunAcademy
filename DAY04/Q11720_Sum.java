package WEEK02.DAY04;

import java.util.Scanner;

public class Q11720_Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // n개가 입력됨
        //한줄로 입력되기때문에 스트링으로 받아서 변환해야함
        String strNum = sc.next();
        int sum = 0;//숫자의 합
        for(int i = 0 ; i < n ; i++)
        {
            String tempStr = ""+ strNum.charAt(i);
            sum+=Integer.parseInt(tempStr);
        }
        System.out.println(sum);
    }
}
