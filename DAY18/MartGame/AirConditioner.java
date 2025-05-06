package P20250504.MartGame;

public class AirConditioner extends Product{

    AirConditioner(AirConditionerType type){
        super(type.getBrandName(), type.getProductType(), type.getPrice() );
    }
    @Override
    public void useProduct(){
        System.out.println("제조사가 " + brand + "인 " + type + " " +toString() + "을 사용한다");
    }

    @Override
    public String toString() {
        return "에어컨";
    }
}
