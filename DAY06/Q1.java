package WEEK02.DAY06;
/*
로또번호 추출기
1~45의 숫자중 6개 중복값이 나오지 않게 만들어주세요.
추가적으로 정렬해주세요.
 */


import java.util.Random;

public class Q1 {
    public static void main(String[] args) {
        int[] lotto = new int[6]; // 로또번호 넣을 칸 6개 생성
        Random r = new Random();

        for(int i = 0 ; i < 6 ; i++) //6번 받음 lotto[i]는 현재 집어넣을 값
        {

            lotto[i] = r.nextInt(45)+1; //0~44 +1 = 1~45
            for(int j = 0 ; j < i ; j++) //lotto[j]는 기본 값
            {
                if(lotto[i] == lotto[j])
                {
                    i--;
                    break;
                }
            }
        }
    /*
        for(int i = 0 ; i < 5 ; i++) // 버블소트
        {
            for(int j = i+1 ; j < 6 ; j++)
            {
                if(lotto[i] > lotto[j])
                {
                    int temp = lotto[j];
                    lotto[j] = lotto[i];
                    lotto[i] = temp;
                }
            }
        }
        */
        int min = 46;
        for(int i = 0 ; i < 5 ; i++)// 최소값 뽑아와서 그거의 값 저장해두고 첫번째꺼랑 바꾸기
        { // i = 0 1 2 3 4 5
            for(int j = i+1 ; j < 6 ;j++) // j = 12345 2345 345 45
            {
                if(lotto[j] < min)
                {
                    int temp = min;
                    min = lotto[j];
                    lotto[j] = temp;
                }
            }
            int temp = min;
            min = lotto[i];
            lotto[i] = temp;

            min = 46;
        }

        for(int i = 0 ; i < 6 ; i++) {
            System.out.print(lotto[i]+" ");
        }
    }
}
