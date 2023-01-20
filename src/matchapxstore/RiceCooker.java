package matchapxstore;
import java.sql.Timestamp;

public class RiceCooker extends Item
{
    public RiceCooker()
    {
        super(21, "RiceCooker", 80, null, "ricecooker.png", "appliances");
        setDescription("Brand: Hamilton Beach\nMaterial: Stainless steel\nCapacity: 64 ounces");
    }

    public RiceCooker(String name, int transaction_cost, Timestamp time)
    {
        super(21, name, transaction_cost, time, "ricecooker.png", "appliances");
        setDescription("Brand: Hamilton Beach\nMaterial: Stainless steel\nCapacity: 64 ounces");
    }
}