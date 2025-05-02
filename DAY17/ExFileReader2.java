package WEEK04.DAY17;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ExFileReader2 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.print("읽을 파일명을 입력하세요 : ");
        String s = sc.next();
        BufferedReader br = new BufferedReader(new FileReader(s));
        String str;
        while ((str = br.readLine()) != null){
            System.out.println(str);
        }
        br.close();
    }
}
