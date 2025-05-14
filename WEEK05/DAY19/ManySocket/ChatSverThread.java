package WEEK05.DAY19.ManySocket;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;

public class ChatSverThread implements Runnable
{
	Socket child; 
	BufferedReader ois; 
	PrintWriter oos; 

	String user_id; 
	HashMap<String, PrintWriter> hm; 
	InetAddress ip; 
	String msg; 

	public ChatSverThread(Socket s, HashMap<String, PrintWriter> h ) {
		child = s;
		hm = h;
		try	{
			ois = new BufferedReader(new InputStreamReader
					(child.getInputStream())); 
			// Client로 받는거
			oos = new PrintWriter( child.getOutputStream() );
            
			user_id = ois.readLine();
            
			ip = child.getInetAddress();
            
            
			System.out.println( ip + "로부터 " + user_id + "님이 접속하였습니다." );
			//출력 서버만 보는거고
			broadcast(user_id + "님이 접속하셨습니다."); // 일반 클라이언트
        
			synchronized( hm ) {
				hm.put( user_id, oos );
			}
		}

		catch (Exception e ) {
			e.printStackTrace();
		}

	}

	public void run() {
		String receiveData; 

		try
		{
			while( (receiveData = ois.readLine()) != null ) {
				if( receiveData.equals( "/quit" ) ) {
					synchronized( hm ) {
						hm.remove( user_id );
					}
					break;
				}
				
				else if( receiveData.indexOf( "/to" ) >= 0 ) {
					sendMsg( receiveData );
				}
				else {
					System.out.println(user_id + " >> " + receiveData );//출력
					broadcast( user_id + " >> " + receiveData );
				}

			}

		}

		catch (Exception e ) {
			e.printStackTrace();
		}

		finally {
			synchronized( hm ) {
				hm.remove( user_id );
			}
			broadcast( user_id + "님이 퇴장했습니다." );
			System.out.println( user_id + "님이 퇴장했습니다." );//출력

			try
			{
				if( child != null ) {              
					ois.close();                    
					oos.close();                   
					child.close();                   
				}
			}
			catch ( Exception e) {}//예외처리 발생시
		}
	}



	public void broadcast(String message){
		synchronized( hm ) {
			try{
				//향상된 포문
				// HashMap values 하면 
				for( PrintWriter oos : hm.values( )){
					oos.println( message ); 
					oos.flush();

				}
                
			}catch(Exception e){ }
		}
	}

	// /to 홍길동 안녕하세요.
	public void sendMsg(String message){
		int begin = message.indexOf(" ") + 1; 
		int end   = message.indexOf(" ", begin);

		if(end != -1){
			String id = message.substring(begin, end);
			String msg = message.substring(end+1);
			PrintWriter oos = hm.get(id);

			try{//시도하다
				if(oos != null){
					oos.println( user_id + "님이 다음과 같은 귓속말을 보내셨습니다. : " 
				+ msg );
					oos.flush();
				}

			}catch(Exception e)//예외처리가 발생하면 실행
			{ 

			}
		}
	}

}

