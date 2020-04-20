
import java.util.*;
import java.util.Map.Entry;

public class BTree 
{
	
	public Integer ReverseLevelOrder(Node root, HashMap<Integer, Vector<Integer>>hashMap, Integer key)
	{
		if(root == null)
			return key;
		
		if(root.left == null && 
		   root.right == null)
		{
			key = 0;
			System.out.println(" assigned "+ key);
			Vector<Integer>vec = hashMap.get(key);
			if(vec == null) {
				vec = new Vector<Integer>();				
			}

			vec.add(root.key);
			hashMap.put(key, vec);
			System.out.println("============leaf node "+ key);
			key++;
			return key;
		}
		else 
		{
			System.out.println("=============== else "+ key);
			
			key = ReverseLevelOrder(root.left, hashMap, key);
			key = ReverseLevelOrder(root.right, hashMap, key);
			Vector<Integer>vec = hashMap.get(key);
			if(vec == null) {
				vec = new Vector<Integer>();				
			}
			vec.add(root.key);
			hashMap.put(key, vec);	
			key++;

		}
		return key;
		
	}
	
	static public void preOrder(Node root) {
		if(root == null)
			return;
		System.out.println(root.key);
		preOrder(root.left);
		preOrder(root.right);		
	}
	
	public static void main(String[] args) {

		Node root = new Node(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.right.right = new Node(6);
		root.left.left = new Node(4);
		root.left.left.left = new Node(5);
	
		
		HashMap<Integer, Vector<Integer>>hashMap= new HashMap<>();
		Integer key = new Integer(0);
		BTree btree = new BTree();
		btree.ReverseLevelOrder(root, hashMap, key);
		System.out.println("Level order travalsal here ");
		for(Entry<Integer, Vector<Integer>>entry : hashMap.entrySet())
		{
			System.out.println(entry.getValue());
		}
	}
}

class Node {
	
	Integer key;
	Node left;
	Node right;
	
	public Node(Integer item) {
		key = item;
		this.left = null;
		this.right = null;
	}	
}
