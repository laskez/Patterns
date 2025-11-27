package order;

public class ReadyState implements OrderState {
    public void next(Order order) {
        order.setState(new CompletedState());
    }

    public String getStatus() {
        return "Готов";
    }
}
