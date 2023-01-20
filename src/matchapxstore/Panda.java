package matchapxstore;
import java.sql.Timestamp;

public class Panda extends Item
{
    public Panda()
    {
        super(17, "Panda", 24, null, "panda.png", "toys");
        setDescription("Dimensions: 13 x 11 x 6.2 inches\nMaterial: Polyester");
    }

    public Panda(String name, int transaction_cost, Timestamp time)
    {
        super(17, name, transaction_cost, time, "panda.png", "toys");
        setDescription("Dimensions: 13 x 11 x 6.2 inches\nMaterial: Polyester");
    }
}