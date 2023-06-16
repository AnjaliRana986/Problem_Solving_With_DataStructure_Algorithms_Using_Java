import java.io.*;
import java.util.*;

public class node_with_maximum_subtree_sum {
  private static class Node {
    int data;
    ArrayList<Node> children = new ArrayList<>();
  }

  public static void display(Node node) {
    String str = node.data + " -> ";
    for (Node child : node.children) {
      str += child.data + ", ";
    }
    str += ".";
    System.out.println(str);

    for (Node child : node.children) {
      display(child);
    }
  }

  public static Node construct(int[] arr) {
    Node root = null;

    Stack<Node> st = new Stack<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == -1) {
        st.pop();
      } else {
        Node t = new Node();
        t.data = arr[i];

        if (st.size() > 0) {
          st.peek().children.add(t);
        } else {
          root = t;
        }

        st.push(t);
      }
    }

    return root;
  }

  
  static int ceil;
  static int floor;
  static int msn = 0 ;
  static int ms  = Integer.MIN_VALUE;
  public static void ceilAndFloor(Node node, int data) {
    if(node.data > data){
      if(node.data < ceil){
        ceil = node.data;
      }
    }

    if(node.data < data){
      if(node.data > floor){
        floor = node.data;
      }
    }

    for (Node child : node.children) {
      ceilAndFloor(child, data);
    }
  }

  public static int kthLargest(Node node, int k){
    floor = Integer.MIN_VALUE;
    int factor = Integer.MAX_VALUE;
    for(int i = 0; i < k; i++){
        ceilAndFloor(node, factor);
        factor = floor;
        floor =  Integer.MIN_VALUE;

    }
    // write your code here
    return factor;
  }
  public static int returnSumCalculateMaxSum(Node node){
        int sum = 0;
        for(Node child: node.children){
            int cs = returnSumCalculateMaxSum(child);
            sum += cs;
        }
        sum += node.data;
        if(sum > ms){
            msn = node.data;
            ms  = sum;
        }
        return sum;
  }
  public static void main(String[] args) throws Exception {
    int[] arr = {10,20,-50,-1,-60,-1,-1,30,-70,-1,80,-110,-1,120,-1,-1,90,-1,-1,40,-100,-1,-1};

    Node root = construct(arr);
    int kthLargest = kthLargest(root, 3);
    System.out.println(kthLargest);
    int sum = returnSumCalculateMaxSum(root);
    System.out.println(msn + " @ " + ms);
  }

}