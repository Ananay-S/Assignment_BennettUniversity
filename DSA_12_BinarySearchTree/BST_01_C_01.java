package DSA_12_BinarySearchTree;

import java.util.HashSet;

class Bst {
    // node
    class Node {
        int data;
        Node left, right;
        Node(int data) {
            this.data = data;
        }
    }
    // search
    boolean search(Node node, int key) {
        if (node==null) return false;

        if (node.data==key) {
            return true;
        } else if (node.data>key) {
            return search(node.left, key);
        } else {
            return search(node.right, key);
        }
    }
    // insert (recursive)
    Node insert(Node node, int data) {
        if (node==null) return new Node(data);

        if (data<node.data) {
            node.left = insert(node.left, data);
        } else if (data>node.data) {
            node.right = insert(node.right, data);
        }
        return node;
    }
    // insert (iterative)
    Node insertI(Node root, int data) {
        Node iNode = new Node(data);
        Node node = root;
        Node parent = null;

        while (node!=null) {
            parent = node;
            if (data<node.data) {
                node=node.left;
            } else {
                node=node.right;
            }
        }
        if (parent==null) {
            root = iNode;
        } else if (data<parent.data) {
            parent.left = iNode;
        } else {
            parent.right = iNode;
        }
        return root;
    }
    // delete
    int minNode(Node root) { // right side
        while (root!=null) {
            if (root.left==null) return root.data;
            root = root.left;
        }
        return root.data;
    }
    // int maxNode(Node root) { // left side
    //     while (root!=null) {
    //         if (root.right==null) return root.data;
    //         root = root.right;
    //     }
    //     return root.data;
    // }
    Node delete(Node root, int data) {
        if (root==null) return root;

        if (data<root.data) {
            root.left = delete(root.left, data);
        } else if (data>root.data) {
            root.right = delete(root.right, data);
        } else {
            if (root.right==null) {
                return root.left;
            } else if (root.left==null) {
                return root.right;
            } else {
                root.data = minNode(root.right); // root.data = maxNode(root.left);
                root.right = delete(root.right, root.data); // root.left = delete(root.left, root.data);
            }   
        }
        return root;
    }
    // isBst (new algorithm)
    boolean isBst(Node root, int max, int min) {
        if (root==null) return true;

        if ((min<root.data)&(root.data<max)) {
            boolean left = isBst(root.left, root.data, min);
            boolean right = isBst(root.right, max, root.data);

            return left&right;    
        } else {
            return false;
        }
    }
    // isBst (inorder)
    Node previous = null;
    boolean isBstPre(Node node) {
        if (node==null) return true;

        if (!isBstPre(node.left)) return false;

        if ((previous!=null)&&(node.data>=previous.data)) return false;
        previous=node;
        
        return isBstPre(node.right);
    }
    // floor 
    int floor(Node node, int key) {
        int ans = Integer.MAX_VALUE;
        while (node!=null) {
            if (node.data==key) return node.data;

            if (node.data<key) {
                ans = node.data; 
                node = node.right; // greatest value smaller than key
            } else {
                node = node.left;
            }
        }
        return ans;
    }
    // floor 
    int ceil(Node node, int key) {
        int ans = Integer.MIN_VALUE;
        while (node!=null) {
            if (node.data==key) return node.data;

            if (node.data>key) {
                ans = node.data; 
                node = node.left; // smallest value greater than key
            } else {
                node = node.right;
            }
        }
        return ans;
    }
    // isPair sum
    boolean isPair(Node node, int sum, HashSet<Integer> set) {
        if (node==null) return false;

        if (isPair(node.left, sum, set)) return true;

        if (set.contains(sum-node.data)) return true;
        set.add(node.data);

        return isPair(node.right, sum, set);
    }

}

public class BST_01_C_01 {
    
    // search
        // time O()
        // space O()
    // insert 
        // time O(h) height of the tree from logn to n (balanced tree to skewed tree) worst case O(n) avg case O(logn)
        // space 
            // r => O(h)
            // i => O(1)
    // delete
        // time O()
        // space O()
    // isBst (algo/inorder traversal'auxilarry array'/'modified')
        // time O(n)
        // space O(h)
    
    // Self Balancing BST
        // AVL trees
            // https://www.geeksforgeeks.org/introduction-to-avl-tree/
        // Red Black Trees


    // Q1 floor or ceil value

    // Q2 find pair with given sum in bst 
        // m1 inorder aux array then 2 sum
        // m2 hashmap then 2 sum



}
