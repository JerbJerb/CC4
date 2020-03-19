import javax.swing.JOptionPane;
import java.util.Scanner;
class Node{
    int key, height;
    Node left, right;
    
    Node(int d){
        key = d;
        height = 1;
    }
}
class AVL1 
{
    Node root;
    // TREE HEIGHT
    int height(Node N)
    {
        if (N == null)
             return 0;
         return N.height;
    }
    // A utility function to get maximum of two integers
    int max(int a, int b)
    {
        return (a > b) ? a : b;
    }
    // A utility function to right rotate subtree rooted with y
    // See the diagram given above.
    Node rightRotate(Node y)
    {
        Node x = y.left;
        Node T2 = x.right;
        // Perform rotation
        x.right = y;
        y.left = T2;
        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;
        // Return new root
        return x;
    }
    // A utility function to left rotate subtree rooted with x
    // See the diagram given above.
    Node leftRotate(Node x)
    {
        Node y = x.right;
        Node T2 = y.left;
 
        // Perform rotation
        y.left = x;
        x.right = T2;
 
        //  Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;
 
        // Return new root
        return y;
    }
 
    // Get Balance factor of node N
    int getBalance(Node N)
    {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }
 
    Node insert(Node node, int key)
    {
        /* 1.  Perform the normal BST rotation */
        if (node == null)
            return (new Node(key));
 
        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Equal keys not allowed
            return node;
 
        /* 2. Update height of this ancestor node */
        node.height = 1 + max(height(node.left),
                              height(node.right));
 
        /* 3. Get the balance factor of this ancestor
           node to check whether this node became
           Wunbalanced */
        int balance = getBalance(node);
        // If this node becomes unbalanced, then
        // there are 4 cases Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);
        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);
 
        // Left Right Case
        if (balance > 1 && key > node.left.key)
        {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        // Right Left Case
        if (balance < -1 && key < node.right.key)
        {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }
        return node;
    }
    Node minValueNode(Node node)
    {
        Node current = node;
 
        /* loop down to find the leftmost leaf */
        while (current.left != null)
           current = current.left;
 
        return current;
    }
 
    Node deleteNode(Node root, int key)
    {
        // STEP 1: PERFORM STANDARD BST DELETE
        if (root == null)
            return root;
 
        // If the key to be deleted is smaller than
        // the root's key, then it lies in left subtree
        if (key < root.key)
            root.left = deleteNode(root.left, key);
 
        // If the key to be deleted is greater than the
        // root's key, then it lies in right subtree
        else if (key > root.key)
            root.right = deleteNode(root.right, key);
 
        // if key is same as root's key, then this is the node
        // to be deleted
        else
        {
 
            // node with only one child or no child
            if ((root.left == null) || (root.right == null))
            {
                Node temp = null;
                if (temp == root.left)
                    temp = root.right;
                else
                    temp = root.left;
 
                // No child case
                if (temp == null)
                {
                    temp = root;
                    root = null;
                }
                else   // One child case
                    root = temp; // Copy the contents of
                                 // the non-empty child
            }
            else
            {
 
                // node with two children: Get the inorder
                // successor (smallest in the right subtree)
                Node temp = minValueNode(root.right);
 
                // Copy the inorder successor's data to this node
                root.key = temp.key;
 
                // Delete the inorder successor
                root.right = deleteNode(root.right, temp.key);
            }
        }
 
        // If the tree had only one node then return
        if (root == null)
            return root;
 
        // STEP 2: UPDATE HEIGHT OF THE CURRENT NODE
        root.height = max(height(root.left), height(root.right)) + 1;
 
        // STEP 3: GET THE BALANCE FACTOR OF THIS NODE (to check whether
        //  this node became unbalanced)
        int balance = getBalance(root);
 
        // If this node becomes unbalanced, then there are 4 cases
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);
 
        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0)
        {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
 
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);
 
        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0)
        {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
 
        return root;
    }
    
    public int getHeight(){
        return root.height;
    }

    private String x;
    private String y;
    private int avlArray[];
    private int indArray[];
    private int lastKnownIndex = 0;
    
    public void showAVL() {
        x = "";
        try{
        int avlSize = ((int) Math.pow(2, root.height)) - 1;
        if (avlSize > 0) {
            avlArray = new int[avlSize];

            int index = 0;

            avlArray[index] = root.key;

            if (avlSize > 1) {
                startAVLSearch(root, index);
            }

            for (int b = 0; b < avlArray.length; b++) {
                if (b <= lastKnownIndex) {
                    String bstValue = (avlArray[b] == 0) ? "null " : avlArray[b] + " ";
                    x = x + " " + bstValue;
                }
            }
            System.out.print("\nAVL:\t[" + x +"]");
        }
        }catch(NullPointerException e){
                System.out.println("[Empty Tree]");
                }
    } 
    public void showIndex() {
        y = "";
        int avlSize = ((int) Math.pow(2, root.height)) - 1;

        if (avlSize > 0) {
            indArray = new int[avlSize];

            for (int i = 0; i < avlSize; i++) {
                indArray[i] = i;
            }
            System.out.println("\n\nMax No. of Nodes: " + avlSize + " nodes");
            System.out.print("\nIndex:\t");
            for (int i = 0; i < avlSize; i++) {
                System.out.print(" " + indArray[i] + " ");
            }
        }
    }
    
    public void startAVLSearch(Node node, int i) {
        Node lt, rt;
        lt = node.left;
        rt = node.right;

        int nodeLeftIndex = (2 * i) + 1;
        int nodeRightIndex = (2 * i) + 2;
        if( lt == null && rt == null){
            System.out.println("No such Key.");
        }
        if (lt != null) {
            avlArray[nodeLeftIndex] = lt.key;
            startAVLSearch(lt, nodeLeftIndex);
            lastKnownIndex = Math.max(nodeLeftIndex, lastKnownIndex);
        } else {
            if (nodeLeftIndex < avlArray.length - 1) {
                avlArray[nodeLeftIndex] = 0;
            }
        }   

        if (rt != null) {
            avlArray[nodeRightIndex] = rt.key;
            startAVLSearch(rt, nodeRightIndex);
            lastKnownIndex = Math.max(nodeRightIndex, lastKnownIndex);
        } else {
            if (nodeRightIndex < avlArray.length - 1) {
                avlArray[nodeRightIndex] = 0;
            }
        }
    }   
}
public class BST {

    public static void main(String[] args) {
        AVL1 avl = new AVL1();
        Scanner sc = new Scanner(System.in);
        int choice;
        int Insertnum;
        int Deletenum;
        try {
            do {
                System.out.print("Options:"
                        + "\n[1]Insert"
                        + "\n[2]Delete"
                        + "\n[3]Exit"
                        + "\nYour choice: ");
                choice = sc.nextInt();
                try{
                switch (choice) {
                    case 1:
                        System.out.print("Enter integer to insert: ");
                        Insertnum  = sc.nextInt();
                        avl.root = avl.insert(avl.root, Insertnum);
                        break;
                    case 2:
                        System.out.print("Enter integer to delete: ");
                        Deletenum  = sc.nextInt();
                        avl.root = avl.deleteNode(avl.root, Deletenum);
                        break;
                    case 3:
                        System.exit(0);
                    default:
                        System.out.println("Invalid input please try again.");
                        continue;
                    }
                } catch (NullPointerException e){
                System.out.print("Nothing to Delete. \n");  
        }
                avl.showAVL();
                System.out.println();
            } while (choice != 3);
        } catch (IllegalArgumentException e) {
            System.out.println("Please input integer values only.");
            System.exit(0);
        }
    }
}