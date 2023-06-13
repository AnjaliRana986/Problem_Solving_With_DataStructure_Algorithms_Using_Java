import java.lang.*;
import java.util.*;
import java.io.*;
public class multisolver_tree {
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }
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
    
    
    public static Node construct(int[] arr){
        Stack<Node> st = new Stack<>();
        Node root = null;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == -1){
                st.pop();
            }
            else{
                Node temp = new Node();
                temp.data = arr[i];
                if(st.size() > 0){
                    st.peek().children.add(temp);
                }
                else{
                    root = temp;
                }
                st.push(temp);

            }
        }
        return root;
    }
    static int size;
    static int min;
    static int max;
    static int height;

    public static void multisolver(Node node, int depth){
        size++;
        min = Math.min(min, node.data);
        max = Math.max(max, node.data);
        height = Math.max(height, depth);
        for(Node child: node.children){
            multisolver(child, depth + 1);
        }
    }
    public static void main(String[] args){
        int[] arr1 = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1};
        Node root1 = construct(arr1);
        // int[] arr2 = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1};
        // Node root2 = construct(arr2);
        
        size = 0;
        min = Integer.MAX_VALUE;
        max = Integer.MIN_VALUE;
        height = 0;

        display(root1);
        multisolver(root1,0);
        // display(root2);
        System.out.println("Size " + size);
        System.out.println("Min value " + min);
        System.out.println("Max value " + max);
        System.out.println("Height of tree " + height);
    }
}