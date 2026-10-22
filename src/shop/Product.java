package shop;

import java.util.Objects;

/**
 * Клас Product описує товар у магазині.
 *
 * @author Мальченко Ростислав
 * @version 1.0
 */
public class Product implements Cloneable {
    private String productId;
    private String name;
    private double price;
    private int quantity;

    public Product(String productId, String name, double price, int quantity) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    /**
     * Конструктор копіювання для класу Product.
     *
     * @param other об'єкт Product для копіювання
     */
    public Product(Product other) {
        if (other != null) {
            this.productId = other.productId;
            this.name = other.name;
            this.price = other.price;
            this.quantity = other.quantity;
        }
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

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, price, quantity);
    }

    /**
     * Перевизначений метод clone() для створення копії товару.
     *
     * @return клонований об'єкт Product
     */
    @Override
    public Product clone() {
        try {
            return (Product) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}