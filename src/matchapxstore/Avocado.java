package matchapxstore;
import java.sql.Timestamp;


public class Avocado extends Item
{
    public Avocado()
    {
        super(1, "Avocado", 4, null, "avocado.png", "food");
        setDescription("Size: 6 pack\nBrand: \nThe Fresh Fruit\nCondition: \nFresh");
    }

    public Avocado(String name, int transaction_cost, Timestamp time)
    {
        super(1, name, transaction_cost, time, "avocado.png", "food");
        setDescription("Size: 6 pack\nBrand: \nThe Fresh Fruit\nCondition: \nFresh");
    }
}