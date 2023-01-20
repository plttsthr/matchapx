package matchapxstore;

import java.sql.Timestamp;

public class Hammer extends Item
{
    public Hammer()
    {
        super(11, "Hammer", 250, null, "hammer.png", "others");
        setDescription("Brand: KURUI\nWeight: 16 Ounces\nMaterial: Steel");
    }

    public Hammer(String name, int transaction_cost, Timestamp time)
    {
        super(11, name, transaction_cost, time, "hammer.png", "others");
        setDescription("Brand: KURUI\nWeight: 16 Ounces\nMaterial: Steel");
    }
}
