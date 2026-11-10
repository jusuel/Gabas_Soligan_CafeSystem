/**
 * Represents a restaurant customer with student status and reward points.
 * Customers can earn points through payments and update their personal information.
 *
 * @author Renato Anthony M. Soligan
 * Jusuel M.Gabas
 * @version 1.0
 */
public class Customer {

    private String customerName;
    private boolean isStudent;
    private int points;

    /**
     * Creates a customer with default values.
     * The default name is Guest, student status is false, and points are zero.
     */
    public Customer() {
        customerName = "Guest";
        isStudent = false;
        points = 0;
    }

    /**
     * Creates a customer with the specified name.
     *
     * @param customerName the name of the customer
     */
    public Customer(String customerName) {
        this.customerName = customerName;
        isStudent = false;
        points = 0;
    }

    /**
     * Creates a customer with the specified name and student status.
     *
     * @param customerName the name of the customer
     * @param isStudent the student status of the customer
     */
    public Customer(String customerName, boolean isStudent) {
        this.customerName = customerName;
        this.isStudent = isStudent;
        points = 0;
    }

    /**
     * Returns the customer's name.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Returns the customer's student status.
     *
     * @return true if the customer is a student, otherwise false
     */
    public boolean getStudentStatus() {
        return isStudent;
    }

    /**
     * Updates the customer's student status.
     *
     * @param student the new student status
     */
    public void setStudent(boolean student) {
        isStudent = student;
    }

    /**
     * Returns the customer's current reward points.
     *
     * @return the total reward points
     */
    public int getPoints() {
        return points;
    }

    /**
     * Adds the specified number of points to the customer's balance.
     *
     * @param newPoints the number of points to add
     */
    public void earnPoints(int newPoints) {

        // Adds points if the entered value is zero or positive.
        if (newPoints >= 0) {
            points = points + newPoints;

            // Displays an error message if the entered points are negative.
        } else {
            System.out.println("Invalid points entered.");
        }
    }

    /**
     * Calculates reward points based on the payment amount.
     * One point is earned for every 50 units of payment.
     *
     * @param payment the payment amount used to calculate reward points
     */
    public void earnPoints(double payment) {

        // Calculates reward points if the payment amount is valid.
        if (payment >= 0) {
            int earned = (int) (payment / 50);
            earnPoints(earned);

            // Displays an error message if the payment amount is negative.
        } else {
            System.out.println("Invalid payment amount.");
        }
    }

    /**
     * Updates the customer's name.
     *
     * @param newName the new customer name
     */
    public void updateName(String newName) {
        customerName = newName;
    }

    /**
     * Updates the customer's reward points.
     *
     * @param newPoints the new total number of points
     */
    public void updatePoints(int newPoints) {

        // Updates the points if the entered value is zero or positive.
        if (newPoints >= 0) {
            points = newPoints;

            // Displays an error message if the entered points are negative.
        } else {
            System.out.println("Points must not be negative.");
        }
    }

    /**
     * Updates the customer's student status.
     *
     * @param status the new student status
     */
    public void updateStudentStatus(boolean status) {
        isStudent = status;
    }
}