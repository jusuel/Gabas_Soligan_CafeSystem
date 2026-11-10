/**
 * Represents a restaurant order containing a customer and up to three menu items.
 * Calculates subtotals, applies student discounts and vouchers,
 * displays receipts, and awards loyalty points.
 *
 * @author Renato Anthony M. Soligan
 * Jusuel M.Gabas
 * @version 1.0
 */
public class Order {

    private Customer buyer;
    private MenuItem firstItem, secondItem, thirdItem;
    private int quantity;
    private String referenceNumber;

    /**
     * Creates an order with the specified reference number and customer.
     *
     * @param referenceNumber the unique reference number of the order
     * @param buyer the customer who placed the order
     */
    public Order(String referenceNumber, Customer buyer) {
        this.quantity = 0;
        setReferenceNumber(referenceNumber);
        setBuyer(buyer);
    }

    /**
     * Returns the customer who placed the order.
     *
     * @return the customer associated with the order
     */
    public Customer getBuyer() {
        return buyer;
    }

    /**
     * Sets the customer associated with the order.
     *
     * @param buyer the customer who placed the order
     */
    public void setBuyer(Customer buyer) {
        this.buyer = buyer;
    }

    /**
     * Returns the order's reference number.
     *
     * @return the order reference number
     */
    public String getReferenceNumber() {
        return referenceNumber;
    }

    /**
     * Sets the reference number of the order.
     *
     * @param referenceNumber the new order reference number
     */
    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    /**
     * Returns the current number of items in the order.
     *
     * @return the total quantity of items
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Adds a menu item to the order if there is an available slot.
     * The order can contain a maximum of three items.
     *
     * @param newItem the menu item to be added
     * @return true if the item was successfully added, otherwise false
     */
    public boolean addItem(MenuItem newItem) {

        // Places the item in the first slot if it is empty.
        if (firstItem == null) {
            firstItem = newItem;

            // Places the item in the second slot if it is empty.
        } else if (secondItem == null) {
            secondItem = newItem;

            // Places the item in the third slot if it is empty.
        } else if (thirdItem == null) {
            thirdItem = newItem;

            // Rejects the item if all three slots are occupied.
        } else {
            System.out.println("Order limit reached! " +
                    "Cannot add: " + newItem.getDescription());
            return false;
        }

        quantity++;
        return true;
    }

    /**
     * Calculates the subtotal of all menu items in the order.
     *
     * @return the total price before discounts and vouchers
     */
    public double calculateSubtotal() {

        double amount = 0;

        // Adds the first item's price if the slot is occupied.
        if (firstItem != null) {
            amount += firstItem.computePrice();
        }

        // Adds the second item's price if the slot is occupied.
        if (secondItem != null) {
            amount += secondItem.computePrice();
        }

        // Adds the third item's price if the slot is occupied.
        if (thirdItem != null) {
            amount += thirdItem.computePrice();
        }

        return amount;
    }

    /**
     * Calculates the total payment after applying the student discount.
     * Students receive a 10% discount on their subtotal.
     *
     * @return the total payment after the student discount
     */
    public double calculateTotal() {

        double amount = calculateSubtotal();

        // Applies a 10% discount if the customer is a student.
        if (buyer.getStudentStatus()) {
            amount = amount * 0.90;
        }

        return amount;
    }

    /**
     * Calculates the final payment after deducting a voucher.
     * Returns zero if the resulting amount is negative.
     *
     * @param voucherAmount the voucher amount to be deducted
     * @return the final payment after applying the voucher
     */
    public double calculateTotal(double voucherAmount) {

        double amount = calculateTotal() - voucherAmount;

        // Rejects the transaction if the final amount is negative.
        if (amount < 0) {
            System.out.println("Invalid transaction! Total cannot be negative.");
            return 0;
        }

        return amount;
    }

    /**
     * Displays the order receipt without applying a voucher.
     */
    public void displayReceipt() {
        displayReceipt(0);
    }

    /**
     * Displays the order receipt with the specified voucher deduction.
     * Also calculates loyalty points earned from the final payment.
     *
     * @param voucherAmount the voucher amount to be deducted
     */
    public void displayReceipt(double voucherAmount) {

        double subtotal = calculateSubtotal();
        double regularTotal = calculateTotal();
        double finalAmount = calculateTotal(voucherAmount);
        double discountAmount = subtotal - regularTotal;

        System.out.println("================================");
        System.out.println("          ORDER RECEIPT         ");
        System.out.println("================================");

        // Displays the customer information with student status if applicable.
        if (buyer.getStudentStatus()) {
            System.out.println("Order No.: " + referenceNumber +
                    " - " + buyer.getCustomerName() + " (Student)");

            // Displays the customer information without student status.
        } else {
            System.out.println("Order No.: " + referenceNumber +
                    " - " + buyer.getCustomerName());
        }

        // Displays the first item if the slot is occupied.
        if (firstItem != null) {
            System.out.println(firstItem.getDescription() +
                    " ............ " + firstItem.computePrice());
        }

        // Displays the second item if the slot is occupied.
        if (secondItem != null) {
            System.out.println(secondItem.getDescription() +
                    " ............ " + secondItem.computePrice());
        }

        // Displays the third item if the slot is occupied.
        if (thirdItem != null) {
            System.out.println(thirdItem.getDescription() +
                    " ............ " + thirdItem.computePrice());
        }

        System.out.println("--------------------------------");
        System.out.println("Subtotal: " + subtotal);

        // Displays the student discount if the customer is a student.
        if (buyer.getStudentStatus()) {
            System.out.println("Student Discount (10%): -" +
                    discountAmount);
        }

        // Displays the voucher deduction if the voucher amount is positive.
        if (voucherAmount > 0) {
            System.out.println("Voucher: -" + voucherAmount);
        }

        System.out.println("--------------------------------");
        System.out.println("Total Payment: " + finalAmount);
        System.out.println("================================");

        buyer.earnPoints(finalAmount);

        System.out.println("Loyalty Points: " +
                buyer.getPoints());
    }
}