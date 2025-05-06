package P20250504.MartGame;

public class Refrigerator extends Product{

    private int size;

    Refrigerator(RefrigeratorType type){
        super(type.getBrandName(), type.getProductType(), type.getPrice() );
        this.size = type.getSize();
    }
    @Override
    public void useProduct(){
        System.out.println("제조사가 " + brand + "인 " + type +"형 " + toString() + "가 식품을 관리한다");
    }

    @Override
    public String toString() {
        return "냉장고";
    }
}
