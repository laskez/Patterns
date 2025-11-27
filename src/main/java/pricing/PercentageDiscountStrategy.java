package pricing;

public class PercentageDiscountStrategy implements  PriceStrategy {

    private double percent;

    public PercentageDiscountStrategy(double percent) {
        this.percent = percent;
    }

    @Override
    public double apply(double price) {
        return price * (1 - percent / 100.0);
    }
}
