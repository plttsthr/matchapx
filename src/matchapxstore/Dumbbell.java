package matchapxstore;

import java.sql.Timestamp;

public class Dumbbell extends Item
{
    public Dumbbell()
    {
        super(8, "Dumbbell", 61, null, "dumbbell.png", "others");
        setDescription("Size: set of 2\nWeight: 27 Kilograms\nMaterial: Cast iron");
    }

    public Dumbbell (String name, int transaction_cost, Timestamp time)
    {
        super(8, name, transaction_cost, time, "dumbbell.png", "others");
        setDescription("Size: set of 2\nWeight: 27 Kilograms\nMaterial: Cast iron");
    }
}