package WEEK01.DAY03;

public class Prac_Main {
    public static void main(String[] args) {
        Prac p1 = new Prac();
        int i1 = 10;
        int i2 = 5;
        double d1 = 3.4456;
        double d2 = 7.27863;

        System.out.printf("i1과 i2의 합은 : %d 입니다\n",p1.plus(i1,i2));
        System.out.printf("d1과 d2의 합은 : %.2f 입니다\n",p1.plus(d1,d2));
        System.out.printf("i1과 d2의 합은 : %.2f 입니다\n",p1.plus(i1,d2)); //직접 실행해보니 double쪽 함수가 실행되었음
        //다시 말하면 int값인 i1이 자동으로 double로 형변환 되었다는 뜻.
    }
}
