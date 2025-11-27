package order;

public class CompletedState implements OrderState {
    public void next(Order order) {}

    public String getStatus() {
        return "Завершен";
    }
}
