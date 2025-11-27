package order;

public class NewState implements OrderState {
    public void next(Order order) {
        order.setState(new PaidState());
    }

    public String getStatus() {
        return "Новый";
    }
}
