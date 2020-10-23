package Stack;
import java.util.Scanner;
import java.util.Stack;

//https://www.geeksforgeeks.org/check-for-balanced-parentheses-in-an-expression/
//https://www.javatpoint.com/java-string-charat

public class BalancedParenthesisStack {
    
    public static void main(String[] args) {
        
	int i;
	Stack<Character> stack = new Stack();
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the number of brackets (n) : ");
	int n = input.nextInt();
	int m=n+1;
	String a[]=new String[m];
        System.out.println("Enter the brackets");
        for(i=0; i<m;i++) {
            a[i] = input.nextLine();            
       	}
        char ch;
        for(i=0; i<m;i++) {
            String g=a[i]; 
            for(int j=0;j<g.length();j++) {
                ch=g.charAt(j); 
                System.out.println(""+ch);
		if(ch=='{' || ch=='(' || ch=='[') {
                    stack.push(ch);     		               
		} else {
                    if(ch==']' && stack.peek()=='[' || ch=='}' && stack.peek()=='{' || ch==')' && stack.peek()=='(') {
                        stack.pop();
                        if(stack.isEmpty()) {
                            System.out.println("YES");
                        }   
                    } else {
                        System.out.println("NO");
		        	   }  
		   }	
            }
        }
    }
}
