package matchapxstore;
import java.sql.Timestamp;

public class Necklace extends Item
{
    public Necklace()
    {
        super(14, "Necklace", 15, null, "necklace.png", "accesories");
        setDescription("Dimensions: 55 x 0.5 cm\nColor: Steel \nMaterial: Natural stones");
    }

    public Necklace(String name, int transaction_cost, Timestamp time)
    {
        super(14, name, transaction_cost, time, "necklace.png", "accesories");
        setDescription("Dimensions: 55 x 0.5 cm\nColor: Steel \nMaterial: Natural stones");
    }
}