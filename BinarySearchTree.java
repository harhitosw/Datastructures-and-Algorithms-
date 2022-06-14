
import java.util.Scanner;
public class BinarySearchTree {
     class Node
     {
      int Value;
      Node LeftChild,RightChild;
      public Node(int Data){
          Value=Data;
          LeftChild=RightChild=null;
      }
    }
      Node root;
      BinarySearchTree(){
          root=null;
      }
    void InsertNode(int Value){
        root=InsertInBST(root,Value);
    }
    Node InsertInBST(Node root,int Value){
        if(root==null){
            root=new Node(Value);
            return root;
        }
        else if(Value<root.Value){
            root.LeftChild=InsertInBST(root.LeftChild, Value);
            return root;
        }
        else{
            root.RightChild=InsertInBST(root.RightChild, Value);
            return root;
        }
       
    }
    void inordertraversal(){
      InOrderTraversal(root);
    }
    void InOrderTraversal(Node root){
        if(root!=null){
            InOrderTraversal(root.LeftChild);
            System.out.println(root.Value+"");
            InOrderTraversal(root.RightChild);
        }
    }
    boolean searchinbstInvoker(int Value_to_be_searched){
        SearchInBST(root, Value_to_be_searched);
        if (root!= null){
            return true;
        }
        else{
            return false;
        }
           
    }
    Node SearchInBST(Node root,int Value_to_be_searched){
        if(root==null||root.Value==Value_to_be_searched){
            return root;
        }
        else if(root.Value>Value_to_be_searched){
            return SearchInBST(root.LeftChild, Value_to_be_searched);
        }
        else{
            return SearchInBST(root.RightChild, Value_to_be_searched);
        }
    }
    int getMinValue(Node root){
        int minvalue=root.Value;
        while (root.LeftChild != null)  { 
            minvalue = root.LeftChild; 
            root = root.LeftChild; 
        } 

        return minvalue;
    }
    void deleteinvoker(int Value){
        root=DeleteNode(root, Value);
    }
    Node DeleteNode(Node root,int Value){
        if(root==null){
            return root;
        }
        // moving along the Left part of the tree
        if(Value<root.Value){
            root.LeftChild=DeleteNode(root.LeftChild, Value);
        }
        // moving along the Right part of the tree
        else if(Value>root.Value){
            root.RightChild=DeleteNode(root.RightChild, Value);
        }
        else{
            // handling the cases where only one child of Root node is present 
            if(root.LeftChild==null){
                return root.RightChild;
            }
            else if(root.RightChild==null){
                return root.LeftChild;
            }
           // getting the inorder successor and deleting it from the tree when the Node has 2 children 
           root.Value=getMinValue(root.RightChild);
           //deleting that value from the tree
           root.RightChild=DeleteNode(root.RightChild, root.Value);


        }
        return root;
    }
    public static void main(String[] args) {
        int N,option,choice;
        boolean var;
        Scanner sc=new Scanner(System.in);
        BinarySearchTree bst=new BinarySearchTree();
        System.out.println("WELCOME TO BINARY SERACH TREE PROGRAM");
        do {
            System.out.println("1.Insert Node in BST 2.Perform Inorder Traversal 3.Search Node 4.Delete Node");
            System.out.println("Enter the choice of operation to be performed");
            option=sc.nextInt();
            switch (option) {
                case 1:
                System.out.println("Enter the Number you want to Insert");
                N=sc.nextInt();
                bst.InsertNode(N);
                    break;
                case 2:
                System.out.println("The Inorder Traversal of the Tree is");
                bst.inordertraversal();
                break;
                case 3:
                System.out.println("Enter the Number you want to Search");
                N=sc.nextInt();
                var=bst.searchinbstInvoker(N);
                if(var){
                    System.out.println("The Node is present in BST ");
                }
                else{
                System.out.println("Sorry The Node is Not Present");
                }
                break;
                case 4:
                System.out.println("Enter the Number you want to delete");
                N=sc.nextInt();
                bst.deleteinvoker(N);
                break;
                default:
                System.out.println("Sorry Please Enter the Right Choice!!!");
                break;
            }
            System.out.println("Do you want to continue with the Program if yes than press 1");
            choice=sc.nextInt();
        } while (choice==1);
       
    }
}
