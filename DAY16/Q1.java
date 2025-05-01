package WEEK04.DAY16;

/*
누가 물을 가지고 있나?
물 : 수량 (private) -> get, set
사람 : 물 객체를 담을 수 있는 배열 -> get, set

메인문에

물 배열이 있고 그 안에는 객체가 30개 있습니다.
물 객체마다 수량을 랜덤으로 1~8까지 채웁니다

물 객체 10개씩 사람에게 줍니다

사람1, 사람2, 사람3

물을 가장 많이 가지고 있는 사람은?
1,2,3 이외 값 잘못된 입력입니다

제일 많이 마신 사람을 선택 못하면 다시 선택해주세요.

 */


import java.util.Random;
import java.util.Scanner;

class Water{
    private int quantity; // 양

    Water(int quantity){
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class Person{
    private Water[] waters;
    private int lastSavedIndex;

    Person(int size){
        waters = new Water[size];
        lastSavedIndex = 0;
    }

    public Water[] getWaters() {
        return waters;
    }

    public void setWaters(Water water) {
        waters[lastSavedIndex++] = water;

    }
}

public class Q1 {
    public static void main(String[] args) {

        Water[] waters = new Water[30];
        Random r = new Random();

        for(int i = 0 ; i < waters.length ; i++){
            waters[i] = new Water(r.nextInt(8)+1);
        }

        Person[] persons = new Person[3];
        for(int i = 0 ; i < persons.length ; i++){
            persons[i] = new Person(10);
        }

        for(int j = 0; j < persons.length ; j++){ // 몇번째 사람꺼인지 체크 (j 0 1 2)
            for(int k = 0 ; k < persons[j].getWaters().length; k++) { // 사람의 waters에 저장
                persons[j].setWaters(waters[j* persons.length + k]); //k = 0 ~ 9
            }
        }

        int[] Quantity = new int[persons.length];
        int index = 0;
        for(Person p : persons){
            for(Water w : p.getWaters()){
                Quantity[index] += w.getQuantity();
            }
            index++;
        }

        for(int num : Quantity){
            System.out.println(num);
        }

        int maxPeopleIndex = -1;
        int maxWater = 0;
        for(int i = 0 ; i < Quantity.length ; i++){
            if(maxWater < Quantity[i]){
                maxWater = Quantity[i];
                maxPeopleIndex = i;
            }
        }
        Scanner sc = new Scanner(System.in);

        while(true){
            System.out.print("물을 가장 많이 가진 사람은? : ");
            int num = sc.nextInt();
            if(num < 1 || num > 3){
                System.out.println("잘못된 입력입니다.");
            }else{
                if(num == maxPeopleIndex+1){
                    System.out.println("정답입니다.");
                    break;
                }else{
                    System.out.println("틀렸습니다.");
                }
            }
        }
    }
}
