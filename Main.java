
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		ShopWriter writer = new GroceryShopWriter();
		Shop groceryShop = new GroceryShop(writer);
		ArrayList<ShoppingItems> items = groceryShop.createStore();
		ArrayList<ShoppingItems> order = groceryShop.takeCustomerOrder(items);

		int[] priority = groceryShop.prioritiseArray(order);
		int[] sortedPriority = groceryShop.sortPriorityArray(priority);
		double bankAccount = getAvailableFunds();

		groceryShop.priorityCheckout(order, sortedPriority, bankAccount, writer);
	}

	/**
	 * This method takes user input for available funds and validates it is a
	 * double.
	 *
	 * @return price
	 */
	public static double getAvailableFunds() {

		boolean isNotValid = true;
		double bankAccount = 0.00;

		Scanner input = new Scanner(System.in);

		while (isNotValid) {
			System.out.println("Please enter your budget.");

			if (input.hasNextDouble()) {
				bankAccount = input.nextDouble();
				isNotValid = false;
			} else {
				System.out.println("You must enter a valid amount");
				isNotValid = true;
				input.next();
			}
		}
		return bankAccount;
	}
}
