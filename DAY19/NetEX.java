package WEEK05.DAY19;

import java.net.InetAddress;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class NetEX {
    public static void main(String[] args) throws UnknownHostException, MalformedURLException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println("로컬의 컴퓨터 이름 : " + address.getHostName());
        System.out.println("로컬 컴퓨터의 IP 주소 : " + address.getHostAddress());
        InetAddress[] all = InetAddress.getAllByName("www.naver.com");
        for(int i = 0 ; i < all.length ; i++){
            System.out.println(all[i]);
        }
        URL starbucks = new URL("https://www.starbucks.co.kr/index.do");

        System.out.println("프로토콜 : " +starbucks.getProtocol());
        System.out.println("포트 : " + starbucks.getPort());
        System.out.println("호스트 : " + starbucks.getHost());
        System.out.println("파일(경로포함) : " +starbucks.getFile());
        System.out.println("전체 URL : " + starbucks.toExternalForm());
    }
}
