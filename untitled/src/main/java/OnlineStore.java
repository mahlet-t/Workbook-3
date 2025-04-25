import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class OnlineStore {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        ArrayList<product> products=getInventory();
        Cart cart=new Cart();
        cart.addNewProduct(products,input);
        cart.removeProduct(input);
        cart.checkOut(input);


    }

    public static ArrayList<product> getInventory() {
        ArrayList<product> products = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader("../DataFiles/product.csv"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                String sku = (parts[0]);
                String productsName = parts[1];
                double price = Double.parseDouble(parts[2]);
                String Department = parts[3];
                products.add(new product(sku, productsName, price, Department));
            }
            reader.close();
            products.sort((p1, p2) -> p1.getProductName().compareToIgnoreCase(p2.getProductName()));
        } catch (Exception e) {
            System.out.println("invalid input");

        }
        return products;
    }
    public static void listAllProduct(ArrayList<product>products){

        System.out.println("Here is all Item We have\n");
        for(product P:products){
            System.out.println(P);
        }
    }
    public static void SearchByName(ArrayList<product>products,Scanner input){
        System.out.println("Enter Product Name ");
        String name=input.nextLine();
        for (product P:products)
            if (P.getProductName().equalsIgnoreCase(name)){
            System.out.println("Found: "+P);

            }


    }
    public static void searchByPrice(ArrayList<product>products,Scanner input){
        System.out.println("Enter Max price");
        double Max=input.nextDouble();
        input.nextLine();
        System.out.println("Enter min price");
        double Min=input.nextDouble();
        input.nextLine();
        for (product P:products){
            double price=P.getPrice();

            if (price<=Max&& price>=Min){
                System.out.println("Found: ");
            }
            else {
                System.out.println("Not Found");
            }

        }
    }
    public static void SearchByDepartment(ArrayList<product>products,Scanner input){
        System.out.println("Enter Department");
        String D=input.nextLine();
        for (product P:products){
            if (P.getDepartment().equalsIgnoreCase(D)){
                System.out.println("Found:");
            }
            else {
                System.out.println("Not Found");
            }
        }
    }
}
