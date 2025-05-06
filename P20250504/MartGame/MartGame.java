package P20250504.MartGame;

import java.util.Scanner;

public class MartGame {

    private final int CONSUMER_NUMBER = 3;
    Scanner sc;
    private Consumer[] consumers;

    private final int SELECT_COMPUTER = 1;
    private final int SELECT_AIRCONDITIONER = 2;
    private final int SELECT_REFRIGERATOR = 3;
    private final int SELECT_AIRCLEANER = 4;


    public void startGame(){

        Mart mart = new Mart();
        mart.openMart();
        sc = new Scanner(System.in);
        createConsumers(sc);
        int turn = 0;
        int count = 0;
        boolean checkbuy;
        while(mart.getProducts().size() > 0 && ( isEnoughMoney(consumers[0],mart) || isEnoughMoney(consumers[1],mart) ||
                isEnoughMoney(consumers[2],mart)) ){
            System.out.println("========================="+(turn+1)+"번째 구매 ============================");
            mart.showMartProuducts();
            checkbuy = false;
            if(isEnoughMoney(consumers[turn % CONSUMER_NUMBER],mart)){
                while(!checkbuy) {
                    checkbuy = purchaseProducts(mart, consumers[turn % CONSUMER_NUMBER]);
                }
                turn++;
            }else if(isEnoughMoney(consumers[(turn+1) % CONSUMER_NUMBER],mart)) {
                while(!checkbuy) {
                    checkbuy = purchaseProducts(mart, consumers[(turn + 1) % CONSUMER_NUMBER]);
                }
                turn++;
            }else{
                while(!checkbuy) {
                    checkbuy =  purchaseProducts(mart, consumers[(turn + 2) % CONSUMER_NUMBER]);
                }
                turn++;
            }
        }

        for(Consumer c : consumers){
            c.showMyProducts();
        }

    }

    public void createConsumers(Scanner sc){
        consumers = new Consumer[CONSUMER_NUMBER];

        for(int i = 0 ; i < CONSUMER_NUMBER ; i++){
            System.out.print((i+1)+"번째 손님의 돈을 입력해주세요 : ");
            consumers[i] = new Consumer((i+1)+"번 손님", Integer.parseInt(sc.nextLine()) );
        }
    }

    public boolean attemptPurchase(Mart m, Consumer c, Product p){
        if(!m.getProducts().contains(p)){
            System.out.println("원하시는 상품의 재고가 부족합니다");
            return false;
        }
        if(c.getMoney() < p.price){
            System.out.println("잔액이 부족합니다.");
            return false;
        }

        int productIndex = m.getProducts().indexOf(p); // 가게에 몇 번째꺼인지 확인
        c.getPurchasedProducts().add(m.getProducts().get(productIndex)); // 손님한테 물건 줌
        c.setMoney(c.getMoney() - m.getProducts().get(productIndex).price); // 손님 돈 줄어듬
        System.out.println(c.getName()+"현재 구매 갯수 : "+c.getPurchasedProducts().size()+" 잔액 : "+c.getMoney());
        m.getProducts().remove(productIndex); // 가게에서 물건 뺌
        return true;
    }

    public boolean purchaseProducts(Mart m, Consumer c){
        int productType = inputInnerNumber(c.getName() + " 원하시는 상품을 입력해주세요 1. 컴퓨터 2. 에어컨 3. 냉장고 4. 공기청정기 : ",
                sc, SELECT_COMPUTER, SELECT_AIRCLEANER);
        if(productType == SELECT_COMPUTER){
            int productBrand = inputInnerNumber(c.getName() + " 제조사 및 사양을 선택해주세요 1.삼성(i7), 2.LG(i5) : ",sc,1,2);
            if(productBrand == 1){
                // 삼성 컴퓨터 구매
                return attemptPurchase(m, c, new Computer(ComputerType.SAMSUNG_COMPUTER) );
            }else{
                // LG 컴퓨터 구매
                return attemptPurchase(m, c, new Computer(ComputerType.LG_COMPUTER) );
            }
        }else if(productType == SELECT_AIRCONDITIONER){
            int productBrand = inputInnerNumber(c.getName() + " 제조사 및 사양을 선택해주세요 1.삼성(벽걸이), 2.LG(스탠드) : ",sc,1,2);
            if(productBrand == 1){
                // 삼성 에어컨 구매
                return attemptPurchase(m, c, new AirConditioner(AirConditionerType.SAMSUNG_AIRCONDITIONER) );
            }else{
                // LG 에어컨 구매
                return attemptPurchase(m, c, new AirConditioner(AirConditionerType.LG_AIRCONDITIONER) );
            }
        }else if(productType == SELECT_REFRIGERATOR){

            int productBrand = inputInnerNumber(c.getName() + " 제조사 및 사양을 선택해주세요 1.삼성(양문형,600L), 2.LG(4도어,800L) : ",sc,1,2);
            if(productBrand == 1){
                // 삼성 에어컨 구매
                return attemptPurchase(m, c, new Refrigerator(RefrigeratorType.SAMSUNG_REFRIGERATOR) );
            }else{
                // LG 에어컨 구매
                return attemptPurchase(m, c, new Refrigerator(RefrigeratorType.LG_REFRIGERATOR) );
            }

        }else{
            int productBrand = inputInnerNumber(c.getName() + " 제조사 및 사양을 선택해주세요 1.LG, 2.다이슨 : ",sc,1,2);
            if(productBrand == 1){
                // LG 공기청정기 구매
                return attemptPurchase(m, c, new AirCleaner(AirCleanerType.LG_AIRCLEANER) );
            }else{
                // 다이슨 공기청정기 구매
                return attemptPurchase(m, c, new AirCleaner(AirCleanerType.DYSON_AIRCLEANER) );
            }
        }
    }

    public int inputInnerNumber(String prompt, Scanner sc, int min, int max) {
        while(true) {
            System.out.print(prompt);
            if(sc.hasNext()) {
                if(sc.hasNextInt()){
                    int num = Integer.parseInt(sc.nextLine());
                    if (num >= min && num <= max) {
                        return num;
                    }else{
                        System.out.println(min+" 이상"+max+" 이하의 올바른 정수를 입력해주세요");
                    }
                }else{
                    System.out.println("올바른 정수를 입력해주세요");
                    sc.nextLine();
                }
            }
        }
    }

    public boolean isEnoughMoney(Consumer c, Mart m){
        if(c.getMoney() >= m.getMinPrice()) {
            return true;
        }else{
            return false;
        }
    }
}
