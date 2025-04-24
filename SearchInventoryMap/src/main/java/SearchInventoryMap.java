import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Scanner;

public class SearchInventoryMap {
    public static void main(String[] args) {
        HashMap<String, Product> inventory = new HashMap<>();
        loadInventory(inventory);
        Scanner input = new Scanner(System.in);
        try {
            boolean keepRunning = true;
            while (keepRunning) {
                while (true) {
                    System.out.println("Enter product name to search");
                    String Name = input.nextLine();
                    Product p = inventory.get(Name);
                    if (p != null) {
                        System.out.println("Found: " + p);break;
                    } else {
                        System.out.println("Not found");
                    }
                }
                System.out.println("Do you want search again (Yes/No)");
                String choose = input.nextLine().trim();
                if (choose.equalsIgnoreCase("yes")) {
                    System.out.println();
                } else if (choose.equalsIgnoreCase("no")) {
                    System.out.println("Good bye");
                    keepRunning=false;
                }
                else {
                    System.out.println("Invalid input Please type (yes/no)");
                }
            }
        } catch (Exception e) {
            System.out.println("Wrong input");
        }
        input.close();
    }

    //....................................................................
    public static void loadInventory(HashMap<String, Product> inventory) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("../DataFiles/inventory.csv"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double price = Double.parseDouble(parts[2]);
                Product product = new Product(id, name, price);
                inventory.put(name, product);

            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Invalid:" + e.getMessage());
        }
    }
}
