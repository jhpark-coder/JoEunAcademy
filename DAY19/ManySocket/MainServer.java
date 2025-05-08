package WEEK05.DAY19.ManySocket;

import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class MainServer {

	int port = 7777; // 정수변수 port선언후 7777 대입
	ServerSocket server = null; // ServerSocket타입 server 선언 후 null 대입
	Socket child = null; // Socket타입 child 선언 후 null 대입

	HashMap<String, PrintWriter> hm; // 방송국
    
	public MainServer() { //ChatServer 생성자

		ChatSverThread sr;
        //ChatServerThread타입에 sr 변수 선언
        //브로드 캐스팅을 하기위한 쓰레드 객체
		Thread t;
        //Thread 타입의 t 변수 선언

		try { //시도하다
			server = new ServerSocket( port ); //서버소켓을 생성해서 server 변수에 대입

			System.out.println( "**************************************" );//출력
			System.out.println( "*              채팅 서버               *" );//출력
			System.out.println( "**************************************" );//출력
			System.out.println( "클라이언트의 접속을 기다립니다." );//출력

			hm = new HashMap<String, PrintWriter>(); 
			//hashMap객체를 생성해서 hm 변수에 대입

			while( true ) { // 무한 반복
				child = server.accept(); 
				if( child != null ) {
					sr = new ChatSverThread( child, hm ); 
					t = new Thread(sr); 
					t.start();
				}
			}
		}
		catch ( Exception e )	{ //예외처리가 발생하면 실행
			e.printStackTrace(); //예외처리 출력
		}
	}



	public static void main(String[] args) 
	{
		new MainServer(); //MainServer 객체 생성
	}

}
