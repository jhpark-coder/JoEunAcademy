package P20250504.MartGame;

import java.util.Objects;

public abstract class Product {
    protected String brand;
    protected String type;
    protected int price;

    Product(String brand, int price){
        this.brand = brand;
        this.type = "";
        this.price = price;
    }

    Product(String brand, String type, int price){
        this.brand = brand;
        this.type = type;
        this.price = price;
    }

    public abstract void useProduct();

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return price == product.price && Objects.equals(brand, product.brand) && Objects.equals(type, product.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, type, price);
    }
}
