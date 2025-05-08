package WEEK05.DAY19.ManySocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.Socket;

class ReceiveDataThread implements Runnable{
	Socket client; //Socket 변수 client 선언
	BufferedReader ois; // BufferReader 변수 ois 선언
	String receiveData; // 문자열 변수 receiveData 선언

	public ReceiveDataThread(Socket s, BufferedReader ois){ 
    //ReceiveDataThread 생성자 이고 Socket과 BufferReader을 인자로 받는다.
		client = s;
        //인자 s를 client에 대입
		this.ois = ois;
        //인자 ois를 인스턴스 변수 ois에 대입
	}

  public void run(){
  //받는게 없고 주지도 않는 run 함수
	try{//시도하다
		while( ( receiveData = ois.readLine() ) != null ) 
        //ois의 readLine 함수를 호출하여 문자열 한줄 씩을 receiveDate에 대입을 하면
        //receiveData가 null이 아니면 계속 반복
			System.out.println( receiveData );
            //receiveData 출력
		
	}catch(Exception e){//예외처리 발생시 실행
		e.printStackTrace();  //예외처리시 출력
    }
    finally{
    //위에 try catch 어떤상황이든 다끝나면 실행
		try{//시도하다.
            ois.close();
            //BufferReader 객체 ois close()
			client.close();
            //Socket 객체 client close()
		}catch(IOException e2){ //예외처리 발생시 실행(IOException 시)
			e2.printStackTrace();//예외처리 출력
		}
    }
  }
}