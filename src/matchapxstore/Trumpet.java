package matchapxstore;
import java.sql.Timestamp;

public class Trumpet extends Item
{
    public Trumpet()
    {
        super(27, "Trumpet", 158, null, "trumpet.png", "others");
        setDescription("Brand: Eastar\nMaterial: Brass\nColor: Gold");
    }

    public Trumpet (String name, int transaction_cost, Timestamp time)
    {
        super(27, name, transaction_cost, time, "trumpet.png", "others");
        setDescription("Brand: Eastar\nMaterial: Brass\nColor: Gold");
    }
}