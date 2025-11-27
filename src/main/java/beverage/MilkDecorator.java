package beverage;

public class MilkDecorator extends BeverageDecorator {

    public MilkDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getName() {
        return beverage.getName() + " + молоко";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 20;
    }
}
