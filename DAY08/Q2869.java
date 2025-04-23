package WEEK02.DAY08;

import java.util.Scanner;

public class Q2869 {
    public static void main(String[] args) {
        //달팽이 올라가기

        Scanner sc = new Scanner(System.in);

        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int result = (int)Math.ceil((double)(c-a)/(a-b)+1);
        System.out.println(result);

    }

}
/*
숫자만큼 입력받음

a - b


c - a 3

(c - a) / (a- b) + 1


5 - 2 / 2 - 1  + 1 = 4 / 1 + 1 = 4


6 - 5 / 5 - 1 = 1 / 4



(a - b) * x = c

(c - a) = (a-b) * x + 1

5 - 2 = 2 - 1 * x +1

c - a / a - b = 3 + 1

5 2 6

1 / 3 + 1 (올림해줘야함)

 */
