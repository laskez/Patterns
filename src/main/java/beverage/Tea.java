package beverage;

public class Tea extends Beverage {

    @Override
    public String getName () {
        return "Чай";
    }

    @Override
    public double getCost() {
        return 100;
    }
}
