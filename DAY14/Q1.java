package WEEK04.DAY14;

/*
오버라이딩 문제
공룡클래스가 있습니다.
공룡클래스는 키, 무게를 가지고 있고 나는 공룡이다를 외치는 함수가 있습니다.

티라노사우르스는 공룡을 상속받고 오버라이딩을 해서 "나는 키 2m 몸무게 1톤인 티라노사우르스다." 를 외치게 해주세요.
트리케라톱스는 공룡을 상속받고 오버라이딩을 해서 "나는 키 3m 몸무게 2톤인 트리케라톱스다." 를 외치게 해주세요.
부경사우르스는 공룡을 상속받고 오버라이딩을 해서 "나는 키 5m 몸무게 3톤인 부경사우르스다." 를 외치게 해주세요.

main문이 있는 클래스에서 static함수를 하나 만들어서 그 함수에서 외치는 함수가 호출이 되도록 구현을 해주세요.
(단 함수 인자도 하나만 받습니다. 그리고 3공룡을 외치게 하려면 main문에서 위의 함수를 3번 호출해주세요.)

 */

class Dinosaur{
    protected int height;
    protected int weight;

    Dinosaur(int height, int weight){
        this.height = height;
        this.weight = weight;

    }

    protected void cry(){
        System.out.println("나는 공룡이다.");
    }

}

class Tyrannosaurus extends Dinosaur{

    Tyrannosaurus(int height, int weight){
        super(height, weight);
        //this.height = height;
        //this.weight = weight;
    }

    @Override
    protected void cry(){
        System.out.println("나는 키 " + height + "m 몸무게 " + weight +"톤인 티라노사우르스다.");
    }

}


class Triceratops extends Dinosaur{

    Triceratops(int height, int weight){
        super(height, weight);
    }
    @Override
    protected void cry(){
        System.out.println("나는 키 " + height + "m 몸무게 " + weight +"톤인 트리케라톱스다.");
    }

}

class Pukyongsaurus extends Dinosaur{
    Pukyongsaurus(int height, int weight){
        super(height, weight);
    }

    @Override
    protected void cry(){
        System.out.println("나는 키 " + height + "m 몸무게 " + weight +"톤인 부경사우르스다.");
    }
}



public class Q1 {
    public static void main(String[] args) {

        Dinosaur d1 = new Tyrannosaurus(2,1);
        Dinosaur d2 = new Triceratops(3,2);
        Dinosaur d3 = new Pukyongsaurus(5,3);

        cry(d1);
        cry(d2);
        cry(d3);



        Tyrannosaurus ty = new Tyrannosaurus(2,1);
        Triceratops tr = new Triceratops(3,2);
        Pukyongsaurus pu = new Pukyongsaurus(5,3);

        cry(ty);
        cry(tr);
        cry(pu);


    }

    static void cry(Dinosaur d){
        d.cry();
    }

}
