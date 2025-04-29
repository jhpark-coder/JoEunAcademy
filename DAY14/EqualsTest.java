package WEEK04.DAY14;

class C3{}

/*

객체 비교 일때는 == 과 equals가 같다
문자열의 equals와는 다르다(문자열은 다른 문자배열변수지만 값을 비교함)
 */

public class EqualsTest {
    public static void main(String[] args) {
        C3 c = new C3();
        C3 c1 = new C3();
        System.out.println(c == c1);
        System.out.println(c.equals(c1));

        C3 c2 = new C3();
        C3 c3 = c2;
        System.out.println(c2 == c3);
        System.out.println(c2.equals(c3));
    }
}
