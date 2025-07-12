package DSA_06_Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

// IMPLEMENTATION

// USING ARRAY
class StackA {
    int stack[];
    int top;
    int capacity;
    public StackA(int capacity) {
        this.capacity = capacity;
        top = -1;
        stack = new int[capacity];
    }

    // push
    void push(int data) {
        if (top == capacity-1) {
            System.out.println("overflow");
        } else {
            top++;
            stack[top] = data;
        } 
    }
    // pop
    int pop() {
        if (top == -1) {
            System.out.println("underflow");
            return -1;
        } else {
            int temp = stack[top];
            top--;
            return temp;
        }
    }
    // peek
    int peek() {
        if (top == -1) {
            System.out.println("empty");
            return -1;
        } else {
            return stack[top];
        }
    }
    // isEmpty
    boolean isEmpty() {
        return (top == -1);
    }
}

// USING LINKED LIST
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
class StackLL {
    Node head;
    int size;
    
    public StackLL() {
        this.head = null;
        this.size = 0;
    }

    // push
    void push(int data) {
        Node temp = new Node(data);
        temp.next = head;
        head = temp;
        size++;
    }
    // pop
    int pop() {
        if (head == null) {
            System.out.println("underflow");
            return -1;
        } else {
            int temp = head.data;
            head = head.next;
            size--;
            return temp;
        }
    }
    // peek
    int peek() {
        if (head == null) {
            System.out.println("empty");
            return -1;
        } else {
            return head.data;
        }
    }
    // isEmpty
    boolean isEmpty() {
        return (head == null);
    }
    // size
    int size() {
        return size;
    }
}

public class S_01_DS {
    public static void main(String[] args) {
        
        // Array
        StackA sA = new StackA(10);
        // Linked-list
        StackLL sLl = new StackLL();
        // Collection framework
        Stack<Integer> s = new Stack<>();

        s.push(10);
        while (!s.isEmpty()) {
            System.out.println(s.peek());
            s.pop();
        }
        System.out.println(s.size());

            //deque interface arraydeque class
            Deque<Integer> ds = new ArrayDeque<>();

    }
}