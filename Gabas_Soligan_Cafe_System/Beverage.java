/**
 * Represents a beverage menu item with selectable sizes.
 * Each size has an additional price.
 *
 * @author Renato Anthony M. Soligan
 * Jusuel M. Gabas
 * @version 1.0
 */
public class Beverage extends MenuItem {

    private String selectedSize;

    /**
     * Creates a beverage with the default size S.
     */
    public Beverage() {
        super();
        selectedSize = "S";
    }

    /**
     * Creates a beverage with the given details and selected size.
     *
     * @param name the name of the beverage
     * @param price the base price of the beverage
     * @param itemCode the unique code of the beverage
     * @param selectedSize the selected beverage size
     */
    public Beverage(String name, double price, String itemCode, String selectedSize) {
        super(name, price, itemCode);
        this.selectedSize = "S";
        updateSize(selectedSize);
    }

    /**
     * Returns the currently selected beverage size.
     *
     * @return the selected beverage size
     */
    public String getSelectedSize() {
        return selectedSize;
    }

    /**
     * Updates the beverage size if the given option is valid.
     *
     * @param sizeOption the size option (S, M, or L)
     */
    public void updateSize(String sizeOption) {

        // Checks if the selected size is Small.
        if ("S".equals(sizeOption)) {
            selectedSize = "S";

            // Checks if the selected size is Medium.
        } else if ("M".equals(sizeOption)) {
            selectedSize = "M";

            // Checks if the selected size is Large.
        } else if ("L".equals(sizeOption)) {
            selectedSize = "L";

            // Displays an error message if the selected size is invalid.
        } else {
            System.out.println("Invalid beverage size. Please select S, M, or L.");
        }
    }

    /**
     * Calculates the final beverage price based on the selected size.
     *
     * @return the computed beverage price
     */
    @Override
    public double computePrice() {

        double prices = price;

        // Adds 15 to the base price if the selected size is Medium.
        if ("M".equals(selectedSize)) {
            prices = price + 15;

            // Adds 25 to the base price if the selected size is Large.
        } else if ("L".equals(selectedSize)) {
            prices = price + 25;
        }

        return prices;
    }

    /**
     * Returns the beverage description, including its selected size.
     *
     * @return the beverage description with its size
     */
    @Override
    public String getDescription() {

        String details = super.getDescription();

        return details + " | Size: " + selectedSize;
    }
}