// Define an interface for shapes
interface Shape {
    /**
     * Draw the shape.
     */
    void draw();
}

// Implement the Circle class, which implements the Shape interface
class Circle implements Shape {
    @Override
    public void draw() {
        // Print a message indicating that a circle is being drawn
        System.out.println("Drawing a Circle.");
    }
}

// Implement the Square class, which implements the Shape interface
class Square implements Shape {
    @Override
    public void draw() {
        // Print a message indicating that a square is being drawn
        System.out.println("Drawing a Square.");
    }
}

// Implement the ShapeFactory class, which creates shapes based on a given type
class ShapeFactory {
    /**
     * Get a shape object based on the given shape type.
     * @param shapeType the type of shape to create (e.g., "CIRCLE", "SQUARE")
     * @return the created shape object, or null if the type is not supported
     */
    public Shape getShape(String shapeType) {
        if (shapeType.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeType.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}

// Main class to demonstrate the use of the factory pattern
public class FactoryPatternMain {
    public static void main(String[] args) {
        // Create a shape factory
        ShapeFactory shapeFactory = new ShapeFactory();

        // Get a circle shape from the factory and draw it
        Shape circle = shapeFactory.getShape("CIRCLE");
        circle.draw();  // Output: Drawing a Circle.

        // Get a square shape from the factory and draw it
        Shape square = shapeFactory.getShape("SQUARE");
        square.draw();  // Output: Drawing a Square.
    }
}