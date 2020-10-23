package Basics;

//https://stackoverflow.com/questions/3059333/validating-input-using-java-util-scanner

import java.util.Scanner;

/**
 *
 * @author Muzaffar
 */

public class InstagramImageDimensions {
    
    public static void main(String[] args){
        
        Scanner in = new Scanner(System.in);
        int l, n, i, w, h;
        
        do {
            System.out.println("Enter the dimension of the image : ");
                while (!in.hasNextInt()) {
                System.out.println("Please Enter an Integer Value!");
                in.next();
                }
                l = in.nextInt();
        } while (l <= 0);
        
        do {
            System.out.println("Enter the number of pictures you want to upload :");
                while (!in.hasNextInt()) {
                System.out.println("Please Enter an Integer Value!");
                in.next();
                }
                n = in.nextInt();
        } while (l <= 0);
        
        for(i=0;i<n;i++){
            do {
                System.out.println("Enter the Width");
                    while (!in.hasNextInt()) {
                    System.out.println("Please Enter Integer Values!");
                    System.out.println("Enter the Width");
                    in.next();
                    }
                w=in.nextInt();
        } while (l <= 0);
            
        do {
        System.out.println("Enter the Height");
            while (!in.hasNextInt()) {
            System.out.println("Please Enter Integer Values!");
            System.out.println("Enter the Height");
            in.next();
            }
            h=in.nextInt();
        } while (l <= 0);
        
            if(w<l && h<l){
                System.out.println("Upload Another");
            }
            if(w>l && h>l){
                System.out.println("Crop it");
            }
            if(w==l && h==l){
                System.out.println("Accepted");
            }     
        }
    }  
}

