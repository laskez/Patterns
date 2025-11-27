package beverage;

public class Coffee extends Beverage {
    @Override
    public String getName() {
        return "Кофе";
    }

    @Override
    public double getCost() {
        return 150;
    }
}
