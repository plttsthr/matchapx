package matchapxstore;
import java.sql.Timestamp;

public class Tiara extends Item
{
    public Tiara()
    {
        super(25, "Tiara", 8, null, "tiara.png", "accesories");
        setDescription("Dimensions: 2.36 x 4.33 inches\nColor: Gold");
    }

    public Tiara(String name, int transaction_cost, Timestamp time)
    {
        super(25, name, transaction_cost, time, "tiara.png", "accesories");
        setDescription("Dimensions: 2.36 x 4.33 inches\nColor: Gold");
    }
}