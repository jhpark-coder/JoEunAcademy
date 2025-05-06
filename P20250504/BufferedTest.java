package P20250504;

import java.io.*;

public class BufferedTest {
    public static void main(String[] args) throws IOException {

        String filePath = "aa.txt";
        File file = new File(filePath);

        BufferedWriter bw = new BufferedWriter(new FileWriter(filePath,false));

        bw.write("AAA");
        bw.flush();
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(filePath));

        System.out.println(br.readLine());


    }
}
