package beverage;

public class SyrupDecorator extends BeverageDecorator {
    public SyrupDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getName() {
        return beverage.getName() + " + сироп";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 30;
    }
}
