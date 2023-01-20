package matchapxstore;
import java.sql.Timestamp;

public class Top extends Item
{
    public Top()
    {
        super(26, "Top", 5, null, "top.png", "toys");
        setDescription("Brand: GoodPlay\nDimensions: 5.3 x 3.5 x 2 inches\nMaterial: Wood\nWeight: 0.13 pounds");
    }

    public Top(String name, int transaction_cost, Timestamp time)
    {
        super(26, name, transaction_cost, time, "top.png", "toys");
        setDescription("Brand: GoodPlay\nDimensions: 5.3 x 3.5 x 2 inches\nMaterial: Wood\nWeight: 0.13 pounds");
    }
}