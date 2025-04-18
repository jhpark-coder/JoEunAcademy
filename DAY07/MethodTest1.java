package DAY07;

import java.util.Random;
import java.util.Scanner;

public class MethodTest1 {
    //public  접근제한자
    //class 클래스
    public static void main(String[] args) {
        //static은 메모리에 올리기때문에 바로 사용 가능
        //main문은 무조건 처음에 실행됨
        //(추가로 작성하는) 메소드 이름은 main으로 지으면 안됨
        // void -> 안주고 , 메소드 이름 main 매개변수 있으니까 받고
        //안주고 받고 -> 매개변수 String[] 문자배열을 받음
        //주고 = return값 유무, 받고 = 매개변수 유무

        System.out.println("hello world"); // 안주고 받고(3번)
        Scanner sc = new Scanner(System.in);//스캐너 객체생성(class)

        int num = sc.nextInt(); //주고 안받고(2번)

        Random r = new Random();
        int ran = r.nextInt(10); // 주고 받고(1번)

    }


}
