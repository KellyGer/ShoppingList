
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GroceryShop extends Checkout implements Shop {

	private ShopWriter shopWriter;

	public GroceryShop(ShopWriter writer) {
		super();

		this.shopWriter = writer;
	}

	/**
	 * This method takes user input for item price and validates it is a double.
	 *
	 * @return price
	 */
	public double readPrice() {

		boolean isNotValid = true;
		double price = 0.00;

		Scanner input = new Scanner(System.in);

		while (isNotValid) {
			System.out.println("Enter the item price");

			if (input.hasNextDouble()) {
				price = input.nextDouble();
				isNotValid = false;
			} else {
				System.out.println("You must enter a valid price");
				isNotValid = true;
				input.next();
			}
		}
		return price;
	}

	/**
	 * This method takes user input for Item Name.
	 *
	 * @return name
	 */
	public String readItemName() {

		Scanner keyboard = new Scanner(System.in);
		System.out.println("Please enter an item name : ");
		String name = keyboard.next();
		return name;
	}

	/**
	 * This method checks if an integer is contained in an int array
	 *
	 * @param arr
	 * @param key
	 * @return
	 */
	public boolean contains(int[] arr, int key) {
		return Arrays.stream(arr).anyMatch(i -> i == key);
	}

	/**
	 * This method takes user input to create ShoppingItems and returns an ArrayList
	 * of ShoppingItems
	 * 
	 * @param skuId
	 * @param quantity
	 * @param priority
	 * @param addMoreItems
	 * @return items
	 */
	public ArrayList<ShoppingItems> createStore() {

		Scanner keyboard = new Scanner(System.in);
		int skuId = 1;
		int quantity = 1;
		int priority = 0;
		boolean addMoreItems = true;

		ArrayList<ShoppingItems> items = new ArrayList<>();
		do {
			ShoppingItems newItem = new ShoppingItems(readItemName(), readPrice(), (skuId), (quantity), (priority));

			for (ShoppingItems alreadyOnList : items) {
				if (newItem.equals(alreadyOnList)) {
					System.out.println("That item is already on your list, you can enter multiple quantities later");
				}
			}
			items.add(newItem);
			skuId++;
			System.out.println("Enter Y to add items" + "\nPress any other key to exit\n");
			String response = keyboard.next();
			if (!(response.equalsIgnoreCase("y"))) {
				addMoreItems = false;
			}
		} while (addMoreItems == true);

		return items;
	}

	/**
	 * This method creates an integer array of skuId numbers for items selected for
	 * purchase.
	 *
	 * @param items
	 * @return int [] options
	 */
	public int[] options(ArrayList<ShoppingItems> items) {
		int index = 0;
		int[] options = new int[items.size()];

		for (ShoppingItems item : items) {
			options[index] = item.getSkuId();
			index++;
		}
		return options;
	}

	/**
	 * This method takes user input to set priority and quantity of ShoppingItems
	 * Multiple priorities are allowed.
	 *
	 * @return ArrayList of ShoppingItems order
	 */
	public ArrayList<ShoppingItems> takeCustomerOrder(ArrayList<ShoppingItems> items) {
		final int exitCondition = 0;
		int selection;

		Scanner shopscanner = new Scanner(System.in);
		ArrayList<ShoppingItems> order = new ArrayList<ShoppingItems>();

		this.shopWriter.displayShopWindow(items);

		try {

			do {
				System.out.println("\nEnter item selection to add it to your Cart, or 0 to exit");

				while (!shopscanner.hasNextInt()) {
					System.out.println("Please enter a number:");
					shopscanner.nextLine();
				}
				selection = shopscanner.nextInt();
				if (!(contains(options(items), selection))) {
					throw new InvalidEntryException();
				}

				for (ShoppingItems item : items) {
					if (item.getSkuId() == selection) {
						System.out.println("Enter a quantity of  " + item.getName());
						item.setQuantity(shopscanner.nextInt());
						System.out.println("Enter a priority for " + item.getName());
						item.setPriority(shopscanner.nextInt());
						order.add(item);
					}
				}
			} while (selection != exitCondition);

		} catch (InvalidEntryException e) {
			System.out.println(e.getMessage());
		}

		return order;
	}

	/**
	 * This method creates creates an array of priority numbers
	 *
	 * @return int array
	 */
	public int[] prioritiseArray(ArrayList<ShoppingItems> order) {

		int index = 0;
		int[] priority = new int[order.size()];

		for (ShoppingItems orders : order) {
			int priorityNum = orders.getPriority();
			priority[index] = priorityNum;
			index++;
		}

		return priority;
	}

	/**
	 * This method calls the Sort class to put priorities in order]
	 *
	 * @return int array
	 */
	public int[] sortPriorityArray(int[] priority) {
		int[] sortedPriority = new int[priority.length];
		sortedPriority = quickSort(priority, 0, priority.length - 1);
		return sortedPriority;
	}
}
