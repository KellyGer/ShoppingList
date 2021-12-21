
import java.util.ArrayList;

public interface Output {

	void displayShopWindow(ArrayList<ShoppingItems> items);

	void displayShoppingList(ArrayList<ShoppingItems> order);

	public void displayPurchasedItems(ArrayList<ShoppingItems> purchasedItems, double bankAccount, double totalSpent,
			double remainingFunds);

	void displayRemainingItems(ArrayList<ShoppingItems> didNotBuy);
}
