package P20250504.MartGame;

public class Computer extends Product{



    Computer(ComputerType type){
        super(type.getBrandName(), type.getCpuType(), type.getPrice() );
    }
    @Override
    public void useProduct(){
        System.out.println("제조사가 " + brand + "인 " + type + " " + toString() + "를 사용한다");
    }

    @Override
    public String toString() {
        return "컴퓨터";
    }




}
