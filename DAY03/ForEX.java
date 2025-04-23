package WEEK01.DAY03;

public class ForEX {
    public static void main(String[] args) {
        int i;
        int sum;
        //초기화문에 1개 이상을 넣어도 상관이 없다
        for (i = 1, sum = 0; i <= 10; i++) {
            sum += i;
        }
        System.out.printf("%d, %d", i, sum);//i,sum for문 밖에서 사용 가능

        /*
        for(int j = 0; i < 10 ; j++){
        }
        System.out.println(j); // for문 안에서 선언됐기때문에 밖에서 사용불가
         */


    }
}
