import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class postordertraversal{
    static int value;
    static Scanner sc=new Scanner(System.in);
    Deque<Node>queue=new LinkedList<Node>();

    static class Node{
        int key;
        Node left;
        Node right;
    }
    static Node newNode(int data){
        Node temp=new Node();
        temp.key=data;
        temp.left=null;
        temp.right=null;
        return temp;
    }
    Node insertNode(Node root,int key){
        Node newnode=newNode(key);

        if(root==null){
            root=newnode;
            queue.add(root);
            return root;
        }
        else{
            Node node;
            node=queue.remove();
            System.out.println("parent node"+node.key);
            if(node.left==null){
                node.left=newnode;
                queue.add(node.left);
                queue.addFirst(node);
                return root;
            }
            else if(node.right==null){
                node.right=newnode;
                queue.add(node.right);
                return root;
            }
        }
        return root;
    }
    public static void postorder(Node root){
        if(root==null){
            return ;
        }
        else{
            postorder(root.left);
            postorder(root.right);
            System.out.println(root.key+"");
        }
    }
    public static void main(String[] args) {
        postordertraversal pt= new postordertraversal();
        Node root=null;
        String status="a";
        while(!status.equals("s")){
            System.out.println("Enter the value to insert");
            value=sc.nextInt();
            root=pt.insertNode(root,value);//pasing value in the function 
            System.out.println("AFTER POSTORDER TRAVERSAL");
            pt.postorder(root);

            System.out.println("\nEnter s to stop or any other charachter to continue insertion");
            status=sc.next();
        }
        System.out.println("Program complete");

    }
}
