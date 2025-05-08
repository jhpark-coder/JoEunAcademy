package WEEK05.DAY19.OneOneSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main(String[] args) {

        try{
            ServerSocket a_socket = new ServerSocket(9000); // ServerSocket 객체 생성
            Socket c_socket = a_socket.accept(); // ServerSocket accept 메소드, 변수 c_socket에 대입

            ReceiveThread receive_thread = new ReceiveThread(); // Receive Thread 객체 생성
            receive_thread.setSocket(c_socket); // Receive Thread Socket 전달
            SendThread send_thread = new SendThread(); // Send Thread 객체 생성
            send_thread.setSocket(c_socket); // Send Thread Socket 전달
            receive_thread.start();
            send_thread.start(); // Send Thread 시작
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
