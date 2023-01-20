package matchapxstore;

import java.sql.Timestamp;

public class Guitar extends Item
{
    public Guitar()
    {
        super(10, "Guitar", 109, null, "guitar.png", "others");
        setDescription("Brand: Fender\nMaterial: Mahogany\nHand Orientation: Right");
    }

    public Guitar(String name, int transaction_cost, Timestamp time)
    {
        super(10, name, transaction_cost, time, "guitar.png", "others");
        setDescription("Brand: Fender\nMaterial: Mahogany\nHand Orientation: Right");
    }
}