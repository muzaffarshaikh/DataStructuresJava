package Stack;

import java.util.Stack;
import java.util.*;

//http://www.iitk.ac.in/esc101/08Jan/Solutions/lab8/thursday/Teststack.java
//https://www.geeksforgeeks.org/tracking-current-maximum-element-in-a-stack/
//https://algorithms.tutorialhorizon.com/track-the-maximum-element-in-a-stack/

public class MaxElementInStack {
	/**
	 *
	 * @author Muzaffar
     * @param args
	 */
    public static void main(String[] args) {

        Stack<Integer> main=new Stack<>();
        Stack<Integer> track = new Stack<>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of queries you want to perform.");
        int number = sc.nextInt();

        for(int i=0; i<number;i++){
            System.out.println("1. To push an element 'x'.");
            System.out.println("2. To delete the element at the top of the stack.");
            System.out.println("3. To print the maximum element in the stack.");
            System.out.println("");
            System.out.println("Enter the Query you want to perform.");
            int qu = sc.nextInt();
            switch (qu) {

                case 1:

                    System.out.println("Enter the element 'x' to be pushed.");
                    int a = sc.nextInt();
                    main.push(a);
                    if(track.isEmpty()) {
                         track.push(a);
                    } else {
                        if(a>track.peek()) {
                            track.push(a);
                        }                    
                    }
                    break;

                case 2:

                    int b = main.pop();
                    if(b==track.peek()) {
                        track.pop();
                    }
                    System.out.println("The poped value is" +b);
                    break;

                case 3:
                    System.out.println("The maximun element in the stack is : " +track.peek());
                    break;
            }
        }
    }		
}
