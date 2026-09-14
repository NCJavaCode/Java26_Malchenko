package shop;

public class Product {
    private String productId;
    private String name;
    private double price;

    public void displayInfo() {
        System.out.println("Товар: " + name + ", Ціна: " + price);
    }
}
