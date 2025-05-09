package API;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

public class JSoupExample2 {
    public static void main(String[] args) throws IOException {
        String url = "https://sports.news.naver.com/index";
        Document document = Jsoup.connect(url).get();
        //HTML 문서에서 <div> 태그 바로 아래에 위치하면서, <strong> 태그이고 title 클래스를 가진 특정 제목 스타일의 요소들을 정확하게 찾아내기 위한 것입니다
        // 자식 결합자 '>'(주로 앞뒤로 공백넣어서 씀, 해당 녀석의 모든 자식(후손 전체)을 가져옴)
        Elements elements = document.select("div > strong.title");
        for(Element e : elements){
            System.out.println(e.text());
        }
    }
}
