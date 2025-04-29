package WEEK04.DAY14;

/*
상어먹이게임

100개의 먹이가 배열로 존재합니다.(객체)
상어의 객체는 5마리 입니다.

그리고 main문에서 상어가 5마리가 먹을 수 있는 만큼 먹이 객체를 먹습니다.

그리고 상어가 먹이를 얼마나 잡아먹었는지 출력합니다.

 */

import java.util.Random;

//먹이 클래스(먹이 객체)
class Food{

}

//상어 클래스(상어 객체)

class Shark{

    int quantity; // 먹이 먹을 수 있는 양
    Food[] stomach;
    String name;


    //상어는 객체가 생성될 때 먹이를 먹을 수 있는 양이 정해집니다.(랜덤으로 8~14)
    Shark(String name, Random r){
        quantity = r.nextInt(7)+8;
        stomach = new Food[quantity]; // 먹을수 있는 크기만큼의 위 크기를 가짐
        this.name = name;
    }

    public int eatFood(Food[] foods, int foodsIndex){
        int count = 0;
        for(int i = 0 ; i < stomach.length; i++){ // 위의 용량만큼 먹음
                stomach[i] = foods[foodsIndex + i]; // 먹이가 위 속으로 이동
                foods[foodsIndex + i] = null; // 먹이 바구니에 있던 먹이는 없어짐
                count++;
        }
        print(name,count);
        return count; // 카운트만큼 먹었습니다.
    }

    private void print(String name, int count){
        System.out.println(name + "상어는 " + count + "마리만큼 잡아먹었습니다.");
    }



}

//상어 5마리가 먹이 객체를 먹음
//각각의 상어가 먹이를 얼마나 먹었는지 출력

public class Q2 {
    public static void main(String[] args) {

        Food[] foods = new Food[100]; // 100칸짜리 먹이배열 선언
        for(int i = 0 ; i < foods.length ; i++){ // 먹이배열에 먹이 가득 채움
            foods[i] = new Food();
        }

        Random r = new Random();

        Shark[] sharks = new Shark[5]; // 상어 5마리 배열 선언
        for(int i = 0 ; i < sharks.length ; i++){ // 상어 5마리 만듬
            sharks[i] = new Shark(i+1+"",r);
        }

        int foodindex = 0;
        for(int i = 0 ; i < sharks.length ; i++){
            foodindex += sharks[i].eatFood(foods,foodindex);
        }

        System.out.println("현재 잡아먹은 먹이수 : "+foodindex);
        System.out.println("현재 남은 먹이수 : "+ (foods.length - foodindex));


        int foodCount = 0; // 먹이배열이 빈게 맞는지 확인
        for(int i = 0 ; i < foods.length ; i++){
            if(foods[i] == null){
                foodCount++;
            }
        }
        System.out.println("FoodCount : " + foodCount);


        int stomachCount = 0; // 상어들 뱃속이 차있는지 확인
        for(int i = 0 ; i < sharks.length ; i++){ // 상어 수만큼 루프
            for(int j = 0 ; j <sharks[i].quantity ; j++) { // 각각 상어의 위용량만큼 루프
                if (sharks[i].stomach[j] != null) {  // 해당 상어의 위 index가 차있다면
                    stomachCount++; // 카운트 더해줌
                }
            }
        }
        System.out.println("stomachCount : " + stomachCount);


    }
}
