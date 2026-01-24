package apcsa.githubtrack;

// Implement your Main class (with the main method) here

public class Main
{
    public static void main(String[] args)
    {
        ShoppingList breakfastEssentials = new ShoppingList();
        ShoppingList dormRun = new ShoppingList();
    
        ShoppingItem eggs = new ShoppingItem("eggs", 350);
        ShoppingItem zucchini = new ShoppingItem("zucchini", 275);
        ShoppingItem frozenBerries = new ShoppingItem("frozen berries", 515);
        ShoppingItem smokedSalmon = new ShoppingItem("smoked salmon", 999);
        ShoppingItem tissues = new ShoppingItem("tissues", 100);

        breakfastEssentials.addToEnd(eggs);
        breakfastEssentials.addToEnd(zucchini);
        breakfastEssentials.addToEnd(frozenBerries);
        breakfastEssentials.addToEnd(smokedSalmon);

        dormRun.addToEnd(eggs);
        dormRun.addToEnd(zucchini);
        dormRun.addToEnd(frozenBerries);
        dormRun.addToEnd(smokedSalmon);
        dormRun.insertAt(1, tissues);

        dormRun.addToEnd(eggs);
        dormRun.removeAt(5);

        System.out.println(dormRun.isIdentical(breakfastEssentials));

        dormRun.removeAt(1);
        dormRun.removeAt(3);

        ShoppingCart breakfast = new ShoppingCart("Breakfast Essentials", breakfastEssentials);
        ShoppingCart dorm = new ShoppingCart("Dorm run", dormRun);

        eggs.buy();
        smokedSalmon.buy();

        System.out.println(dorm.getComplete());

        breakfast.getList().goShopping();
        System.out.println(breakfast.getCartsReturned());
        breakfast.returnCart();
        dorm.returnCart();
        System.out.println(breakfast.getCartsReturned());

        System.out.println(breakfastEssentials.getAt(0).compareTo(dormRun.getAt(2)));

        System.out.print(dorm.getName() + "'s cart includes the following items: ");
        for (int i = 0; i < dorm.getList().getSize(); i++)
        {
            System.out.print(dorm.getList().getAt(i).getName());
            System.out.print(", ");
        }
        System.out.print("for a total of $" + dorm.getList().totalPrice() + ". It is ");
        if (dorm.isCompleted())
        {
            System.out.print("completed!");
        }
        else
        {
            System.out.print("not completed!");
        }
    }
}