
// two ways to do One thing both are discussed here one is by using the collections and other is normal way by defing maxheapify and minheapify functions
// The second way using the brute Force way is given downwards 
import java.util.*;
class MaxMinHeapOldway{
     void maxheapify(int a[],int i,int n){
        int left = i*2;
        int right = (i*2)+1;
        int largest = i;
        if(left<= n-1 &&a[left]>a[i]){
            largest = left;
        }else{
            largest = i;
        }
        if(right<= n-1 && a[right]>a[largest]){
            largest =right;
        }
        if(largest != i){
            int temp = a[i];
            a[i]=a[largest];
            a[largest]= temp;
            maxheapify(a,largest,n);
        }
    }
    void minheapify(int a[],int i,int n){
        int left = i*2;
        int right = (i*2)+1;
        int largest = i;
        if(left<= n-1 &&a[left]<a[i]){
            largest = left;
        }else{
            largest = i;
        }
        if(right<= n-1 && a[right]<a[largest]){
            largest =right;
        }
        if(largest != i){
            int temp = a[i];
            a[i]=a[largest];
            a[largest]= temp;
            minheapify(a,largest,n);
        }
    }
}
// Class for printing heap using PriorityQueue class provided by Java collections library 
class MaxMinHeap{
// declaring necessary variables 
   int mrks,n_students;
// PriorityQueue as Max heap reversered the order reverse order fuction
   PriorityQueue<Integer> pQueue= new PriorityQueue<Integer>(Collections.reverseOrder());
// min heap as normal PriorityQueue
   PriorityQueue<Integer> qQueue= new PriorityQueue<Integer>();   
   Scanner sm =new Scanner(System.in);
// passing the number of students through a parametrized constructor
    public MaxMinHeap(int n){
        n_students=n;
    }
// an utility function for printing the Max and Min marks from the Heaps
  void printminmaxmarks(){
    for(int i=1;i<=n_students;++i){
        System.out.println("Please Enter the marks of student "+i+" for a particular subject");
        mrks=sm.nextInt();
        // adding the marks in the Heap 
        pQueue.add(mrks);
        qQueue.add(mrks);
    }
// using the in-built peek fucntion to print the max and min marks 
    System.out.println("The maximum marks obtained by the student in a subject are : "+pQueue.peek());
    System.out.println("The minimum marks obtaained by the student in a subject are are : "+qQueue.peek());
  }
   
}
public class Heap{
    public static void main (String[] args) {
         int n,ch;
         System.out.println("Please Enter the Number of students to be analysed");
         Scanner sc =new Scanner(System.in);
         n=sc.nextInt();
         int arr[]=new int [n];
         System.out.println("Please Enter choice 1.using priotrity Queue 2. Using traditional way");
         ch=sc.nextInt();
         if(ch==1){
         MaxMinHeap heap=new MaxMinHeap(n);
         heap.printminmaxmarks();
         }
         if(ch==2){
             MaxMinHeapOldway m=new MaxMinHeapOldway();
             System.out.println("Enter the marks: ");
		   for(int i =0;i<n;i++){
		      arr[i]= sc.nextInt();
		    }
		    for(int i = arr.length/2;i>=0;i--){
		    m.maxheapify(arr,i,arr.length);
		}
		System.out.println("Higest "+arr[0]);
        for(int i = arr.length/2;i>=0;i--){
		    m.minheapify(arr,i,arr.length);
		}
		System.out.println("Smallest "+arr[0]);
         }
    }
}
