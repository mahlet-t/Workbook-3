import java.io.FileReader;
import java.io.BufferedReader;


public class PayrollCalculator {
    public static void main(String[] args) {
                try {
                    FileReader fileReader = new FileReader("C:/Users/mahle/pluralsight/Workbook-3/DataFiles/employees.csv/");
                    BufferedReader reader = new BufferedReader(fileReader);
                    reader.readLine();
                    String line;
                    while ((line = reader.readLine()) != null) {
                        String[] parts = line.split("\\|");


                        int id = Integer.parseInt(parts[0]);
                        String name = parts[1];
                        double hours = Double.parseDouble(parts[2]);
                        double rate = Double.parseDouble(parts[3]);
                        Employee emp = new Employee(id, name, hours, rate);
                        System.out.printf("ID: %d, Name: %s, Gross Pay: $%.2f%n",
                                emp.getEmployeeId(), emp.getName(), emp.calculateGrossPay());
                    }

                    reader.close();

                } catch (Exception e) {
                    System.out.println("Something went wrong: " + e.getMessage());
                }
            }
        }

