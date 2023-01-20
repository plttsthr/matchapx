package matchapxstore;

import java.sql.Timestamp;

public class Computer extends Item
{
    public Computer()
    {
        super(7, "Computer", 2300, null, "computer.png", "electronics");
        setDescription("Brand: HP\nCPU Model: Core i5\nMemory Size: 8GB\nRam: 8GB\nColor: Black\nScreen Size: 19 inches");
    }

    public Computer(String name, int transaction_cost, Timestamp time)
    {
        super(7, name, transaction_cost, time, "computer.png", "electronics");
        setDescription("Brand: HP\nCPU Model: Core i5\nMemory Size: 8GB\nRam: 8GB\nColor: Black\nScreen Size: 19 inches");
    }
}