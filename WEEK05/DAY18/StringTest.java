package WEEK05.DAY18;

public class StringTest {
    public static void main(String[] args) {
        String str = "hello";
        System.out.println(str.length()); // 문자열 길이를 알려줌
        String str1 = "홍길동\t\t010\t\t인천시";
        String[] array = str1.split("\t\t"); // \t\t기준으로 문자열을 잘라서 문자열 배열에 데이터를 전달

        //잘린 문자열 담은 배열 출력
        for(String s : array){
            System.out.println(s);
        }

        String str2 = "<앵커> 무인함정 10년 라이벌 LIG넥스원과 한화시스템이 선박 건조 역량 확보를 위해 각각 HD현대중공업, 한화오션과 손을 잡으며 하반기 수주 대전을 예고하고 있습니다.\n" +
                "\n" +
                "육해공 첨단 무기를 한눈에 볼 수 있는 이순신방위산업전(YIDEX)이 지난 24일부터 경남 창원에서 열리고 있는데 이들의 신경전이 대단하다고 합니다. \n" +
                "\n";



    }
}
