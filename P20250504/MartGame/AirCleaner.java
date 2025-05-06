package P20250504.MartGame;

public class AirCleaner extends Product{

    AirCleaner(AirCleanerType type){
        super(type.getBrandName(), type.getPrice() );
    }
    @Override
    public void useProduct(){
        System.out.println("제조사가 " + brand + "인 " + toString() + "가 공기를 깨끗하게 한다");
    }

    @Override
    public String toString() {
        return "공기청정기";
    }
}
