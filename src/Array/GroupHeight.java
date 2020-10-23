package Array;
import java.util.Scanner;

/**
 *
 * @author Muzaffar
 */

public class GroupHeight {
    
    public static void main(String[] args) {
        
        Scanner h = new Scanner(System.in);
        int i, j, group=1, numOfPeople;
        System.out.println("Enter the number of people :");
        numOfPeople=h.nextInt();
        int height[] = new int[numOfPeople];
        System.out.println("Enter height");
            for(i=0;i<numOfPeople;i++) {
                height[i]=h.nextInt();
            }        
            for(i=0;i<numOfPeople;i++) {
                j=i+1;
                    if(j==numOfPeople)
                        break;
                        if(height[i]>height[j]) {
                            group=group+1;
                        }
            }
            
        System.out.println("Groups are : "+group);
        
    }
    
}
