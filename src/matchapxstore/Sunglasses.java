package matchapxstore;
import java.sql.Timestamp;

public class Sunglasses extends Item
{
    public Sunglasses()
    {
        super(23, "Sunglasses", 18, null, "sunglasses.png", "accesories");
        setDescription("Brand: Ray-Ban\nFrame Length: 5.47 inches\nLens Height:1.73 inches\nColor: Black");
    }

    public Sunglasses(String name, int transaction_cost, Timestamp time)
    {
        super(23, name, transaction_cost, time, "sunglasses.png", "accesories");
        setDescription("Brand: Ray-Ban\nFrame Length: 5.47 inches\nLens Height:1.73 inches\nColor: Black");
    }
}