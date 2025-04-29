package WEEK04.DAY14;

/*
문제: 로봇 창고 관리 시스템
시나리오:
당신은 최첨단 로봇 창고 관리 시스템을 개발하고 있습니다. 이 창고에는 다양한 종류의 상품(Item)들이 선반(Shelf)에 보관되어 있으며, 운반 로봇(Robot)들이 상품을 지정된 선반으로 옮기거나 외부로 반출하는 작업을 수행합니다.
요구사항:
Item 클래스 (상품 - 부모 클래스):
itemId (상품 고유 ID, String)
name (상품명, String)
volume (상품 부피, int)
생성자를 통해 위 필드들을 초기화합니다.
displayInfo() 메서드: 상품의 기본 정보(ID, 이름, 부피)를 출력합니다. (오버라이딩 대상)
출력 예: [ID: I-001] 상품명: 일반상자, 부피: 10
Item을 상속받는 구체적인 상품 클래스 (IS-A 관계):
FragileItem (파손주의 상품):
packingMaterial (포장재 종류, String) 필드를 추가로 가집니다.
생성자에서 부모 생성자를 호출하고 packingMaterial도 초기화합니다.
displayInfo() 메서드를 오버라이딩하여 포장재 정보도 함께 출력합니다.
출력 예: [ID: F-001] 상품명: 유리컵세트, 부피: 5 (파손주의: 뽁뽁이 포장)
TemperatureSensitiveItem (온도민감 상품):
requiredTemp (요구 온도, int) 필드를 추가로 가집니다.
생성자에서 부모 생성자를 호출하고 requiredTemp도 초기화합니다.
displayInfo() 메서드를 오버라이딩하여 요구 온도 정보도 함께 출력합니다.
출력 예: [ID: T-001] 상품명: 아이스크림, 부피: 8 (보관온도: -18도)
Shelf 클래스 (선반 - HAS-A 관계):
shelfId (선반 ID, String)
maxCapacity (최대 적재 가능 부피, int)
items (선반에 보관된 상품들, Item[] 배열) - HAS-A 관계
currentItemCount (현재 보관된 상품 개수, int)
currentTotalVolume (현재 적재된 총 부피, int)
생성자에서 shelfId, maxCapacity를 받고, items 배열을 maxCapacity 크기만큼은 아니고, 적절한 크기(예: 10개)로 초기화합니다. currentItemCount와 currentTotalVolume은 0으로 초기화합니다.
addItem(Item item) 메서드:
선반에 상품을 추가합니다.
조건문: 추가하려는 상품의 volume과 현재 currentTotalVolume의 합이 maxCapacity를 초과하지 않고, currentItemCount가 배열 크기를 넘지 않는지 확인합니다.
성공 시 items 배열에 상품을 추가하고, currentItemCount와 currentTotalVolume을 업데이트 후 true 반환.
실패 시 (공간 부족 또는 배열 꽉 참) 메시지 출력 후 false 반환.
removeItem(String itemId) 메서드:
itemId에 해당하는 상품을 선반에서 찾아 제거합니다.
반복문을 사용하여 items 배열을 탐색합니다.
상품을 찾으면 배열에서 제거(해당 인덱스를 null로 만들고 뒤의 요소들을 당겨오는 방식 또는 다른 방식 사용 가능)하고, currentItemCount와 currentTotalVolume을 업데이트 후 해당 Item 객체 반환.
상품을 찾지 못하면 null 반환.
displayItems() 메서드:
반복문을 사용하여 선반에 있는 모든 상품들의 displayInfo() 메서드를 호출하여 출력합니다. (다형성 확인)
현재 적재된 총 부피와 남은 용량도 출력합니다.
Robot 클래스 (운반 로봇):
robotId (로봇 ID, String)
currentItem (현재 로봇이 들고 있는 상품, Item) - HAS-A 관계 (하나만 들 수 있다고 가정)
생성자에서 robotId를 초기화하고 currentItem은 null로 설정합니다.
pickUpItem(Shelf shelf, String itemId) 메서드:
지정된 shelf에서 itemId에 해당하는 상품을 집어듭니다.
조건문: 로봇이 이미 다른 상품(currentItem != null)을 들고 있는지 확인합니다. 들고 있다면 실패 메시지 출력.
shelf.removeItem(itemId)를 호출하여 상품을 가져옵니다.
성공적으로 가져왔다면(null이 아니라면) currentItem에 할당하고 성공 메시지 출력.
실패했다면 (선반에 상품이 없거나 로봇이 이미 물건을 들고 있다면) 실패 메시지 출력.
placeItem(Shelf shelf) 메서드:
로봇이 들고 있는 상품(currentItem)을 지정된 shelf에 내려놓습니다.
조건문: 로봇이 상품을 들고 있는지 (currentItem != null) 확인합니다. 없다면 실패 메시지 출력.
shelf.addItem(currentItem)을 호출하여 상품을 선반에 추가합니다.
성공적으로 추가했다면 currentItem을 null로 만들고 성공 메시지 출력.
실패했다면 (선반 공간 부족 등) 실패 메시지 출력 (상품은 계속 들고 있음).
displayStatus() 메서드: 로봇 ID와 현재 들고 있는 상품 정보(currentItem이 null이 아니면 currentItem.displayInfo() 호출)를 출력합니다.
WarehouseManager 클래스 (main 메서드 포함):
main 메서드에서 다음 시나리오를 구현합니다.
여러 개의 Shelf 객체를 생성합니다. (ID와 용량 지정)
다양한 종류의 Item 객체들(FragileItem, TemperatureSensitiveItem 포함)을 생성합니다.
생성된 상품들을 초기 위치로 몇몇 Shelf에 addItem 메서드를 이용해 배치합니다. (초기 재고 설정)
Robot 객체를 생성합니다.
시뮬레이션:
특정 선반의 모든 상품 정보를 출력 (shelf.displayItems()).
로봇이 특정 선반에서 특정 상품을 집도록 합니다 (robot.pickUpItem()).
로봇의 현재 상태를 출력 (robot.displayStatus()).
로봇이 집은 상품을 다른 선반에 내려놓도록 합니다 (robot.placeItem()).
상품이 이동된 후 양쪽 선반의 상태와 로봇의 상태를 다시 출력하여 확인합니다.
배열, 반복문, 조건문을 활용하여 위 과정들을 여러 번 수행하거나, 특정 조건(예: 특정 상품 찾아서 옮기기)을 만족하는 동작을 구현해볼 수 있습니다.
핵심 평가 요소:
IS-A 관계 (Item 상속 구조)와 HAS-A 관계 (Shelf가 Item 배열을, Robot이 Item을 가짐)를 올바르게 구현했는가?
배열을 사용하여 여러 객체(선반의 상품들)를 관리하는가?
반복문을 적절히 사용하여 배열 탐색 및 정보 출력을 수행하는가?
조건문을 사용하여 로직의 분기(공간 확인, 상품 유무 확인 등)를 처리하는가?
메서드 오버라이딩(displayInfo)을 통해 각 객체 타입에 맞는 동작을 구현했는가?
객체 간의 상호작용(Robot이 Shelf에서 Item을 가져오고 놓는 동작)을 메서드 호출로 구현했는가? (객체 이동 개념)
다형성이 shelf.displayItems() 등에서 잘 활용되는가?
이 문제는 클래스 설계, 상속, 포함 관계, 배열 처리, 제어문, 오버라이딩, 객체 간 상호작용 등 여러 개념을 종합적으로 요구합니다. 도전해보세요!

 */

class Item{
    protected String itemId; // 상품 고유 ID
    protected String name; // 상품명
    protected int volume; // 상품 부피

    Item(String itemId, String name, int volume){
        this.itemId = itemId;
        this.name = name;
        this.volume = volume;
    }

    public void displayInfo(){
        System.out.printf("[ID : %s] 상품명 : %s, 부피 : %d\n",itemId,name,volume);
    }


}

class FragileItem extends Item{

    private String packingMaterial;

    FragileItem(String itemId, String name, int volume, String packingMaterial){
        super(itemId,name,volume);
        this.packingMaterial = packingMaterial;
    }

    @Override
    public void displayInfo(){
        System.out.printf("[ID : %s] 상품명 : %s, 부피 : %d (파손주의: %s 포장)\n",itemId,name,volume,packingMaterial);
    }

}

class TemperatureSensitiveItem extends Item{

    private int requiredTemp; //요구 온도

    TemperatureSensitiveItem(String itemId, String name, int volume, int requiredTemp){
        super(itemId,name,volume);
        this.requiredTemp = requiredTemp;
    }

    @Override
    public void displayInfo(){
        System.out.printf("[ID : %s] 상품명 : %s, 부피 : %d (보관온도: %d도)\n",itemId,name,volume,requiredTemp);
    }
}


class Shelf{
    private String shelfId; // 선반 ID
    private int maxCapacity; // 최대 적재 가능 부피
    private Item[] items;
    private int currentItemCount;
    private int currentTotalVolume;

    Shelf(String shelfId, int maxCapacity){
        this.shelfId = shelfId;
        this.maxCapacity = maxCapacity;
        items = new Item[maxCapacity/2];
        currentItemCount = 0;
        currentTotalVolume = 0;
    }

    public boolean addItem(Item item){
        //선반에 상품 추가
        if( (item.volume + currentTotalVolume) <= maxCapacity && currentItemCount < items.length)
        {
            items[currentItemCount] = item;
            currentItemCount++;
            currentTotalVolume+=item.volume;
            return true;
        }else{
            System.out.println("공간이 부족하거나 배열이 가득 찼습니다.");
            return false;
        }
    }

    public Item removeItem(String itemId){
        for(int i = 0 ; i < items.length ; i++){
            if(items[i].itemId.equals(itemId)){
                currentItemCount--;
                currentTotalVolume-=items[i].volume;
                Item item = items[i];
                items[i] = null;
                return item;
            }
        }
        return null;
    }
    public void displayItems(){
        for(int i = 0 ; i < items.length ; i++){
            items[i].displayInfo();
            System.out.println("총 용량 : " + maxCapacity + "남은 용량 : " + (maxCapacity - currentTotalVolume) );
        }
    }
}

class Robot{
    String robotId;
    Item currentItem;

    Robot(String robotId){
        this.robotId = robotId;
        currentItem = null;
    }

    public void pickUpItem(Shelf shelf, String itemId){
        if(currentItem != null){ //손이 차있는 경우
            System.out.println("이미 물건을 들고 있어 새로운 물건을 드는데 실패했습니다.");
        }else{ // 손이 비어있는 경우
            Item item = shelf.removeItem(itemId); // 리무브해서 그걸 넣어줌
            if(item != null){ // 리무브결과값이 널이 아니면 넣어줌
                currentItem = item;
                System.out.println("성공적으로 물건을 들었습니다.");
            }else {//손은 비어있지만 결과값이 널인 경우 = 상품이 없는 경우
                System.out.println("선반에 상품이 없어서 물건을 드는데 실패했습니다.");
            }
        }
    }

    public void placeItem(Shelf shelf){
        if(currentItem != null) { //손이 차있는 경우 실행
            boolean addCheck = shelf.addItem(currentItem);
            if(addCheck){
                currentItem = null;
            }else{
                System.out.println("물건을 내려 놓는데 실패했습니다.");
            }
        }else {//아닌경우 실패
            System.out.println("손에 들고 있는 물건이 없어 내려놓는데 실패했습니다.");
        }
    }

    public void displayStatus(){
        if(robotId != null && currentItem != null){
            currentItem.displayInfo();
        }
    }
}


public class WarehouseManager {
    public static void main(String[] args) {

        Shelf[] shelves = new Shelf[3];

    }
}
