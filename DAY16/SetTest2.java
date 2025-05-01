package WEEK04.DAY16;

import java.util.HashSet;
import java.util.Iterator;

public class SetTest2 {
    public static void main(String[] args) {
        HashSet<A> hashSet = new HashSet<>();

        A a1 = new A(5,6);
        //A a1 = new A(7,8);


        hashSet.add(new A(5,6));
        hashSet.add(a1);
        Iterator<A> it = hashSet.iterator();
        int num = 1;
        while(it.hasNext()){
            A a = it.next();
            if( a == a1){
                System.out.println(num + "번째에 있습니다.");
            }
            num++;
        }
    }
}
