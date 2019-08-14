package dictionary;

import java.util.Scanner;

public class Driver {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		DictionaryImplementation bst = new DictionaryImplementation();
		JsonInput jsonRead = new JsonInput();
		bst.root = jsonRead.Json("C:\\AMAN\\GET\\PF\\ASSIGNMENT2019\\DS_Session5\\KeyValue.json.txt");
		Scanner sc = new Scanner(System.in);

		int choice;
	
		
		while(true){
			System.out.println("Enter 1 for delete key value pair in dictionary ");
			System.out.println("Enter 2 to get the value corresponding to a specified key, ");
			System.out.println("Enter 3 to get sorted list of key value pairs ");
			System.out.println("Enter 4 to get sorted list of key value pairs for all the keys >=K1 and <=K2 ");
			System.out.println("Enter 5 for display ");
			System.out.println("Enter 6 for Exit ");
			choice  =sc.nextInt();
			switch (choice) {

			case 1:
				
				System.out.println("enter key -");
				int keyForRemove = sc.nextInt();
				bst.root = bst.deleteKey(keyForRemove);
				System.out.println("key deleted");
				break;

			case 2:
				System.out.println("enter key -");
				int keyForFind = sc.nextInt();
				String valueForFind = bst.getKeyValue(keyForFind);
				System.out.println(keyForFind + ": " + valueForFind);
				break;

			case 3:
				bst.list.clear();
				System.out.println("Sorted list of key value pair is ");
				bst.getSortedList(bst.root);
				for (int index = 0; index < bst.list.size(); index++) {
					System.out.println("\"" + bst.list.get(index).key + "\" : " + "  " + bst.list.get(index).value);
				}
				break;

			case 4:
				bst.listRange.clear();
				System.out.print("enter range from ");
				int k1 = sc.nextInt();
				System.out.println("to ");
				int k2 = sc.nextInt();
				bst.getSortedListRange(bst.root, k1, k2);
				System.out.println("Sorted list from " + k1 + " to " + k2);
				for (int index = 0; index < bst.listRange.size(); index++) {
					System.out.println("\"" + bst.listRange.get(index).key + "\" : " + "  " + bst.listRange.get(index).value);
				}
				break;
				
			case 5:
				bst.inOrderTraversal(bst.root);
				break;

			case 6:
				System.out.println("EXIT");
				System.exit(0);
				

			default:
				System.out.println("Invalid input ");
				break;
			}
			
		}
		

	}

}
