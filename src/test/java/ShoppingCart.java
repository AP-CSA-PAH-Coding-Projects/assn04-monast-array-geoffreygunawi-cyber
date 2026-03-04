

// Implement your ShoppingCart class here
public class ShoppingCart
{
    private ShoppingList list;
    private String name;
    private boolean complete = false;
    private static int cartsReturned = 0;
    private boolean returned = false;

    public ShoppingCart()
    {
        list = new ShoppingList();
    }
    public ShoppingCart(String initName, ShoppingList initList)
    {
        list = initList;
        name = initName;
    }
    public boolean isCompleted()
    {
        int count = 0;
        for (ShoppingItem s : list.getStorage())
        {
            if (s != null && s.isSold())
            {
                count++;
            }
        }
        if (list.getSize() == count)
        {
            complete = true;
        }
        return complete;
    }
    public void returnCart()
    {
        if (this.isCompleted() && returned == false)
        {
            returned = true;
            cartsReturned++;
        }
    }
    public ShoppingList getList()
    {
        return list;
    }
    public String getName()
    {
        return name;
    }
    public boolean getComplete()
    {
        return complete;
    }
    public int getCartsReturned()
    {
        return cartsReturned;
    }
    public boolean isReturned()
    {
        return returned;
    }
    public static int getTotalCartsReturned()
    {
        return cartsReturned;
    }
}