package WEEK03.DAY10;
/*

동물이 4마리가 있습니다.
동물은 원숭이, 개, 닭, 돼지가 있습니다.
동물들은 자기가 무슨 동물인지와 음식을 들고 있습니다.
(단, 그 정보는 함수를 통해서만 넣고 뺄수 있습니다 -> getset사용)

마지막으로 어떤 동물이 어떤 음식을 들고 있는지 출력하는 기능을 가지고 있습니다.


처음 먹이와 동물
원숭이 - 바나나
개 - 뼈다귀
닭 - 모이
돼지 - 여물
이렇게 들고 있는 것을 출력해줍니다.

그 후에 먹이를 옆동물에게 전달합니다.
원 -> 개 -> 닭 -> 돼지로 이동합니다.
(원 -> 개)
(개 -> 닭)
(닭 -> 돼)
(돼 -> 여)


 */

class Animal{

    String animalType; //동물 종류
    String food; // 음식

    Animal(String animalType, String food){
        setAnimalType(animalType);
        setFood(food);
    }

    void setAnimalType(String animalType) {
        this.animalType = animalType;
    }

    void setFood(String food) {
        this.food = food;
    }

    String getAnimalType() {
        return animalType;
    }

    String getFood() {
        return food;
    }

    void print(){
        System.out.println(getAnimalType()+" - "+getFood());
    }

}

public class Q4 {
    public static void main(String[] args) {


        Animal monkey = new Animal("원숭이","바나나");
        Animal dog = new Animal("개","뼈다귀");
        Animal chicken = new Animal("닭","모이");
        Animal pig = new Animal("돼지","여물");

        Animal[] aniArr = new Animal[4];
        aniArr[0] = monkey;
        aniArr[1] = dog;
        aniArr[2] = chicken;
        aniArr[3] = pig;

        /*
        monkey.print();
        dog.print();
        chicken.print();
        pig.print();
         */

        for(int i = 0 ; i < aniArr.length ; i++){
            aniArr[i].print();
        }

        System.out.println();


        /* // 바꾸는 순서까지 고려해서 적은거
        String temp1 = dog.getFood(); // 개 음식 임시저장
        dog.setFood(monkey.getFood());// 개에게 원숭이 음식(바나나)을 줌 => 개 = 바나나
        String temp2 = chicken.getFood(); // 닭 음식 임시저장
        chicken.setFood(temp1);// 닭에게 개 음식(뼈다귀)을 줌 => 닭 = 뼈다귀

        temp1 = pig.getFood(); //돼지 음식 임시저장
        pig.setFood(temp2); // 돼지한테 닭 음식(모이) 줌 => 닭 = 모이
        monkey.setFood(temp1); // 원숭이한테 돼지 음식(여물) 줌 => 원숭이 = 여물

        */
        /*
        //바꾸는 순서 무시하고 임시변수 하나로 줄인거
        String temp = monkey.getFood();
        monkey.setFood(pig.getFood());
        pig.setFood(chicken.getFood());
        chicken.setFood(dog.getFood());
        dog.setFood(temp);



        monkey.print(); // 여물
        dog.print(); // 바나나
        chicken.print(); // 뼈다귀
        pig.print(); // 모이
        */

        String temp = pig.getFood();
        for(int i = 3 ; i > 0 ; i--){
            aniArr[i].setFood(aniArr[i-1].getFood());
        }

        aniArr[0].setFood(temp);

        for(int i = 0 ; i < aniArr.length ; i++){
            aniArr[i].print();
        }

    }
}
