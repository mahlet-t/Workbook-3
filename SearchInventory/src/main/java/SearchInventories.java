import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SearchInventories {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        getInventory();
        ArrayList<product>inventory=getInventory();
        //show the inventory
        try {

            System.out.println("we carry the following inventory:");
            for (product p:inventory) {
                System.out.printf("Id: %d , %s , price:$%.2f\n", p.getId(), p.getName(), p.getPrice());
            }
            boolean keepRunning=true;
            while (keepRunning) {
                // ask user
                System.out.println("what do you want to do");
                System.out.println("1-List all product");
                System.out.println("2-lookup a product by its Id");
                System.out.println(" 3-Find all product within a price range");
                System.out.println("4-Add a new product");
                System.out.println("5-Quit the application");
                System.out.println("Enter command");
                int command = input.nextInt();
                input.nextLine();
                switch (command) {
                    case 1:
                        ListAllProduct(inventory);
                        break;
                    case 2:
                        LookUpByItsId(inventory, input);
                        break;
                    case 3:
                        LookUpBYPriceRange(inventory, input);
                        break;
                    case 4:
                        AddNewProduct(inventory, input);
                        break;
                    case 5:
                        System.out.println("Good Bye!");
                        keepRunning=false; break;
                    default:
                        System.out.println("Invalid choice");
                }
                if (keepRunning){
                    System.out.println("Do you want choose another option(yes/no): ");
                    String again=input.nextLine();
                    if (!again.equalsIgnoreCase("yes")){
                        keepRunning=false;
                        System.out.println("Thanks for using the app!");

                    }
                }


            }


        }catch (Exception e){
            System.out.println("invalid input try again");
        }


    }
    //..............................................................
   public static  ArrayList<product> getInventory(){
        ArrayList<product> inventory=new ArrayList<>();
       try {
           BufferedReader reader =new  BufferedReader(new FileReader("../DataFiles/inventory.csv"));
           String line;
           while ((line= reader.readLine())!=null){
               String[] parts=line.split("\\|");
               int id =Integer.parseInt(parts[0]);
               String name=parts[1];
               double price=Double.parseDouble( parts[2]);
               inventory.add(new product(id,name,price));
           }
       reader.close();
       inventory.sort((p1,p2)->p1.getName().compareToIgnoreCase(p2.getName()));

        }catch (Exception e){
            System.out.println("invalid"+e.getMessage());
        }
       return inventory;


   }
   //......................................................................

        public static void ListAllProduct(ArrayList<product>inventory){
        for (product p :inventory){
            System.out.printf("Id: %d , %s , price:$%.2f\n",p.getId(),p.getName(),p.getPrice());

        }


    }
    //.................................................................................
    public static void LookUpByItsId(ArrayList<product>inventory,Scanner input){
        System.out.println("Enter the Id");
        int I=input.nextInt();
        input.nextLine();
       for (product p:inventory)

            if (p.getId()==I){
                System.out.printf("Id: %d , %s , price:$%.2f\n",p.getId(),p.getName(),p.getPrice());

                   return;
            }

    }
    //..........................................................................................
    public static void LookUpBYPriceRange(ArrayList<product>inventory,Scanner input){
        System.out.println("Enter max price");
        double Mp=input.nextDouble();
        input.nextLine();
        System.out.println("Enter minimum price");
        double mP=input.nextDouble();
        input.nextLine();
        for (product p:inventory) {
            double price = p.getPrice();
            if (price>=mP&&price<=Mp){
                System.out.printf("Id: %d , %s , price:$%.2f\n",p.getId(),p.getName(),p.getPrice());

            }
        }
    }
    //................................................................................................................
    public static void AddNewProduct(ArrayList<product>inventory,Scanner input){
        System.out.println("Enter product Id ");
        int Id=input.nextInt();
        input.nextLine();
        System.out.println("Enter product Name");
        String Name=input.nextLine();
        System.out.println("Enter product Price");
        double Price=input.nextDouble();
        input.nextLine();
        product p=new product(Id,Name,Price);
        inventory.add(p);
        System.out.println("Product Added Successfully");
    }


   }
