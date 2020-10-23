package Array;

//https://gist.github.com/eMahtab/297419cb805fe93346c0
//https://stackoverflow.com/questions/16050222/put-a-range-on-the-input-of-an-array-in-java

import java.util.*;

public class TwoDimenasionalArrayIPattern {
    
    public static void main(String[] args){
        
       System.out.print("Enter 2D array size : ");
       Scanner sc=new Scanner(System.in);
       int sum;
       
       //int low=-9, high=9;
       
       int previous_sum=Integer.MIN_VALUE;
       int r=sc.nextInt();
       int c=sc.nextInt();
       System.out.println("Enter array elements : ");     
       int a[][]=new int[r][c];
       //if(a[r][c]>=low && a[r][c]<=high){
       for(int i=0; i<r; i++) {
           for(int j=0; j<c;j++) {
               a[i][j]=sc.nextInt();
           }
       }
       
       //}
       //else{
       //System.out.println("Please enter values in range from -9 to 9");
       //}
       
       System.out.print("\nThe Array that you entered : \n");
       for(int []x:a){
           for(int y:x){
               System.out.print(y+"  ");
           }
           System.out.println();
       }
       
        for(int i=0; i<4;i++){
            for(int j=0; j<4;j++) {
                   sum=a[i][j]+a[i][j+1]+a[i][j+2]+a[i+1][j+1]+a[i+2][j]+a[i+2][j+1]+a[i+2][j+2];
                   previous_sum=Math.max(previous_sum, sum);
            }   
        }
        
        System.out.println("sum="+previous_sum);
        
    }  
    
}
