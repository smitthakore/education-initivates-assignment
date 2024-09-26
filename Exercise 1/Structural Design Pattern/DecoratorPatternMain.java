// Define an interface for coffee
interface Coffee {
    /**
     * Get the description of the coffee.
     * @return the description of the coffee
     */
    String getDescription();

    /**
     * Get the cost of the coffee.
     * @return the cost of the coffee
     */
    double cost();
}

// Implement the SimpleCoffee class, which implements the Coffee interface
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        // Return the description of the simple coffee
        return "Simple Coffee";
    }

    @Override
    public double cost() {
        // Return the cost of the simple coffee
        return 5.00;
    }
}

// Implement the MilkDecorator class, which implements the Coffee interface
class MilkDecorator implements Coffee {
    // Private field to store the coffee object being decorated
    protected Coffee coffee;

    /**
     * Constructor to initialize the milk decorator with the given coffee.
     * @param coffee the coffee object to decorate
     */
    public MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        // Return the description of the coffee with milk
        return coffee.getDescription() + ", Milk";
    }

    @Override
    public double cost() {
        // Return the cost of the coffee with milk
        return coffee.cost() + 1.00;
    }
}

// Implement the SugarDecorator class, which implements the Coffee interface
class SugarDecorator implements Coffee {
    // Private field to store the coffee object being decorated
    protected Coffee coffee;

    /**
     * Constructor to initialize the sugar decorator with the given coffee.
     * @param coffee the coffee object to decorate
     */
    public SugarDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String getDescription() {
        // Return the description of the coffee with sugar
        return coffee.getDescription() + ", Sugar";
    }

    @Override
    public double cost() {
        // Return the cost of the coffee with sugar
        return coffee.cost() + 0.50;
    }
}

// Main class to demonstrate the use of the decorator pattern
public class DecoratorPatternMain {
    public static void main(String[] args) {
        // Create a simple coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println(coffee.getDescription() + " Cost: $" + coffee.cost());  // Output: Simple Coffee Cost: $5.0

        // Add milk to the coffee
        coffee = new MilkDecorator(coffee);
        System.out.println(coffee.getDescription() + " Cost: $" + coffee.cost());  // Output: Simple Coffee, Milk Cost: $6.0

        // Add sugar to the coffee
        coffee = new SugarDecorator(coffee);
        System.out.println(coffee.getDescription() + " Cost: $" + coffee.cost());  // Output: Simple Coffee, Milk, Sugar Cost: $6.5
    }
}