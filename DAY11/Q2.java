package WEEK03.DAY11;

/*
A 2개 - B 2개 - A 1개 - B  - 1개 A - 2개 B - 2개
-> 필통의 갯수만큼 구매가능함

 학생 두명. 학생객체 필요

 문방구 하나 문방구 객체필요.

 색연필 객체 필요
 지우개 객체 필요
 펜 객체 필요

 A학생의 필통 : 색연필 2개, 지우개 1개, 펜 2개
 B학생의 필통 : 색연필 2개, 지우개 1개, 펜 2개

물건의 거래(객체의 이동)는 문방구 클래스의 문방구 객체에서 이루어져야함.
문방구(stationaryStore)
purchace 메소드

학생(student)
학생객체에서 할지
학생의 필통객체에서 할지.
필통에 들어가는 갯수가 같으므로 필통클래스를 따로 만들어도 될듯.

필통(pencilCase) -> 학생의 속성이 아니라, 학생이 필통이라는 객체를 가지고 있으므로 필통객체를 만드는게 바람직해보임

 */

import java.util.Scanner;

class ColoredPencil{ //색연필 객체
    String color;
    ColoredPencil(String color){
        this.color = color;
    }
}

class Eraser{ // 지우개 객체
    String color;
    Eraser(String color){
        this.color = color;
    }
}

class Pen{ // 펜 객체
    String color;
    Pen(String color){
        this.color = color;
    }
}

class PencilCase{ // 필통 객체
    ColoredPencil[] cps;// 색연필 가질 공간이 있음
    Eraser[] es;// 지우개 1개를 가질 공간이 있음
    Pen[] ps;// 펜 2개를 가질 공간이 있음

    PencilCase(){
        cps = new ColoredPencil[2]; // 색연필 2개를 가질 공간이 있음(초기값은 null)
        es = new Eraser[1]; // 지우개 1개를 가질 공간이 있음(초기값은 null)
        ps = new Pen[2]; // 펜 2개를 가질 공간이 있음(초기값은 null)
    }

    void setCps(ColoredPencil cp, int i) {
        cps[i] = new ColoredPencil(cp.color);
    }

    void setEs(Eraser e, int i) {
        es[i] = new Eraser(e.color);
    }
    void setPs(Pen p, int i) {
        ps[i] = new Pen(p.color);
    }
}

class Student{ // 학생 객체
    PencilCase pc;
    String name;

    Student(String name){
        pc = new PencilCase();
        this.name = name;
    }

    void buyStudentColoredPencil(Student s, ColoredPencil cp){
        int i;
        for(i = 0 ; i < s.pc.cps.length ; i++){
            if(s.pc.cps[i] == null){
                break;
            }
        }
        s.pc.setCps(cp,i); // 학생의 필통의 i번째 색연필을 받아서 채움(구매)
        //System.out.printf("학생의 필통의 i번째 색연필을 채움\n");
    }

    void buyStudentEraser(Student s, Eraser e){
        int i;
        for(i = 0 ; i < s.pc.es.length ; i++){
            if(s.pc.es[i] == null){
                break;
            }
        }
        //System.out.printf("i : %d",i);
        s.pc.setEs(e,i); // 학생의 필통의 i번째 지우개를 받아서 채움(구매)
        //s.pc.es[i] = e; // 학생의 필통의 i번째 지우개를 받아서 채움(구매)
    }

    void buyStudentPen(Student s, Pen p){
        int i;
        for(i = 0 ; i < s.pc.ps.length ; i++){
            if(s.pc.ps[i] == null){
                break;
            }
        }
        s.pc.setPs(p,i); // 학생의 필통의 i번째 펜을 받아서 채움(구매)
        //s.pc.ps[i] = p; // 학생의 필통의 i번째 펜을 받아서 채움(구매)
    }
}

class StationaryStore{ // 문방구 객체
    //거래가 일어나는 장소

    ColoredPencil[] cps; // 문방구가 가질 수 있는 색연필 객체배열
    Eraser[] es; // 문방구가 가질 수 있는 지우개 객체배열
    Pen[] ps; //문방구가 가질 수 있는 펜 객체배열
    //int[] countProduct; // 마지막으로 팔린 색연필/지우개/펜의 인덱스
    String[] cpString = {"주황색","초록색","노랑색","파랑색"};
    String[] erString = {"회색","빨간색"};
    String[] penString = {"주황색","초록색","노랑색","파랑색"};
    Scanner sc;

    StationaryStore(){//문방구는 처음에 색연필 객체 4개, 지우개 객체 2개, 펜 객체 4개를 가지고 있음
        cps = new ColoredPencil[4]; // 문방구는 색연필 객체 4개를 가질 수 있다(배열만 만들었으므로 초기값은 null)
        setCp(); // 4개의 객체를 만들어줌
        es = new Eraser[2]; // 문방구는 지우개 객체 2개를 가질 수 있다(배열만 만들었으므로 초기값은 null)
        setEraser(); // 2개의 객체를 만들어줌
        ps = new Pen[4]; // 문방구는 펜 객체 4개를 가질 수 있다(배열만 만들었으므로 초기값은 null)
        setPen(); // 4개의 객체를 만들어줌
        //countProduct = new int[]{4, 2, 4}; // 처음에 가진 갯수
        //cpString = new String[] {"주황색","초록색","노랑색","파랑색"};
        //erString = new String[] {"회색","빨간색"};
        //penString = new String[] {"주황색","초록색","노랑색","파랑색"};
        sc = new Scanner(System.in);
    }

    void setCp(){ // 문방구의 색연필 객체 초기화(처음에 4개 가지고 있음)

       for(int i = 0 ; i < cpString.length ; i++){ // 문방구가 가질 수 있는 만큼(4개) 넣어줌
           cps[i] = new ColoredPencil(cpString[i]);
           //System.out.println(cps[i].color);
       }
    }
    void setEraser() { // 문방구의 지우개 객체 초기화(처음에 2개 가지고 있음)
        for(int i = 0 ; i < erString.length ; i++){ // 문방구가 가질 수 있는 만큼(2개) 넣어줌
            es[i] = new Eraser(erString[i]);
            //System.out.println(es[i].color);
        }
    }

    void setPen() { // 문방구의 펜 객체 초기화(처음에 4개 가지고 있음)
        for(int i = 0 ; i < penString.length ; i++){ // 문방구가 가질 수 있는 만큼(4개) 넣어줌
            ps[i] = new Pen(penString[i]);
            //System.out.println(ps[i].color);
        }
    }

    void wrongInput(){
        System.out.println("잘못된 입력입니다.");
    }

    void soldInput(){
        System.out.println("이미 팔렸습니다.");
    }

    int checkCorrectInput(String prompt, int checkType) { // 뭘 사려는지 입력함
        //잘못된 입력(아예 다른 글자)
        System.out.println(prompt); // xx학생 xx색깔 골라주세요.
        while(sc.hasNext()){
            String str = sc.next(); //사려는 색깔
            boolean checkAllList = false; // 입력한 값이 몇번 인덱스에 있었는지 확인용
            if(checkType == 1){ // 색연필 체크
                for(int i = 0 ; i < cpString.length ; i++){
                    if(str.equals(cpString[i])){
                        checkAllList = true;
                        break;
                    }
                }// -> 여기에 해당하면 있는거임 안해당하면 없는거임
                if(checkAllList){ // 해당하면 전체목록에는 있음
                    for(int i = 0 ; i < cps.length; i++){
                        //System.out.println(cps[i].color);
                        if(cps[i] != null && cps[i].color.equals(str)){ // 여기 있으면 남아있는거임
                            //System.out.println("여기지나감");
                            return i;
                        }
                    }
                    soldInput(); //for문동안 return 못했으면 이미 팔린거임

                }else{
                    wrongInput();
                }
            }else if(checkType == 2){ // 지우개 체크
                for(int i = 0 ; i < erString.length ; i++){
                    if(str.equals(erString[i])){
                        checkAllList = true;
                        break;
                    }
                }// -> 여기에 해당하면 있는거임 안해당하면 없는거임
                if(checkAllList){ // 해당하면 전체목록에는 있음
                    for(int i = 0 ; i < es.length; i++){
                        if(es[i] != null && es[i].color.equals(str)){ // 여기 있으면 남아있는거임
                            return i;
                        }
                    }
                    soldInput(); //for문동안 return 못했으면 이미 팔린거임

                }else{
                    wrongInput();
                }
            }else { // 펜 체크
                for (int i = 0; i < penString.length; i++) {
                    if (str.equals(penString[i])) {
                        checkAllList = true;
                        break;
                    }
                }// -> 여기에 해당하면 있는거임 안해당하면 없는거임
                if (checkAllList) { // 해당하면 전체목록에는 있음
                    for (int i = 0; i < ps.length; i++) {
                        if (ps[i] != null && ps[i].color.equals(str)) { // 여기 있으면 남아있는거임
                            return i;
                        }
                    }
                    soldInput(); //for문동안 return 못했으면 이미 팔린거임
                } else {
                    wrongInput();
                }
            }
        }
        return 0;
    }
    //거래기능을 통해 학생에게 색연필, 지우개, 펜을 건네줌

    void sellColoredPencil(Student st){ //
        for(int i = 0 ; i < st.pc.cps.length; i++){ // i는 학생의 필통크기만큼 돔(0 , 1)
            int num = checkCorrectInput(st.name+"학생 색연필 색깔 골라주세요",1);
            st.buyStudentColoredPencil(st, cps[num]);
            cps[num] = null; // 팔렸음
            //countProduct[0]--;
        }
    }


    void sellEraser(Student st){ //
        for(int i = 0 ; i < st.pc.es.length; i++){ // i는 학생의 필통크기만큼 돔(0)
            int num = checkCorrectInput(st.name+"학생 지우개 색깔 골라주세요",2);
            st.buyStudentEraser(st, es[num]);
            es[num] = null; // 팔렸음
            //countProduct[1]--;
        }
    }

    void sellPen(Student st){ //
        for(int i = 0 ; i < st.pc.ps.length; i++){ // i는 학생의 필통크기만큼 돔(0 , 1)
            int num = checkCorrectInput(st.name+"학생 펜 색깔 골라주세요",3);
            st.buyStudentPen(st, ps[num]);
            ps[num] = null; // 팔렸음
            //countProduct[2]--;
        }
    }

    void tradeInStationary(){ //문방구 내에서의 거래
        Student st1 = new Student("A");
        Student st2 = new Student("B");
        showStationaryShopProduct(1);
        sellColoredPencil(st1);
        sellColoredPencil(st2);
        showStationaryShopProduct(2);
        sellEraser(st1);
        sellEraser(st2);
        showStationaryShopProduct(3);
        sellPen(st1);
        sellPen(st2);
        showStationaryShopProduct(4);
        showStudentPencilCase(st1);
        showStudentPencilCase(st2);
    }
    void showStationaryShopProduct(int num){
        switch(num){
            case 1:
                System.out.print("색연필의 색 종류 : ");
                for(int i = 0 ; i < cps.length ; i++)
                {
                    System.out.print(cps[i].color+"\t");
                }
                System.out.println();
                break;
            case 2:
                System.out.print("지우개의 색 종류 : ");
                for(int i = 0 ; i < es.length ; i++)
                {
                    System.out.print(es[i].color+"\t");
                }
                System.out.println();
                break;
            case 3:
                System.out.print("펜의 색 종류 : ");
                for(int i = 0 ; i < ps.length ; i++)
                {
                    System.out.print(ps[i].color+"\t");
                }
                System.out.println();
                break;
            default:
                System.out.println("다 팔렸습니다.");
                break;
        }
    }

    void showStudentPencilCase(Student s){
        System.out.print(s.name+"학생의 색연필 : ");
        for(int i = 0 ; i < s.pc.cps.length ; i++){
            System.out.print(s.pc.cps[i].color+"\t");
        }
        System.out.println();
        System.out.print(s.name+"학생의 지우개 : ");
        for(int i = 0 ; i < s.pc.es.length ; i++){
            System.out.print(s.pc.es[i].color+"\t");
        }
        System.out.println();
        System.out.print(s.name+"학생의 펜 : ");
        for(int i = 0 ; i < s.pc.ps.length ; i++){
            System.out.print(s.pc.ps[i].color+"\t");
        }
        System.out.println();
    }
}

public class Q2 {
    public static void main(String[] args) {
        StationaryStore ss = new StationaryStore();
        ss.tradeInStationary();
    }
}
