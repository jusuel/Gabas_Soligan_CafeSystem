/**
 * Serves as the main application class for the Cafe Ordering System.
 * Creates customers and menu items, processes orders, and displays
 * receipts with applicable discounts and vouchers.
 *
 * @author Renato Anthony M. Soligan
 * Jusuel M.Gabas
 * @version 1.0
 */
public class CafeApp {

    /**
     * Starts the Cafe Ordering System application.
     * Creates sample customers and menu items, processes two orders,
     * and displays their corresponding receipts.
     *
     * @param args command-line arguments passed to the application
     */
    public static void main(String[] args) {

        System.out.println("====== CAFE ORDERING SYSTEM ======");

        // Creates two customers with different student statuses.
        Customer firstCustomer = new Customer("Rey Soligan", true);
        Customer secondCustomer = new Customer("Jusuel Gabas");

        // Creates menu items using parameterized constructors.
        Beverage latte = new Beverage("Iced Latte", 95, "B-01", "L");
        Pastry ensaymada = new Pastry("Ensaymada", 45, "P-01", true);
        Meal adobo = new Meal("Chicken Adobo", 110, "M-01", true, 1);

        // Creates a beverage using the default constructor and updates its details.
        Beverage hotChocolate = new Beverage();
        hotChocolate.changeName("Hot Chocolate");
        hotChocolate.changeCode("B-02");
        hotChocolate.updateSize("M");

        // Tests an invalid price before assigning a valid price.
        hotChocolate.changePrice(-5);
        hotChocolate.changePrice(80);

        // Creates a pastry using the default constructor and updates its details.
        Pastry cookie = new Pastry();
        cookie.changeName("Cookie");
        cookie.changeCode("P-02");
        cookie.changePrice(30);

        // Creates a meal using the default constructor and updates its details.
        Meal beefTapa = new Meal();
        beefTapa.changeName("Beef Tapa");
        beefTapa.changeCode("M-02");
        beefTapa.changePrice(130);
        beefTapa.changeSize(false);
        beefTapa.changePrice(0);

        // Creates the first order for a student customer.
        Order firstOrder = new Order("1001", firstCustomer);

        // Adds three menu items to the first order.
        firstOrder.addItem(latte);
        firstOrder.addItem(ensaymada);
        firstOrder.addItem(adobo);

        // Displays the first order receipt with the student discount.
        firstOrder.displayReceipt();

        System.out.println();

        // Creates the second order for a regular customer.
        Order secondOrder = new Order("1002", secondCustomer);

        // Adds two menu items to the second order.
        secondOrder.addItem(hotChocolate);
        secondOrder.addItem(beefTapa);

        // Displays the second order receipt with a 20-unit voucher.
        secondOrder.displayReceipt(20);

        System.out.println();
        System.out.println("====== THANK YOU FOR VISITING! ======");
    }
}