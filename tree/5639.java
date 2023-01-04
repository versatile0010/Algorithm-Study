import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Node{
        int value;
        Node left;
        Node right;
        public Node(int value){
            this.value=value;
            this.right=null;
            this.right=null;
        }
    }

    static class BinaryTree{
        Node root=null;
        public void insert(int ele){
            if(root==null){
                root=new Node(ele);
            } else{
                Node head = root;
                Node currentNode;
                while(true){
                    currentNode = head;

                    if(head.value > ele){
                        head = head.left;
                        if(head == null){
                            currentNode.left = new Node(ele);
                            break;
                        }
                    }
                    else {
                        head = head.right;
                        if(head==null){
                            currentNode.right = new Node(ele);
                            break;
                        }
                    }
                }
            }
        }
        public void postorder(Node root, int depth){
            if(root!=null){
                postorder(root.left, depth+1);
                postorder(root.right, depth+1);;
                System.out.println(root.value);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BinaryTree tree = new BinaryTree();
        String input;
        while(true){
            input = br.readLine();
            if(input==null || input.equals(""))
                break;
            tree.insert(Integer.parseInt(input));
        }

        tree.postorder(tree.root, 0);
    }
}
