package WEEK02.DAY04;

public class Q4 {
    public static void main(String[] args) {


        //5번 찍고 1,3,5,7,9개 찍음 그리고 가운데정렬을 함
        for (int i = 0 ; i < 5 ; i++)
        {
            for(int j = 5 ; j >= 0  ; j--) //
            {
                // 공백 4개 별 1개 총 5번 찍음
                // 공백 3개 별 2개
                // 공백 2개 별 3개
                // 공백 1개 별 4개
                // 공백 0개 별 5개
                if(i < j){
                    System.out.print(" ");
                }
                else {
                    System.out.print("*");
                }
            }

            for(int j = 0 ; j < i ; j++) // 별 0개 1개 2개 3개 4개 찍음
            {
                System.out.print("*");
            }
            System.out.println();
        }

        //5번 찍고 1,3,5,3,1개 찍음

        for (int i = 0 ; i < 3 ; i++) // 1, 3, 5 찍음
        {
            for(int j = 3 ; j >= 0  ; j--) //
            {

                if(i < j){
                    System.out.print(" ");
                }
                else {
                    System.out.print("*");
                }
            }

            for(int j = 0 ; j < i ; j++) // 별 0개 1개 2개 3개 4개 찍음
            {
                System.out.print("*");
            }
            System.out.println();

        }
        for (int i = 2 ; i >= 0 ; i--) // 3, 1
        {
                                          //공백 1개 별 2개
                                          //공백 2개 별 1개
                                          //공백 3개 별 0개
            for(int j = 0 ; j < 2 ; j++) {
                if (j <= i) {
                    System.out.print(" ");
                }
                else {
                    System.out.print("*");
                }
            }


             for(int j = 1 ; j > 0 ; j--) // 별 0개 1개 2개 3개 4개 찍음
            {
                System.out.print("*");
            }
            System.out.println();

        }





    }
}
