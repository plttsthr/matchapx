package matchapxstore;
import java.sql.Timestamp;

public class Ramen extends Item
{
    public Ramen()
    {
        super(20, "Ramen", 15, null, "ramen.png", "food");
        setDescription("Brand: Nongshim\nWeight: 3 pounds\nFlavor: Gourmet spicy");
    }

    public Ramen(String name, int transaction_cost, Timestamp time)
    {
        super(20, name, transaction_cost, time, "ramen.png", "food");
        setDescription("Brand: Nongshim\nWeight: 3 pounds\nFlavor: Gourmet spicy");
    }
}