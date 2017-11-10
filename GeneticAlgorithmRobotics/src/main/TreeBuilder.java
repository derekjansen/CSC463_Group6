package main;

import java.util.ArrayList;

public class TreeBuilder 
{
	public TreeBuilder() {}
	/**
	 * List of functions and what each function calls
	 */
	private ArrayList<Component> components = new ArrayList<Component>();
	
	/**
	 * Gets the list of functions
	 * @return queueList
	 */
	public ArrayList<Component> getComponents()
	{
		return this.components;
	}
	
	/**
	 * Inserts into queueList
	 * @param node
	 */
	public void insert(Component node)
	{
		this.components.add(node);
	}
	
	/**
	 * Finds component in list
	 * @param id
	 * @return
	 */
	public Component find(int id)
	{
		for(int i1 = 0; i1 < this.components.size(); i1++)
		{
			if(components.get(i1).getFunctionId() == id)
			{
				return components.get(i1);
			}
		}
		return null;
	}
	
	/**
	 * Root of the tree
	 */
	private Node root;
	
	/**
	 * Gets root
	 * @return root
	 */
	public Node getRoot()
	{
		return root;
	}
	
	/**
	 * Builds tree
	 * @return the last node
	 */
	public Node buildTree()
	{
		this.root = new Node(components.get(0).getFunctionId(), components.get(0).getFunction(), 0);
		return buildNode(root, components.get(0));
	}
	
	/**
	 * Recursively builds nodes
	 * @param parent
	 * @param queue
	 * @return
	 */
	private Node buildNode(Node parent, Component queue)
	{	
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
		else
		{
			parent.setNodeA(newChild(queue.getFunctionId(), queue.getFunction(), parent.getDepth() + 1));
		}
		return parent;
	}
	
	/**
	 * Creates new node
	 * @param id
	 * @param function
	 * @param depth
	 * @return the created node
	 */
	private Node newNode(int id, String function, int depth)
	{
		return new Node(id, function, depth);
	}
	
	/**
	 * Creates a child node
	 * @param id
	 * @param function
	 * @param depth
	 * @return
	 */
	private Node newChild(int id, String function, int depth)
	{
		return new Node(id, function, depth);
	}
	
}
