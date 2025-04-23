import java.io.*;
import java.util.Scanner;


public class PayrollCalculator {
    public static void main(String[] args) {
        try {
            Scanner input =new Scanner(System.in);
            System.out.println("enter the name of the employee file to process:");
            String inputFile= input.nextLine();
            System.out.println("Enter the name of the Payroll file to create: ");
            String outPutFile=input.nextLine();
            //Read from the input file
            BufferedReader reader = new BufferedReader(new FileReader("../DataFiles/"+inputFile));
            reader.readLine();
            boolean isJson=outPutFile.toLowerCase().endsWith(".json");
            //write to the output file
            FileWriter writer = new FileWriter("../DataFiles"+outPutFile,true);
            //
            String line;
            if (isJson)writer.write("[\n");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");


                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hours = Double.parseDouble(parts[2]);
                double rate = Double.parseDouble(parts[3]);
                Employee emp = new Employee(id, name, hours, rate);
                if (isJson) {
                    // write in JSON format
                    writer.write(String.format("{ \"id\": %d, \"name\": \"%s\", \"grossPay\": %.2f },\n",
                            emp.getEmployeeId(), emp.getName(), emp.calculateGrossPay()));
                } else {
                    // write in CSV format
                    writer.write(emp.getEmployeeId() + "|" + emp.getName() + "|" +
                            String.format("%.2f", emp.calculateGrossPay()) + "\n");
                }
            }
            if (isJson) writer.write("]\n");

            reader.close();
            writer.close();

        } catch (Exception e) {
            System.out.println("Something went wrong: " + e.getMessage());
        }
    }
}
