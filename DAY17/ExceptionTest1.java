package WEEK04.DAY17;

import java.io.FileReader;

public class ExceptionTest1 {
    public static void main(String[] args) {
        FileReader fr;
        try {
            fr = new FileReader("c.txt");
            int i;
            while((i= fr.read())!= -1){
                System.out.print((char) i);
            }
        }
        catch (Exception e){ // 예외처리 최상위 부모
            System.out.println("예외처리루틴 : "+e+"파일이 존재하지 않습니다.");
        }
        finally{ // 무조건 실행됨
            System.out.println("hello");
        }
    }
}
