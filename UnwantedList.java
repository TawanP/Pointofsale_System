import java.util.Iterator;

public class UnwantedList implements Iterable
{
    private class UWIngredientNode extends IngredientNode
    {
        private IngredientNode firstUWI,lastUWI;

        public UWIngredientNode()
        {
            super();
        }
        public UWIngredientNode(String iname)
        {
            super(iname);
        }

//        private void setEnd()
//        {
//            if(this.next == null)
//            lastUWI = this;
//        }

        private void setNextUWI(UWIngredientNode newUWI)
        {
            this.next = newUWI;
        }

    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
