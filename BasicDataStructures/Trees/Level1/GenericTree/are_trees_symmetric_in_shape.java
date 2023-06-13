
import java.lang.*;
import java.util.*;
import java.io.*;

public class are_trees_symmetric_in_shape {
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
    public static boolean areTreeSimilarInshape(Node node1, Node node2){
        if(node1.children.size() != node2.children.size()){
            return false;
        }
        for(int i = 0; i < node1.children.size(); i++){
            Node c1 = node1.children.get(i);
            Node c2 = node2.children.get(i);
            if(areTreeSimilarInshape(c1, c2)==false){
                return false;
            }
        }
        return true;
    }
    public static boolean areTreesmirrorInShape(Node node1, Node node2){
        if(node1.children.size() != node2.children.size()){
            return false;
        }
        for(int i = 0;i < node1.children.size(); i++){
            int j = node2.children.size() -1 -i;
            Node c1 = node1.children.get(i);
            Node c2 = node2.children.get(j);
            if(areTreesmirrorInShape(c1, c2) == false){
                return false;
            }
        }
        return true;
    }
    public static boolean areTreeSymmetric(Node node){
        return areTreesmirrorInShape(node, node); 
    }
    public static void main(String[] args){
        int[] arr1 = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1};
        Node root1 = construct(arr1);
        int[] arr2 = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1};
        Node root2 = construct(arr2);
        
        display(root1);
        display(root2);
       boolean shape = areTreeSimilarInshape(root1,root2);
       System.out.println(shape);
       boolean mirror = areTreesmirrorInShape(root1, root2);
       System.out.println(mirror);
       boolean symmetric = areTreeSymmetric(root1);
       System.out.println(symmetric);
    }
}
