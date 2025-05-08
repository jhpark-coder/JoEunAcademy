package WEEK05.DAY19.OneOneSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientThread extends Thread{
    private Socket m_Socket;
    public void run(){
        try{
            BufferedReader tmpbuf = new BufferedReader(new InputStreamReader(System.in));
            // BufferReader 이용해 입력 객체 생성
            PrintWriter sendWriter = new PrintWriter(m_Socket.getOutputStream());
            //PrintWriter 객체 생성
            //객체 생성 시, Socket의 출력 스트림 인자로 받아서 생성
            String sendString;

            while(true){
                sendString = tmpbuf.readLine();
                if(sendString.equals("quit")){
                    break;
                }else{
                    sendWriter.println(sendString);
                    sendWriter.flush();
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    //메인문에서 Socket 객체 받아 내 변수에 대입
    public void setSocket(Socket _socket){ m_Socket = _socket; }

}
