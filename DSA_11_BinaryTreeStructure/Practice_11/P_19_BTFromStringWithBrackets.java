package DSA_11_BinaryTreeStructure.Practice_11;


public class P_19_BTFromStringWithBrackets {
    
    static class Node {
        int data;
        Node left,right;
        Node(int data) {
            this.data = data;
            this.left = this.right = null;
        }
    }

    // M1
    
    static class Index {
        int idx;
    }

    static boolean isOC(char s) {
        if (s=='(' || s==')') return true;
        return false;
    }
    static boolean isOpen(char s) {
        if (s=='(') return true;
        return false;
    }
    static boolean isClose(char s) {
        if (s==')') return true;
        return false;
    }

    static Node buildUtil(String s, Index ptr) {
        if (s.length() <= ptr.idx) return null;
        
        char c = s.charAt(ptr.idx++);

        if (isClose(c)) return null;

        if (isOpen(c)) {
            char cn = s.charAt(ptr.idx++);
            if (isClose(cn)) return null;
            Node node = new Node(cn-'0');
            node.left = buildUtil(s, ptr);
            node.right = buildUtil(s, ptr);
            return node;
        }

        // root node
        Node root = new Node(c-'0');
        root.left = buildUtil(s, ptr);
        root.right = buildUtil(s, ptr);
        
        return root;
    }
    static Node build(String s) {
        if (s.length()==0) return null;
        Index ptr = new Index();
        ptr.idx=0;
        return buildUtil(s, ptr);
    }


    // M2___________________________________________________________

    static int start = 0;

// Construct Tree Function which accepts 
// a string and return root of the tree;
static Node constructTree(String s) 
{
	
	// Check for null or empty string
	// and return null;
	if (s.length() == 0 || s == null)
	{
		return null;
	}
	
	if (start >= s.length())
		return null;
	
	// Boolean variable to check
	// for negative numbers
	boolean neg = false;
	
	// Condition to check for negative number
	if (s.charAt(start) == '-') 
	{
		neg = true;
		start++;
	}
	
	// This loop basically construct the
	// number from the continuous digits 
	int num = 0;
	while (start < s.length() && 
		Character.isDigit(s.charAt(start)))
	{
		int digit = Character.getNumericValue(
			s.charAt(start));
		num = num * 10 + digit;
		start++;
	}
	
	// If string contains - minus sign 
	// then append - to the number;
	if (neg) 
		num = -num;
	
	// Create the node object i.e. root of 
	// the tree with data = num;
	Node node = new Node(num);
	
	if (start >= s.length()) 
	{
		return node;
	}
	
	// Check for open bracket and add the
	// data to the left subtree recursively
	if (start < s.length() && s.charAt(start) == '(' )
	{
		start++;
		node.left = constructTree(s);
	}
	
	if (start < s.length() && s.charAt(start) == ')')
	{
		start++;
		return node;
	}
	
	// Check for open bracket and add the data 
	// to the right subtree recursively
	if (start < s.length() && s.charAt(start) == '(') 
	{
		start++;
		node.right = constructTree(s);
	}
	
	if (start < s.length() && s.charAt(start) == ')') 
	{
		start++;
		return node;
	}
	return node;
}
    public static void main(String[] args) {
        System.out.println('5'-'0');
    }


}
