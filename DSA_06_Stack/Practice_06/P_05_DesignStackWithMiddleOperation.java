package DSA_06_Stack.Practice_06;

public class P_05_DesignStackWithMiddleOperation {
    
    // m1
    static class DLL {
        int data;
        DLL prev;
        DLL next;
        DLL(int data) {
            this.data = data;
        }
    }
    static class StackM {
        DLL head;
        DLL mid;
        // DLL prev;
        // DLL next;
        int size;
        void push(int data) {
            DLL node = new DLL(data);
            if (size==0) {
                head = node;
                mid = head;
                size++;
                return;
            }
            head.prev = node;
            node.next = head;
            head = node;
            // size++;
            if ((size&1)==0) mid = mid.prev;
            size++;
        }
        int pop() {
            if (size==0) return -1;
            
            int data = head.data;

            if (size==1) {
                head=null;
                mid=null;
                size--;
                return data;
            }

            head = head.next;
            head.prev = null;
            if ((size&1)!=0) mid = mid.next;
            size--;
            return data;
        }

        int getMiddle() {
            if (size==0) return -1;
            return mid.data;
        }

        void popMiddle() {
            if (size==0) {
                return;
            } else if (size==1) {
                head=null;
                mid=null;
                size--;
                return;
            } else if (size==2) {
                mid = head;
                head.next = null;
                return;
            }

            // int data = head.data;

            mid.next.prev = mid.prev;
            mid.prev.next = mid.next;
            if ((size&1)==0)  {
                mid = mid.next;
            } else {
                mid = mid.prev;
            }
            size--;
        }
    }

    public static void main(String[] args) {
        
        StackM ms = new StackM();
		ms.push(11);
		ms.push(22);
		ms.push(33);
		ms.push(44);
		ms.push(55);
		ms.push(66);
		ms.push(77);
		ms.push(88);
		ms.push(99);

		System.out.println("Popped : " + ms.pop());
		System.out.println("Popped : " + ms.pop());
		System.out.println("Middle Element : "
						+ ms.getMiddle());
		ms.popMiddle();
		System.out.println("New Middle Element : "
						+ ms.getMiddle());
    }
}
