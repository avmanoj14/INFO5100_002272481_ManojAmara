import java.util.ArrayList;
import java.util.List;

// Singleton Design Pattern
class Restaurant {
    private static Restaurant instance;
    private final List<OrderObserver> orderObservers;
    private Restaurant() {
        orderObservers = new ArrayList<>();
    }

    public static Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    public void addObserver(OrderObserver observer) {
        orderObservers.add(observer);
    }


    public void notifyObservers(String order) {
        for (OrderObserver observer : orderObservers) {
            observer.update(order);
        }
    }

    public void receiveOrder(String order) {
        System.out.println("Order received: " + order);
        notifyObservers(order);
    }
}

// Observer Design Pattern
interface OrderObserver {
    void update(String order);
}

class Kitchen implements OrderObserver {
    @Override
    public void update(String order) {
        System.out.println("Kitchen received order: " + order);
        System.out.println("Order is being prepared...");
        System.out.println("Order is ready for serving!");
    }
}

class Waiter implements OrderObserver {
    @Override
    public void update(String order) {
        System.out.println("Waiter received order: " + order);
        System.out.println("Serving order to the customer...");
        System.out.println("Order served!");
    }
}

// Strategy Design Pattern
interface PaymentStrategy {
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment: $" + amount);
        System.out.println("Credit card payment processed successfully!");
    }
}

class CashPayment implements PaymentStrategy {
    @Override
    public void processPayment(double amount) {
        System.out.println("Collecting cash payment: $" + amount);
        System.out.println("Cash payment collected!");
    }
}

public class RestaurantSystem {
    public static void main(String[] args) {
        // Singleton Pattern
        Restaurant restaurant = Restaurant.getInstance();

        // Observer Pattern
        OrderObserver kitchen = new Kitchen();
        OrderObserver waiter = new Waiter();

        restaurant.addObserver(kitchen);
        restaurant.addObserver(waiter);

        // Strategy Pattern
        PaymentStrategy creditCardPayment = new CreditCardPayment();
        PaymentStrategy cashPayment = new CashPayment();

        restaurant.receiveOrder("Pasta");
        creditCardPayment.processPayment(20.0);

        restaurant.receiveOrder("Burger");
        cashPayment.processPayment(15.0);
    }
}
