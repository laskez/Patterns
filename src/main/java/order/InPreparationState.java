package order;

public class InPreparationState implements OrderState {
    public void next(Order order) {
        order.setState(new ReadyState());
    }

    public String getStatus() {
        return "Готовится";
    }
}
