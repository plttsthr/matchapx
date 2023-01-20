package matchapxstore;

import java.sql.Timestamp;

public class ChristmasTree extends Item
{
    public ChristmasTree()
    {
        super(6, "ChristmasTree", 100, null, "christmastree.png", "decor");
        setDescription("Dimensions: 56 x 56 x 90 inches\nColor: Green\nWeight: 42.5 pounds\nInterface: USB");
    }

    public ChristmasTree(String name, int transaction_cost, Timestamp time)
    {
        super(6, name, transaction_cost, time, "christmastree.png", "decor");
        setDescription("Dimensions: 56 x 56 x 90 inches\nColor: Green\nWeight: 42.5 pounds\nInterface: USB");
    }
}