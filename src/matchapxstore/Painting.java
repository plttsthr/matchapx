package matchapxstore;
import java.sql.Timestamp;

public class Painting extends Item
{
    public Painting()
    {
        super(16, "Mona Lisa", 217, null, "painting.png", "decor");
        setDescription("Material: Cotton Canvas\nTheme: Portrait \nSize: 16 x 24 inches frame");
    }

    public Painting (String name, int transaction_cost, Timestamp time)
    {
        super(16, name, transaction_cost, time, "painting.png", "decor");
        setDescription("Material: Cotton Canvas\nTheme: Portrait \nSize: 16 x 24 inches frame");
    }
}