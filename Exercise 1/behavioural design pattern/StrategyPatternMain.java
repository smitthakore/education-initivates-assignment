// Define an interface for payment strategies
interface PaymentStrategy {
    /**
     * Pay a certain amount using the payment strategy.
     * @param amount the amount to pay
     */
    void pay(int amount);
}

// Implement the CreditCardPayment class, which implements the PaymentStrategy interface
class CreditCardPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        // Print a message indicating that the payment was made using a credit card
        System.out.println("Paid " + amount + " using Credit Card.");
    }
}

// Implement the PayPalPayment class, which implements the PaymentStrategy interface
class PayPalPayment implements PaymentStrategy {
    @Override
    public void pay(int amount) {
        // Print a message indicating that the payment was made using PayPal
        System.out.println("Paid " + amount + " using PayPal.");
    }
}

// Define a context class that uses a payment strategy to process payments
class PaymentContext {
    // Private field to store the payment strategy
    private PaymentStrategy paymentStrategy;

    /**
     * Constructor to initialize the payment context with a payment strategy.
     * @param paymentStrategy the payment strategy to use
     */
    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    /**
     * Process a payment using the payment strategy.
     * @param amount the amount to pay
     */
    public void processPayment(int amount) {
        // Delegate the payment processing to the payment strategy
        paymentStrategy.pay(amount);
    }
}

// Main class to demonstrate the use of the strategy pattern
public class StrategyPatternMain {
    public static void main(String[] args) {
        // Create a payment context with a credit card payment strategy
        PaymentContext paymentContext = new PaymentContext(new CreditCardPayment());
        // Process a payment of 100 using the credit card payment strategy
        paymentContext.processPayment(100);  // Output: Paid 100 using Credit Card.

        // Create a payment context with a PayPal payment strategy
        paymentContext = new PaymentContext(new PayPalPayment());
        // Process a payment of 200 using the PayPal payment strategy
        paymentContext.processPayment(200);  // Output: Paid 200 using PayPal.
    }
}