package WEEK04.DAY17;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExFileReader {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("읽어 들일 파일명을 입력하세요 : ");
        String s = sc.next();
        //FileReader 객체를 생성 생성자 매개변수에는 파일명을 넣어줍시다.
        FileReader fr = new FileReader(s);

        int i;

        //fr.read() 가 정수 반환 -> 문자
        //더이상 읽을 게 없으면 -1을 줌
        while( (i = fr.read()) != -1){
            System.out.print( (char) i);
        }
        fr.close();


    }
}
