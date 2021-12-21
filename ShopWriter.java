
import java.util.ArrayList;

/**
 * ShopWriter defines display and write operations for a shop
 */
public interface ShopWriter {

  void displayShopWindow(ArrayList<ShoppingItems> items);

  void displayShoppingList(ArrayList<ShoppingItems> order);

  void writeShoppingList(ArrayList<ShoppingItems> order);

  void displayPurchasedItems(
      ArrayList<ShoppingItems> purchasedItems,
      double bankAccount,
      double totalSpent,
      double remainingFunds);

  void displayRemainingItems(ArrayList<ShoppingItems> didNotBuy);

  void displayBankAcount(double bankAccount);
}
