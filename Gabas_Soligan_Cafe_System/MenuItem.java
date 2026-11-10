/**
 * Represents an abstract menu item in the restaurant ordering system.
 * Stores the item's name, price, and unique code.
 * Subclasses must implement their own price calculation.
 *
 * @author Renato Anthony M. Soligan
 * Jusel M.Gabas
 * @version 1.0
 */
public abstract class MenuItem {

    protected String itemName;
    protected double price;
    private String code;

    /**
     * Creates a menu item with default values.
     */
    public MenuItem() {
        itemName = "Unknown Item";
        price = 0.0;
        code = "N/A";
    }

    /**
     * Creates a menu item with the specified name, price, and code.
     *
     * @param itemName the name of the menu item
     * @param price the base price of the menu item
     * @param code the unique code of the menu item
     */
    public MenuItem(String itemName, double price, String code) {
        this.itemName = itemName;
        setPrice(price);
        this.code = code;
    }

    /**
     * Sets the item's price if the given value is valid.
     *
     * @param price the price to be assigned
     */
    private void setPrice(double price) {

        // Sets the price if the entered value is zero or positive.
        if (price >= 0) {
            this.price = price;

            // Sets the price to zero if the entered value is negative.
        } else {
            this.price = 0.0;
            System.out.println("Invalid price! Price cannot be negative.");
        }
    }

    /**
     * Returns the name of the menu item.
     *
     * @return the menu item name
     */
    public String getItemName() {
        return itemName;
    }

    /**
     * Returns the base price of the menu item.
     *
     * @return the menu item price
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the unique code of the menu item.
     *
     * @return the menu item code
     */
    public String getCode() {
        return code;
    }

    /**
     * Changes the name of the menu item.
     *
     * @param newName the new menu item name
     */
    public void changeName(String newName) {
        itemName = newName;
    }

    /**
     * Changes the menu item's price if the new value is valid.
     *
     * @param newPrice the new price of the menu item
     */
    public void changePrice(double newPrice) {

        // Updates the price if the entered value is zero or positive.
        if (newPrice >= 0) {
            price = newPrice;

            // Displays an error message if the entered price is negative.
        } else {
            System.out.println("Invalid price! Price cannot be negative.");
        }
    }

    /**
     * Changes the unique code of the menu item.
     *
     * @param newCode the new menu item code
     */
    public void changeCode(String newCode) {
        code = newCode;
    }

    /**
     * Returns the menu item's name and unique code.
     *
     * @return the formatted menu item description
     */
    public String getDescription() {
        return itemName + " [" + code + "]";
    }

    /**
     * Calculates the final price of the menu item.
     * Subclasses must provide their own pricing implementation.
     *
     * @return the computed menu item price
     */
    public abstract double computePrice();
}