package ui;

import order.Order;

import java.util.List;

public class RemoveCommand implements Command{
    private Order order;
    private List<Order> cart;

    public RemoveCommand(Order order, List<Order> cart) {
        this.order = order;
        this.cart = cart;
    }

    @Override
    public void execute() {
        cart.remove(order);
    }

    @Override
    public void undo() {
        cart.add(order);
    }
}
