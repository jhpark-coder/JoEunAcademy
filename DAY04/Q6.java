package WEEK02.DAY04;

import java.util.Scanner;

/*
1~6까지 받음
1. 직사각형
2. 정직삼각형 *
            **
3. 역직삼각형  *
            **

4. 피라미드    *
            ***
5. 다이아몬드 *
            ((((
6. 종료
그외 : 잘못된 입력입니다.
1~5일때 : 숫자를 입력하세요 : n
 */
public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        while(check)
        {
            System.out.print("숫자를 입력하세요 : ");
            System.out.println("\n1. 직사각형");
            System.out.println("2. 정직삼각형");
            System.out.println("3. 역직삼각형");
            System.out.println("4. 피라미드");
            System.out.println("5. 다이아몬드");
            System.out.println("6. 종료");
            int n = sc.nextInt(); // n은 뭘할지 종류를 고르는 값
            int m; //m은 실제로 몇번 찍을지(행렬의 열) 고르는 값
            switch(n) {
                case 1://직사각형 출력
                    System.out.print("숫자를 입력하세요 : ");
                    m = sc.nextInt();
                    for(int i = 0 ; i < m ; i++)//직사각형으로 출력
                    {
                        for(int j = 0 ; j < m ; j++)
                        {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;
                case 2: // 정직삼각형 출력
                    System.out.print("숫자를 입력하세요 : ");
                    m = sc.nextInt();
                    for(int i = 0 ; i < m ; i++) //m줄만큼 수행함
                    {
                        for(int j = 0 ; j <= i ; j++)
                        {
                            System.out.print("*");
                        }
                        System.out.println();
                    }

                    break;
                case 3:// 역직삼각형 출력
                    System.out.print("숫자를 입력하세요 : ");
                    m = sc.nextInt();
                    for(int i = 0; i < m ; i++) //m줄만큼 수행
                    {
                        for(int j = m-i ; j > 1 ; j--) // m-i만큼 빈칸 출력
                        {
                            System.out.print(" ");
                        }
                        for(int k = 0 ; k <= i ; k++) // i만큼 별 출력
                        {
                            System.out.print("*");
                        }
                        System.out.println();

                    }
                    break;
                case 4: //피라미드 출력
                    System.out.print("숫자를 입력하세요 : ");
                    m = sc.nextInt();
                    for(int i = 0 ; i < m ; i++) // m줄만큼 수행
                    {
                        for(int j = m-i ; j > 1 ; j--) // m-i개만큼 빈칸 출력
                        {
                            System.out.print(" ");
                        }
                        for(int k = 0 ; k <= i*2 ; k++) // i*2만큼 별 출력
                        {
                            System.out.print("*");
                        }
                        System.out.println();

                    }
                    break;
                case 5: //다이아몬드 출력(입력값이 홀수가 되어야함)
                    System.out.print("숫자를 입력하세요 : ");
                    m = sc.nextInt();
                    for(int i = 0 ; i <= m/2 ; i++) //m은 항상 홀수임 //삼각형모양 완성
                    {
                        for(int j = m/2-i+1 ; j > 1 ; j--)
                        {
                            System.out.print(" ");
                        }
                        for(int k = 0 ; k <= i*2 ; k++)
                        {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                        //역삼각형 모양 작성
                    for(int i = 0 ; i < m/2 ; i++)//m=7이면 3번 작성 //0,1,2
                    {
                        for(int j = 0 ; j <= i ; j++) // 공백은 됐음
                        {
                            System.out.print(" ");
                        }
                        for(int k = m-((i+1) * 2) ; k > 0 ; k--)//
                        {
                            System.out.print("*");
                        }
                        System.out.println();

                    }
                    break;
                case 6:
                    check = false;
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    break;
            }
        }

    }
}
