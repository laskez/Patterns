package payment;

public class PaymentFacade {
    public boolean pay(double amount) {
        System.out.println("Оплата прошла успешно: " + amount + "₽");
        return true;
    }
}
