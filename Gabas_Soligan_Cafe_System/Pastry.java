/**
 * Represents a pastry menu item that can be served heated or unheated.
 * Heating a pastry adds an additional charge to its base price.
 *
 * @author Renato Anthony M. Soligan
 * Jusuel M.Gabas
 * @version 1.0
 */
public class Pastry extends MenuItem {

    private boolean heated;

    /**
     * Creates a pastry with the default heating status set to false.
     */
    public Pastry() {
        super();
        heated = false;
    }

    /**
     * Creates a pastry with the specified details and heating status.
     *
     * @param name the name of the pastry
     * @param basePrice the base price of the pastry
     * @param itemCode the unique code of the pastry
     * @param heated the heating status of the pastry
     */
    public Pastry(String name, double basePrice, String itemCode, boolean heated) {
        super(name, basePrice, itemCode);
        this.heated = heated;
    }

    /**
     * Returns the current heating status of the pastry.
     *
     * @return true if the pastry is heated, otherwise false
     */
    public boolean getHeatedStatus() {
        return heated;
    }

    /**
     * Changes the heating status of the pastry.
     *
     * @param status the new heating status
     */
    public void changeHeatingStatus(boolean status) {
        heated = status;
    }

    /**
     * Calculates the final price of the pastry.
     * An additional charge of 10 is added if the pastry is heated.
     *
     * @return the computed pastry price
     */
    @Override
    public double computePrice() {

        double totalPrice = price;

        // Adds 10 to the base price if the pastry is heated.
        if (heated) {
            totalPrice += 10;
        }

        return totalPrice;
    }

    /**
     * Returns the pastry description, including its heating status.
     *
     * @return the pastry description with its heating condition
     */
    @Override
    public String getDescription() {

        // Displays the heating condition only if the pastry is heated.
        String condition = heated ? " (Heated)" : "";

        return super.getDescription() + condition;
    }
}