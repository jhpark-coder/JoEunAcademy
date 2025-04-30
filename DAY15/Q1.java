package WEEK04.DAY15;

/*
클래스 형변환 문제
동물 : 색깔, 기능(abstract)
강아지 : 오버라이딩 기능(나는 + 색깔 + 강아지 입니다.);
고양이 : 오버라이딩 기능(나는 + 색깔 + 고양이 입니다.);
미어캣 : 오버라이딩 기능(나는 + 색깔 + 미어캣 입니다.);
판다 : 오버라이딩 기능(나는 + 색깔 + 판다 입니다.);

색깔은 빨,주,노,초,파,남,보 총 7가지

동물 우리에는 총 10마리가 들어갈 수 있습니다.

랜덤을 통해 색깔과 동물을 우리 안에 넣어주세요.

색깔 0~6 / 동물 0~3까지 랜덤을 통해 동물 우리 안에 넣어주세요.

동물 우리 안에 동물이 다 들어가면 각각의 동물의 기능을 호출해주세요.

 */

import java.util.Random;

abstract class Animal{
    protected String color;
    abstract void introduceMyself();
    Animal(String color){
        this.color = color;
    }
}

class Dog extends Animal{

    Dog(String color){
        super(color);
    }
    @Override
    public void introduceMyself(){
        System.out.println("나는 " + super.color + " 강아지 입니다.");
    }
}
class Cat extends Animal{

    Cat(String color){
        super(color);
    }
    @Override
    public void introduceMyself(){
        System.out.println("나는 " + super.color + " 고양이 입니다.");
    }
}
class Meerkat extends Animal{

    Meerkat(String color){
        super(color);
    }
    @Override
    public void introduceMyself(){
        System.out.println("나는 " + super.color + " 미어캣 입니다.");
    }
}
class Panda extends Animal{

    Panda(String color){
        super(color);
    }
    @Override
    public void introduceMyself(){
        System.out.println("나는 " + super.color + " 판다 입니다.");
    }
}

class Cage{ // 동물 우리

    private int countAnimal = 0; // 마지막에 우리에 넣은 우리 인덱스
    private Animal[] animals; // 우리에는 여러마리 동물이 있을 수 있음

    Cage(int num){
        animals = new Animal[num]; // 입력받은 값만큼 우리의 크기가 결정됨
    }

    public void inputAnimal(Animal animal){ // 동물 집어넣기
        if(animals[countAnimal] == null){ //
            animals[countAnimal++] = animal;
        }else{
            System.out.println("동물을 집어넣는데 실패했습니다.");
        }
    }

    public Animal[] getAnimals(){ //동물 우리에 어떤 동물 있는지 받아오기
        return animals;
    }

}



public class Q1 {
    public static void main(String[] args) {
        String[] colors = {"빨강색","주황색","노랑색","초록색","파랑색","남색","보라색"};
        Cage cage = new Cage(10); // 10칸짜리 케이지 만들기
        Random r = new Random(); // 랜덤 쓸거라서 랜덤객체 선언

        for(int i = 0 ; i < cage.getAnimals().length ; i++){ // 케이지 크기만큼 돔
            int r1 = r.nextInt(7); // color
            int r2 = r.nextInt(4); // 동물종류

            Animal animal = createAnimal(colors[r1], r2); // 동물 색과, 동물 종류에 맞게 새로운 동물 하나 만들어줌
            cage.inputAnimal(animal); // 우리에 방금 생성한 동물 하나 넣어줌. 마지막에 넣은곳보다 하나 뒤에
        }

        for(int i = 0 ; i < cage.getAnimals().length ; i++){ // 동물들의 자기소개하기
            cage.getAnimals()[i].introduceMyself();
        }
    }


    static Animal createAnimal(String color, int kind){ // 개던 고양이던 미어캣이던 판다던 원하는 색에 맞춰 리턴해줌
        if(kind == 0){
            return new Dog(color);
        }else if(kind == 1){
            return new Cat(color);
        }else if(kind == 2){
            return new Meerkat(color);
        }else{
            return new Panda(color);
        }
    }
}
