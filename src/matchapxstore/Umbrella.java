package matchapxstore;
import java.sql.Timestamp;

public class Umbrella extends Item
{
    public Umbrella()
    {
        super(28, "Umbrella", 15, null, "umbrella.png", "accesories");
        setDescription("Brand: Repel\nMaterial: Fiberglass\nColor: Blue");
    }

    public Umbrella(String name, int transaction_cost, Timestamp time)
    {
        super(28, name, transaction_cost, time, "umbrella.png", "accesories");
        setDescription("Brand: Repel\nMaterial: Fiberglass\nColor: Blue");
    }
}