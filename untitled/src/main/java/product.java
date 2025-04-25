public class product {
    private String sku;
    private String productName;
    private double price;
    private String department;

    public product(String sku, String productName, double price, String department) {
        this.sku = sku;
        this.productName = productName;
        this.price = price;
        this.department = department;
    }

    public String getSku() {
        return sku;
    }

    public String getProductName() {
        return productName;
    }

    public double getPrice() {
        return price;
    }

    public String getDepartment() {
        return department;
    }
    public String toString(){
     return "Sku: "+sku+","+"Product Name: "+productName+","+"Price: "+price+","+"Department: "+department;}
    }

