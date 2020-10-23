package HashMap;
import java.util.Scanner;
/**
 *
 * @author Muzaffar
 */
public class LinearProbing {
  
    public static int length;
    
    public static int compression(int d){
        return d%length; 
    }
    
    public static void main(String []args){
        int i, n;
        int index;
        Scanner sc = new Scanner(System.in);
        System.out.println("Number of elements:");
        length=sc.nextInt();
        
        int num[] = new int[length];
        System.out.println("Enter elements");
        
        for(i = 0; i < length; i++)
        {
            int no = sc.nextInt();
            index = compression(no);
            {
                boolean isRunning = true;
                while(isRunning){
                    if(index >= length)
                        index = 0;
                    if(num[index] == 0)
                    {                    
                        num[index] = no;
                        isRunning = false;
                    }
                    index++;
                }
            }   
        }
        int j;
        for(j=0;j<length;j++){
            System.out.println(num[j]);
        }
	//NOT COMPLETE

    } 
    }
