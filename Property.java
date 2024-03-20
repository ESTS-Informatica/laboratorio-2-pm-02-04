

/**
 * A property to sell.
 *
 * @author POO
 * @version 03/2024
 */
public class Property {

    private static int NUMBER_OF_PROPERTIES = 0;
    private final int id;
    private String description;
    private double price;


    /**
     * Constructor of class Property
     *
     * @param description The property description.
     * @param price The property price.
     */
    public Property(String description, double price) {
        this.price = price;
        this.description = description;
        this.id = NUMBER_OF_PROPERTIES++;
    }

    /**
     * Id selector.
     */
    public int getId() {
        return this.id;
    }

    /**
     * Description selector.
     */
    public String getDescription() {
            return this.description;
    }

    /**
     * Description modifier.
     * 
     * @param description The new description. Must not be null.
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Price selector.
     */
    public double getPrice() {
        return this.price;
    }
    
    /**
     * Price modifier.
     * 
     * @param price The new price. Must not be negative.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return this.id + " " + this.NUMBER_OF_PROPERTIES + " " + this.description + " " + this.price;
    }
}
