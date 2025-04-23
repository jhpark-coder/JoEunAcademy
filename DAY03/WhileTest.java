package WEEK01.DAY03;

public class WhileTest {
    public static void main(String[] args) {
        //1~10까지 더한 값 출력
        int result = 0;
        int flag = 1;
        while(flag <= 10)
        {
            result+=flag;
            flag++;
        }
        System.out.println(result);
    }
}
