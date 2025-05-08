package WEEK05.DAY19;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class ExClientTCP {
    public static void main(String[] args) throws IOException {
        //String server = "192.168.30.54";
        String server = "192.168.30.3";
        int port = 7777;
        Socket c = new Socket(server,port);
        InputStream is = c.getInputStream(); // InputStream 서버가 보내면 받는 Stream
        DataInputStream dis = new DataInputStream(is); // 편하게 사용하기 위한 DataInputStream
        for(int i = 1 ; i <= 10 ; i++){
            int j = dis.read(); // read() 서버가 보낸 데이터 읽어서 리턴
            System.out.println("서버로 부터 받은 데이터 " + j + "출력");
        }
    }
}
