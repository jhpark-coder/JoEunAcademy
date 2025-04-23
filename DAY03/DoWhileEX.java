package WEEK01.DAY03;

public class DoWhileEX {
    public static void main(String[] args) {
        int num = 1;
        int result =0;

        do{
            result+=num;
            num++;
        }while(num<=10);
        System.out.println("1부터 10까지의 합은 " + result + "입니다.");
    }
}
