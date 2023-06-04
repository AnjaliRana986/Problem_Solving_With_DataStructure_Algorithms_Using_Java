import java.lang.*;
import java.io.*;
import java.util.*;
public class generic_tree_traversal_pre_post_order{
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

    // GENERIC TREE TRAVERSAL - PRE AND POST ORDER
    public static void traverse(Node node){
        // euler's left , on the way deep in the recusrion
        System.out.println("Node Pre " + node.data);
        for(Node child: node.children){
            //Edge pre
            System.out.println("Edge Pre " + node.data + "->" + child.data);
            traverse(child);
            //Edge post
            System.out.println("Edge Post " + node.data + "->" + child.data);
        } 
        System.out.println("Node Post " + node.data);
        // euler's  right , on the way out of the recusrion
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
        traverse(root);
    }
}