package WEEK03.DAY12;


class D{}

public class ObjectArrayMethodTest {

    static D[] sendD(D[][] d, int i , int j){
        d[i][j] = new D();
        return d[i];
    }


    public static void main(String[] args) {
        D[][] d1 = new D[3][3];
        D[] d2 = sendD(d1, 0, 2);

        //d1 = 3 * 3크기 2차원 D배열객체(값은 null)
        //d2 = D형 1차원배열 = send( 2차원배열을 받고 0, 2)를 받음
        // d2[0][2] = new D();
        // d[0] -> d2;

        //
    }
}
