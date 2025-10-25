package week8;

// Claire Francis, Week8Program1, October 24, 2025

// Create a program that allows a user to build a list of items (the items could be combination of integers, decimal numbers, characters and/or strings). 
// After building the list the user is able to add, remove or edit any item from the list.  
// Use a while loop to allow the user to keep changing the list until done. 

import java.util.ArrayList;
import java.util.Scanner;

public class Week8Program1 {
	static Scanner userinput = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<String> items = new ArrayList<>();
		
		System.out.println("Building your List.");
		System.out.println("Enter items (type 'done' when finished): ");
		
		
		while(true) {
			System.out.print("Enter an item: ");
			String item = userinput.nextLine();
			if(item.equalsIgnoreCase("done")) {
				break;
			}
			items.add(item);
		}
		
		boolean running = true;
		while(running) {
			System.out.println("\nCurrent List");
			if(items.isEmpty()) {
				System.out.println("The list is currently empty.");
			}
			else {
				for(int i=0; i < items.size(); i++) {
					System.out.println(i + ": " + items.get(i));
				}
			}
			
			System.out.println("\nWhat would you like to do?");
			System.out.println("1 - Add an item");
			System.out.println("2 - Edit an item");
			System.out.println("3 - Remove an item");
			System.out.println("4 - Display the list");
			System.out.println("5 - Quit");
			System.out.println("Choose an option: ");
			
			String choice = userinput.nextLine();
			
			switch(choice) {
				case "1":
					System.out.println("Enter the new item to add: ");
					String newItem = userinput.nextLine();
					items.add(newItem);
					System.out.println("Item added.");
					break;
					
				case "2":
					if(items.isEmpty()) {
						System.out.println("The list is empty. Nothing to edit.");
						break;
					}
					System.out.println("Enter the new value: ");
					try {
						int editIndex = Integer.parseInt(userinput.nextLine());
						if(editIndex >= 0 && editIndex < items.size()) {
							System.out.print("Enter the new value: ");
							String editedValue = userinput.nextLine();
							items.set(editIndex, editedValue);
							System.out.println("item updated.");
					
						}		
						else {
							System.out.println("Invalid Index.");
						}
						
					}
					catch(NumberFormatException e) {
						System.out.println("Please enter a valid number for the index.");
					}
					break;
					
				case "3":
					if(items.isEmpty()) {
						System.out.println("List is empty. Nothing to remove.");
						try {
							int removeIndex = Integer.parseInt(userinput.nextLine());
							if(removeIndex >= 0 && removeIndex < items.size()) {
								items.remove(removeIndex);
								System.out.println("Item removed.");
								
							}
							else {
								System.out.println("Invalid index.");
							}
						}
						catch(NumberFormatException e) {
							System.out.println("Please enter a valid number for the index.");
						}
						break;}
						
						case "4":
							System.out.println("Your current list: ");
							for(int i = 0; i < items.size(); i++) {
								System.out.println(i + ": " + items.get(i));
							}
							break;
							
						case "5":
							running = false;
							System.out.println("Exiting program. Goodbye.");
							break;
							
						default:
							System.out.println("Invalid choice. Please try again.");
							break;
							
					}
			}
		}

	}


