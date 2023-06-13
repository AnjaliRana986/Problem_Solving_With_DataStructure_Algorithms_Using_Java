import java.lang.*;
import java.util.*;
import java.io.*;
public class lowest_common_ancestor{
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
    public static boolean find(Node node, int value){
        if(node.data == value){
            return true;
        }
        for(Node child: node.children){
            boolean fic = find(child,value);
            if(fic){
                return true;
            }
        }
        return false;
    }
    public static ArrayList<Integer> nodetonodetorootpath(Node node, int value){
        if(node.data == value){
            ArrayList<Integer> list = new ArrayList<>();
            list.add(node.data);
            return list;
        }
        for(Node child: node.children){
            ArrayList<Integer> ptc = nodetonodetorootpath(child, value);
            if(ptc.size() > 0 ){
                ptc.add(node.data);
                return ptc;
            }
        }
        return new ArrayList<>();
    }
    public static int lowestCommonAncestor(Node node, int v1, int v2){
        ArrayList<Integer> ntorv1 = nodetonodetorootpath(node, v1); 
        ArrayList<Integer> ntorv2 = nodetonodetorootpath(node, v2); 
        int i =ntorv1.size() -1;
        int j =ntorv2.size() -1;
        while(i >=0 && j >=0 && ntorv1.get(i )== ntorv2.get(j)){
            i--;
            j--;
        }
        i++;
        j++;
        return ntorv1.get(i);
    }
    public static void main(String[] args){
        int[] arr = {10,20,50,-1,60,-1,-1,30,70,-1,80,110,-1,120,-1,-1,90,-1,-1,40,100,-1,-1};
        Node root = null;
        Stack<Node> st = new Stack<>();
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
        display(root);
        boolean isFind = find(root, 110);
        ArrayList<Integer> listpath = nodetonodetorootpath(root, 110);
        System.out.println(listpath);
        int lca = lowestCommonAncestor(root, 70, 110);
        System.out.println("LCA " + lca);
    }
}