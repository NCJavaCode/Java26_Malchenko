package shop;

public class Order {
    private String orderId;
    private String status;
    private Product[] products;

    public Order(String orderId, Product[] products) {
        this.orderId = orderId;
        this.products = products;
        this.status = "NEW";
    }

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