package order;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private BeverageOrder beverageOrder;
    private OrderState state = new NewState();
    private List<OrderObserver> observers = new ArrayList<>();

    public Order(BeverageOrder order) {
        this.beverageOrder = order;
    }

    public void addObserver(OrderObserver observer) {
        observers.add(observer);
    }

    public void setState(OrderState state) {
        this.state = state;
        notifyObservers();
    }

    public OrderState getState() {
        return state;
    }

    public void nextState() {
        state.next(this);
    }

    private void notifyObservers() {
        observers.forEach(o -> o.update(this));
    }

    public double getCost() {
        return beverageOrder.getBeverage().getCost();
    }

    public String getDescription() {
        return beverageOrder.getBeverage().getName();
    }
}
