package matchapxstore;

import java.sql.Timestamp;

public class Cactus extends Item
{
    public Cactus()
    {
        super(4, "Cactus", 10, null, "cactus.png", "decor");
        setDescription("Dimensions: 2.36 x 2.36 x 4.72 inches\n Package information: Pot\n Additional: Light weight, for small places ");
    }

    public Cactus(String name, int transaction_cost, Timestamp time)
    {
        super(4, name, transaction_cost, time, "cactus.png", "decor");
        setDescription("Dimensions: 2.36 x 2.36 x 4.72 inches\n Package information: Pot\n Additional: Light weight, for small places ");
    }
}