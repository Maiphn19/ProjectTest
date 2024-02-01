/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package A;

import Model.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 *
 * @author Mai
 */
public class TreeAndList {
    
    //Given the root of a binary tree, invert the tree, and return its root.
    public TreeNode invertTree(TreeNode root) {
        if(root==null) return null;

        TreeNode temp = root.left;
        root.left=root.right;
        root.right=temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
    
    //Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).
    public List<List<Integer>> levelOrder(TreeNode root) 
    {
        List<List<Integer>>al=new ArrayList<>();
        pre(root,0,al);
        return al;
    }
    public static void pre(TreeNode root,int l,List<List<Integer>>al)
    {
        if(root==null)
            return;
        if(al.size()==l)
        {
            List<Integer>li=new ArrayList<>();
            li.add(root.val);
            al.add(li);
        }
        else
            al.get(l).add(root.val);
        pre(root.left,l+1,al);
        pre(root.right,l+1,al);
    } 
//    
//    Given a reference of a node in a connected undirected graph.
//
//Return a deep copy (clone) of the graph.
//
//Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
    public void dfs(Node node , Node copy , Node[] visited){
        visited[copy.val] = copy;// store the current node at it's val index which will tell us that this node is now visited
        
//         now traverse for the adjacent nodes of root node
        for(Node n : node.neighbors){
//             check whether that node is visited or not
//              if it is not visited, there must be null
            if(visited[n.val] == null){
//                 so now if it not visited, create a new node
                Node newNode = new Node(n.val);
//                 add this node as the neighbor of the prev copied node
                copy.neighbors.add(newNode);
//                 make dfs call for this unvisited node to discover whether it's adjacent nodes are explored or not
                dfs(n , newNode , visited);
            }else{
//                 if that node is already visited, retrieve that node from visited array and add it as the adjacent node of prev copied node
//                 THIS IS THE POINT WHY WE USED NODE[] INSTEAD OF BOOLEAN[] ARRAY
                copy.neighbors.add(visited[n.val]);
            }
        }
        
    }
    public Node cloneGraph(Node node) {
        if(node == null) return null; // if the actual node is empty there is nothing to copy, so return null
        Node copy = new Node(node.val); // create a new node , with same value as the root node(given node)
        Node[] visited = new Node[101]; // in this question we will create an array of Node(not boolean) why ? , because i have to add all the adjacent nodes of particular vertex, whether it's visited or not, so in the Node[] initially null is stored, if that node is visited, we will store the respective node at the index, and can retrieve that easily.
        Arrays.fill(visited , null); // initially store null at all places
        dfs(node , copy , visited); // make a dfs call for traversing all the vertices of the root node
        return copy; // in the end return the copy node
    }
}
