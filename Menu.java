//
//import java.util.Iterator;
//
///*
//This is List class create node and generate linked list from it.
//        <Plan of the data structure>
//      Hash table -> (speed: o(1)/o(n)) (Shrimp pasta)->(14.99)->(pasta)->(olive oil)->(shrimp)->(dog)
//                                        [is Vegan = false, isVTR = false, gluten = true, dairy = false]
//                                        (Shrimp)
//                                        |
//                                        (Dog)
//      Hash table -> (speed: o(1)/o(n)) (Foodname)->(price)->(ingredient1)->(ingredient2)->(ingredient n+1)
// */
//class MenuList<T> implements Iterable<T>
//{
//    private class FoodNode<T>extends IngredientNode
//    {
//        private T name;
//        /*
//        next will take it to the next ingredient of the food.
//         */
//        private IngredientNode firstI, lastI;
//        /*
//        Attribute of the food&ingredients
//         */
//        private boolean foodName,isVegan,isVTR, halal,kosher;
//        private double fPrice;
//        private FoodNode nextF;
//        /*
//        (Constructor &  overloaded constructor)
//        Initialize the data that user input into the node
//         */
//        private FoodNode()
//        {
//            super();
//            this.name = null;
//            this.fPrice = 0;
//            this.isVegan = false;
//            this.isVTR = false;
//            this.halal = false;
//            this.kosher = false;
//            this.nextF = null;
//        }
//        private FoodNode(T name)
//        {
//            super();
//            this.name = name;
//            this.fPrice = 0;
//            this.isVegan = false;
//            this.isVTR = false;
//            this.halal = false;
//            this.kosher = false;
//            this.nextF = null;
//        }
//        private FoodNode(T name, double fPrice)
//        {
//            super();
//            this.name = name;
//            this.fPrice = fPrice;
//            this.isVegan = false;
//            this.isVTR = false;
//            this.halal = false;
//            this.kosher = false;
//            this.nextF = null;
//        }
//        private FoodNode(T name, double fPrice, boolean isVegan)
//        {
//            super();
//            this.name = name;
//            this.fPrice = fPrice;
//            this.isVegan = false;
//            this.isVTR = false;
//            this.halal = false;
//            this.kosher = false;
//            this.nextF = null;
//        }
//        private FoodNode(T name, double fPrice, boolean isVegan, boolean isVTR)
//        {
//            super();
//            this.name = name;
//            this.fPrice = fPrice;
//            this.isVegan = isVegan;
//            this.isVTR = isVTR;
//            this.halal = false;
//            this.kosher = false;
//            this.nextF = null;
//        }
//        private FoodNode(T name, double fPrice, boolean isVegan, boolean isVTR, boolean halal)
//        {
//            super();
//            this.name = name;
//            this.fPrice = fPrice;
//            this.isVegan = isVegan;
//            this.isVTR = isVTR;
//            this.halal = halal;
//            this.kosher = false;
//            this.nextF = null;
//        }
//        private FoodNode(T name, double fPrice, boolean isVegan, boolean isVTR, boolean halal, boolean kosher)
//        {
//            super();
//            this.name = name;
//            this.fPrice = fPrice;
//            this.isVegan = isVegan;
//            this.isVTR = isVTR;
//            this.halal = halal;
//            this.kosher = kosher;
//            this.nextF = null;
//        }
//        private FoodNode(T name, double fPrice, boolean isVegan, boolean isVTR, boolean halal, boolean kosher, FoodNode nextF)
//        {
//            super();
//            this.name = name;
//            this.fPrice = fPrice;
//            this.isVegan = isVegan;
//            this.isVTR = isVTR;
//            this.halal = halal;
//            this.kosher = kosher;
//            this.nextF = nextF;
//        }
//        /*
//        Get name of the food
//         */
//        public T getFName()
//        {
//            return name;
//        }
//        /*
//        Attach the food to the ingredient
//         */
//        public void setNextI(IngredientNode newNode)
//        {
//            this.firstI = newNode;
//        }
//        /*
//        Return the first item of the menu.
//         */
//        public IngredientNode getFirstI()
//        {
//            return this.firstI;
//        }
//        public IngredientNode getLastI(){return this.lastI;}
//    }
//
//    /*
//    @foodHead use for add menu to the cart
//    @foodEnd use for add next item to the cart avoid the unnecessary iteration.
//     */
//    FoodNode<T> foodHead, foodEnd;
//    private IngredientNode iHead, currI;
//    int nodeCount;
//    /*
//    List constructor.
//     */
//    public MenuList()
//    {
//        foodHead = null;
//        nodeCount = 0;
//    }
//    /*
//    Add item into the list (Duplication acceptable)
//    Use case:
//    using when guests ordering something mutiple time.
//     */
//    public boolean append(T data)
//    {
//        FoodNode newNode = new FoodNode(data);
//        if(nodeCount == 0)
//        {
//            nodeCount++;
//            foodHead = newNode;
//            foodEnd = newNode;
//            return true;
//        }
//        else if (data != null)
//        {
//            nodeCount++;
//            foodEnd.nextF = newNode;
//            foodEnd = newNode;
//            return true;
//        }
//        return false;
//    }
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
//
//    //    /*
////    This method use to detect whether the current foodname is existed in the menu already or not (lowercase and uppercase??).
////    Use cases:
////    1) When press order the food.
////    2) Add new items into the menu.
////     */
////    public FoodNode<T> containsFood(T data)
////    {
////        int count = 0;
////        currNode = head;
////        while(currNode.down != null)
////        {
////            if(currNode.name.equals(data))
////            {
////                return currNode;
////            }
////            currNode = currNode.down;
////        }
////        return null;
////    }
//    /*
//    (under progress )
//    This method check all the new order ingredients inside with the unwanted ingredients.
//     */
//    public void foodCheck(FoodNode newOrder,FoodNode.IngredientNode unwantedIngredient)
//    {
//        FoodNode.IngredientNode currI = newOrder.firstI;
//        FoodNode.IngredientNode currUWI = unwantedIngredient;
//        boolean firstI = true;
//        while(currI != null)
//        {
//            /*
//            If unwanted ingredient found inside the ingredients list of the food call function for it
//             */
//            if(currI.getIName().equals(currUWI.getIName()) && firstI == true)
//            {
//                unwantedChoice(currI);
//
//            }
//            firstI = false;
//        }
//    }
//
//    public void unwantedChoice(FoodNode.IngredientNode foundI)
//    {
//        System.out.println("1)Remove\n2)Substitute\n3)Skip");
//        int input = Common.userInputToInt();
//        if(input == 1)
//        {
//
//        }
//        else if(input ==2)
//        {
//
//        }
//        else if(input ==3)
//        {
//
//        }
//
//    }
//
//
//}
//
//    @Override
//    public Iterator<T> iterator()
//    {
//        return null;
//    }
//
//}
