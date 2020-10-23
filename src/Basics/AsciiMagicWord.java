package Basics;

import java.text.ParseException;
import java.util.*;
//https://javarevisited.blogspot.com/2015/07/how-to-convert-string-or-char-to-ascii-example.html
/**
 *
 * @author Student
 */
public class AsciiMagicWord {
    public static void main(String[] args) throws ParseException {
        String m;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter the String");
        m=sc.nextLine();
        try {
        byte[] bytes = m.getBytes("US-ASCII"); 
        System.out.println("ASCII value of " + m + " is : "); 
        System.out.println(Arrays.toString(bytes)); 
        } catch (java.io.UnsupportedEncodingException e) {}
        //System.out.println("" +bytes[]);
        //INCOMPLETE // LEFT HALFWAY
    }
}
