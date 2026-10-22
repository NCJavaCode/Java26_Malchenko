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

    /**
     * Конструктор замовлення.
     *
     * @param orderId  ідентифікатор
     * @param products масив товарів
     */
    public Order(String orderId, Product[] products) {
        this.orderId = orderId;
        this.products = products;
        this.status = "NEW";
    }

    /**
     * Конструктор копіювання.
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

    /**
     * Отримує товар з масиву за індексом з обробкою виходу за межі масиву.
     * (Завдання 1)
     *
     * @param index індекс товару
     * @return об'єкт Product або null у разі помилки
     */
    public Product getProductByIndex(int index) {
        try {
            return products[index];
        } catch (ArrayIndexOutOfBoundsException e) {
            int maxIndex = (products != null) ? products.length - 1 : 0;
            System.err.println("Помилка: ArrayIndexOutOfBoundsException! " +
                    "Спроба звернення до некоректного індексу: " + index +
                    ". Допустимі межі індексів: від 0 до " + maxIndex);
            return null;
        }
    }

    /**
     * Обчислює загальну вартість замовлення.
     *
     * @return сумарна вартість
     */
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

    /**
     * Додає новий товар у замовлення з обробкою передачі null.
     * (Завдання 2)
     *
     * @param product новий товар для додавання
     */
    public void addProduct(Product product) {
        try {
            if (product == null) {
                throw new NullPointerException("Передано порожній об'єкт товара!");
            }
            if (products == null) {
                products = new Product[1];
                products[0] = product;
            } else {
                Product[] newProducts = new Product[products.length + 1];
                System.arraycopy(products, 0, newProducts, 0, products.length);
                newProducts[products.length] = product;
                products = newProducts;
            }
            System.out.println("Товар " + product.getName() + " успішно додано.");
        } catch (NullPointerException e) {
            System.err.println("Помилка: NullPointerException! Об'єкт класу Product відсутній (null). " + e.getMessage());
        }
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