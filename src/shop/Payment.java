package shop;

/**
 * Клас Payment описує процес проведення оплати за замовлення.
 *
 * @author Мальченко Ростислав
 * @version 1.0
 */
public class Payment {
    /** Унікальний код транзакції/платежу */
    private String paymentId;

    /** Сума платежу */
    private double amount;

    /**
     * Конструктор для створення об'єкта платежу.
     *
     * @param paymentId номер платежу
     * @param amount сума платежу
     */
    public Payment(String paymentId, double amount) {
        this.paymentId = paymentId;
        this.amount = amount;
    }

    /**
     * Виконує спробу проведення транзакції.
     */
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