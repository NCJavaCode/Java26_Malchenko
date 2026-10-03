package shop;

public class Product {
    private String productId;
    private String name;
    private double price;

    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public void setPrice(double price) {
        if (price > 0 && price < 100000) {
            this.price = price;
            System.out.println("Ціну оновлено: " + this.price);
        } else {
            System.out.println("Некоректна ціна!");
        }
    }

    public void displayInfo() {
        System.out.println("Товар: " + name + ", Ціна: " + price + " грн");
    }
}