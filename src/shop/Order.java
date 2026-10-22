package shop;

/**
 * Клас Order описує замовлення у магазині.
 *
 * @author Мальченко Ростислав
 * @version 1.0
 */
public class Order implements Cloneable {
    private String orderId;
    private String status;
    private Product[] products;

    public Order(String orderId, Product[] products) {
        this.orderId = orderId;
        this.products = products;
        this.status = "NEW";
    }

    /**
     * Конструктор копіювання для глибокого клонування об'єкта Order.
     * (Завдання 2)
     *
     * @param other об'єкт Order для копіювання
     */
    public Order(Order other) {
        if (other != null) {
            this.orderId = other.orderId;
            this.status = other.status;
            if (other.products != null) {
                this.products = new Product[other.products.length];
                for (int i = 0; i < other.products.length; i++) {
                    if (other.products[i] != null) {
                        this.products[i] = new Product(other.products[i]);
                    }
                }
            }
        }
    }

    public double calculateTotal() {
        double total = 0.0;
        if (products != null) {
            for (Product product : products) {
                if (product != null) {
                    total += product.getPrice();
                }
            }
        }
        return total;
    }

    public void updateStatus(int statusCode) {
        switch (statusCode) {
            case 1 -> this.status = "NEW";
            case 2 -> this.status = "PAID";
            case 3 -> this.status = "SHIPPED";
            case 4 -> this.status = "DELIVERED";
            case 5 -> this.status = "CANCELLED";
            default -> System.out.println("Невідомий код статусу!");
        }
    }

    /**
     * Перевизначений метод clone() для глибокого клонування замовлення.
     * (Завдання 1)
     *
     * @return клонований об'єкт Order
     */
    @Override
    public Order clone() {
        try {
            Order cloned = (Order) super.clone();
            if (this.products != null) {
                cloned.products = new Product[this.products.length];
                for (int i = 0; i < this.products.length; i++) {
                    if (this.products[i] != null) {
                        cloned.products[i] = this.products[i].clone();
                    }
                }
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}