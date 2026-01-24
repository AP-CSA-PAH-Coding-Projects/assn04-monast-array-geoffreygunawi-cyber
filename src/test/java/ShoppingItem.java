

// Implement your ShoppingItem class here
public class ShoppingItem
{
    private String name = "";
    private int price;
    private boolean bought = false;

    public ShoppingItem (String initName, int initPrice)
    {
        name = initName;
        price = initPrice;
    }
    public void buy()
    {
        bought = true;
    }
    public boolean equals(ShoppingItem other)
    {
        if (name.equals(other.name) && price == other.price)
        {
            return true;
        }
        return false;
    }
    public int compareTo(ShoppingItem other)
    {
        if (!name.equals(other.name))
        {
            System.out.println("Error: Different items!");
            return price - other.price;
        }
        else
        {
            return price - other.price;
        }
    }
    public String getName()
    {
        return name;
    }
    public double getPrice()
    {
        return ((double) price) / 100.0;
    }
    public boolean isSold()
    {
        return bought;
    }
}