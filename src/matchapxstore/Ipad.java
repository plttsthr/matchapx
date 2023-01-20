package matchapxstore;

import java.sql.Timestamp;


public class Ipad extends Item
{
    public Ipad()
    {
        super(12, "Ipad", 580, null, "ipad.png", "electronics");
        setDescription("Brand: Apple\nSize: 10.2 inches\nOperating System: iPadOS\nStorage capacity: 64 GB");
    }

    public Ipad(String name, int transaction_cost, Timestamp time)
    {
        super(12, name, transaction_cost, time, "ipad.png", "electronics");
        setDescription("Brand: Apple\nSize: 10.2 inches\nOperating System: iPadOS\nStorage capacity: 64 GB");
    }
}