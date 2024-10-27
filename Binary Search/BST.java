package BinaryTree;
class Node{
    int key ;
    Node left , right ;
    public Node(int key){
        this.key = key ; 
        this.right = null;
        this.left = null;
    }
}
public class BinarySearchTree {
    static Node addBST(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.key) {
            root.left = addBST(root.left, key);
        } else if (key > root.key) {
            root.right = addBST(root.right, key);
        }
        return root;
    }
    static boolean search(Node root, int x) {
        if (root == null)
            return false;
        if (root.key == x)
            return true;
        return search(root.left, x) || search(root.right, x);
    }

    static Node delete(Node root, int x) {
        if (root == null) return null;

        if (x < root.key) {
            root.left = delete(root.left, x);
        } else if (x > root.key) {
            root.right = delete(root.right, x);
        } else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.key = minValue(root.right); 
            root.right = delete(root.right, root.key); 
        }
        return root;
    }

    static int minValue(Node root) {
        if (root == null) return -1;
        while (root.left != null) {
            root = root.left;
        }
        return root.key;
    }

    static int maxValue(Node root) {
        if (root == null) return -1;
        while (root.right != null) {
            root = root.right;
        }
        return root.key;
    }
    static int floor(Node root, int x) {
        int floorValue = -1;
        while (root != null) {
            if (root.key == x) {
                return root.key;
            }
            if (root.key > x) {
                root = root.left;
            } 
            else {
                floorValue = root.key;
                root = root.right;
            }
        }
        return floorValue;
    }
    static int ceil(Node root , int x){
        int ceil_val = -1;
        while (root != null) {
            if (root.key == x)
                return root.key;
            else if (root.key < x )
                root = root.right;
            else 
                ceil_val = root.key;
                root = root.right;
        }
        return ceil_val;
    }
    static void inorder(Node root){
        if (root == null)
            return ;
        inorder(root.left);
        System.out.print(root.key + " ");
        inorder(root.right);
    }
    public static void main(String[] args) {
        Node root1 = new Node(50);
        root1 = addBST(root1, 62);
        root1 = addBST(root1, 53);
        root1 = addBST(root1, 34);
        root1 = addBST(root1, 25);
        
        System.out.println("\nDuyet theo thu tu truoc ra sau:");
        inorder(root1);

        int key = 63;
        root1 = addBST(root1, key);
        System.out.println("\nThem " + key );
        inorder(root1);

        key = 49;
        root1 = addBST(root1, key);
        System.out.println("\nThem " + key );
        inorder(root1);

        System.out.println();

        int x = 63;
        if (search(root1, x))
            System.out.println(x + " ton tai trong BST");
        else
            System.out.println(x + " khong ton tai trong BST");

        key = 62;
        root1 = delete(root1, key);
        System.out.println("\nXoa " + key );
        inorder(root1);
        System.out.println();

        x = 63;
        if (search(root1, x))
            System.out.println(x + " ton tai trong BST");
        else
            System.out.println(x + " khong ton tai trong BST");

        int min = minValue(root1);
        System.out.print("\nGia tri nho nhat BST: " + min);

        int max = maxValue(root1);
        System.out.print("\nGia tri lon nhat BST: " + max);

        int floor_val = 72;
        int result_floor = floor(root1, floor_val);
        System.out.println("\nGia tri san la " + result_floor);

        int ceil_val = 33 ; 
        int result_ceil = ceil(root1,ceil_val);
        System.out.println("\nGia tri ceil la " + result_ceil);

    }

}
