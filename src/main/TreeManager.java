package main;

import java.util.ArrayList;
import java.util.Stack;

public class TreeManager 
{
	/**
	 * List of functions and what each function calls
	 */
	private static ArrayList<QueueObject> queueList = new ArrayList<QueueObject>();
	
	/**
	 * Gets the list of functions
	 * @return queueList
	 */
	public static ArrayList<QueueObject> getQueue()
	{
		return queueList;
	}
	
	/**
	 * Inserts into queueList
	 * @param node
	 */
	public static void insert(QueueObject node)
	{
		queueList.add(node);
	}
	
	public static QueueObject find(int id)
	{
		for(int i1 = 0; i1 < queueList.size(); i1++)
		{
			if(queueList.get(i1).getFunctionId() == id)
			{
				return queueList.get(i1);
			}
		}
		return null;
	}
	
	/**
	 * Root of the tree
	 */
	private static Node root;
	
	/**
	 * Gets root
	 * @return root
	 */
	public static Node getRoot()
	{
		return root;
	}
	
	/**
	 * List of all the nodes in the tree, not in any specific order
	 */
	private static ArrayList<Node> treeNodes = new ArrayList<Node>();
	
	/**
	 * Gets list of nodes
	 * @return treeNodes
	 */
	public static ArrayList<Node> getTreeNodes()
	{
		return treeNodes;
	}
	
	/**
	 * Swaps a node in the tree, but keeps the old subtree
	 * @param newNode
	 * @param oldNode
	 */
	public static void swapNodeA(Node parent, Node newNode)
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
		parent.setNodeA(newNode);
	}
	
	/**
	 * Swaps a subtree with a new subtree
	 * @param newNode
	 * @param oldNode
	 */
	public static void swapSubTree(Node newNode, Node oldNode)
	{
		
	}
	
	/**
	 * Traverses the tree to find a node
	 * @param parent
	 */
	public static Node searchDFS(int id)
	{
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while(!stack.isEmpty())
		{
			Node x = stack.pop();
			if(x.getId() == id)
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
	
	public static Node buildTree()
	{
		root = new Node(queueList.get(0).getFunctionId(), queueList.get(0).getFunction(), 0);
		return buildNode(root, queueList.get(0));
	}
	
	private static Node buildNode(Node parent, QueueObject queue)
	{
		treeNodes.add(parent);
		
		if(parent.getDepth() < 20)
		{
			if(queue.getRandomComponent1() != null)
			{
				parent.setNodeA(newNode(queue.getC1id(), queue.getRandomComponent1(), parent.getDepth() + 1));
				buildNode(parent.getNodeA(), find(queue.getC1id()));
				
				if(queue.getRandomComponent2() != null)
				{
					parent.setNodeB(newNode(queue.getC2id(), queue.getRandomComponent2(), parent.getDepth() + 1));
					buildNode(parent.getNodeB(), find(queue.getC2id()));
				}
				else
				{
					parent.setNodeB(null);
				}
			}
			else
			{
				parent.setNodeA(newChild(queue.getFunctionId(), queue.getFunction(), parent.getDepth() + 1));
				parent.setNodeB(null);
			}
		}
		/*else
		{
			parent.setNodeA(newChild(queue.getFunctionId(), queue.getFunction(), parent.getDepth() + 1));
		}*/
		return parent;
	}
	
	private static Node newNode(int id, String function, int depth)
	{
		return new Node(id, function, depth);
	}
	
	private static Node newChild(int id, String function, int depth)
	{
		return new Node(id, function, depth);
	}
	
}
