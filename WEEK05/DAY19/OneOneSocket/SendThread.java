package WEEK05.DAY19.OneOneSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class SendThread extends Thread{

    private Socket m_Socket; // 변수 m_Socket 선언

    public void run() // Thread에 있는 run 메소드를 오버라이딩
    {
        try {
            //키보드 입력
            BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
            //BufferReader 이용해 입력 객체 생성
            // 소켓에 out 쏘려고
            PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
            //PrintWriter 객체 생성
            //객체 생성 시, Socket의 출력 스트림 인자로 받아서 생성
            String sendString;
            while (true) {
                sendString = tmpbuf.readLine(); // 키보드 입력

                if (sendString.equals("종료")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                } else {
                    // 입력 받은 값 sendString에 대입
                    sendWriter.print(sendString);
                    //printWriter의 println 메소드에 sendString 대입
                    sendWriter.flush(); // 소켓에 전송
                    // PrintWriter의 flush 함수 호출 시, 문자열 데이터 전송
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //메인문에서 Socket 객체 받아 내 변수에 대입
    public void setSocket(Socket _socket){ m_Socket = _socket; }

}

