
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
class IngredientNode implements Iterable
{
            private class SpecifyIngredient
            {
                private String sIName;
                SpecifyIngredient down;
                /*
                (Constructor &  overloaded constructor)
                Initialize the data that user input into the node
                 */
                private SpecifyIngredient()
                {
                    sIName = null;
                    down = null;
                }
                private SpecifyIngredient(String name)
                {
                    this.sIName = name;
                    down = null;
                }
                /*
                Set the next specify ingredients
                 */
                public void setNextSIngredient(SpecifyIngredient newSI)
                {
                    this.down = newSI;
                }
                public void setName(String name)
                {
                    this.sIName = name;
                }
                public String getName()
                {
                    if (this != null)
                        return this.sIName;
                    return null;
                }
            }
            private String iName;
            private double iPrice, ogPrice ,amount;
            private boolean gluten, dairy;
            IngredientNode next;
            SpecifyIngredient down;

            public IngredientNode()
            {
                this.iName = null;
                this.iPrice = 0;
                this.amount = 0;
                this.gluten = false;
                this.dairy = false;
                this.next = null;
                this.down = null;
            }

            public IngredientNode(String name)
            {
                this.iName = name;
                this.iPrice = 0;
                this.amount = 0;
                this.gluten = false;
                this.dairy = false;
                this.next = null;
                this.down = null;
            }
            public IngredientNode(String name, double iPrice)
            {
                this.iName = name;
                this.iPrice = iPrice;
                this.amount = 0;
                this.gluten = false;
                this.dairy = false;
                this.next = null;
                this.down = null;
            }
            public IngredientNode(String name, double iPrice, double amount)
            {
                this.iName = name;
                this.iPrice = iPrice;
                this.amount = amount;
                this.gluten = false;
                this.dairy = false;
                this.next = null;
                this.down = null;
            }
            public IngredientNode(String name, double iPrice, double amount, boolean gluten)
            {
                this.iName = name;
                this.iPrice = iPrice;
                this.amount = amount;
                this.gluten = gluten;
                this.dairy = false;
                this.next = null;
                this.down = null;
            }
            public IngredientNode(String name, double iPrice, double amount, boolean gluten, boolean dairy)
            {
                this.iName = name;
                this.iPrice = iPrice;
                this.amount = amount;
                this.gluten = gluten;
                this.dairy = dairy;
                this.next = null;
                this.down = null;
            }
            public IngredientNode(String name, double iPrice, double amount, boolean gluten, boolean dairy,SpecifyIngredient specI)
            {
                this.iName = name;
                this.iPrice = iPrice;
                this.amount = amount;
                this.gluten = gluten;
                this.dairy = dairy;
                this.next = null;
                this.down = specI;
            }
            public String getIName()
            {
                return iName;
            }

            public void listIngredient(IngredientNode currI)
            {
                while (currI != null)
                {
                    System.out.print(currI.iName);
                    currI = currI.next;
                    if(currI!= null) System.out.print(",");
                    else System.out.print("\n");
                }

            }

            public void appendI(String uwI)
            {
                this.next = new IngredientNode(uwI);
            }

//            public  void setEnd(IngredientNode lastI)
//            {
//
//            }

            public void setiPrice(double iPrice)
            {
                this.iPrice = iPrice;
            }
            public double getiPrice()
            {
                return this.iPrice;
            }

    @Override
    public Iterator iterator()
    {
        return null;
    }

}
