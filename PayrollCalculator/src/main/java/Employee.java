public class Employee {

    private int employeeId;
    private String name;
    private double hourWorked;
    private double payRate;

    public Employee(int employeeId, String name, double hourWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hourWorked = hourWorked;
        this.payRate = payRate;
    }
    public double calculateGrossPay(){
        return hourWorked*payRate;
    }



    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHourWorked() {
        return hourWorked;
    }

    public void setHourWorked(double hourWorked) {
        this.hourWorked = hourWorked;
    }

    public double getPayRate() {
        return payRate;
    }

    public void setPayRate(double payRate) {
        this.payRate = payRate;
    }



}
