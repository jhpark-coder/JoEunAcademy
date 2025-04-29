package WEEK04.DAY14;

/* 구글 gemini산 문제 1

상속과 오버라이딩 활용 문제: 차량 렌탈 비용 계산
문제 설명:
다양한 종류의 차량을 렌탈해주는 가게가 있습니다. 각 차량은 기본 렌탈 비용 계산 방식이 있지만, 차종에 따라 약간의 차이가 있을 수 있습니다. 상속과 메서드 오버라이딩을 사용하여 각 차량의 렌탈 비용을 계산하고 출력하는 프로그램을 작성하세요.
요구사항:
Vehicle 클래스 정의 (부모 클래스):
모든 차량의 기본이 되는 Vehicle 클래스를 만듭니다. (추상 클래스가 아님)
modelName (차량 모델명, String) 필드를 가집니다.
rentalPricePerDay (하루 렌탈 비용, int) 필드를 가집니다.
modelName과 rentalPricePerDay를 초기화하는 생성자를 가집니다.
getModelName(), getRentalPricePerDay() 메서드를 통해 필드 값을 반환할 수 있습니다.
calculateRentalCost(int days) 메서드를 정의합니다.
이 메서드는 기본적으로 rentalPricePerDay * days를 계산하여 정수 비용을 반환합니다.
비용을 반환하기 전에 "[모델명]" 기본 렌탈 비용: [계산된 비용]원 형식으로 콘솔에 출력합니다.
Vehicle 클래스를 상속받는 구체적인 차량 클래스 정의:
Car 클래스와 Bicycle 클래스를 Vehicle을 상속받아 구현합니다.
각 클래스는 부모 클래스의 생성자를 호출하여 자신의 modelName과 rentalPricePerDay를 설정해야 합니다. (super() 사용)
각 클래스는 calculateRentalCost(int days) 메서드를 **오버라이딩(Override)**하여 자신만의 방식으로 비용을 계산하고 출력하도록 수정합니다.
Car:
rentalPricePerDay * days를 계산합니다.
출력 메시지를 "[모델명]" 자동차 렌탈 비용: [계산된 비용]원 (보험료 포함) 으로 변경합니다.
계산된 비용을 반환합니다.
Bicycle:
rentalPricePerDay * days를 계산합니다.
출력 메시지를 "[모델명]" 자전거 렌탈 비용: [계산된 비용]원 (헬멧 대여 포함) 으로 변경합니다.
계산된 비용을 반환합니다.
(@Override 어노테이션 사용 권장)
RentalShop 클래스 (main 메서드 포함):
main 메서드에서 다음을 수행합니다.
Car 객체와 Bicycle 객체를 각각 하나 이상 생성합니다. (모델명, 가격은 자유롭게 지정)
이 객체들을 Vehicle 타입의 배열 또는 ArrayList<Vehicle>에 저장합니다. (다형성 활용)
렌탈할 일수(예: int rentalDays = 3;)를 정합니다.
반복문을 사용하여 배열(또는 리스트)에 있는 모든 Vehicle 객체들을 순회합니다.
각 Vehicle 객체에 대해 calculateRentalCost(rentalDays) 메서드를 호출합니다.
(다형성 덕분에 각 객체의 실제 타입에 맞는 오버라이딩된 calculateRentalCost() 메서드가 호출되어야 합니다.)
실행 예시 (rentalDays = 3 일 때):
소나타 자동차 렌탈 비용: 150000원 (보험료 포함)
따릉이 자전거 렌탈 비용: 30000원 (헬멧 대여 포함)
(만약 더 많은 차량을 추가했다면 해당 차량의 계산 결과도 출력)
Use code with caution.
핵심 평가 요소:
Vehicle 부모 클래스를 올바르게 정의했는가? (추상 클래스가 아님, 기본 메서드 구현 포함)
Car, Bicycle 클래스가 Vehicle을 제대로 상속하고 생성자를 구현했는가? (super() 활용)
각 차량 클래스가 calculateRentalCost() 메서드를 @Override하여 요구사항에 맞게 동작을 변경했는가?
main 메서드에서 Vehicle 타입의 배열/리스트를 사용하여 다양한 차량 객체를 관리하는가? (다형성)
반복문 내에서 Vehicle 타입 변수를 통해 calculateRentalCost()를 호출했을 때, 각 객체의 실제 타입에 맞는 오버라이딩된 메서드가 실행되는가?


 */

class Vehicle{
    protected String modelName;
    protected int rentalPricePerDay;

    Vehicle(String modelName, int rentalPricePerDay){
        this.modelName = modelName;
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public String getModelName() {
        return modelName;
    }

    public int getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public int calculateRentalCost(int days){
        int result = rentalPricePerDay * days;
        System.out.printf("[%s] 기본 렌탈 비용 : [%d]원\n",modelName,result);
        return result;
    }

}

class Car extends Vehicle{

    Car(String modelName, int rentalPricePerDay){
        super(modelName, rentalPricePerDay);
    }

    @Override
    public int calculateRentalCost(int days){
        int result = rentalPricePerDay * days;
        System.out.printf("[%s] 자동차 렌탈 비용 : [%d]원 (보험료 포함)\n",modelName,result);
        return result;
    }


}

class Bicycle extends Vehicle{

    Bicycle(String modelName, int rentalPricePerDay){
        super(modelName, rentalPricePerDay);
    }

    @Override
    public int calculateRentalCost(int days){
        int result = rentalPricePerDay * days;
        System.out.printf("[%s] 자전거 렌탈 비용 : [%d]원 (헬멧 대여 포함)\n",modelName,result);
        return result;
    }

}




public class RentalShop {
    public static void main(String[] args) {

        Vehicle[] vehicles = new Vehicle[4];
        vehicles[0] = new Car("아반떼",50000);
        vehicles[1] = new Car("소나타",30000);
        vehicles[2] = new Bicycle("삼천리 기본형",10000);
        vehicles[3] = new Bicycle("알톤 기본형",8000);

        int rentalDays = 3;

        for( int i = 0 ; i < vehicles.length ; i++){
            vehicles[i].calculateRentalCost(rentalDays);
        }


    }
}
