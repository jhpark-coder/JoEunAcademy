package API;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

/*
태그 : 특정 태그 모두 가져오기
태그.class : 특정 태그 내의 특정 클래스 가져오기
태그#id : 특정 태그내의 특정 id 가져오기
-> 태그는 그냥 씀 클래스는 앞에 점 찍음. id는 앞에 #붙임
요소1요소2 : 모든 자식 요소 가져오기
요소1>요소2: 바로 아래 나오는 자식 요소
요소[특성] : attribute가 있는 요소 가져오기 a[title] 이런식 문제조건이면 .s-talker a[title]
요소[특성=값] : 속성과 값이 일치하는 요소
요소[특성*=값] : ~가 들어가는
요소[특성$=값] : ~로 끝나는
요소[특성^=값] : ~로 시작하는
 */

public class JSoupExample1 {
    public static void main(String[] args) throws IOException {
        String url = "https://pann.nate.com/";

        Document document = Jsoup.connect(url).get();
        //System.out.println(document);

        /*
        //HTML 문서 내에서, 클래스 이름이 s-talker인 요소의 모든 자손 요소들 중에서 클래스 이름이 post_list인 요소들을 모두 선택하라는 의미.
        Elements elements = document.select(".s-talker .post_list");
        ArrayList<String> List = new ArrayList<>();

        // . class # id
        // 클래스 s-talker -> 클래스 post_list
        for(Element e : elements){
            //System.out.println(e.text());
            Elements elements1 = e.children(); // e.children() -> '>' 와 거의 동일한 역할을 함
            for(Element e1 : elements1){
                List.add(e1.text());
                System.out.println(e1.text());
            }
        }
        */

        Elements elements = document.select(".post_list#talkerChoiceArea0 a[title]");
        ArrayList<String> List = new ArrayList<>();

        for(Element e : elements){
            List.add(e.attr("title")); // e의 특정 속성(a 의 title속성)만 가져옴
            System.out.println(e.attr("title"));
        }
    }
}
