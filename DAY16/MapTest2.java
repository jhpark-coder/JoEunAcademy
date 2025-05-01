package WEEK04.DAY16;

import java.util.HashMap;

class C{
    int k;
}

class D{
    String str;
}

public class MapTest2 {
    public static void main(String[] args) {
        HashMap<C, D> map = new HashMap<>();
        C c = new C();
        C c1 = new C();
        map.put(c,new D());
        System.out.println(map.get(c).str);
        //System.out.println(map.get(c1).str); // 에러
    }
}
