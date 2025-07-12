package DSA_11_BinaryTreeStructure;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;


// node class
class Node {
    int data;
    Node left, right;
    public Node(int data) {
        this.data = data;
    }
}
class BinaryTree {
    static Scanner sc = new Scanner(System.in);
    // root of the binary tree
    Node root;
    
    // create bt
    int index = -1;
    public Node buildTree(int[] nodes) { // preorder
        index++ ; 
        if(nodes[index] == -1) {
            return null;
        }
        Node newNode = new Node(nodes[index]);
        // left
        newNode.left = buildTree(nodes);
        // right
        newNode.right = buildTree(nodes);

        return newNode;
    }
    // create binary tree
    public Node createBT() {

        System.out.println("Enter data: ");
        int data = sc.nextInt();

        if (data==-1) return null;

        Node root = new Node(data);

        System.out.println("Enter left for:"+data);
        root.left = createBT();
        
        System.out.println("Enter right for: "+data);
        root.right = createBT();

        this.root = root;
        return root;
    }
    // Inorder
    void inorder(Node node) {
        if (node==null) return;

        inorder(node.left);
        System.out.print(node.data+" ");
        inorder(node.right);
    }
    // Preorder
    void preorder(Node node) {
        if (node==null) return;

        System.out.print(node.data+" ");
        preorder(node.left);
        preorder(node.right);
    }
    // postorder
    void postorder(Node node) {
        if (node==null) return;

        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data+" ");
    }
    // levelorder (queue /hashmap(node,arraylist)) (adding null to indicate end of level)
    void levelOrder(Node node) {
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            Node c = q.poll();
            System.out.print(c.data+" ");
            if (c.left!=null) {
                q.add(c.left);
            }
            if (c.right!=null) {
                q.add(c.right);
            }
        }
    }
    // verticalorder
    class hdNode {
        int hd; // horizantal distance
        Node node; // node
        hdNode(int hd, Node node) {
            this.hd = hd;
            this.node = node;
        }
    }
    ArrayList<Integer> verticalOrder(Node node) {
        Queue<hdNode> q = new ArrayDeque<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();
        q.add(new hdNode(0, node));
        while (!q.isEmpty()) {
            hdNode c = q.poll(); // current
            // System.out.print(c.data+" ");
            if (map.containsKey(c.hd)) {
                map.get(c.hd).add(c.node.data);
            } else {
                ArrayList<Integer> temp = new ArrayList<>();
                temp.add(c.node.data);
                map.put(c.hd, temp);
            }
            if (c.node.left!=null) {
                q.add(new hdNode(c.hd-1, c.node.left));
            }
            if (c.node.right!=null) {
                q.add(new hdNode(c.hd+1, c.node.right));
            }
        }
        ArrayList<Integer> order = new ArrayList<>();
        for (int hd : map.keySet()) {
            order.addAll(map.get(hd));
        }
        return order;
    }
    // height
    int height(Node node) {
        if (node==null) return 0;
        return Math.max(height(node.left), height(node.right))+1;
    }
    // size (no of nodes)
    int size(Node node) {
        if (node==null) return 0;
        return (size(node.left)+size(node.right)+1);
    }
    // Max
    int max(Node node) {
        if (node==null) return -1;
        return Math.max(node.data, Math.max(max(node.left), max(node.right)));
    }
    // Min
    int min(Node node) {
        if (node==null) return Integer.MAX_VALUE;
        return Math.min(node.data, Math.min(min(node.left), min(node.right)));
    }
    // Left view
        // using level order traversal first element of each level
        // use hashmap insted of list (list.get()==null)
    void leftViewUtil(Node node, ArrayList<Node> list, int level) {
        if (node==null) return;

        // try {
        //     list.get(level);
        // } catch (Exception e) {
        //     // TODO: handle exception
        //     list.add(node);
        // }
        if (list.size()<=level) {
            list.add(node);
        }
        leftViewUtil(node.left, list, level+1);
        leftViewUtil(node.right, list, level+1);
    }
    void leftView(Node node) {
        ArrayList<Node> list = new ArrayList<>();
        leftViewUtil(node, list, 0);
        for (Node pt : list) {
            System.out.print(pt.data+" ");
        }System.out.println();
        // return list;
    }
    // Right view
        // using level order traversal last element of each level
        // two ways either (nlr to nrl) or instead of keep checking kepp updating 
    void rightViewUtil(Node node, ArrayList<Node> list, int level) {
        if (node==null) return;

        try {
            list.get(level);
        } catch (Exception e) {
            // TODO: handle exception
            list.add(node);
        }
        rightViewUtil(node.right, list, level+1);
        rightViewUtil(node.left, list, level+1);
    }
    void rightView(Node node) {
        ArrayList<Node> list = new ArrayList<>();
        rightViewUtil(node, list, 0);
        for (Node pt : list) {
            System.out.print(pt.data+" ");
        }System.out.println();
    }
    // Top view (needs level order as need to traverse top -> bottom not left <-> right)
    class Pair{
        int hd; //horizontal distance
        Node node;
        Pair(int hd, Node node) {
            this.hd=hd;
            this.node=node;
        }
    }
    void topView(Node node) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>(); 

        q.add(new Pair(0, node));

        while (!q.isEmpty()) {
            Pair c = q.poll();

            if (!map.containsKey(c.hd)) {
                map.put(c.hd,c.node.data);
            }
            if (c.node.left!=null) {
                q.add(new Pair(c.hd-1, c.node.left));
            }
            if (c.node.right!=null) {
                q.add(new Pair(c.hd+1, c.node.right));
            }
        }

        for (Integer hd : map.keySet()) {
            System.out.print(map.get(hd)+" ");
        }System.out.println();
    }
    // Bottom view
    void bottomView(Node node) {
        Queue<Pair> q = new ArrayDeque<>();
        Map<Integer, Integer> map = new TreeMap<>(); 

        q.add(new Pair(0, node));

        while (!q.isEmpty()) {
            Pair c = q.poll();

            // if (!map.containsKey(c.hd)) 
                map.put(c.hd,c.node.data);
            
            if (c.node.left!=null) {
                q.add(new Pair(c.hd-1, c.node.left));
            }
            if (c.node.right!=null) {
                q.add(new Pair(c.hd+1, c.node.right));
            }
        }

        for (Integer hd : map.keySet()) {
            System.out.print(map.get(hd)+" ");
        }System.out.println();
    }
    // Flatten a bt (inorder)
    Node previous=null, head=null;
    void flattenBt(Node node) {
        if (node==null) return;
        
        flattenBt(node.left);
        if (previous==null) {
            head=node;
        } else {
            node.left = previous;
            previous.right = node;
        }
        previous = node;
        flattenBt(node.right);
    }
    void printDll(Node node) {
        while (node!=null) {
            System.out.print(node.data+" ");
            node = node.right;
        }System.out.println();
    }
    // Diameter
    int diameter(Node node) {
        if (node==null) return 0;
        int dl = diameter(node.left);
        int dr = diameter(node.right);
        int st = height(node.left)+height(node.right)+1;
        return Math.max(Math.max(dl, dr), st);
    }
    int ans=0;
    int diameterHeight(Node node) { //return height ans is the diameter
        if (node==null) return 0;
        int lh = diameterHeight(node.left);
        int rh = diameterHeight(node.right);
        ans = Math.max(ans, lh+rh+1);
        return 1+Math.max(lh, rh);
    }
    // LCA
    Node lca(Node node, int n1, int n2) {
        // case-4 (none subtree)
        if (node==null) return null;
        // case-1 (node itself)
        if(node.data==n1 || node.data==n2) return node;
        // case-3 (one subtree) (both)
        Node l = lca(node.left, n1, n2);
        Node r = lca(node.right, n1, n2);
        if (l==null) return r;
        if (r==null) return l;
        // case-2 (both subtree) (one each)
        return node;
    }
    // Burn a tree
    class Depth {
        int d;
        Depth(int d) {
            this.d = d;
        }
    }
    int minTime(Node node, int leaf) {
        Depth depth = new Depth(-1);
        burn(node, leaf, depth);
        return time;
    }
    int time=-1;
    int burn(Node node, int leaf, Depth depth) {
        if (node==null) return 0;

        if (node.data==leaf) {
            depth.d = 1;
            return 1;
        }

        Depth ld = new Depth(-1);
        Depth rd = new Depth(-1);

        int lh = burn(node.left, leaf, ld);
        int rh = burn(node.right, leaf, rd);

        if (ld.d!=-1) {
            time = Math.max(time, ld.d+rh+1);
            depth.d = ld.d+1;
        } else if (rd.d!=-1) {
            time = Math.max(time, rd.d+lh+1);
            depth.d = rd.d+1;
        }
        return Math.max(lh, rh) +1;
    }

}

public class BT_01_C {
    public static void main(String[] args) {
        
        // binary tree (recursion) 
                // maximum number of nodes at each level is 2^i
                // maximum no. of nodes for height h is 3^h -1
            // represented by array of n+1 (disjoint set union find)
            //     left child represented by 2*i 
            //     right child represented by 2*i+1
            //     parent represent by i/2
            // represented by node class
        
        // Initialise
            BinaryTree bt = new BinaryTree();
        // Create bt
            // Node root = bt.createBT();
            //preorer
            int[] nodes = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
            Node root = bt.buildTree(nodes);
        // Traversal 
            // inorder
            System.out.print("inorder: ");  bt.inorder(root);   System.out.println();
            // preorder
            System.out.print("preorder: "); bt.preorder(root);  System.out.println();
            // postorder
            System.out.print("postorder: ");bt.postorder(root); System.out.println();
            // levelorder
            System.out.print("levelorder: ");bt.levelOrder(root);System.out.println();
            // veritcal
        // Height
            System.out.println("height: "+bt.height(root));
        // Size
            System.out.println("size: "+bt.size(root));
        // Maximum
            System.out.println("max: "+bt.max(root));       // timeO(n) spaceO(h)
        // Minimum
            System.out.println("min: "+bt.min(root));
        // View
            // left
            System.out.print("left view: "); bt.leftView(root);
            // right
            System.out.print("right view: ");bt.rightView(root);
            // top
            System.out.print("top view: "); bt.topView(root);
            // bottom
            System.out.print("bottom view: ");bt.bottomView(root);

        // Q1 Binary to Dll (flatten a binary tree)
            // constraints inorder in place conversion (left->previous right->next)
            // System.out.print("flatten bt: ");bt.flattenBt(root);bt.printDll(bt.head);
        
        // Q2 Diameter of bt
            // longest path b/w two leaf nodes 
            // O(n^n)
            System.out.println("diameter: "+bt.diameter(root));
            // O(n)
            System.out.print("diameter: ");bt.diameterHeight(root);System.out.println(bt.ans);

        // Q3 Lowest common ancester in abinary tree (LCA of bt)
            // m1 two tree iteration and two arrays then third iteration for arrays
            // m2 
            System.out.println("lca of (2,5): "+bt.lca(root, 2, 5).data);
        
        // Q4 Burn a bt
            // minimum time to burn a bt starting from leaf node

        
    }   
}
