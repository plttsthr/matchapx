package matchapxstore;
import java.sql.Timestamp;

public class Microwave extends Item
{
    public Microwave()
    {
        super(13, "Microwave", 420, null, "microwave.png", "appliances");
        setDescription("Brand: Toshiba \nDimensions: \n19.2 x 15.9 x 11.5 inches\nWeight: \n28.7 Pounds\nEnergy Consumption: \n1350 Watts");
    }

    public Microwave(String name, int transaction_cost, Timestamp time)
    {
        super(13, name, transaction_cost, time, "microwave.png", "appliances");
        setDescription("Brand: Toshiba\nDimensions: 19.2 x 15.9 x 11.5 inches\nWeight: 28.7 Pounds\nEnergy Consumption: 1350 Watts");
    }
}