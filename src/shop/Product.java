package shop;

/**
 * Клас Product імітує сутність "Товар" у магазині.
 * Зберігає інформацію про ідентифікатор, назву та ціну товару.
 *
 * @author Мальченко Ростислав
 * @version 1.0
 */
public class Product {
    /** Унікальний ідентифікатор товару */
    private String productId;

    /** Назва товару */
    private String name;

    /** Ціна товару в гривнях */
    private double price;

    /**
     * Конструктор для створення нового товару.
     *
     * @param productId унікальний код товару
     * @param name назва товару
     * @param price ціна товару
     */
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    /**
     * Отримати ціну товару.
     *
     * @return ціна товару
     */
    public double getPrice() {
        return price;
    }

    /**
     * Отримати назву товару.
     *
     * @return назва товару
     */
    public String getName() {
        return name;
    }

    /**
     * Встановити нову ціну товару з перевіркою коректності.
     *
     * @param price нова ціна товару (повинна бути більше 0 і менше 100000)
     */
    public void setPrice(double price) {
        if (price > 0 && price < 100000) {
            this.price = price;
            System.out.println("Ціну оновлено: " + this.price);
        } else {
            System.out.println("Некоректна ціна!");
        }
    }

    /**
     * Виводить інформацію про товар у консоль.
     */
    public void displayInfo() {
        System.out.println("Товар: " + name + ", Ціна: " + price + " грн");
    }
}