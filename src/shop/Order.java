package shop;

/**
 * Клас Order описує замовлення, оформлене в магазині.
 * Містить список товарів, унікальний номер та статус виконання.
 *
 * @author Мальченко Ростислав
 * @version 1.0
 */
public class Order {
    /** Унікальний номер замовлення */
    private String orderId;

    /** Поточний статус замовлення */
    private String status;

    /** Масив товарів, що входять до замовлення */
    private Product[] products;

    /**
     * Конструктор для створення замовлення.
     *
     * @param orderId номер замовлення
     * @param products масив товарів
     */
    public Order(String orderId, Product[] products) {
        this.orderId = orderId;
        this.products = products;
        this.status = "NEW";
    }

    /**
     * Обчислює загальну вартість замовлення.
     *
     * @return сумарна вартість усіх товарів у замовленні
     */
    public double calculateTotal() {
        double total = 0.0;
        if (products != null) {
            for (int i = 0; i < products.length; i++) {
                if (products[i] != null && products[i].getPrice() > 0) {
                    total = total + products[i].getPrice();
                }
            }
        }
        return total;
    }

    /**
     * Оновлює статус замовлення за його кодом.
     *
     * @param statusCode числовой код статусу (1 - Створено, 2 - Оплачено, 3 - Відправлено)
     */
    public void updateStatus(int statusCode) {
        switch (statusCode) {
            case 1:
                this.status = "NEW";
                System.out.println("Замовлення " + orderId + " створено.");
                break;
            case 2:
                this.status = "PAID";
                System.out.println("Замовлення " + orderId + " оплачено.");
                break;
            case 3:
                this.status = "SHIPPED";
                System.out.println("Замовлення " + orderId + " відправлено.");
                break;
            default:
                this.status = "UNKNOWN";
                System.out.println("Невідомий код статусу.");
                break;
        }
    }
}