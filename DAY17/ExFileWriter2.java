package WEEK04.DAY17;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class ExFileWriter2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("파일명을 입력 :");
        String s = sc.next();
        File file = new File(s);

        //bufferedwriter의 생성자 매개변수로 filewriter를 줌 filewriter는 매개변수로 파일과 boolean값을 가짐
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file,true));

        bufferedWriter.write("안녕하세요.");
        bufferedWriter.newLine();
        bufferedWriter.write("잘가세요.");
        bufferedWriter.flush();
        bufferedWriter.close();

    }
}
