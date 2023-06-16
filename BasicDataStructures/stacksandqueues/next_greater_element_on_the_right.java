import java.lang.*;
import java.io.*;
import java.util.*;
public class next_greater_element_on_the_right {
    public static int[] solve1(int[] arr){
        int[] nge = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(arr[arr.length - 1]);
        nge[arr.length-1] = -1;
        for(int i = nge.length -2; i>= 0;i-- ){
            //pop
            while(st.size() > 0 && arr[i] >= st.peek()){
                st.pop();
            }
            if(st.size() == 0){
                nge[i] = -1;
            }else{
                nge[i] = st.peek();
            }
            st.push(arr[i]);
            //ans
            //pushes
        }
        return nge;
    }
    public static int[] solve2(int[] arr){
        int[] ngl = new int[arr.length];
        Stack<Integer> st = new Stack<>();
        st.push(0);
        for(int i = 0; i < arr.length; i++){
            while(st.size() > 0 && arr[i] > arr[st.peek()]){
                int pos = st.peek();
                ngl[pos] = arr[i];
                st.pop();
            }
            st.push(i);
        }
        while(st.size() > 0){
            int pos = st.peek();
            ngl[pos] = -1;
            st.pop();
        }
        return ngl;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i < arr.length; i++){
            arr[i] = scn.nextInt();
        }
        int[] ans = solve1(arr);
        for(int i = 0; i < ans.length; i++){
            System.out.println(ans[i]);
        }
        int[] ans2 = solve2(arr);
        for(int i = 0; i < ans2.length; i++){
            System.out.println(ans2[i]);
        }
    }
}
