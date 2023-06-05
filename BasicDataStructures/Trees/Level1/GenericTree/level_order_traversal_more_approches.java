import java.lang.*;
import java.io.*;
import java.util.*;
public class level_order_traversal_more_approches{
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
        Node(){   // default constructor

        }
        Node(int data){
            this.data = data;
        }
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
    public static void levelordertraversal(Node node){
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
    
        while(q.size() > 0){
            node = q.remove();
            System.out.print(node.data + " ");
            for(Node child: node.children){
                q.add(child);
            }
            
        }
        System.out.println(".");
    }
    public static void levelorderzigzag(Node node){
        Stack<Node> st = new Stack<>();
        st.push(node);
        Stack<Node> cs  = new Stack<>();
        int level = 1;
        while(st.size() > 0){
            node = st.pop();
            System.out.print(node.data + " ");
            if(level % 2 == 1){
                for(int i =0; i < node.children.size(); i++){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }
            else{
                for(int i = node.children.size() - 1; i >= 0; i--){
                    Node child = node.children.get(i);
                    cs.push(child);
                }
            }
            if(st.size() == 0){
                st = cs;
                cs = new Stack<>();
                level ++;
                System.out.println();
            }
        }
    }
    public static void levelordertravermoreapproach1(Node node){
        Queue<Node> q = new ArrayDeque<>();
         q.add(node);
         q.add(new Node(-1));
         while(q.size() > 0){
            node = q.remove();
            if(node.data != -1){
                System.out.print(node.data + " ");
                for(Node child: node.children){
                    q.add(child);
                }
            }
            else{
                if(q.size() > 0){
                    q.add(new Node(-1));
                    System.out.println();
                }
            }
         }
    }
    public static void levelordertraverapproach2(Node node){
        System.out.println();
        // size count approach
        Queue<Node> q = new ArrayDeque<>();
        q.add(node);
        while(q.size() > 0){
            int countchildofqueue = q.size();
            for(int i = 0; i < countchildofqueue; i++){
                 node = q.remove();
                 System.out.print(node.data + " ");
                 for(Node child: node.children){
                    q.add(child);
                 }
            }
            System.out.println();
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
        levelordertraversal(root);
        levelorderzigzag(root);
        levelordertravermoreapproach1(root);
        levelordertraverapproach2(root);
    }
}