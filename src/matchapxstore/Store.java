package matchapxstore;
import java.util.ArrayList;

public class Store 
{
    private static Store INSTANCE;
    private ArrayList<Item> StoreItems = new ArrayList<Item>();
    private ArrayList<Item> SearchItems = new ArrayList<Item>();
    private User current_user = null;
    private DB_Handler db = new DB_Handler();
    
    public Store()
    {
        this.current_user = null;
        this.StoreItems = InitItems();
        this.db = new DB_Handler();
    }
    
    public Store(User u)
    {
        this.current_user = u;
        this.StoreItems = InitItems();
        this.db = new DB_Handler();
    }

    // for passing data among controllers //
    public static void setInstance(Store ins)
    {
        INSTANCE = ins;
    }
    
    // accesor methods for private list: store item //
    public static ArrayList<Item> getStoreItems()
    {
        return(INSTANCE.StoreItems);
    }
    
    // accesor methods for private list: records //
    public static ArrayList<Item> getUserOrders()
    {
        INSTANCE.current_user.resetOrders();
        INSTANCE.db.getOrder(INSTANCE.current_user); // get updated records: from current session //
        return(INSTANCE.current_user.getMyOrder());
    }
    
    public static ArrayList<Item> getFoundItems()
    {
        return(INSTANCE.SearchItems);
    }
    
    public void SearchItems(String input)
    {
        ArrayList<Item> found = new ArrayList<Item>();
        for(Item i: getStoreItems())
        {
            if(i.getName().toLowerCase().contains(input.toLowerCase()))
                found.add(i);
        }
        this.SearchItems = found;
    }
    
    public boolean hasAccess()
    {
        if(current_user == null || current_user.getId() == 0)
            return(false);
        return(true);
    }
    
    public int getUserMoney()
    {
        return(current_user.getMoney());
    }
    
    private ArrayList<Item> InitItems()
    {
        Avocado avocado = new Avocado();
        StoreItems.add(avocado);
        
        Burger burger = new Burger();
        StoreItems.add(burger);
        
        Bench bench = new Bench();
        StoreItems.add(bench);
        
        Cactus cactus = new Cactus();
        StoreItems.add(cactus);
        
        Camera camera = new Camera();
        StoreItems.add(camera);
        
        ChristmasTree christmastree = new ChristmasTree();
        StoreItems.add(christmastree);
        
        Computer computer = new Computer();
        StoreItems.add(computer);
        
        Dumbbell dumbbell = new Dumbbell();
        StoreItems.add(dumbbell);
        
        Frog frog = new Frog();
        StoreItems.add(frog);  

        Guitar guitar = new Guitar();
        StoreItems.add(guitar); 
        
        Hammer hammer = new Hammer();
        StoreItems.add(hammer);
        
        Ipad ipad = new Ipad();
        StoreItems.add(ipad);
        
        Microwave microwave = new Microwave();
        StoreItems.add(microwave);
        
        Necklace necklace = new Necklace();
        StoreItems.add(necklace);
        
        Oven oven = new Oven();
        StoreItems.add(oven);
        
        Painting painting = new Painting();
        StoreItems.add(painting);
        
        Panda panda = new Panda();
        StoreItems.add(panda);
        
        Phone phone = new Phone();
        StoreItems.add(phone);
        
        Popcorn popcorn = new Popcorn();
        StoreItems.add(popcorn);
        
        Ramen ramen = new Ramen();
        StoreItems.add(ramen);
        
        RiceCooker ricecooker = new RiceCooker();
        StoreItems.add(ricecooker);
        
        Rocket rocket = new Rocket();
        StoreItems.add(rocket);
        
        Sunglasses sunglasses = new Sunglasses();
        StoreItems.add(sunglasses);
        
        Television television = new Television();
        StoreItems.add(television);
        
        Tiara tiara = new Tiara();
        StoreItems.add(tiara);
        
        Top top = new Top();
        StoreItems.add(top);
        
        Trumpet trumpet = new Trumpet();
        StoreItems.add(trumpet);
        
        Umbrella umbrella = new Umbrella();
        StoreItems.add(umbrella);
        
        return this.StoreItems;
    }
    
    public void AddCredit(int amount)
    {
        current_user.addMoney(amount);
        db.update_money(current_user.getMoney());
        System.out.println(db.get_current_userID()); 
    }
    
    public boolean SignUp(String username, String pass)
    {
        db.make_connection();
        return(db.register(username, pass));
    }
    
    public void LogIn(String username, String pass)
    {
        db.make_connection();
        this.current_user = db.signin(username, pass);
    }
    
    public boolean UpdatePassword(String current_pass, String new_pass)
    {
       return(db.update_password(current_pass, new_pass));
    }
    
    public static int Buy(String itemName)
    {
        //INSTANCE.current_user.resetOrders();
        Item newbie = null;
        
        switch(itemName.toLowerCase())
        {
            case "avocado":
                newbie = new Avocado();
                break;
            case "burger":
                newbie = new Burger();
                break;
            case "bench":
                newbie = new Bench();
                break;
            case "cactus":
                newbie = new Cactus();
                break;
            case "camera":
                newbie = new Camera();
                break;
            case "christmastree":
                newbie = new ChristmasTree();
                break;
            case "computer":
                newbie = new Computer();
                break;
            case "dumbbell":
                newbie = new Dumbbell();
                break;
            case "frog":
                newbie = new Frog();
                break;
            case "guitar":
                newbie = new Guitar();
                break;
            case "hammer":
                newbie = new Hammer();
                break;
            case "ipad":
                newbie = new Ipad();
                break;
            case "microwave":
                newbie = new Microwave();
                break;
            case "necklace":
                newbie = new Necklace();
                break;
            case "oven":
                newbie = new Oven();
                break;
            case "painting":
                newbie = new Painting();
                break;
            case "panda":
                newbie = new Panda();
                break;
            case "phone":
                newbie = new Phone();
                break;
            case "popcorn":
                newbie = new Popcorn();
                break;
            case "ramen":
                newbie = new Ramen();
                break;
            case "ricecooker":
                newbie = new RiceCooker();
                break;
            case "rocket":
                newbie = new Rocket();
                break;
            case "sunglasses":
                newbie = new Sunglasses();
                break;
            case "television":
                newbie = new Television();
                break;
            case "tiara":
                newbie = new Tiara();
                break;
            case "top":
                newbie = new Top();
                break;
            case "trumpet":
                newbie = new Trumpet();
                break;
            case "umbrella":
                newbie = new Umbrella();
                break;
            default:
                return(0);
        }
        
        System.out.println("Stock: " + INSTANCE.StoreItems.get(newbie.getId()  - 1).getStock());
        if(INSTANCE.StoreItems.get(newbie.getId() - 1).getStock() <= 0)
        {
            System.out.println("Item out of stock");
            return(-2);
        }
        
        if(INSTANCE.current_user.getMoney() - newbie.getPrice() <= 0)
        {
            System.out.println("Not enough money.");
            return(-1);
        }
        
        INSTANCE.current_user.addMoney(-1 * newbie.getPrice());
        INSTANCE.db.insert_records(newbie.getName(), newbie.getPrice(), 
                    INSTANCE.current_user.getMoney());
        INSTANCE.StoreItems.get(newbie.getId()  - 1).decreaseStock();
        
        return(1);
    }
    
    public void LogOut()
    {
        db.close_connection();
        current_user = null;
    }
}
