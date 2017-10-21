public class Product 
{
    private int productID;
    private String name;
    private double price;
    private double quantity;
    private double tax;

    public double getPrice() 
    {
        return price;
    }

    public void setPrice(double price) 
    {
        this.price = price;
    }

    public int getProductID() 
    {
        return productID;
    }

    public void setProductID(int productID) 
    {
        this.productID = productID;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public double getQuantity() 
    {
        return quantity;
    }
    
    public double getTax() 
    {
        return tax;
    }

    public void setQuantity(double quantity) 
    {
        this.quantity = quantity;
    }
    
    public void setTax(double Tax1) 
    {
        this.tax = Tax1;
    }
}
