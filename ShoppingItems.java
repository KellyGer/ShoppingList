
import java.util.Objects;


public class ShoppingItems {

	private int skuId;
	private String name;
	private double price;
	private int quantity;
	private int priority;

	public ShoppingItems(String newItemName, double newItemPrice, int newSkuId, int newQuantity, int newPriority) {

		name = newItemName;
		price = newItemPrice;
		skuId = newSkuId;
		quantity = newQuantity;
		priority = newPriority;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getSkuId() {
		return skuId;
	}

	public ShoppingItems setSkuId(int skuId) {
		this.skuId = skuId;
		return this;
	}

	public String getName() {
		return name;
	}

	public ShoppingItems setName(String name) {
		this.name = name;
		return this;
	}

	public double getPrice() {
		return price;
	}

	public ShoppingItems setPrice(double price) {
		this.price = price;
		return this;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ShoppingItems that = (ShoppingItems) o;
		return Double.compare(that.price, price) == 0 && Objects.equals(name, that.name);
	}
}
