package pricing;

import order.Order;

public interface PriceStrategy {
    double apply(double price);
}
