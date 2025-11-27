package order;

public class PaidState implements OrderState {
    public void next(Order order) {
        order.setState(new InPreparationState());
    }

    public String getStatus() {
        return "Оплачен";
    }
}
