

import java.util.Arrays;

// Implement the ShoppingList class here

public class ShoppingList implements MyList {
    private int capacity = 8;
    private int size = 0;
    private ShoppingItem[] storage;

    public ShoppingList (ShoppingItem[] initStorage)
    {
        storage = initStorage;
    }
    public ShoppingList ()
    {
        storage = new ShoppingItem[capacity];
    }

    public void addToEnd(ShoppingItem item)
    {
        if (size + 1 > storage.length)
        {
           makeCapacity(storage.length * 2);
        }
        storage[size] = item;
        size++;
    }
    public void insertAt(int index, ShoppingItem item)
    {
        if (index < 0 || index > size)
        {
            System.out.println("Invalid index!");
        }
        else
        {
            if (size + 1 > storage.length)
            {
                makeCapacity(storage.length + 1);
            }
            for (int i = size - 1; i >= index; i--)
            {
                storage[i+1] = storage[i];
            }
            storage[index] = item;
            size++;
        }
    }
    public void removeAt(int index)
    {
        if (index < 0 || index > size)
        {
            System.out.println("Invalid index!");
        }
        else
        {
            for (int i = index; i < size-1; i++)
            {
                storage[i] = storage[i+1];
            }
            size--;
        }
    }
    public ShoppingItem getAt(int index)
    {
        if (index < 0 || index > size || storage[index] == null)
        {
            System.out.println("Invalid index!");
        }
        return storage[index];
    }
    public int getSize()
    {
        return size;
    }
    public void makeCapacity(int minCapacity)
    {
        storage = Arrays.copyOf(storage, minCapacity);
        capacity = minCapacity;
    }
    public void trimExcess()
    {
        makeCapacity(size);
    }
    public void goShopping()
    {
        for (int i = 0; i < size; i++)
        {
            storage[i].buy();
        }
    }
    public void goShopping(ShoppingList toBuy)
    {
        for (int i = 0; i < storage.length; i++)
        {
            for (int j = 0; j < toBuy.getSize(); j++)
            {
                if (storage[i] != null && toBuy.getStorage()[j] != null && storage[i].equals(toBuy.getStorage()[j]))
                {
                    storage[i].buy();
                }
            }
            
        }
    }
    public double totalPrice()
    {
        double total = 0;
        for (int i = 0; i < size; i++)
        {
            total += storage[i].getPrice();
        }
        return total;
    }
    public boolean isIdentical(ShoppingList other)
    {
        ShoppingItem[] tempList1 = this.sort();
        ShoppingItem[] tempList2 = other.sort();
        if (tempList1.length != tempList2.length)
        {
            return false;
        }
        int count = 0;
        for (int i = 0; i < tempList1.length; i++)
        {
            if (tempList1[i].equals(tempList2[i]))
            {
                count++;
            }
        }
        if (count == tempList1.length)
        {
            return true;
        }
        return false;
    }
    public ShoppingItem[] sort()
    {
        ShoppingItem[] tempList = Arrays.copyOf(storage, size);
        int count = 0;
        ShoppingItem swap;
        for (ShoppingItem s : tempList)
        {
            if (s != null)
            {
                count++;
            }
        }
        for (int i = 0; i < count - 1; i++)
        {
            for (int j = 0; j < count - i - 1; j++)
            {
                if (tempList[j].getPrice() > tempList[j+1].getPrice())
                {
                    swap = tempList[j];
                    tempList[j] = tempList[j+1];
                    tempList[j+1] = swap;
                }
            }
        }
        return tempList;
    }
    public int getCapacity()
    {
        return capacity;
    }
    public ShoppingItem[] getStorage()
    {
        return storage;
    }

}