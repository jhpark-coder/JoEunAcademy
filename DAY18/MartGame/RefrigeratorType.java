package P20250504.MartGame;

public enum RefrigeratorType {

    SAMSUNG_REFRIGERATOR("삼성","양문",600,200),
    LG_REFRIGERATOR("LG","4도어",800,350);


    private final String brandName;
    private final String productType;
    private final int size;
    private final int price;

    RefrigeratorType(String brandName, String productType, int size, int price){
        this.brandName = brandName;
        this.productType = productType;
        this.size = size;
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public String getProductType() {
        return productType;
    }

    public int getSize() {
        return size;
    }

    public int getPrice() {
        return price;
    }
}
