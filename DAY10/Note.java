package WEEK03.DAY10;

class AA{
    int a;
    String str;
    BB b;
}
class BB{
    int k;
}

class CC{
    BB b = new BB();
}


public class Note {
    public static void main(String[] args) {
        AA a = new AA();
        CC c = new CC();
        c.b.k = 5;
    }

}
