import java.lang.*;
import java.io.*;
import java.util.*;
public class balanced_brackets {
    public static boolean handlecorrespondingchar(Stack<Character> st, char correschar){
        if(st.size() == 0){
            return false;
        }else if(st.peek() != correschar){
            return false;
        }else{
            st.pop();
            return true;
        }
               
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        String s = scn.nextLine();
        Stack<Character> st = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else if(ch == ')')
            {
               boolean val =  handlecorrespondingchar(st, '(');
               if(val == false){
                System.out.println(val);
                return;
               }
            }
            else if(ch == ']')
            {   
                boolean val = handlecorrespondingchar(st, '[');
                if(val == false){
                System.out.println(val);
                return;
               }
            }
            else if(ch == '}')
            {
                boolean val = handlecorrespondingchar(st, '{');
                if(val == false){
                System.out.println(val);
                return;
               }
            }
        }
        if(st.size() != 0){
            System.out.println(false);
            // return;
        }
        else{
            System.out.println(true);

        }
    }
}
