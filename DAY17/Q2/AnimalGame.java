package WEEK04.DAY17.Q2;

import java.util.Random;

public class AnimalGame {

    String[] dogNames = {"말티즈", "요크셔테리어","포메라니안","시바","웰시코기"};
    String[] catNames = {"먼치킨", "스핑크스", "뱅갈", "샴", "폴드"};
    String[] birdNames = {"앵무새", "참새", "닭" ,"까마귀", "비둘기"};
    String[] animalColors = {"갈색", "검은색", "흰색", "노란색", "점박이"};
    Random r;
    Animal[] animals;

    AnimalGame(){
        r = new Random();
        animals = new Animal[6];
    }

    void startAnimalGame(){
        animals[0] = new Dog(dogNames[r.nextInt(dogNames.length)],animalColors[r.nextInt(animalColors.length)]);
        animals[1] = new Dog(dogNames[r.nextInt(dogNames.length)],animalColors[r.nextInt(animalColors.length)]);
        animals[2] = new Dog(dogNames[r.nextInt(dogNames.length)],animalColors[r.nextInt(animalColors.length)]);
        animals[3] = new Cat(catNames[r.nextInt(catNames.length)],animalColors[r.nextInt(animalColors.length)]);
        animals[4] = new Cat(catNames[r.nextInt(catNames.length)],animalColors[r.nextInt(animalColors.length)]);
        animals[5] = new Bird(birdNames[r.nextInt(birdNames.length)],animalColors[r.nextInt(animalColors.length)]);

        for(Animal a : animals){
            a.behavior();
        }

    }




}
