
import java.util.ArrayList;

public interface Shop {

	ArrayList<ShoppingItems> takeCustomerOrder(ArrayList<ShoppingItems> items);

	ArrayList<ShoppingItems> createStore();

	ArrayList<ShoppingItems> priorityCheckout(ArrayList<ShoppingItems> order, int[] sortedPriority,
			double startingBalance, ShopWriter writer);

	int[] prioritiseArray(ArrayList<ShoppingItems> order);

	int[] sortPriorityArray(int[] priority);
}
