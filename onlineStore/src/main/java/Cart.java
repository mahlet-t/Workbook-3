import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Cart {

   private final Map<product,Integer>cartItems=new HashMap<>();
   public void addNewProduct(ArrayList<product> products, Scanner input){
      boolean found=false;
      while (!found) {
         System.out.println("Enter product Name");
         String Name = input.nextLine();
         //find products from the product list
         product selectedProducts = null;
         for (product p : products) {
            if (p.getProductName().equalsIgnoreCase(Name)) {
               selectedProducts = p;
               break;
            }
         }
         if (selectedProducts != null) {
            // add to cart
            if (cartItems.containsKey(selectedProducts)) {
               cartItems.put(selectedProducts, cartItems.get(selectedProducts) + 1);
            } else {
               cartItems.put(selectedProducts, 1);
            }
            System.out.println("Product Added Successfully");
            found=true;
         } else {
            System.out.println("Not found");
         }
      }
   }
      //...........................................................
   public void removeProduct(Scanner input){
      boolean found=false;
      while (!found){
         System.out.println("Enter the product you want to remove");
         String Rp = input.nextLine();
         product selectedProduct = null;
         for (product p : cartItems.keySet()) {
            if (p.getProductName().equalsIgnoreCase(Rp)) {
               selectedProduct = p;
               break;
            }
         }
         if (selectedProduct != null) {
            int quantity = cartItems.get(selectedProduct);
            if (quantity > 1) {
               cartItems.put(selectedProduct, quantity - 1);

            } else {
               cartItems.remove(selectedProduct);
            }
            System.out.println("Product removed Successfully.");
            found=true;
         }
         else {
            System.out.println("Product not found in the cart");
         }
      }
   }
//...........................................................................
   public void checkOut(Scanner input) {
      double total = 0;
      for (product p : cartItems.keySet()) {
         double price = p.getPrice();
         int quantity = cartItems.get(p);
         total += price * quantity;
      }
      System.out.println("Total amount: $" + String.format("%.2f", total));
      //
      System.out.println("Enter payment amount:");
      double payment = input.nextDouble();
      input.nextLine();
      //
      double change = payment - total;
      if (payment >= total) {
         System.out.println("Payment accepted.");
         System.out.println("Change given: $" + String.format("%.2f", change));

         System.out.println("\nOrder Date:" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")));
         for (product p : cartItems.keySet()) {
            int quantity = cartItems.get(p);
            System.out.println(p.getProductName() + "-Quantity:" + quantity);
         }
         System.out.println("Sales Total............: $" + String.format("%.2f", total));
         System.out.println("Amount paid: $" + String.format("%.2f", payment));
         System.out.println("Change Given: $" + String.format("%.2f", change));
         System.out.println("Thank you for using online order");


         String fileName = "../Receipts/" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmm")) + ".txt";
         try {
            FileWriter writer = new FileWriter(fileName);
            writer.write("order Date:............" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "\n");
            for (product p : cartItems.keySet()) {
               int quantity = cartItems.get(p);
               writer.write(p.getProductName() + "-Quantity:.......... " + quantity + "\n");
            }
            writer.write("Sales Total............: $" + String.format("%.2f", total) + "\n");
            writer.write("Amount paid: $" + String.format("%.2f", payment));
            writer.write("Change Given: $" + String.format("%.2f", change));
            writer.write("Thank you for using online order");
            writer.close();
         } catch (IOException e) {
            System.out.println("Error writing receipt:" + e.getMessage());

         }
         cartItems.clear();
         }
      else{
         System.out.println("Not enough money.Please try again");
      }
   }
   }
