package order;

public class CustomerNotifier implements OrderObserver {

    @Override
    public void update(Order order) {
        System.out.println("Уведомление: ваш заказ " + order.getState().getStatus());
    }
}
