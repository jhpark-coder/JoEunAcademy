package WEEK02.DAY04;
/*
별찍기
1.  *****
    *****
    *****
    *****
    *****
2.  *
    **
    ***
    ****
    *****
3.      *
       **
      ***
     ****
    *****
 */
public class Q3 {
    public static void main(String[] args) {

        for(int i = 0 ; i < 5 ; i++) //1번 찍기
        {
            System.out.println("*****");
        }

        //2번 찍기(1, 12, 123 ... 찍기)
        for(int i = 0; i < 5 ; i++)
        {
            for(int j = i ; j >= 0 ; j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }

        //3번 찍기(오른쪽정렬로 나오게)
        for(int i = 0 ; i < 5 ; i++)
        {
            for(int j = 4-i ; j > 0 ; j--)
            {
                System.out.print(" ");
            }
            for(int j = i ; j >= 0 ; j--)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    }
}
