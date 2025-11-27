package ui;

import beverage.*;
import config.MenuRepository;
import menu.BeverageFactory;
import menu.BeverageType;
import order.*;
import payment.PaymentFacade;
import pricing.*;

import java.util.*;

public class ConsoleUI {

    private Scanner sc = new Scanner(System.in);
    private List<Order> cart = new ArrayList<>();
    private CartInvoker invoker = new CartInvoker();

    public void start() {
        while (true) {
            System.out.println("\n╚═══ CoffeeShop ═══╝  ");
            System.out.println("1 - Создать напиток");
            System.out.println("2 - Показать корзину");
            System.out.println("3 - Отменить");
            System.out.println("4 - Выход");

            switch (sc.nextLine()) {
                case "1" -> createDrink();
                case "2" -> showCart();
                case "3" -> invoker.undo();
                case "0" -> { return; }
            }
        }
    }

    private void createDrink() {
        System.out.println("Выберите напиток:");
        List<BeverageType> menu = MenuRepository.getInstance().getMenu();

        for (int i = 0; i < menu.size(); i++) {
            System.out.println((i + 1) + ". " + menu.get(i));
        }

        int choice = Integer.parseInt(sc.nextLine());
        Beverage base = BeverageFactory.create(menu.get(choice - 1));

        boolean customizing = true;
        while (customizing) {
            System.out.println("Добавки:");
            System.out.println("1 - молоко");
            System.out.println("2 - сироп");
            System.out.println("3 - сливки");
            System.out.println("0 - далее");

            switch (sc.nextLine()) {
                case "1" -> base = new MilkDecorator(base);
                case "2" -> base = new SyrupDecorator(base);
                case "3" -> base = new WhipDecorator(base);
                case "0" -> customizing = false;
            }
        }

        BeverageOrder orderBuilder = new BeverageOrder.Builder()
                .setBase(base)
                .build();

        Order order = new Order(orderBuilder);
        order.addObserver(new CustomerNotifier());

        System.out.println("Выберите скидку:");
        System.out.println("1 - нет");
        System.out.println("2 - 10%");
        System.out.println("3 - старая система скидок");

        PriceStrategy strategy = switch (sc.nextLine()) {
            case "2" -> new PercentageDiscountStrategy(10);
            case "3" -> new DiscountAdapter();
            default -> new NoDiscountStrategy();
        };

        double finalPrice = strategy.apply(order.getCost());
        System.out.println("Цена: " + finalPrice);

        PaymentFacade facade = new PaymentFacade();
        facade.pay(finalPrice);

        order.nextState();

        invoker.execute(new AddCommand(order, cart));
    }

    private void showCart() {
        if (cart.isEmpty()) {
            System.out.println("Корзина пуста");
            return;
        }

        for (Order order : cart) {
            System.out.println(order.getDescription() + " - " + order.getCost());
        }
    }
}
