package ui;

import order.Order;

import java.util.List;

public class AddCommand implements Command {
    private Order order;
    private List<Order> cart;

    public AddCommand(Order order, List<Order> cart) {
        this.order = order;
        this.cart = cart;
    }

    @Override
    public void execute() {
        cart.add(order);
    }

    @Override
    public void undo() {
        cart.remove(order);
    }
}
