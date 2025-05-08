package WEEK05.DAY19.ManySocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class  MainClient {
	String ipAddress; 
	static final int port=7777; 
	Socket client=null; 
	BufferedReader read; 
	PrintWriter oos; 
	BufferedReader ois; 
	String sendData; 
	String receiveData; 

	String user_id; 
	ReceiveDataThread rt; 
	boolean endflag=false; 

	public MainClient(String id, String ip) {

		user_id=id; 
		ipAddress=ip; 
		try{//시도하다.
			System.out.println("**** 클라이언트*****");//출력
			client = new Socket(ipAddress, port); 

			
			read= new BufferedReader(new InputStreamReader(System.in)); // 키보드 입력
			ois = new BufferedReader( new InputStreamReader
					( client.getInputStream() ) ); // 소켓 input
			oos = new PrintWriter( client.getOutputStream() ); // 소켓 output
			oos.println( user_id );
			oos.flush();
			//전달을 받는 것만 Thread를 생성
			rt= new ReceiveDataThread(client, ois);
			Thread t = new Thread(rt);
			t.start(); 

			// 입력
			while(true){
				sendData = read.readLine();

				oos.println( sendData );
				oos.flush();

				if(sendData.equals( "/quit") ) { 
					endflag = true; 
					break;
				}
			}
			System.out.print("클라이트의 접속을 종료합니다. ");
			System.exit( 0 );
		} catch(Exception e){  
			if(!endflag) {
				e.printStackTrace();
			}
		}
		finally{
        
			try{//시도하다.
				ois.close();               
				oos.close();              
				client.close();                               
				System.exit(0); 
                
			}catch(IOException e2){
				e2.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); //스캐너 입력
		System.out.print("아이디를 입력하세요 : ");//출력
		String id = sc.next();//입력 받기
		new MainClient(id, "192.168.30.3");
	}
}
