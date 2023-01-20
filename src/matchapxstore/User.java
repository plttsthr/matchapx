package matchapxstore;
import java.util.ArrayList;

public class User 
{
    private int money; // cash available for user updated with db //
    private final int user_id; // not very useful right now //
    private ArrayList<Item> myOrder = new ArrayList<Item>(); // list of items bought updated with records //

    public User() // default constructor //
    {
        money = 1000;
        user_id = 0;
    }

    public User(int money, int id) // custom constructor //
    {
        this.money = money;
        this.user_id = id;
    }

    public int getMoney()
    {
        return(this.money);
    }

    public int getId()
    {
        return(user_id);
    }
    
    public ArrayList<Item> getMyOrder()
    {
        return(myOrder);
    }

    public void addItemToOrder(Item item)
    {
        myOrder.add(item);
    }
    
    public void resetOrders()
    {
        myOrder = new ArrayList<Item>();
    }

    public int addMoney(int amount)
    {
        this.money += amount;
        return(this.money);
    }
}
