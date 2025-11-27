package pricing;

public class DiscountAdapter implements PriceStrategy {

    private OldDiscountSystem oldSystem = new OldDiscountSystem();

    @Override
    public double apply(double price) {
        return oldSystem.getDiscount(price);
    }
}
