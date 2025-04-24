
package WEEK03.DAY12;

/*
마트 게임
마트에는 컴퓨터, 에어컨, 냉장고, 공기청정기가 각각 10대씩 있습니다.
컴퓨터 5대는 삼성, cpu i7, 200입니다.
컴퓨터 5대는 LG, CPU i5, 150입니다.
(사용기능, 예 : "제조사가 " + 삼성 + "인 " + i7 + "컴퓨터를 사용한다.")

에어컨 5대는 제조사는 삼성, 에어컨 종류 벽걸이, 가격은 100입니다.
에어컨 5대는 제조사는 LG, 에어컨 종류 스탠드, 가격은 250입니다.
(시작기능 : 예: "제조사가 " + 삼성 + "인 " + 벽걸이 +"에어컨을 사용한다")

냉장고 5대는 제조사는 삼성, 냉장고 문은 양문, 크기는 600L, 가격은 200
냉장고 5대는 제조사는 LG, 냉장고 문은 4도어, 크기는 800L, 가격은 350
시작기능(예 : "제조사가 " + 삼성 + "인 " 양문 + "형 " + 600L + "냉장고가 식품을 관리한다")

공기청정기 5대는 제조사는 LG, 가격은 80
공기청정기 5대는 제조사는 다이슨, 가격은 60
시작기능(예 : "제조사가 " + LG + "인 " + "공기청정기가 공기를 깨끗하게 한다"

소비자는 돈을 가지고 있고 물건들을 살 수 있습니다. (기능 X)


마트게임 시작
소비자는 총 3명이 있습니다.
소비자에게는 각각의 돈을 입력받아서 각자의 돈이 입력됩니다.

1번째 소비자 :
2번째 소비자 :

1번 입력시
"제조사 및 사양을 선택해주세요.
1. 삼성(i7) 2. LG(i5)

1~3번 순서대로 사다가(사면 남은돈이 나옴, 돈이 부족하면 돈 부족하다고 알려주고 다시 입력하게 함)
(돈이 없는 사람은 건너뜀)

 */

import java.util.Scanner;

class Computer{
    String brand;
    String cpu;
    int price;
    Computer(String brand, String cpu, int price){
        this.brand = brand;
        this.cpu = cpu;
        this.price = price;
    }
}

class AirConditioner{
    String brand;
    String purpose;
    int price;
    AirConditioner(String brand, String purpose, int price){
        this.brand = brand;
        this.purpose = purpose;
        this.price = price;
    }

}

class Refrigerator{
    String brand;
    String door;
    int price;
    Refrigerator(String brand, String door, int price){
        this.brand = brand;
        this.door = door;
        this.price = price;
    }

}

class AirCleaner{
    String brand;
    int price;
    AirCleaner(String brand, int price){
        this.brand = brand;
        this.price = price;
    }
}

class Customer{
    int money;
    Computer[] computers = new Computer[10];
    AirConditioner[] airConditioners = new AirConditioner[10];
    Refrigerator[] refrigerators = new Refrigerator[10];
    AirCleaner[] airCleaners = new AirCleaner[10];
    Customer(int money){
        this.money = money;
    }
}

class Mart{
    Computer[] computers = new Computer[10];
    AirConditioner[] airConditioners = new AirConditioner[10];
    Refrigerator[] refrigerators = new Refrigerator[10];
    AirCleaner[] airCleaners = new AirCleaner[10];
    String[][] comStrArr = {{"삼성","i7"},{"LG","i5"}};
    int[] comPriceArr = {200, 150};
    String[][] airConStrArr = {{"삼성","벽걸이"},{"LG","스탠드"}};
    int[] airConPriceArr = {100, 250};
    String[][] refriStrArr = {{"삼성","양문"},{"LG","4도어"}};
    int[] refriPriceArr = {200, 350};
    String[] airCleanStrArr = {"LG","다이슨"};
    int[] airCleanPriceArr = {80, 60};
    int[][] stockProducts;

    Mart(){
        stockProducts = new int[4][2]; //0으로 초기화
        setComputers(comStrArr, comPriceArr);
        setAirConditioners(airConStrArr, airConPriceArr);
        setRefrigerators(refriStrArr, refriPriceArr);
        setAirCleaners(airCleanStrArr, airCleanPriceArr);
    }

    void printMart(){

        for(int i = 0 ; i <computers.length; i++){
            System.out.printf("%s, %s %d\n",computers[i].brand,computers[i].cpu,computers[i].price);
        }
        for(int i = 0 ; i <airConditioners.length; i++){
            System.out.printf("%s, %s %d\n",airConditioners[i].brand,airConditioners[i].purpose,airConditioners[i].price);
        }
        for(int i = 0 ; i <refrigerators.length; i++){
            System.out.printf("%s, %s %d\n",refrigerators[i].brand,refrigerators[i].door,refrigerators[i].price);
        }
        for(int i = 0 ; i <airCleaners.length; i++){
            System.out.printf("%s, %d\n",airCleaners[i].brand,airCleaners[i].price);
        }

    }

    public void setComputers(String[][] strArr, int[] intArr) {
        int i;
        for(i = 0 ; i < computers.length; i++){
            if(i < computers.length / 2) {
                computers[i] = new Computer(strArr[0][0], strArr[0][1], intArr[0]);
                stockProducts[0][0]++;
            }else{
                computers[i] = new Computer(strArr[1][0], strArr[1][1], intArr[1]);
                stockProducts[0][1]++;
            }
        }
    }

    public void setAirConditioners(String[][] strArr, int[] intArr) {
        int i;
        for(i = 0 ; i < airConditioners.length; i++){
            if(i < airConditioners.length / 2) {
                airConditioners[i] = new AirConditioner(strArr[0][0], strArr[0][1], intArr[0]);
                stockProducts[1][0]++;
            }else{
                airConditioners[i] = new AirConditioner(strArr[1][0], strArr[1][1], intArr[1]);
                stockProducts[1][1]++;
            }
        }
    }

    public void setRefrigerators(String[][] strArr, int[] intArr) {
        int i;
        for(i = 0 ; i < refrigerators.length; i++){
            if(i < refrigerators.length / 2) {
                refrigerators[i] = new Refrigerator(strArr[0][0], strArr[0][1], intArr[0]);
                stockProducts[2][0]++;
            }else{
                refrigerators[i] = new Refrigerator(strArr[1][0], strArr[1][1], intArr[1]);
                stockProducts[2][1]++;
            }
        }
    }

    public void setAirCleaners(String[] strArr, int[] intArr) {
        int i;
        for(i = 0 ; i < airCleaners.length; i++){
            if(i < airCleaners.length / 2) {
                airCleaners[i] = new AirCleaner(strArr[0], intArr[0]);
                stockProducts[3][0]++;
            }else{
                airCleaners[i] = new AirCleaner(strArr[1], intArr[1]);
                stockProducts[3][1]++;
            }
        }
    }
}

class MartGame{

    Customer[] customers;
    Scanner sc = new Scanner(System.in);

    void startGame(){
        Mart m = new Mart(); // 마트 개장
         // 스캐너 객체 열고
        setCustomers(sc); // 손님 받음
        int flagTemp1;
        int flagTemp2;
        boolean[] checkmoney = {true,true,true};

        while(checkmoney[0] || checkmoney[1] || checkmoney[2]){ // 돈 남은 손님이 존재하면 계속 받음
            for(int i = 0 ; i < customers.length ; i++){ // 손님한테 한번씩 물어보기
                //손님 돈이 없으면 건너뜀
                boolean checkBuy = true;
                if(customers[i].money >= 60) { // 손님이 돈 있는 경우만
                    //아니라면 물어봄
                    while(checkBuy) {
                        System.out.print((i + 1) + "번 소비자 상품을 선택해주세요 1. 컴퓨터, 2.에어컨, 3.냉장고, 4.공기청정기 : ");
                        flagTemp1 = inputValidNumber(sc, 1, 4);
                        //1-> 컴퓨터 2-> 에어컨 3-> 냉장고 4-> 공기청정기
                        flagTemp2 = whatModel(m, flagTemp1, sc);
                        //살 수 있는지 체크 살 수 있으면 입력 못사면 다시 입력하게 함
                        //샀으면 다음 아니면 다시
                        checkBuy = canYouBuyIt(m, customers[i],i+1, flagTemp1,flagTemp2);
                        //1-1 or 1-2시 가격과 손님의 남은 돈 비교하고 넘겨줌
                    }
                }else checkmoney[i] = false;
            }

        }

        sc.close(); //입력 종료
    }

    boolean canYouBuyIt(Mart m, Customer c, int i, int temp1, int temp2){
        if(temp1 == 1){// 첫번째 컴퓨터
            if(temp2 == 1){
                if(m.stockProducts[0][0] == 0 ){
                    System.out.println("재고가 부족합니다.");
                    return true;
                }
                else
                {   if((c.money >= m.comPriceArr[0])) {
                    c.money -= m.comPriceArr[0];
                    c.computers[m.stockProducts[0][0] - 1] = m.computers[m.stockProducts[0][0] - 1];
                    m.computers[m.stockProducts[0][0] - 1] = null;
                    m.stockProducts[0][0]--;
                    System.out.println(m.comStrArr[0][0] + "컴퓨터를 샀습니다." + i + "번 손님의 남은 돈 : " + c.money);
                    }else {
                    System.out.printf("고객님의 돈은 %s 상품의 가격은 %s 이므로 돈이 부족합니다.",c.money,m.comPriceArr[0]);
                    return true;
                }
                }
            }else{ // 두번째 컴퓨터
                if(m.stockProducts[0][1] == 0 ){
                    System.out.println("재고가 부족합니다.");
                    return true;
                }
                else {
                    if (c.money >= m.comPriceArr[1]) {
                        c.money -= m.comPriceArr[1];
                        c.computers[m.stockProducts[0][1] - 1] = m.computers[m.stockProducts[0][1] - 1];
                        m.computers[m.stockProducts[0][1] - 1] = null;
                        m.stockProducts[0][1]--;
                        System.out.println(m.comStrArr[1][0] + "컴퓨터를 샀습니다." + i + "번 손님의 남은 돈 : " + c.money);
                    }else {
                        System.out.printf("고객님의 돈은 %s 상품의 가격은 %s 이므로 돈이 부족합니다.",c.money,m.comPriceArr[1]);
                        return true;
                    }
                }

            }
        }else if(temp1 == 2){
            if(temp2 == 1){ // 첫번째 에어컨
                if(m.stockProducts[1][0] == 0 ){
                    System.out.println("재고가 부족합니다.");
                    return true;
                }
                else {
                    if (c.money >= m.airConPriceArr[0]) {
                        c.money -= m.airConPriceArr[0];
                        c.airConditioners[m.stockProducts[1][0] - 1] = m.airConditioners[m.stockProducts[1][0] - 1];
                        m.airConditioners[m.stockProducts[1][0] - 1] = null;
                        m.stockProducts[1][0]--;
                        System.out.println(m.airConStrArr[0][0] + "에어컨을 샀습니다." + i + "번 손님의 남은 돈 : " + c.money);
                    }else {
                        System.out.printf("고객님의 돈은 %s 상품의 가격은 %s 이므로 돈이 부족합니다.",c.money,m.airConPriceArr[0]);
                        return true;
                    }
                }

            }else{//두번째 에어컨
                if(m.stockProducts[1][1] == 0 ){
                    System.out.println("재고가 부족합니다.");
                    return true;
                }
                else {
                    if (c.money >= m.airConPriceArr[1]) {
                        c.money -= m.airConPriceArr[1];
                        c.airConditioners[m.stockProducts[1][1] - 1] = m.airConditioners[m.stockProducts[1][1] - 1];
                        m.airConditioners[m.stockProducts[1][1] - 1] = null;
                        m.stockProducts[1][1]--;
                        System.out.println(m.airConStrArr[1][0] + "에어컨을 샀습니다." + i + "번 손님의 남은 돈 : " + c.money);
                    }else {
                        System.out.printf("고객님의 돈은 %s 상품의 가격은 %s 이므로 돈이 부족합니다.",c.money,m.airConPriceArr[1]);
                        return true;
                    }
                }
            }

        }else if(temp1 == 3) {
            if (temp2 == 1) { //첫번째 냉장고
                if(m.stockProducts[2][0] == 0 ){
                    System.out.println("재고가 부족합니다.");
                    return true;
                }
                else {
                    if (c.money >= m.refriPriceArr[0]) {
                        c.money -= m.refriPriceArr[0];
                        c.refrigerators[m.stockProducts[2][0] - 1] = m.refrigerators[m.stockProducts[2][0] - 1];
                        m.refrigerators[m.stockProducts[2][0] - 1] = null;
                        m.stockProducts[2][0]--;
                        System.out.println(m.refriStrArr[0][0] + "냉장고를 샀습니다." + i + "번 손님의 남은 돈 : " + c.money);
                    }else {
                        System.out.printf("고객님의 돈은 %s 상품의 가격은 %s 이므로 돈이 부족합니다.",c.money,m.refriPriceArr[0]);
                        return true;
                    }
                }

            } else { // 두번째 냉장고
                if(m.stockProducts[2][1] == 0 ){
                    System.out.println("재고가 부족합니다.");
                    return true;
                }
                else {
                    if (c.money >= m.refriPriceArr[1]) {
                        c.money -= m.refriPriceArr[1];
                        c.refrigerators[m.stockProducts[2][1] - 1] = m.refrigerators[m.stockProducts[2][1] - 1];
                        m.refrigerators[m.stockProducts[2][1] - 1] = null;
                        m.stockProducts[2][1]--;
                        System.out.println(m.refriStrArr[1][0] + "냉장고를 샀습니다." + i + "번 손님의 남은 돈 : " + c.money);
                    }else {
                        System.out.printf("고객님의 돈은 %s 상품의 가격은 %s 이므로 돈이 부족합니다.",c.money,m.refriPriceArr[1]);
                        return true;
                    }
                }

            }
        }else{
            if(temp2 == 1){//첫번째 공기청정기
                if(m.stockProducts[3][0] == 0 ){
                    System.out.println("재고가 부족합니다.");
                    return true;
                }
                else {
                    if (c.money >= m.airCleanPriceArr[0]) {
                        c.money -= m.airCleanPriceArr[0];
                        c.airCleaners[m.stockProducts[3][0] - 1] = m.airCleaners[m.stockProducts[3][0] - 1];
                        m.airCleaners[m.stockProducts[3][0] - 1] = null;
                        m.stockProducts[3][0]--;
                        System.out.println(m.airCleanStrArr[0] + "공기청정기를 샀습니다." + i + "번 손님의 남은 돈 : " + c.money);
                    }else {
                        System.out.printf("고객님의 돈은 %s 상품의 가격은 %s 이므로 돈이 부족합니다.",c.money,m.airCleanPriceArr[0]);
                        return true;
                    }
                }

            }else{ //두번째 공기청정기
                if(m.stockProducts[3][1] == 0 ){
                    System.out.println("재고가 부족합니다.");
                    return true;
                }
                else {
                    if (c.money >= m.airCleanPriceArr[1]) {
                        c.money -= m.airCleanPriceArr[1];
                        c.airCleaners[m.stockProducts[3][1] - 1] = m.airCleaners[m.stockProducts[3][1] - 1];
                        m.airCleaners[m.stockProducts[3][1] - 1] = null;
                        m.stockProducts[3][1]--;
                        System.out.println(m.airCleanStrArr[1] + "공기청정기를 샀습니다." + i + "번 손님의 남은 돈 : " + c.money);
                    }else {
                        System.out.printf("고객님의 돈은 %s 상품의 가격은 %s 이므로 돈이 부족합니다.",c.money,m.airCleanPriceArr[1]);
                        return true;
                    }
                }
            }
        }
        //살 수 있다면
        //객체를 넘겨주면서 돈을 깎음
        //못 사면 다시 입력하게 함 => boolean true으로 리턴해서 계속 돌게하면 됨
        return false;
    }

    public int inputValidNumber(Scanner sc, int min, int max) {
        int num;
        while(true){
            if(sc.hasNext()) {
                num = sc.nextInt();
                if (num >= min && num <= max) {
                    return num;
                } else {
                    System.out.println("올바른 값을 입력해주세요");
                }
            }
        }
    }

    MartGame(){
        customers = new Customer[3]; // 손님 받을수 있는 공간 마련
    }

    void setCustomers(Scanner sc){
        for(int i = 0; i < 3 ; i++){ //3명
            System.out.printf("%d번째 소비자의 돈 : ",i+1); // 손님 총예산 받음
            customers[i] = new Customer(sc.nextInt());
        }
    }

    int whatModel(Mart m, int flag, Scanner sc){
        if(flag == 1){
            //컴퓨터 브랜드 고르기
            System.out.print("제조사 및 사양을 선택해주세요. ");
            System.out.printf("1. %s(%s) 2. %s(%s) : ",m.comStrArr[0][0],m.comStrArr[0][1],m.comStrArr[1][0],m.comStrArr[1][1]);
        }else if(flag == 2){
            //에어컨 브랜드 고르기
            System.out.print("제조사 및 사양을 선택해주세요. ");
            System.out.printf("1. %s(%s) 2. %s(%s) : ",m.airConStrArr[0][0],m.airConStrArr[0][1],m.airConStrArr[1][0],m.airConStrArr[1][1]);

        }else if(flag == 3){
            //냉장고 브랜드 고르기
            System.out.print("제조사 및 사양을 선택해주세요. ");
            System.out.printf("1. %s(%s) 2. %s(%s) : ",m.refriStrArr[0][0],m.refriStrArr[0][1],m.refriStrArr[1][0],m.refriStrArr[1][1]);

        }else{//4
            //공기청정기 브랜드 고르기
            System.out.print("제조사 및 사양을 선택해주세요. ");
            System.out.printf("1. %s 2. %s : ",m.airCleanStrArr[0],m.airCleanStrArr[1]);
        }

        return inputValidNumber(sc, 1, 2);
    }


//              1번째 소비자 :
//            2번째 소비자 :
//
//            1번 입력시
//"제조사 및 사양을 선택해주세요.
//        1. 삼성(i7) 2. LG(i5)
//
//1~3번 순서대로 사다가(사면 남은돈이 나옴, 돈이 부족하면 돈 부족하다고 알려주고 다시 입력하게 함)
//(돈이 없는 사람은 건너뜀)


}

public class Q3 {
    public static void main(String[] args) {

        MartGame mg = new MartGame();
        mg.startGame();

    }
}
