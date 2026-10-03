package shop;

public class Payment {
    private String paymentId;
    private double amount;

    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }


    public void processPayment() {
        int attempts = 3;
        boolean success = false;

        while (attempts > 0 && !success) {
            System.out.println("Обробка платежу " + paymentId + "... Залишилось спроб: " + attempts);
            attempts--;
            success = true;
        }

        if (success) {
            System.out.println("Оплата на суму " + amount + " грн пройшла успішно!");
        } else {
            System.out.println("Помилка оплати.");
        }
    }
}