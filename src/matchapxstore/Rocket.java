package matchapxstore;
import java.sql.Timestamp;

public class Rocket extends Item
{
    public Rocket()
    {
        super(22, "Rocket", 24, null, "rocket.png", "toys");
        setDescription("Brand: Stomp Rocket\nMaterial: Foam\nWeight: 0.34 g");
    }

    public Rocket(String name, int transaction_cost, Timestamp time)
    {
        super(22, name, transaction_cost, time, "rocket.png", "toys");
        setDescription("Brand: Stomp Rocket\nMaterial: Foam\nWeight: 0.34 g");
    }
}