/**
 * Represents a meal menu item with selectable size and side orders.
 * Upsizing a meal and adding side orders increase its base price.
 *
 * @author Renato Anthony M. Soligan
 * Jusuel M.Gabas
 * @version 1.0
 */
public class Meal extends MenuItem {

    private boolean largeSize;
    private int sideOrders;

    /**
     * Creates a meal with the default regular size and zero side orders.
     */
    public Meal() {
        super();
        largeSize = false;
        sideOrders = 0;
    }

    /**
     * Creates a meal with the specified details, size, and side orders.
     *
     * @param name the name of the meal
     * @param price the base price of the meal
     * @param itemCode the unique code of the meal
     * @param largeSize the size status of the meal
     * @param sideOrders the number of side orders
     */
    public Meal(String name, double price, String itemCode,
                boolean largeSize, int sideOrders) {

        super(name, price, itemCode);

        this.largeSize = largeSize;
        this.sideOrders = 0;
        setSideOrders(sideOrders);
    }

    /**
     * Returns the current size status of the meal.
     *
     * @return true if the meal is upsized, otherwise false
     */
    public boolean getLargeSize() {
        return largeSize;
    }

    /**
     * Returns the current number of side orders.
     *
     * @return the number of side orders
     */
    public int getSideOrders() {
        return sideOrders;
    }

    /**
     * Changes the size of the meal.
     *
     * @param newSize the new size status of the meal
     */
    public void changeSize(boolean newSize) {
        largeSize = newSize;
    }

    /**
     * Changes the number of side orders if the quantity is valid.
     *
     * @param quantity the new number of side orders
     */
    public void changeSideOrders(int quantity) {

        // Displays an error message if the quantity is negative.
        if (quantity < 0) {
            System.out.println("Invalid quantity! Side orders cannot be negative.");

            // Updates the side orders if the quantity is zero or positive.
        } else {
            sideOrders = quantity;
        }
    }

    /**
     * Sets the number of side orders using the specified quantity.
     *
     * @param quantity the number of side orders to set
     */
    public void setSideOrders(int quantity) {
        changeSideOrders(quantity);
    }

    /**
     * Calculates the final meal price based on its size and side orders.
     * Each side order adds 12 to the base price, while an upsized meal
     * adds an additional 20.
     *
     * @return the computed meal price
     */
    @Override
    public double computePrice() {

        double total = price + (sideOrders * 12);

        // Adds 20 to the total price if the meal is upsized.
        if (largeSize) {
            total += 20;
        }

        return total;
    }

    /**
     * Returns the meal description, including its size and side orders.
     *
     * @return the formatted meal description
     */
    @Override
    public String getDescription() {

        String sizeDescription = largeSize ? "Upsized" : "Regular";

        return super.getDescription() + " " +
                sizeDescription + ", " + sideOrders + " side/s";
    }
}