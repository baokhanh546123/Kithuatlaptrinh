package BinaryTree;
import java.util.*;
class Node {
    int data;
    Node right, left;
    public Node(int data) {
        this.data = data;
        this.right = null;
        this.left = null;
    }
}
public class LevelOrderTraversal {
    static void LevelOrder(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
            } 
        }
    public static void main(String[] args) {
            Node root = new Node(1);
            root.left = new Node(2);
            root.right = new Node(3);
            root.left.right = new Node(4);
            root.left.left = new Node(5);
            LevelOrder(root);
         
        }
    }
