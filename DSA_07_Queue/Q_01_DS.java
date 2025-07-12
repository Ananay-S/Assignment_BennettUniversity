package DSA_07_Queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

// IMPLEMENTATION USING LINKED-LIST
class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
    }
}
class QueueLL {
    Node front=null, rear=null;
    
    void enqueue(int data) {
        Node newNode = new Node(data);
        if (front==null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = rear.next;
        }
    }

    int dequeue() {
        if (front==null) {
            System.out.println("underflow");
            return -1;
        }
        int res = front.data;
        front = front.next;
        return res;
    }
}

// IMPLEMENTATION USING ARRAY
class QueueA {
    int arr[];
    int capacity;
    int rear;
    public QueueA(int n) {
        this.capacity = n;
        arr = new int[n];
        rear = -1;
    }

    void enqueue(int data) {
        if (rear == capacity-1) {
            System.out.println("overflow");
        }
        rear++;
        arr[rear] = data;
    }

    int dequeue() {
        if (rear == -1) {
            System.out.println("underflow");
            return -1;
        }
        int res = arr[0];
        for (int i = 0; i < rear; i++) {
            arr[i] = arr[i+1]; 
        }
        rear--;
        return res;
    }

    int peek() {
        if (rear == -1) {
            System.out.println("empty");
            return -1;
        }
        return arr[0];
    }
}

// IMPLEMENTATION USING ARRAY
class CQueueA {
    int arr[];
    int n;
    int front=-1, rear=-1;
    public CQueueA(int n) {
        this.n = n;
        arr = new int[n];
    }

    void enqueue(int data) {
        if ((rear+1)%n == front) return;
        if (front==-1) front = 0;
        rear = (rear+1)%n;
        arr[rear] = data;
    }

    int dequeue() {
        if (front == -1) return -1;
        int res = arr[rear];
        if (front==rear) {
            front=rear=-1;
        } else {
            front = (front+1)%n;
        }
        return res;
    }
}

// IMPLEMENTATION USING 2stack
class Queue2S {
    
}

public class Q_01_DS {
    
    public static void main(String[] args) {
        
        // queue inteface linkedlist or arraydequue
        // Collection framework
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(10); //add
        System.out.println(q.peek()); //element
        System.out.println(q.size());
        q.poll(); //remove
        System.out.println(q.isEmpty());
        
    }
}
