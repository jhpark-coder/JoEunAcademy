package WEEK03.DAY09;

/*
연필, 지우개, 펜이 있습니다.
연필은 각각 빨강,파랑, 주황, 노란색을 가지고 있습니다.
연필은 쓰는 기능(출력)이 있습니다.
쓰는 기능은 빨간색 연필로 적습니다.(출력)

지우개는 각각 잠자리, 모닝글로리의 제조사가 있습니다.
지우개는 지우는 기능(출력)이 있습니다.
ex) 지우개를 잠자리의 제품으로 지웁니다.(출력)

펜은 검정색 - 모나미 / 초록 - 제트스트림 / 베이비블루 - 워터맨틀을 가지고 있습니다.
펜은 쓰는 기능(출력)이 있습니다.
ex) 펜을 모나미 제품의 검정색으로 씁니다(출력)
먼저 4개의 연필을 쓰고 그다음 2개의 지우개로 지우고
마지막으로 3개의 펜을 쓰는 프로그램을 만들어주세요.

 */

class Pencil{
    String color;

    void usePencil(){
        System.out.println(color+"색 연필로 적습니다.");
    }
}

class Eraser{
    String brand;

    void useEraser(){
        System.out.println("지우개를 "+brand+"의 제품으로 지웁니다.");
    }
}
class Pen{
    String color;
    String brand;

    void usePen(){
        System.out.println("펜을 "+brand+"제품의 "+color+"색으로 씁니다.");
    }
}

public class Q4 {
    public static void main(String[] args) {

        //4개의 연필 쓰기
        Pencil pc1 = new Pencil();
        pc1.color = "빨강";
        Pencil pc2 = new Pencil();
        pc2.color = "파랑";
        Pencil pc3 = new Pencil();
        pc3.color = "주황";
        Pencil pc4 = new Pencil();
        pc4.color = "노랑";
        pc1.usePencil();
        pc2.usePencil();
        pc3.usePencil();
        pc4.usePencil();

        //2개의 지우개 지우기
        Eraser e1 = new Eraser();
        e1.brand = "잠자리";
        Eraser e2 = new Eraser();
        e2.brand = "모닝글로리";
        e1.useEraser();
        e2.useEraser();

        //3개의 펜 쓰기
        Pen p1 = new Pen();
        p1.color = "검정";
        p1.brand = "모나미";
        Pen p2 = new Pen();
        p2.color = "초록";
        p2.brand = "제트스트림";
        Pen p3 = new Pen();
        p3.color = "베이비블루";
        p3.brand = "워터맨틀";

        p1.usePen();
        p2.usePen();
        p3.usePen();


    }
}
