package shop;

public class User {
    private String id;
    private String name;
    private String email;

    public User(String id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public void makeOrder() {
        System.out.println("Користувач " + name + " (" + email + ") створює нове замовлення.");
    }
}