/*
Not using
 */
//import java.util.Iterator;
//import java.util.function.Consumer;
///*
//This is List class create node and generate linked list from it.
// */
//class List<T> implements Iterator<T>
//{
//    private class Node<T>
//    {
//        private T data;
//        //next will take it to the next ingredient of the food.
//        private Node<T> next;
//        //down will take it to the detail of the current food (such as whether it is gluten free or not)
//        private Node<T> down;
//
//        /*
//        (Constructor)
//        Initialize the data that user input into the node
//         */
//        private Node(T data)
//        {
//            this.data = data;
//            this.next = null;
//        }
//        /*
//        Get data of the current node
//         */
//        public T getData()
//        {
//            return data;
//        }
//        /*
//        Attach current node to the next one
//         */
//        public void setNext(Node<T> newNode)
//        {
//            this.next = newNode;
//        }
//        /*
//        Return the next item of the current node.
//         */
//        public Node<T> getNext()
//        {
//            return this.next;
//        }
//    }
//
//    Node<T> head, currNode,endNode;
//    int nodeCount;
//    /*
//    List constructor.
//     */
//    public List()
//    {
//        head = null;
//        nodeCount = 0;
//    }
//    /*
//    Add item into the list (Duplication acceptable)
//    Good case: using when guests ordering something mutiple time.
//     */
//    public boolean append(T data)
//    {
//        Node newNode = new Node(data);
//        if(nodeCount == 0)
//        {
//            nodeCount++;
//            head = newNode;
//            endNode = newNode;
//            return true;
//        }
//        else if (data != null)
//        {
//            nodeCount++;
//            endNode.next = newNode;
//            endNode = newNode;
//            return true;
//        }
//        return false;
//    }
//    /*
//    Add item into the list (Duplication can be detected and determined)
//    Good case: When the company want to add new menu which end up duplicate with the existing menu
//     */
//    public boolean appendND(T data)
//    {
//        Node newNode = new Node(data);
//        if(nodeCount == 0)
//        {
//            nodeCount++;
//            head = newNode;
//            endNode = newNode;
//            return true;
//        }
//        else if (data != null)
//        {
//            currNode = head;
//            do
//            {
//
//            }while(currNode.next != null);
////            nodeCount++;
////            endNode.next = newNode;
////            endNode = newNode;
////            return true;
//        }
//        return false;
//    }
////    @Override
////    public boolean hasNext()
////    {
////        if(this.next()!= null) return true;
////        return false;
////    }
////
////    @Override
////    public T next()
////    {
////        return this.getNext().getData();
////    }
////
////    @Override
////    public void remove()
////    {
////        Iterator.super.remove();
////    }
////
////    @Override
////    public void forEachRemaining(Consumer<? super T> action)
////    {
////        Iterator.super.forEachRemaining(action);
////    }
//}
