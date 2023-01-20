package matchapxstore;

import java.sql.Timestamp;

public class Bench extends Item
{
    public Bench()
    {
        super(2, "Bench", 166, null, "bench.png", "decor");
        setDescription("Dimensions: 22.05\"D x 57.09\"W x 35.04\"H\n Material: Wood\n Color: Brown\n Style: casual ");
    }

    public Bench (String name, int transaction_cost, Timestamp time)
    {
        super(2, name, transaction_cost, time, "bench.png", "decor");
        setDescription("Dimensions: 22.05\"D x 57.09\"W x 35.04\"H\n Material: Wood\n Color: Brown\n Style: casual ");
    }
}