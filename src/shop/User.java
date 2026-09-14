package shop;

public class User {
    private String id;
    private String name;
    private String email;

    public void makeOrder() {
        System.out.println("Створено нове замовлення для " + name);
    }
}
