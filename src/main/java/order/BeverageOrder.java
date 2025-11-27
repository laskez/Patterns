package order;

import beverage.Beverage;

public class BeverageOrder {
    private Beverage beverage;

    private BeverageOrder() {}

    public Beverage getBeverage() {
        return beverage;
    }

    public static class Builder {
        private Beverage beverage;

        public Builder setBase(Beverage beverage) {
            this.beverage = beverage;
            return this;
        }

        public BeverageOrder build() {
            BeverageOrder order = new BeverageOrder();
            order.beverage = this.beverage;
            return order;
        }
    }
}
