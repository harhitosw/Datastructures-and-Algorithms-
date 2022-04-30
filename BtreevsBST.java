import java.time.Duration;
import java.time.Instant;
import java.util.Scanner;
//the class for BST begins here 
 class BST
{
    class BSTNode 
     {
      int Value;
      BSTNode LeftChild,RightChild;
      public BSTNode(int Data){
          Value=Data;
          LeftChild=RightChild=null;
      }
    }
    BSTNode bstroot;
    void inordertraversalinvoker(){
      InOrderTraversal(bstroot);
    }
    void InOrderTraversal(BSTNode bstroot){
      if(bstroot!=null){
          InOrderTraversal(bstroot.LeftChild);
          System.out.println(bstroot.Value+" ");
          InOrderTraversal(bstroot.RightChild);
      }
  }
    void InsertNode(int N)
    {
        bstroot=InsertInBST(bstroot,N);
    }
        // Recursive Function to insert a Node in BST 
    BSTNode InsertInBST(BSTNode bstroot,int Value)
    {
            if(bstroot==null){
                bstroot=new BSTNode(Value);
            }
            else if(Value<bstroot.Value){
                bstroot.LeftChild=InsertInBST(bstroot.LeftChild, Value);
            }
            else{
                bstroot.RightChild=InsertInBST(bstroot.RightChild, Value);
            }
            return bstroot;
        }
        BSTNode SearchInBST(BSTNode bstroot,int Value_to_be_searched){
          if(bstroot==null||bstroot.Value==Value_to_be_searched){
              return bstroot;
          }
          else if(bstroot.Value>Value_to_be_searched){
              return SearchInBST(bstroot.LeftChild, Value_to_be_searched);
          }
          else{
              return SearchInBST(bstroot.RightChild, Value_to_be_searched);
          }
        }
        boolean searchinbstInvoker(int Value_to_be_searched){
          SearchInBST(bstroot, Value_to_be_searched);
          if (bstroot!= null){
              return true;
          }
          else{
              return false;
          }
        }
    
      }


 class BTree
{
  // the order of the given tree is 3 
    private int T=3;
    public class Node {
        // int n is the current number of keys in the B tree
          int n;
          // the maximum number of keys that a node can hold  is 2T-1 see that this is not applicable for the root 
          int key[] = new int[2*T-1];
          // the maximum number of children that a Node can have is one more than Keys in the Node 
          Node child[] = new Node[2*T];
        // an array of child pointer is created on above line and below line tells us that it is leaf node 
          boolean leaf = true;
          public int Find(int k) {
            for (int i = 0; i < this.n; i++) {
              if (this.key[i] == k) {
                return i;
              }
            }
            return -1;
          }
        }
        Node root=new Node();
        public BTree() {
            root = new Node();
            root.n = 0;
            root.leaf = true;
          }
    private void split(Node x, int pos, Node y) {
        // taking a new node for operations and making some attributes of that Nodes to new node 
        Node z = new Node();
        z.leaf = y.leaf;
        z.n = T - 1;
        // from the sorted Node we write all elements of next hlf to begining of new node 
        for (int j = 0; j < T - 1; j++) {
          z.key[j] = y.key[j + T];
        }
        // iff given Node is not leaf than manage the children 
        if (!y.leaf) {
          for (int j = 0; j < T; j++) {
            // make the Next hlf children of y children of z
            z.child[j] = y.child[j + T];
          }
        }
      // setting the Keys in Node Y equal to T-1 
        y.n = T - 1;
      // adjusting the position of the child from the given pos 
        for (int j = x.n; j >= pos + 1; j--) {
          x.child[j + 1] = x.child[j];
        }
        // make z the child at pos+1  on node x
        x.child[pos + 1] = z;
        for (int j = x.n - 1; j >= pos; j--) {
          x.key[j + 1] = x.key[j];
        }
        x.key[pos] = y.key[T - 1];
        x.n = x.n + 1;
      }
    public void insert(final int key) {
        // allocate the memory of a temporary Node and make it equal to root 
        Node r = root;
        // we need to handle the case where Node is Full 
        if (r.n == 2*T - 1) {
        // creating another Temp Node 
          Node s = new Node();
        // making that node as root declaring it as non-leaf node and making the number of Keys as 0 for that node 
          root = s;
          s.leaf = false;
          s.n = 0;
          s.child[0] = r;
        // now we split the Node such that we are abe to insert a given value 
          split(s, 0, r);
          _insert(s, key);
        } else {
          _insert(r, key);
        }
      }
    final private void _insert(Node x, int k) {
        // if the given node is a leaf Node 
        if (x.leaf) {
          int i = 0;
          //shift all the Greater than NewKey Nodes to right by one and find the position for the NewKey
          for (i = x.n - 1; i >= 0 && k < x.key[i]; i--) {
            x.key[i + 1] = x.key[i];
          }
          // overwrite the value of key to that position and increment the current counter 
          x.key[i + 1] = k;
          x.n = x.n + 1;
        } else {
          int i = 0;
          //finding the Child who is going to have the NewKey and also the value from we can spilt the node 
          while (i >= 0 && x.key[i] > k){
              i--;
          }
          // assigning that value to the tmporary Node 
          Node tmp = x.child[i];
          // handling the case where that child is full by spilting 
          if (tmp.n == 2*T - 1) {
            split(x, i, tmp);
            if (k > x.key[i]) {
              i++;
            }
          }
          _insert(x.child[i], k);
        }
      }
    public boolean Contain(int k) {
        if (this.Search(root, k) != null) {
          return true;
        } else {
          return false;
        }
      }
      private void display(Node x) {
        assert (x == null);
        for (int i = 0; i < x.n; i++) {
          System.out.print(x.key[i] + " ");
        }
        if (!x.leaf) {
          for (int i = 0; i < x.n + 1; i++) {
            display(x.child[i]);
          }
        }
      } 
      public void display() {
        display(root);
      }
      private Node Search(Node x, int key) {
        int i = 0;
        //if there is No Node than return x;
        if (x == null)
          return x;
        for (i = 0; i < x.n; i++) {
        // iff we did not find the Key than break and execute else part 
          if (key < x.key[i]) {
            break;
          }
          if (key == x.key[i]) {
            return x;
          }
        }
        if (x.leaf) {
          return null;
        }
        // recursively search again for the given Key 
        else {
          return Search(x.child[i], key);
        }
      } 
};
public class BtreevsBST{
public static void main(String[] args) {
    BTree bt = new BTree();
    BST b=new BST();
    int N,option;
    Scanner sc=new Scanner(System.in);
    while(true) 
    {
        System.out.println("---------------B-tree vs BST---------------");
        System.out.println("\n1.Insert Node in BST \t2.Perform Inorder Traversal \n3.Search Node \t\t4.Exit");
        System.out.println("Enter the choice of operation to be performed:");
        option=sc.nextInt();
        switch (option) 
        {
            case 1:
              System.out.println("Enter the Number you want to Insert:");
              N=sc.nextInt();
              long start2 = System.nanoTime();
              bt.insert(N);
              long end2 = System.nanoTime();
              System.out.println("Time to insert in B tree is "+ (end2-start2)+"ms");
              long start1 = System.nanoTime();
              b.InsertNode(N);
              long end1 = System.nanoTime();
              System.out.println("Time to insert in BST is "+ (end1-start1)+"ms");
              break;
            case 2:
              System.out.println("The  Traversal of the B-tree is :-");
              long start5 = System.nanoTime();
              bt.display();
              long end5 = System.nanoTime();
              System.out.println("\n Time to Display in B-tree is "+ (end5-start5)+"ms");
              System.out.println("The  Traversal of the BST is :-");
              long start6 = System.nanoTime();
              b.inordertraversalinvoker();
              long end6 = System.nanoTime();
              System.out.println("\n Time to Display in BST is "+ (end6-start6)+"ms");
              break;
            case 3:
              System.out.println("Enter the Number you want to Search:");
              N=sc.nextInt();
              long start3 = System.nanoTime();
              boolean contains=bt.Contain(N);
              long end3 = System.nanoTime();
              long start4 = System.nanoTime();
              boolean present=b.searchinbstInvoker(N);
              long end4 = System.nanoTime();
              if(present){
                System.out.println("The Node is present in B-Tree and the time taken to search in B-tree is "+(end4-start4)+"ns");
              }
              if(contains){
                System.out.println("The Node is present in BST and the time taken to search in BST is "+(end3-start3)+"ns");
              }
              if(present!=true){
                System.out.println("Node is not Present");
              }
              break;
            case 4: 
              System.out.println("Program ended successfully.\n Hence we conclude that B-Tree is efficient on DBMS as compared to BST and AVL trees ");
              System.exit(0);
            default:
              System.out.println("Sorry Please Enter the Right Choice!!!");
              break;
        }
    }
  }
}