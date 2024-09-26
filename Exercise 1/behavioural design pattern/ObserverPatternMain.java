// Import necessary Java utility classes
import java.util.ArrayList;
import java.util.List;

// Define an interface for observers
interface Observer {
    /**
     * Update the observer with the latest temperature reading.
     * @param temperature the current temperature
     */
    void update(float temperature);
}

// Implement the WeatherStation class, which manages a list of observers
class WeatherStation {
    // Private field to store a list of observers
    private List<Observer> observers = new ArrayList<>();
    // Private field to store the current temperature
    private float temperature;

    /**
     * Add an observer to the list of observers.
     * @param observer the observer to add
     */
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    /**
     * Remove an observer from the list of observers.
     * @param observer the observer to remove
     */
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    /**
     * Set the current temperature and notify all observers.
     * @param temperature the new temperature
     */
    public void setTemperature(float temperature) {
        this.temperature = temperature;
        notifyObservers();
    }

    /**
     * Notify all observers of the updated temperature.
     */
    private void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(temperature);
        }
    }
}

// Implement the PhoneDisplay class, which implements the Observer interface
class PhoneDisplay implements Observer {
    @Override
    public void update(float temperature) {
        // Print a message indicating that the phone display has received an update
        System.out.println("Phone Display: Temperature updated to " + temperature + " degrees.");
    }
}

// Implement the TVDisplay class, which implements the Observer interface
class TVDisplay implements Observer {
    @Override
    public void update(float temperature) {
        // Print a message indicating that the TV display has received an update
        System.out.println("TV Display: Temperature updated to " + temperature + " degrees.");
    }
}

// Main class to demonstrate the use of the observer pattern
public class ObserverPatternMain {
    public static void main(String[] args) {
        // Create a weather station
        WeatherStation weatherStation = new WeatherStation();

        // Create observers for the phone display and TV display
        Observer phoneDisplay = new PhoneDisplay();
        Observer tvDisplay = new TVDisplay();

        // Register the observers with the weather station
        weatherStation.addObserver(phoneDisplay);
        weatherStation.addObserver(tvDisplay);

        // Set the temperature to 30.0 degrees and notify observers
        weatherStation.setTemperature(30.0f);  // Both displays will receive this update
        // Set the temperature to 25.5 degrees and notify observers
        weatherStation.setTemperature(25.5f);  // Both displays will receive this update
    }
}