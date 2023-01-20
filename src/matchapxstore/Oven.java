package matchapxstore;
import java.sql.Timestamp;

public class Oven extends Item
{
    public Oven()
    {
        super(15, "Oven", 140, null, "oven.png", "appliances");
        setDescription("Brand: LUBY\nDimensions: 18 x 11 x 11 inches\nMaterial: Iron\nWeight: 17.69 pounds");
    }

    public Oven(String name, int transaction_cost, Timestamp time)
    {
        super(15, name, transaction_cost, time, "oven.png", "appliances");
        setDescription("Brand: LUBY\nDimensions: 18 x 11 x 11 inches\nMaterial: Iron\nWeight: 17.69 pounds");
    }
}