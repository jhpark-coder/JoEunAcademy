package WEEK04.DAY17;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExFileWriter {
    public static void main(String[] args) throws IOException {
        //입력 객체 생성
        Scanner sc = new Scanner(System.in);

        //문자열 변수 선언 후 문자열 데이터 대입
        String source = "비어 있어야 비로서 가득해지는 사랑\n"+"영원히 사랑하는 것은\n"
                +"평온한 마음으로 아침을 맞는다는 것입니다.\n";

        //문자열을 char배열로 변경하기 위해 객체 생성
        char[] input = new char[source.length()];

        //char[]에 문자열 데이터 값 넣기
    //                  소스시작인덱스 길이          목적지 목적지 시작 인덱스
        source.getChars(0,source.length(),input,0);

        System.out.println("파일명을 입력하세요 : ");
        String s = sc.next();

        //파일 쓰기 객체 생성
        //파일 쓰기 객체 생성 시 생성자 매개변수에 들어간 문자열은 파일명이 됩니다.
        FileWriter fw = new FileWriter(s);
        //파일쓰기 실행
        fw.write(input);
        //파일 다 쓰면 close를 통해 종료 시킴
        fw.close();
        System.out.println(s+"파일이 생성되었습니다.");
    }

}
