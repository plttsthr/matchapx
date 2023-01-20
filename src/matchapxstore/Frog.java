package matchapxstore;

import java.sql.Timestamp;

public class Frog extends Item
{
    public Frog()
    {
        super(9, "Frog", 24, null, "frog.png", "toys");
        setDescription("Dimensions: 8 x 6.5 x 8.5 inches\nMaterial: Polyester");
    }

    public Frog(String name, int transaction_cost, Timestamp time)
    {
        super(9, name, transaction_cost, time, "frog.png", "toys");
        setDescription("Dimensions: 8 x 6.5 x 8.5 inches\nMaterial: Polyester");
    }
}