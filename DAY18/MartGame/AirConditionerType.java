package P20250504.MartGame;

public enum AirConditionerType {

    SAMSUNG_AIRCONDITIONER("삼성", "벽걸이", 100),
    LG_AIRCONDITIONER("LG","스탠드",250);


    private final String brandName;
    private final String productType;
    private final int price;

    AirConditionerType(String brandName, String productType, int price){
        this.brandName = brandName;
        this.productType = productType;
        this.price = price;
    }


    public String getBrandName() {
        return brandName;
    }

    public String getProductType() {
        return productType;
    }

    public int getPrice() {
        return price;
    }
}
