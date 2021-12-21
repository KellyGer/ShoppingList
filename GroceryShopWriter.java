import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/** Provides concrete implementations for ShopWriter */
public class GroceryShopWriter implements ShopWriter {

	@Override
	public void writeShoppingList(ArrayList<ShoppingItems> order) {
		StringBuilder sb = new StringBuilder();
		for (ShoppingItems item : order) {
			sb.append("Item name: " + item.getName() + " Price : " + item.getPrice() + " Quantity: "
					+ item.getQuantity() + " Priority: " + item.getPriority() + "\n");
		}

		try (BufferedWriter writer = new BufferedWriter(new FileWriter("shoppinglist.txt"))) {
			writer.write(sb.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void displayShopWindow(ArrayList<ShoppingItems> items) {
		for (ShoppingItems item : items) {
			System.out.printf("Item name: %s , Price : %s Selection # %d \n", item.getName(), item.getPrice(),
					item.getSkuId());
		}
	}

	public void displayShoppingList(ArrayList<ShoppingItems> order) {
		System.out.println("Original List");
		for (ShoppingItems item : order) {
			System.out.printf("Item name: %s , Price : %s , Quantity: %d, Priority: %d \n", item.getName(),
					item.getPrice(), item.getQuantity(), item.getPriority());
		}
	}

	public void displayPurchasedItems(ArrayList<ShoppingItems> purchasedItems, double bankAccount, double totalSpent,
			double remainingFunds) {
		System.out.println("\nPurchased: ");
		for (ShoppingItems item : purchasedItems) {
			System.out.printf("Item name: %s , Price: $%s , Quantity:  %d \n", item.getName(), item.getPrice(),
					item.getQuantity());
		}
		System.out.println("\nOriginal Balance $" + bankAccount + ". Total Spent $" + totalSpent + ". Remaining funds $"
				+ remainingFunds);
	}

	public void displayRemainingItems(ArrayList<ShoppingItems> didNotBuy) {
		System.out.println("\nDid not purchase items:");
		for (ShoppingItems item : didNotBuy) {
			System.out.printf("Item name: %s , Price : %s , Quantity: %d\n", item.getName(), item.getPrice(),
					item.getQuantity());
		}
	}

	public void displayBankAcount(double bankAccount) {
		System.out.println("Your available funds are + $" + bankAccount);
	}
}
