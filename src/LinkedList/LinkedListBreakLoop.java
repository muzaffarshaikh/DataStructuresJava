package LinkedList;
import java.util.Scanner;

//https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/
//https://www.geeksforgeeks.org/make-loop-k-th-position-linked-list/
//https://www.javatpoint.com/java-program-to-create-and-display-a-singly-linked-list
//https://www.geeksforgeeks.org/implementing-a-linked-list-in-java-using-class/

class NodeR { 
        int data; 
        NodeR nextLink; 
        
        NodeR(int d) 
        { 
            data = d; 
            nextLink = null; 
        } 
    }

public class LinkedListBreakLoop {
    
    static NodeR head = null;
    static NodeR lastLink = null;
    
    static void addNode(int data){
        NodeR newNode = new NodeR(data);
        
        if(head==null){
            head = newNode;
            lastLink = newNode;
        }
        else{
            lastLink.nextLink = newNode;
            //lastLink will become the newNode
            lastLink = newNode;
        }
    }
    
    public void display(){
        NodeR currentptr = head;
        
         if(head == null) {    
            System.out.println("Linked List is Empty");    
            return;
         }
         while(currentptr != null) {    
            //Prints each node    
            System.out.print(currentptr.data + " ");    
            currentptr = currentptr.nextLink;    
        }    
        System.out.println();    
    }
    
    public void loop(){
    	NodeR lastLink=head;
    	while(lastLink.nextLink != null) {
    		lastLink=lastLink.nextLink;
    	}
    	lastLink.nextLink=head.nextLink;
    }
    
    public void detect() {
    	NodeR tort = head;
    	NodeR hare = head;
    	
    	while(hare.nextLink.nextLink != null) {
    		tort=tort.nextLink;
    		hare=hare.nextLink.nextLink;
            if(tort==hare){
                System.out.println("Loop Detected in the LinkedList.");
               break;
            }
    	}
    }
    
    public void breakloop(){
        NodeR tort = head;
    	NodeR hare = head;
    	
    	while(hare.nextLink.nextLink != null) {
    		tort=tort.nextLink;
    		hare=hare.nextLink.nextLink;
            if(tort==hare){
                System.out.println("Loop Detected in the LinkedList.");
               break;
            }
    	}
        int c=1;
        hare = head.nextLink;
        while(hare!=tort){
            hare=hare.nextLink;
            c++;
        }
        hare=head.nextLink;
        while(hare.nextLink!=tort){
            hare=hare.nextLink;
        }
        hare.nextLink=null;
        System.out.println("Loop is broken.");   
    }
    
            public static void main(String[] args){
            LinkedListBreakLoop linklist = new LinkedListBreakLoop();
            int n, i;
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the number of nodes you want: ");
            n=sc.nextInt();
            System.out.println("Enter "+n+" nodes");
            for(i=0;i<n;i++){
               int da=sc.nextInt();
               addNode(da);
            }        
            System.out.print(" The LinkList is  ");
            linklist.display();
            //System.out.print(" The Looped LinkList is  ");
            linklist.loop();
            linklist.detect();
            linklist.breakloop();
        }
}
