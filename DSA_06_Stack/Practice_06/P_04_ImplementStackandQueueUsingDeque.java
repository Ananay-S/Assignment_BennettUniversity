package DSA_06_Stack.Practice_06;

public class P_04_ImplementStackandQueueUsingDeque {
    
    // m
    static class DQueNode {
        int value;
        DQueNode next;
        DQueNode prev;
    }

    // Implementation of deque class
    static class deque {

        // Pointers to head and tail of deque
        private DQueNode head;
        private DQueNode tail;

        // Constructor
        public deque() { head = tail = null; }

        // If list is empty
        boolean isEmpty()
        {
            if (head == null)
                return true;

            return false;
        }

        // count the number of nodes in list
        int size()
        {

            // If list is not empty
            if (!isEmpty()) {
                DQueNode temp = head;
                int len = 0;

                while (temp != null) {
                    len++;
                    temp = temp.next;
                }
                return len;
            }
            return 0;
        }

        // Insert at the first position
        void insert_first(int element)
        {

            // Allocating node of DQueNode type
            DQueNode temp = new DQueNode();
            temp.value = element;

            // If the element is first element
            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            }
            else {
                head.prev = temp;
                temp.next = head;
                temp.prev = null;
                head = temp;
            }
        }

        // Insert at last position of deque
        void insert_last(int element)
        {

            // Allocating node of DQueNode type
            DQueNode temp = new DQueNode();
            temp.value = element;

            // If element is the first element
            if (head == null) {
                head = tail = temp;
                temp.next = temp.prev = null;
            }
            else {
                tail.next = temp;
                temp.next = null;
                temp.prev = tail;
                tail = temp;
            }
        }

        // Remove element at the first position
    public void remove_first()
    {
    // If list is not empty
    if (!isEmpty()) {
        // If there is only one node
        if (head == tail) {
            head = tail = null;
            return;
        } else {
            head = head.next;
            head.prev = null;
        }
    } else {
        System.out.println("List is Empty");
        }
    }


        // Remove element at the last position
        void remove_last()
        {

            // If list is not empty
            if (!isEmpty()) {
                DQueNode temp = tail;
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }
                return;
            }
            System.out.print("List is Empty");
        }

        // Displays the elements in deque
        void display()
        {

            // If list is not empty
            if (!isEmpty()) {
                DQueNode temp = head;

                while (temp != null) {
                    System.out.print(temp.value + " ");
                    temp = temp.next;
                }

                return;
            }
            System.out.print("List is Empty");
        }
    }

    // Class to implement stack using Deque
    static class Stack {
        deque d = new deque();

        // push to push element at top of stack
        // using insert at last function of deque
        public void push(int element)
        {
            d.insert_last(element);
        }

        // Returns size
        public int size() { return d.size(); }

        // pop to remove element at top of stack
        // using remove at last function of deque
        public void pop() { d.remove_last(); }

        // Display
        public void display() { d.display(); }
    }

    // Class to implement queue using deque
    static class Queue {
        deque d = new deque();

        // enqueue to insert element at last
        // using insert at last function of deque
        public void enqueue(int element)
        {
            d.insert_last(element);
        }

        // dequeue to remove element from first
        // using remove at first function of deque
        public void dequeue() { d.remove_first(); }

        // display
        public void display() { d.display(); }

        // size
        public int size() { return d.size(); }
    }


    public static void main(String[] args) {
        
    }
}
