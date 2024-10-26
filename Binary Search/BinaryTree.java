package BinaryTree;
import java.util.*;
class Node{
    int key ; 
    Node left , right ; 
    Node(int key){
        this.key = key;
        this.left = null ;
        this.right = null;
    }
}
public class BinaryTree {
    static void preorderDFS(Node node){
        if (node == null){
            return;
        }
        System.out.print(node.key + " ");
        preorderDFS(node.left);
        preorderDFS(node.right);
    }
    static void inorderDFS(Node node){
        if (node == null){
            return;
        }
        inorderDFS(node.left);
        System.out.print(node.key + " ");
        inorderDFS(node.right);
    }
    static void postOrderDFS(Node node){
        if (node == null){
            return;
        }
        postOrderDFS(node.left);
        postOrderDFS(node.right);
        System.out.print(node.key + " ");
    }
    static void bfs(Node root){
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.key + " ");
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null){
                queue.add(node.right);
            }
        }
    }
    static Node add_binary_tree(Node root , int key){
        if (root == null)
            return new Node(key);
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            Node temp = queue.poll();
            if (temp.left == null){
                temp.left = new Node(key);
                break;
            }else{
                queue.add(temp.left);
            }
            if (temp.right == null){
                temp.right = new Node(key);
                break;
            }else{
                queue.add(temp.right);
            }
        }
        return root;
    }
    static boolean searchDFS(Node root , int x){
        if (root == null)
            return false;
        if (root.key == x )
            return true; 
        boolean left_res = searchDFS(root.left, x);
        boolean right_res = searchDFS(root.right, x);
        return left_res || right_res;
    }
    static Node delete(Node root , int x ){
        if (root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        Node target = null;
        queue.add(root);
        while(!queue.isEmpty()){
            Node current = queue.poll();
            if (current.key == x){
                target = current;
                break;
            }
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        if (target == null)
            return root;
        Node lastNode  = null;
        Node lastParent = null;
        Queue<Node> queue2 = new LinkedList<>();
        Queue<Node> parentQueue = new LinkedList<>();
        queue2.add(root);
        parentQueue.add(null);
        while(!queue2.isEmpty()){
            Node current = queue2.poll();
            Node parent = parentQueue.poll();

            lastNode = current;
            lastParent = parent ;

            if (current.left != null)
                queue2.add(current.left);
                parentQueue.add(current);
            if (current.right != null)
                queue2.add(current.right);
                parentQueue.add(current);
        }
        target.key = lastNode.key;
        if (lastParent != null){
            if (lastParent.left != lastNode){
                lastParent.left = null;
            }else{
                lastParent.right = null;
            }
        }else{
            return null;
        }
        return root;
    } 
     public static void main(String[] args) {
        Node root1 = new Node(78);
        root1.left = new Node(62);
        root1.right = new Node(53);
        root1.left.left = new Node(34);
        root1.left.right = new Node(25);
        System.out.println("Duyet truoc ");
        preorderDFS(root1);

        System.out.println("\nDuyet theo thu tu tu truoc den sau ");
        inorderDFS(root1);

        System.out.println("\nDuyet theo thu tu tu sau vao truoc ");
        postOrderDFS(root1);

        int key = 6 ; 
        root1 = add_binary_tree(root1, key);
        System.out.println("\nSau khi them ");
        inorderDFS(root1);

        key = 10 ; 
        root1 = add_binary_tree(root1, key);
        System.out.println("\nSau khi them ");
        inorderDFS(root1);
        
        key = 14 ; 
        root1 = add_binary_tree(root1, key);
        System.out.println("\nSau khi them ");
        inorderDFS(root1);
        System.out.println();

        int val  = 25;
        delete(root1, val);
        System.out.println("Xoa phan tu trong cay nhi phan");
        inorderDFS(root1);
        System.out.println();

        int x = 6; 
        if (searchDFS(root1, x))
            System.out.println(x + " Ton trong cay nhi phan");
        else 
            System.out.println(x + " Khong ton tai trong cay nhi phan");
        
        
    }
}
