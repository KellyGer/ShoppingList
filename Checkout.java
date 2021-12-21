import java.util.ArrayList;
import java.util.Arrays;


public class Checkout extends AbstractSort {

	/**
	 * This method iterates over order array and purchases/does not purchase
	 * depending on budget. displays items purchased, not purchased and funds
	 * remaining.
	 */
	public ArrayList<ShoppingItems> priorityCheckout(ArrayList<ShoppingItems> order, int[] sortedPriority,
			double bankAccount, ShopWriter shopWriter) {
		double remainingFunds = bankAccount;
		double totalSpent = 0;

		ArrayList<ShoppingItems> purchasedItems = new ArrayList<ShoppingItems>();
		ArrayList<ShoppingItems> didNotBuy = new ArrayList<ShoppingItems>();

		sortedPriority = Arrays.stream(sortedPriority).distinct().toArray();

		for (int n : sortedPriority) {

			for (ShoppingItems orders : order) {
				if (n == orders.getPriority()) {

					double totalItemPrice = ((orders.getPrice()) * (orders.getQuantity()));

					if (remainingFunds - totalItemPrice >= 0) {
						remainingFunds = remainingFunds - totalItemPrice;
						totalSpent = totalSpent + totalItemPrice;
						purchasedItems.add(orders);

					} else {
						didNotBuy.add(orders);
					}
				}
			}
		}

		shopWriter.displayBankAcount(bankAccount);
		shopWriter.displayShoppingList(order);
		shopWriter.displayPurchasedItems(purchasedItems, bankAccount, totalSpent, remainingFunds);
		shopWriter.displayRemainingItems(didNotBuy);

//  shopWriter.writeShoppingList(order);
		shopWriter.writeShoppingList(didNotBuy);

		return purchasedItems;
	}
}
