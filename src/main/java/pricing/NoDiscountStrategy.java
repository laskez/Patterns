package pricing;

public class NoDiscountStrategy implements PriceStrategy {
    @Override
    public double apply(double price) {
        return price;
    }
}
