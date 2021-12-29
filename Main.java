import org.w3c.dom.Node;
import java.awt.*;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
/*
Main interface of the program.
 */
public class Main
{

    /*
    Prefixed table size, could be change through the  Edit menu option.
     */
    static int tableCount = 10;
    static  MenuList.FoodNode[] tableArray = new MenuList.FoodNode[tableCount+1];
    public static void main(String[] args)
    {
        mainscreen();
    }
    public static void mainscreen()
    {
        int nInput = 0;
        Timer timer = new Timer();
        /*
        This TimerTask activate when no user using the POS for the period of time.
         */
        TimerTask task = new TimerTask()
        {
            @Override
            public void run()
            {
                System.out.println("No user activity the program automatically return to mainscreen.");
                mainscreen();
            }
        };
        do
        {
            /*
            <INPROGRESS> 60 second Try to set sleep timer which exit the program instantly when no users use it for certain period of time,
            timer stop counting when user insert something.
            */
//            timer.schedule(task,60000);
            System.out.println("1)Start table\n"+"2)Existing table\n"+"3)Edit menu\n"+"4)Exit");
            nInput =  Integer.parseInt(Common.userInput());
            if(nInput == 1) startTable(tableCount, tableArray);
            else if(nInput == 2) existingTable(tableCount, tableArray);
            else if(nInput == 3) editMenu();
        }while(nInput != 4);
    }
    /*
    This method start the new table.
     */
    public static void startTable(int tableCount, MenuList.FoodNode[] tableArray)
    {
        boolean tComplete = false, yesNo = false;
        // input for String & nInput for integer
        String input = null;
        int nInput = 0;
        do
        {
            int tableNum = 0;
            System.out.println("Insert table number or type cancel to exit to main menu \nTable number:");
            input = Common.userInput();
            if(!input.equals("cancel"))
                    tableNum = Integer.parseInt(input);
            //10 is the amount of table that the resturant have.
            if(tableNum <= tableCount && tableNum != 0)
            {
                //If the table have not occupied.
                if(tableArray[tableNum] == null)
                {
                    IngredientNode uwIngredient = new IngredientNode();
                    System.out.println("Any unwanted ingredients?(Y/N)");
                    input = Common.userInput();
                    /*
                    If user have any unwanted ingredient that want to insert to the list.
                     */
                    if(input.equalsIgnoreCase("Y"))
                    {
                        unwantedIngredient(uwIngredient);
                        System.out.println("Unwanted Ingredient:");
                        uwIngredient = uwIngredient.next;
                        uwIngredient.listIngredient(uwIngredient);
                    }
                    editTable(tableNum, tableArray);
                    return;
                }
                //if the table already occupied or the check have not close yet.
                else
                {
                    System.out.println("Table currently existed");
                }
            }
            else System.out.println("Table is not exist");
        }while(tComplete != true || !input.equals("cancel"));
    }
    /*
    Access existing table add more item etc. Similar to the startTable(),
    but just skipping the checking table part and straight to the ordering
     */
    public static void existingTable(int tableCount, MenuList.FoodNode[] tableArray)
    {
        for (int x = 1; x <= tableCount; x++)
        {
            if(tableArray[x] != null) System.out.println("Table "+x);
        }
        int aTable = Common.userInputToInt();
        if(aTable <= tableCount && tableArray[aTable] != null)
        {
            editTable(aTable, tableArray);
        }

    }
    /*
        Edit table.
     */
    public static void editTable(int aTable, MenuList.FoodNode[] tableArray)
    {
        int nInput = 0;
         /*
         <Adding item to the list of food>
         Each menu that input insert will be attach to each other with linklist (foodlist).
         Every time the new menu added to the foodlist, the program will go through ingredients of that menu
         and compare to the unwanted ingredient linklist whether it had any unwanted ingredients or not.
         */
        do
        {
            if(tableArray[aTable] == null)
            {
                tableArray[aTable] = new MenuList.FoodNode();
            }
            System.out.println("1)Insert food\n"+"2)Check out\n"+"3)Edit unwanted ingredient\n4)Done\n");
            nInput = Common.userInputToInt();
            if(nInput == 1)
            {
                //Call the list of food here.
            }

            else if(nInput == 2)
            {
                //call method from price calculation from here.
            }
        }while(nInput != 4);
        mainscreen();
    }

    public boolean addFood()
    {
        return false;
    }
    public boolean returnFood()
    {
        return false;
    }
    public boolean voidFood()
    {
        return false;
    }

    /*
    Require to edit the txt file/ or SQL.
    */
    public static void editMenu()
    {

    }

    /*
    <Adding ingredients into the list of unwanted food>
    This is where to insert the ingredients that the table don't wanted and generate link list out of it.
    */
    public static void unwantedIngredient(IngredientNode uwIngredient)
    {
        IngredientNode currUWI = uwIngredient;
        System.out.println("Specified unwanted ingredients (Type N to stop):\n" +
                "Type:\n 1) Vegan(no meat & dairy product)\n 2) Vegetarian(no meat)");
        String input = "";
        do
        {
            input = Common.userInput();
            if(!input.equalsIgnoreCase("N"))
            {
                currUWI.next = new IngredientNode(input);
                currUWI = currUWI.next;
            }
        }while(!input.equalsIgnoreCase("N"));
    }

}
