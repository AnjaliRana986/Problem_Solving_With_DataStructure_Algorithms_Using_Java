import java.lang.*;
import java.util.*;
import java.io.*;
public class maximum_in_a_generic_tree{
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
    //d(10) -> will print itslef and it's family
    //d(20),d(30),d(40) will print the,selves and print their family
    // d(10) = s(10) + d(20) +d(30) + d(40)
    public static void display(Node node){
        String str = node.data + "->";
        for(Node child: node.children){
            str += child.data +",";
        }
        str += ".";
        System.out.println(str);
        for(Node child : node.children){
            display(child);
        }

    }
    public static int sizeoftree(Node node){
        int size = 0;
        for(Node child: node.children){
            int cs = sizeoftree(child);
            size = size + cs;
        }
        size = size + 1;
        return size;
    }
    public static int maximumvaluenode(Node node){
        int max = Integer.MIN_VALUE;
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1};
        Node root = null;
        Stack<Node> st = new Stack<>();
        for(int i =0; i < arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }else{
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
        int size = sizeoftree(root);
        System.out.println("Size of generic tree: "+ size);
        int max = maximumvaluenode(root);
        System.out.println("maximum in a generic tree: " + max);
    }
}