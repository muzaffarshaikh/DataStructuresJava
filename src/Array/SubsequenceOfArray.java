//https://www.geeksforgeeks.org/java-math-max-method-examples/
//https://www.geeksforgeeks.org/collections-max-method-in-java-with-examples/
//https://www.youtube.com/watch?v=etyrkipdKvc

import java.util.*;

public class SubsequenceOfArray {
    
    public static void main(String[] args) {
        
        Scanner h=new Scanner(System.in); 
        int i,n,t1,ans=0,st,t2;
        
        System.out.println("Number of elements:");
        n=h.nextInt();
        
        int num1[] = new int[n];
        int num2[][] = new int[10][n];   
        
        System.out.println("Enter elements");
        for(i=0;i<n;i++) {
            num1[i] = h.nextInt();
        }
        
        for(i=0;i<10;i++) {           
            for(int j=0;j<n;j++){
                t1=num1[j];    
                while(t1>0) {
                    t2=t1%10;
                    num2[t2][j]=1;
                    t1=t1/10;
                }
            }                     
        }
        
        for(int k=0;k<10;k++) {
            for(int p=0;p<n;p++) {
                System.out.println(num2[k][p]);
            }
        System.out.println();
        }
        
        for(int u=0;u<10;u++) {
            st=0;
            for(int v=0;v<n;v++) {
                if(num2[u][v]==1) {
                    st=st+1;
                }
            }
            ans=Math.max(st, ans);
        }
        System.out.println("Maximum number of array is : " + ans);  
    }   
}
