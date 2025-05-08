package WEEK05.DAY19.OneOneSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReceiveThread extends Thread{
    private Socket m_Socket; // 소켓 객체와 연결 시킬 수 있는 변수 생성
    //start() -> run() 메소드 실행

    public void run(){
        try{
            //getInputStream -> InputStreamReader -> BufferReader
            BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(m_Socket.getInputStream()));
            // Socket을 이용한 BufferReader 생성
            String receiveString;
            //무한루프
            while(true){
                receiveString = tmpbuf.readLine(); // 문자열 한 줄을 읽어옵니다.
                // BufferReader ReadLine 저장

                if(receiveString == null){
                    System.out.println("상대방 연결이 끊겼습니다.");
                    break;
                }else{
                    System.out.println("상대방 : " + receiveString);
                }
            }
            //BufferedReader 종료 시킵니다.
            tmpbuf.close();
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // 메인문에서 Socket 객체 받아 내 변수에 대입
    public void setSocket(Socket _socket) { m_Socket = _socket;}
}
