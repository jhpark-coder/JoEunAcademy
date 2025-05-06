package P20250504;

public class StringTest {
    public static void main(String[] args) {
        String s1 = "AAA";
        for(char c : s1.toCharArray()){
            System.out.print(c);
        }
        System.out.println();

        String s2 = "   BBB  ";
        s2=s2.trim(); // BBB 좌우 공백 제거
        System.out.println(s2);

        String s3 = "CCC";
        for(int i = 0 ; i < s3.length() ; i++){
            System.out.print(s3.charAt(i)); // i인덱스의 char 알려줌
        }
        System.out.println();

        String s4 = "DDD    EEE  FFF GGG";
        String[] s1s = s4.split("\\s+"); // '\s' 즉 공백기준으로 나눔, \\로 쓴건 정규식규칙 +는 1회 이상인 경우를 의미.
        for(String temp : s1s){
            System.out.println(temp);
        }

        String s5 = "ddd";

        if(s5.toLowerCase().equals(s5)){ // 모두 소문자로 바꾼게 s5와 같다면 = s5는 모두 소문자이다
            s5=s5.toUpperCase(); // 모두 소문자라면 대문자로 바꿔주고 그걸 s5에 줌
            System.out.println(s5); // s5를 출력
        }

        String s6 = "HhHHhhhHHH";
        String result="";
        for(char c : s6.toCharArray()){ // 문자열을 char[]로 바꾸어서 c에 하나씩 줌
            if(Character.isUpperCase(c)){ // 만약에 c가 대문자라면
                result+=Character.toLowerCase(c); // 소문자로 바꿈
            }else{
                result+=Character.toUpperCase(c); // 대문자가 아니라면 == 소문자라면 -> 대문자로 바꿔줌
            }
        }
        System.out.println(result);

        String s7 = "Hello World";
        s7=s7.replace('l','t');
        System.out.println(s7); // Hetto Wortd
        s7=s7.replaceAll("t","l");
        System.out.println(s7); // Hello World
        s7=s7.replaceFirst("l","t");
        System.out.println(s7); // Hetlo World

    }
}
