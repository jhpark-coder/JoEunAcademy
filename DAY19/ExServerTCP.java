package WEEK05.DAY19;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ExServerTCP {
    public static void main(String[] args) throws IOException {
        int port = 7777; // 포트번호
        int times = 10; //client 10명까지는 대응 하겠다.
        ServerSocket ss = new ServerSocket(port); // 서버 소켓 생성
        int i = 1; // times와 비교해서 10명까지 카운트해주는 변수
        while(i <= times){ // i가 times보다 작거나 같으면 반복
            Socket s = ss.accept(); // accept 메소드가 Client 소켓과 연결 될 때까지 기다린다.
            /// /////////////// 연결되면 이제 시작 됨 /////////////////////////////////
            // 소켓에서 Output 출력 스트림을 보내기 위해 객체를 소켓에서 받는다.
            OutputStream os = s.getOutputStream();
            //OutputStream객체를 데이터 전송이 용이하게 DataOutputStream 객체를 생성 시 매개변수로 OutputStream 객체를 받는다.
            DataOutputStream dos = new DataOutputStream(os);
            // 반복하면서 j 값을 Client에게 보낸다. 1~10까지 전송
            for(int j = 1 ; j <= 10 ; j++){
                dos.write(j);
            }
            //전송이 끝나면 Client와 소켓을 끊는다.
            s.close();
            // i 값은 증가한다.
            ++i;
        }
        ss.close();
    }
}
