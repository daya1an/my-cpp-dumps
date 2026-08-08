/*Node class  used in the program
class Node
{
    int data;
    Node next;
    Node bottom;

    Node(int d)
    {
        data = d;
        next = null;
        bottom = null;
    }
}
*/
/*  Function which returns the  root of
    the flattened linked list. */
import java.util.*;

class GfG {
    Node flatten(Node root) {
        // Your code here
        ArrayList<Integer> values = new ArrayList<>();
        
        while (root != null){
            values.add(root.data);
            
            Node temp = root.bottom;
            
            while(temp != null){
                values.add(temp.data);
                temp = temp.bottom;
            }
            root = root.next;
        }
        
        Collections.sort(values);
        
        Node head = null, tail = null;
        
        for (int v: values){
            
            Node newNode = new Node(v);
            
            if (head == null) head = newNode;
            else{
                tail.bottom = newNode;
            }
            tail = newNode;
        }
        
        return head;
        
    }
}