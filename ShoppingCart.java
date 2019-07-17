import java.util.ArrayList;
import java.util.Scanner;

public class ShoppingCart {

	/*
	 * Object of class Item(pencil)
	 */
	static Item pencil = new Item("pencil", 5.0);
	static Item eraser = new Item("eraser", 3.5);
	static Item sharpner = new Item("sharpner", 6.9);
	static Item scale = new Item("scale", 25.0);
	static Item notebook = new Item("notebook", 55.5);

	/*
	 * ArrayLists are for the storing of values
	 */

	static ArrayList<Item> items = new ArrayList<Item>();
	static ArrayList<Item> cart = new ArrayList<Item>();

	public static void main(String[] args) {

		int menu,option ,quantity;

		Scanner sc = new Scanner(System.in);

		System.out.println("Items Available (select specific options to choose from ) :-");
		System.out.println("[options]\t [ItemName]\t[Price(Rs)]");
		System.out.println("---------\t ----------\t ----------");
		System.out.println("1   \t\t  Pencil  \t  5.0");
		System.out.println("2   \t\t  Eraser  \t  3.5");
		System.out.println("3   \t\t  Sharpner  \t  6.9");
		System.out.println("4   \t\t  Scale   \t  25.0");
		System.out.println("5   \t\t  Notebook  \t  55.5\n");

		do {
			System.out.println(
					"[To add item press '1']\n[To update cart press '2']\n[To Show Cart press '3']\n[To generate bill press '4']");
			menu = sc.nextInt();
			if (menu == 1) {
				System.out.print("Choose from Available Option to Add items");
				option = sc.nextInt();
				System.out.print("Enter the quantity");
				quantity = sc.nextInt();

				switch (option) {

				case 1: {
					add(pencil, quantity);
					break;
				}
				case 2: {
					add(eraser, quantity);
					break;
				}
				case 3: {
					add(sharpner, quantity);
					break;
				}
				case 4: {
					add(scale, quantity);
					break;
				}
				case 5: {
					add(notebook, quantity);
					break;
				}
				default:
					System.out.println(" XXX Invalid Choice ...pls try again XXX ");

				}

			}

			else if (menu == 2) {
				System.out.print("Choose from Available Option to update/remove items");
				option = sc.nextInt();
				System.out.println(
						"Enter the quantity[ quantity as negative or zero will remove the product from the cart]");
				quantity = sc.nextInt();
				switch (option) {

				case 1: {
					if (cart.contains(pencil)) {
						// setting quantity as negative or zero will remove the product from the cart
						if (quantity <= 0) {
							cart.remove(pencil);
							System.out.println("Item removed succesfully\n");
						} else {
							pencil.product_quantity = quantity;
							System.out.println("Item updated succesfully\n");
						}

					}

					break;
				}
				case 2: {
					if (cart.contains(eraser)) {
						if (quantity <= 0) {
							cart.remove(eraser);
							System.out.println("Item removed succesfully\n");
						} else {
							eraser.product_quantity = quantity;
							System.out.println("Item updated succesfully\n");
						}

					}
					break;
				}
				case 3: {
					if (cart.contains(sharpner)) {
						if (quantity <= 0) {
							cart.remove(sharpner);
							System.out.println("Item removed succesfully\n");
						} else {
							sharpner.product_quantity = quantity;
							System.out.println("Item updated succesfully\n");
						}

					}
					break;
				}
				case 4: {
					if (cart.contains(scale)) {
						if (quantity <= 0) {
							cart.remove(scale);
							System.out.println("Item removed succesfully\n");
						} else {
							scale.product_quantity = quantity;
							System.out.println("Item updated succesfully\n");
						}

					}
				}
				case 5: {
					if (cart.contains(notebook)) {
						if (quantity <= 0) {
							cart.remove(notebook);
							System.out.println("Item removed succesfully\n");

						} else {
							notebook.product_quantity = quantity;
							System.out.println("Item updated succesfully\n");
						}

					}
				}

				}
			}

			else if (menu == 3) {
				showCart();
			}

			else if (menu == 4) {

				generateBills();
			}

			else {

				System.out.println("Please choose from the available options\n");
				continue;
			}

		} while (menu != 0);

	}

	public static void add(Item item, int quantity) {
		if (cart.contains(item)) {
			System.out.println("This Item already exists");

		} else {

			if (quantity > 0) {
				cart.add(item);
				item.product_quantity = quantity;
				System.out.println("Item Added succesfully\n");
			}
		}
	}

	public static void showCart() {
		System.out.println("\nItem Name\t" + "Item Qty\t" + "Item price(/piece)");
		System.out.println("==========\t" + "========\t" + "==================");
		for (Item value : cart) {
			System.out.println(
					value.product_itemname + "   \t   " + value.product_quantity + "   \t   " + value.product_price);
		}
	}

	public static void generateBills() {
		double total = 0;
		System.out.println("\nItem Name\t" + "Item Qty\t" + "Price(/piece)\t" + "Price");
		System.out.println("=========\t" + "========\t" + "=============\t" + "=====");
		for (Item value : cart) {
			System.out.println(value.product_itemname + "   \t   "
							+ value.product_quantity + "   \t   "
							+ value.product_price + "   \t   "
							+ (value.product_price * value.product_quantity));
			
			total = total + (value.product_price * value.product_quantity);
		}
		
		System.out.println("=========\t" + "========\t" + "=============\t" + "=====");
		
		System.out.println("\nTOTAL = " + total + "\n");
	}
}
