package shop;

/**
 * Клас User описує користувача (покупця) системи.
 *
 * @author Мальченко Ростислав
 * @version 1.0
 */
public class User {
    /** Ідентифікатор користувача */
    private String id;

    /** Ім'я користувача */
    private String name;

    /** Електронна пошта користувача */
    private String email;

    /**
     * Конструктор користувача.
     *
     * @param id ідентифікатор
     * @param name ім'я
     * @param email пошта
     */
    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    /**
     * Імітує процес створення нового замовлення користувачем.
     */
    public void makeOrder() {
        System.out.println("Користувач " + name + " (" + email + ") створює нове замовлення.");
    }
}