package main;

import java.util.ArrayList;
import java.util.Stack;

public class TreeManager 
{
	/**
	 * Swaps a node in the tree, but keeps the old subtree
	 * @param newNode
	 * @param oldNode
	 */
	public static void swapNodeA(Node parent, Node newNode)
	{
		if(parent.getNodeA() != null)
		{
			Node old = parent.getNodeA();
			if(old.getNodeA() != null)
			{
				newNode.setNodeA(old.getNodeA());
			}
			if(old.getNodeB() != null)
			{
				newNode.setNodeB(old.getNodeB());
			}
		}
		parent.setNodeA(newNode);
	}
	
	/**
	 * Swaps node b
	 * @param parent
	 * @param newNode
	 */
	public static void swapNodeB(Node parent, Node newNode)
	{
		if(parent.getNodeB() != null)
		{
			Node old = parent.getNodeB();
			if(old.getNodeA() != null)
			{
				newNode.setNodeA(old.getNodeA());
			}
			if(old.getNodeB() != null)
			{
				newNode.setNodeB(old.getNodeB());
			}
		}
		parent.setNodeB(newNode);
	}
	
	/**
	 * Swaps a subtree with a new subtree
	 * @param newNode
	 * @param oldNode
	 */
	public static void swapSubTreeA(Node parent, Node newNode)
	{
		parent.setNodeA(newNode);
	}
	
	/**
	 * Swaps subtree b
	 * @param parent
	 * @param newNode
	 */
	public static void swapSubTreeB(Node parent, Node newNode)
	{
		parent.setNodeB(newNode);
	}
	
	/**
	 * Combines two subtrees
	 * @param subtreeA
	 * @param subtreeB
	 * @param newParent
	 */
	public static void combineTrees(Node subtreeA, Node subtreeB, Node newParent)
	{
		newParent.setNodeA(subtreeA);
		newParent.setNodeB(subtreeB);
	}
	
	/**
	 * Traverses the tree to find a node
	 * @param parent
	 */
	public static Node searchDFS(int uid, Node root)
	{
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while(!stack.isEmpty())
		{
			Node x = stack.pop();
			if(x.getUid() == uid)
			{
				return x;
			}
			if(x.getNodeA() != null)
			{
				stack.add(x.getNodeA());
			}
			if(x.getNodeB() != null)
			{
				stack.add(x.getNodeB());
			}
		}
		return null;
	}
	
	/**
	 * Finds deepest node in tree provided
	 * @param root
	 * @return
	 */
	public static Node findDeepestDFS(Node root)
	{
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		int maxDepth = 0;
		Node result = null;
		while(!stack.isEmpty())
		{
			Node x = stack.pop();
			System.out.println(x.toString());
			if(x.getDepth() > maxDepth)
			{
				result = x;
			}
			if(x.getNodeA() != null)
			{
				stack.add(x.getNodeA());
			}
			if(x.getNodeB() != null)
			{
				stack.add(x.getNodeB());
			}
		}
		return result;
	}
}
