package P20250504.MartGame;

public enum ComputerType {

    SAMSUNG_COMPUTER("삼성","i7",200),
    LG_COMPUTER("LG","i5",150);


    private final String brandName;
    private final String cpuType;
    private final int price;

    ComputerType(String brandName, String productType, int price){
        this.brandName = brandName;
        this.cpuType = productType;
        this.price = price;
    }


    public String getBrandName() {
        return brandName;
    }

    public String getCpuType() {
        return cpuType;
    }

    public int getPrice() {
        return price;
    }
}
