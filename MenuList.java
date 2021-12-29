
import java.util.Hashtable;
import java.util.Iterator;

/*
This is List class create node and generate linked list from it.
        <Plan of the data structure>
      Hash table -> (speed: o(1)/o(n)) (Shrimp pasta)->(14.99)->(pasta)->(olive oil)->(shrimp)->(dog)
                                        [is Vegan = false, isVTR = false, gluten = true, dairy = false]
                                        (Shrimp)
                                        |
                                        (Dog)
      Hash table -> (speed: o(1)/o(n)) (Foodname)->(price)->(ingredient1)->(ingredient2)->(ingredient n+1)
 */
//class MenuList<T> implements Iterable<T>
class MenuList<T> implements Iterable<T>
{
    public static class FoodNode
    {
        private String name;
        /*
        next will take it to the next ingredient of the food.
         */
        private IngredientNode firstI, lastI;
        /*
        Attribute of the food&ingredients
         */
        private boolean foodName,isVegan,isVTR, halal,kosher;
        private double fPrice;
        private FoodNode nextF;
        /*
        (Constructor &  overloaded constructor)
        Initialize the data that user input into the node
         */
        FoodNode()
        {
            super();
            this.name = null;
            this.fPrice = 0;
            this.isVegan = false;
            this.isVTR = false;
            this.halal = false;
            this.kosher = false;
            this.nextF = null;
        }
        private FoodNode(String name)
        {
            super();
            this.name = name;
            this.fPrice = 0;
            this.isVegan = false;
            this.isVTR = false;
            this.halal = false;
            this.kosher = false;
            this.nextF = null;
        }
        private FoodNode(String name, double fPrice)
        {
            super();
            this.name = name;
            this.fPrice = fPrice;
            this.isVegan = false;
            this.isVTR = false;
            this.halal = false;
            this.kosher = false;
            this.nextF = null;
        }
        private FoodNode(String name, double fPrice, boolean isVegan)
        {
            super();
            this.name = name;
            this.fPrice = fPrice;
            this.isVegan = false;
            this.isVTR = false;
            this.halal = false;
            this.kosher = false;
            this.nextF = null;
        }
        private FoodNode(String name, double fPrice, boolean isVegan, boolean isVTR)
        {
            super();
            this.name = name;
            this.fPrice = fPrice;
            this.isVegan = isVegan;
            this.isVTR = isVTR;
            this.halal = false;
            this.kosher = false;
            this.nextF = null;
        }
        private FoodNode(String name, double fPrice, boolean isVegan, boolean isVTR, boolean halal)
        {
            super();
            this.name = name;
            this.fPrice = fPrice;
            this.isVegan = isVegan;
            this.isVTR = isVTR;
            this.halal = halal;
            this.kosher = false;
            this.nextF = null;
        }
        private FoodNode(String name, double fPrice, boolean isVegan, boolean isVTR, boolean halal, boolean kosher)
        {
            super();
            this.name = name;
            this.fPrice = fPrice;
            this.isVegan = isVegan;
            this.isVTR = isVTR;
            this.halal = halal;
            this.kosher = kosher;
            this.nextF = null;
        }
        private FoodNode(String name, double fPrice, boolean isVegan, boolean isVTR, boolean halal, boolean kosher, FoodNode nextF)
        {
            super();
            this.name = name;
            this.fPrice = fPrice;
            this.isVegan = isVegan;
            this.isVTR = isVTR;
            this.halal = halal;
            this.kosher = kosher;
            this.nextF = nextF;
        }
        /*
        Get name of the food
         */
        public String getFName()
        {
            return name;
        }
        /*
        Attach the food to the ingredient
         */
        public void setFirstI(IngredientNode newNode)
        {
            this.firstI = newNode;
        }
        /*
        Return the first item of the menu.
         */
        public IngredientNode getFirstI()
        {
            return this.firstI;
        }
        public IngredientNode getLastI(){return this.lastI;}
    }

    /*
    @foodHead use for add menu to the cart
    @foodEnd use for add next item to the cart avoid the unnecessary iteration.
     */
    FoodNode foodHead, foodEnd;
    private IngredientNode iHead, currI;
    int nodeCount;
    /*
    List constructor.
     */
    public MenuList()
    {
        foodHead = null;
        nodeCount = 0;
    }
    /*
    Add item into the list (Duplication acceptable)
    Use case:
    using when guests ordering something mutiple time.
     */
    public boolean append(String data)
    {
        FoodNode newNode = new FoodNode(data);
        if(nodeCount == 0)
        {
            nodeCount++;
            foodHead = newNode;
            foodEnd = newNode;
            return true;
        }
        else if (data != null)
        {
            nodeCount++;
            foodEnd.nextF = newNode;
            foodEnd = newNode;
            return true;
        }
        return false;
    }
//    /*
//    (Unfinished)
//    Add item into the list (Duplication can be detected and determined)
//    Use hashing
//    Use case:
//    When the company want to add new menu which end up duplicate with the existing menu
//     */
//    public boolean appendND(T data)
//    {
//        FoodNode newNode = new FoodNode(data);
//        return false;
//    }
    /*
    This method check all the new order ingredients inside with the unwanted ingredients.
     */
    public void foodCheck(FoodNode newOrder, IngredientNode unwantedIngredient)
    {
        IngredientNode currI = newOrder.firstI;
        IngredientNode currUWI = unwantedIngredient;
        while(currI != null)
        {
            /*
            If unwanted ingredient found in the first of the unwantedlist.
            Since the way to remove of the first item in the list is different from others inside the list,
            it require to have separate if statement.
             */
            if(currI.getIName().equals(currUWI.getIName()) && newOrder.firstI == currI)
            {
                unwantedChoice(currI, newOrder);
            }
            /*
            If unwanted ingredient found inside the ingredients list of the food call function for it.
            Pass .next in this case because it singly linked list which not capable to go backward.
             */
            else if(currI.next.getIName().equals(currUWI.next.getIName()))
            {
                unwantedChoice(currI.next, null);
            }
        }
    }

    /*
    Give the choices for the users to decide whether what user what to do with the ingredient
     that match with ingredient inside the unwantedIngredient.
     */
    public void unwantedChoice(IngredientNode foundI, FoodNode newOrder)
    {
        System.out.println("1)Remove\n2)Substitute\n3)Skip");
        int input = Common.userInputToInt();
        if(input == 1)
        {
            //If newOrder equal to null, mean that the unwanted ingredient is not in the first one of the list.
            if(newOrder != null) newOrder.firstI = newOrder.firstI.next;
            else currI.next = currI.next.next;
        }
        /*
        This option will ask user for specific ingredients from the library,
        then show the user the price different between the two ingredients and lets the guests decide whether
        they want to change it to something else or not.
         */
        else if(input ==2)
        {
            String sInput = null;
                System.out.println("Which ingredient:\n");
                IngredientNode subI = searchIngredient(Common.userInput());
                double addPrice = subI.getiPrice() - foundI.getiPrice();
                if(addPrice>0)
                {
                    System.out.println("$"+addPrice+" will be additional cost for this ingredient (Y/N)");
                    sInput = Common.userInput();
                    /*
                    If users change their mind and does not want to substituted with this ingredients (recursion) to ask the user again.
                     */
                    if(sInput.equalsIgnoreCase("N")) unwantedChoice(foundI, newOrder);
                }
                else
                {
                    System.out.println("No additional cost require (Y/N)");
                    if(sInput.equalsIgnoreCase("N")) unwantedChoice(foundI, newOrder);
                    if(newOrder != null)
                    {
                        subI.next = newOrder.firstI.next;
                        newOrder.firstI = subI;
                    }
                    else
                    {
                        subI.next = foundI.next.next;
                        foundI.next = subI.next;
                    }
                }
        }
    }
    /*
    (under process)
    This function going through data and search for the specific ingredient node.
     */
    public IngredientNode searchIngredient(String name)
    {
        IngredientNode subI = null;
        return subI;
    }

    public Hashtable generateMenuList(FoodNode food)
    {
        /*
        Read sql data here. create linkedlist of each menu then store them into hashtable and return that hashtable in the main menu
         */
        Hashtable<Integer,FoodNode> menulist = new Hashtable<Integer,FoodNode>();
        int hashnum = hashcodeGenerator(food);
        return null;
    }

    /*
    Generate random number with hashcode algorithm
     */
    public int hashcodeGenerator(FoodNode food)
    {
        return (int) food.hashCode() * food.firstI.hashCode();
    }

    @Override
    public Iterator<T> iterator()
    {
        return null;
    }

}
