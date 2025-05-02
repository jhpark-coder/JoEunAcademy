package WEEK04.DAY17;

import java.io.*;

public class IOTest {
    public static void main(String[] args) throws IOException {
        File file = new File("c.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(file,true));

        bw.write("AAA");
        bw.flush();
        bw.close();

        BufferedReader br = new BufferedReader(new FileReader(file));
    }
}
