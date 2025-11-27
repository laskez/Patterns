package beverage;

public class WhipDecorator extends BeverageDecorator {

    public WhipDecorator(Beverage beverage) {
        this.beverage = beverage;
    }

    @Override
    public String getName() {
        return beverage.getName() + " + сливки";
    }

    @Override
    public double getCost() {
        return beverage.getCost() + 25;
    }
}

