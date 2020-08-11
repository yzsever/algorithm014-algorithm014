import java.util.Deque;
import java.util.LinkedList;

public class DequeTest {


    public static void main(String args[]){
/*        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop()); }
        System.out.println(deque);*/

        /*
        * Comparison of Stack and Deque methods
            Stack Method	Equivalent Deque Method
            push(e)	        addFirst(e)
            pop()	        removeFirst()
            peek()	        peekFirst()
        *
        * */

        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.peekFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.removeFirst()); }
        System.out.println(deque);
    }
}
