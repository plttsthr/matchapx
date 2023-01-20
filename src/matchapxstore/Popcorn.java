package matchapxstore;
import java.sql.Timestamp;

public class Popcorn extends Item
{
    public Popcorn()
    {
        super(19, "Popcorn", 3, null, "popcorn.png", "food");
        setDescription("Brand: Orville Redenbacher’s\nWeight: 3.29 ounces\nSize: 1 packet");
    }

    public Popcorn(String name, int transaction_cost, Timestamp time)
    {
        super(19, name, transaction_cost, time, "popcorn.png", "food");
        setDescription("Brand: Orville Redenbacher’s\nWeight: 3.29 ounces\nSize: 1 packet");
    }
}