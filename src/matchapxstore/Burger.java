package matchapxstore;

import java.sql.Timestamp;

public class Burger extends Item 
{
    public Burger()
    {
        super(3, "Burger", 5, null, "burger.png", "food");
        setDescription("Size: 10 piece set\nBrand: Aloha Steak Burgers\nWeight: 4 ounces ");
    }
    
     public Burger(String name, int transaction_cost, Timestamp time)
    {
        super(3, name, transaction_cost, time, "burger.png", "food");
        setDescription("Size: 10 piece set\nBrand: Aloha Steak Burgers\nWeight: 4 ounces ");
    }
    
}
