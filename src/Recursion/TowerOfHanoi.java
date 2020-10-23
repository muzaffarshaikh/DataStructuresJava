package Recursion;

import java.util.Scanner;

/**
 *
 * @author Muzaffar
 */

public class TowerOfHanoi {
    
    static void towerOfHanoi(int n, char from, char to, char aux) 
    { 
        if (n == 1) 
        { 
            System.out.println("Move disk 1 from " +  from + " to " + to); 
            return; 
        } 
        towerOfHanoi(n-1, from, aux, to); 
        System.out.println("Move disk " + n + " from " +  from + " to " + to); 
        towerOfHanoi(n-1, aux, to, from); 
    } 
      
    //  Driver method 
    public static void main(String args[]) 
    { 
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of Disks");
        int n = sc.nextInt();
        towerOfHanoi(n, 'A', 'C', 'B');  
        // A, B, C = names of rods 
    } 
    
}
