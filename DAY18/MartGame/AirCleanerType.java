package P20250504.MartGame;

public enum AirCleanerType {

    LG_AIRCLEANER("LG","공기청정기",80),
    DYSON_AIRCLEANER("다이슨","공기청정기",60);


    private final String brandName;
    private final String productType;
    private final int price;

    AirCleanerType(String brandName, String productType, int price){
        this.brandName = brandName;
        this.productType = productType;
        this.price = price;
    }

    public String getBrandName() {
        return brandName;
    }

    public int getPrice() {
        return price;
    }
}
