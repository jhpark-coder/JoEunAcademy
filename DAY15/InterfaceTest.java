package WEEK04.DAY15;

interface K{
    void abc();
}

interface R{
    void xxx();
}

class YOU implements K, R{

    @Override
    public void abc(){

    }

    @Override
    public void xxx(){

    }
}

interface Q extends K{
    void def();
}

abstract class Y implements Q{
    @Override
    public void def() {

    }
    abstract void kor();
}

class XXXO{

}

class XOR extends XXXO implements K,R{

    @Override
    public void abc(){

    }

    @Override
    public void xxx(){

    }
}

class KOR extends Y{

    @Override
    void kor(){

    }

    @Override
    public void abc(){

    }

}


public class InterfaceTest {
    public static void main(String[] args) {

    }
}
