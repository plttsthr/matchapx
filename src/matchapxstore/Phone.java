package matchapxstore;
import java.sql.Timestamp;

public class Phone extends Item
{
    public Phone()
    {
        super(18, "Phone", 300, null, "phone.png", "electronics");
        setDescription("Brand: Apple\nMemory Storage Capacity: 128 GB\nOperating System: IOS 12\nColor: Graphite");
    }

    public Phone(String name, int transaction_cost, Timestamp time)
    {
        super(18, name, transaction_cost, time, "phone.png", "electronics");
        setDescription("Brand: Apple\nMemory Storage Capacity: 128 GB\nOperating System: IOS 12\nColor: Graphite");
    }
}