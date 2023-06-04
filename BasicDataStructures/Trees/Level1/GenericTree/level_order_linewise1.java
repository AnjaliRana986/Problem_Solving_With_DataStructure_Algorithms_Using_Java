
import java.lang.*;
import java.io.*;
import java.util.*;
public class level_order_linewise1{
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
        int h = -1;
        for(Node child : node.children){
            int ch  = height(child);
            h = Math.max(ch,h);
        }
        h += 1;

        return h;
    }
    public static void levelordertraversalnextline(Node node){
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();
        mq.add(node);
        while(mq.size() > 0 ){
            node = mq.remove();
            System.out.print(node.data + " ");
            for(Node child: node.children){
                cq.add(child);
            }
            if(mq.size() == 0){
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
        
        
    }
    public static void main(String[] args) {
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1};
        Node root = null;
        Stack<Node> st = new Stack<>();
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }
            else{
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
           
        }
        display(root);
        int h = height(root);
        System.out.println(h);
        levelordertraversalnextline(root);
    }
}