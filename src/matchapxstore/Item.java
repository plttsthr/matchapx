package matchapxstore;
import java.sql.Timestamp;
import java.util.Random;

public abstract class Item
{
    Random rand = new Random();
    private final String name;
    private int stock;
    private final int id;
    private int price;
    private final String department;
    private Timestamp date_of_purchase;
    private final String imageSource;
    private String description;

    // constructors //
    public Item()
    {
        name = " ";
        price = 0;
        date_of_purchase = null;
        imageSource = " ";
        department = " ";
        stock = rand.nextInt(10);
        id = 0;
    }

    public Item(int id, String name, int price, Timestamp date_of_purchase, String path, String department)
    {
        this.name = name;
        this.price = price;
        this.date_of_purchase = date_of_purchase;
        this.imageSource = "images/"+path;
        this.department = department;
        this.id = id;
        stock = rand.nextInt(10);
        
    }

    // accesor methods //
    public String getName()
    {
        return(this.name);
    }
    
    public int getId()
    {
        return(this.id);
    }
    
    public int getPrice()
    {
        return(this.price);
    }

    public int getStock()
    {
        return(this.stock);
    }
    
    public String getImage()
    {
        return(this.imageSource);
    }
    
    public Timestamp getDateOfPurchase()
    {
        return(this.date_of_purchase);
    }
    
    public String getDepartment()
    {
        return(this.department);
    }
    
    public String getDescription()
    {
        return(this.description);
    }
    
    
    // mutator methods //
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    public void decreaseStock()
    {
        this.stock--;
    }

    public void setDateOfPurchase(Timestamp date_of_purchase)
    {
        this.date_of_purchase = date_of_purchase;
    }
    
    public void setDescription(String description)
    {
        this.description = description;
    }
}