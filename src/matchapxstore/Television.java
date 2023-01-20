package matchapxstore;
import java.sql.Timestamp;


public class Television extends Item
{
    public Television()
    {
        super(24, "Television", 600, null, "television.png", "appliances");
        setDescription("Brand: Norcent\nResolution: 729p\nSize: 24 inches\nColor: Black");
    }

    public Television(String name, int transaction_cost, Timestamp time)
    {
        super(24, name, transaction_cost, time, "television.png", "appliances");
        setDescription("Brand: Norcent\nResolution: 729p\nSize: 24 inches\nColor: Black");
    }
}