import java.lang.*;
import java.io.*;
import java.util.*;
public class height_of_a_generic_tree{
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    public static void display(Node node){
        String str  = node.data + "->";
        for(Node child: node.children){
            str += child.data + ",";
        }
        str += ".";
        System.out.println(str);
        for(Node child: node.children){
            display(child);
        }
    }
    public static int height(Node node){
        // handles base case i.e. only single node is geven : hieght of tree will be 0
        int maxh = -1;  //in terms of edges
        // int h = 0   // i terms of nodes
        for(Node child: node.children){
            int ch = height(child);
            maxh = Math.max(maxh, ch);
        }
        maxh += 1;
        return maxh;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1};
        Node root = null;
        Stack<Node> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }
            Node t = new Node();
            t.data = arr[i];
            if(st.size() > 0){
                st.peek().children.add(t);
            }
            else{
                root = t;
            }
            st.push(t);
        }
        display(root);
        int h = height(root);
        System.out.println(h);
    }
}