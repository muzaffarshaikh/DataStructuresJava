package LinkedList;

//https://www.youtube.com/watch?v=rllxESAWeP8&feature=youtu.be
//https://www.geeksforgeeks.org/rotate-a-linked-list/

//package LabSession5;

import java.util.Scanner;
//import sun.security.ssl.Debug;


class Node { 
        int data; 
        Node next; 
        
        Node(int d) 
        { 
            data = d; 
            next = null; 
        } 
    }

public class LinkListRotate {
    static Node head = null;
    static Node lastLink = null;
    
    static void addNode(int data){
        Node newNode = new Node(data);
        
        if(head==null){
            head = newNode;
            lastLink = newNode;
        }
        else{
            lastLink.next = newNode;
            //lastLink will become the newNode
            lastLink = newNode;
        }
    }
    
    public void display(){
        Node currentptr = head;
        
         if(head == null) {    
            System.out.println("Linked List is Empty");    
            return;
         }
         while(currentptr != null) {    
            //Prints each node    
            System.out.print(currentptr.data + " ");    
            currentptr = currentptr.next;    
        }    
        System.out.println();    
    }
    
    public void rotate(int k){      
        if(k==0) return;
        Node cpt=head;
        int c=1, l;
        l=k%n;
        //Debug.println(n + "", null);
        while( c < l && cpt!=null){
            cpt=cpt.next;
            c++;  
        }
        if(cpt==null) return;
        Node kn = cpt;
        while(cpt.next!=null)
            cpt=cpt.next;
            cpt.next=head;
            head=kn.next;
            kn.next=null; 
        
    }
    
    public static int n; 
    public static void main(String[] args){
            LinkListRotate linklist = new LinkListRotate();
            int i, k;
            Scanner sc=new Scanner(System.in);
            System.out.println("Enter the number of nodes you want: ");
            n=sc.nextInt();
            System.out.println("Enter "+n+" nodes");
            for(i=0;i<n;i++){
               int da=sc.nextInt();
               addNode(da);
            }        
            System.out.print("The LinkList is  ");
            linklist.display();

           System.out.println("By how many places you want to rotate the LINKLIST?");
           k=sc.nextInt();
           linklist.rotate(k);
           System.out.println("Rotated List is : ");
           linklist.display();
           
           }
}