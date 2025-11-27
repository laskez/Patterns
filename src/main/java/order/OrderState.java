package order;

public interface OrderState {
    void next(Order order);
    String getStatus();
}
