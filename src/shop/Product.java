package shop;

import java.util.Objects;

/**
 * Клас Product описує товар у магазині.
 *
 * @author Мальченко Ростислав
 * @version 1.0
 */
public class Product {
    private String productId;
    private String name;
    private double price;       // Примітивний тип 1
    private int quantity;       // Примітивний тип 2

    public Product(String productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
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
        System.out.println("Товар: " + name + ", Ціна: " + price + " грн, Кількість: " + quantity);
    }

    /**
     * Перевизначений метод equals() для порівняння об'єктів за посиланнями та значеннями полів.
     * Використовує дві примітивні змінні: price та quantity.
     *
     * @param o об'єкт для порівняння
     * @return true, якщо об'єкти еквівалентні
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(product.price, price) == 0 &&
                quantity == product.quantity &&
                Objects.equals(productId, product.productId) &&
                Objects.equals(name, product.name);
    }

    /**
     * Перевизначений метод hashCode(), узгоджений із методом equals().
     *
     * @return цілочисельний хеш-код об'єкта
     */
    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price, quantity);
    }
}