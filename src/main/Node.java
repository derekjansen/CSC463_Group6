package main;

public class Node 
{
	private int id;
	private String function;
	private int depth;
	private Node nodeA;
	private Node nodeB;
	
	public Node(int id, String function, int depth)
	{
		this.id = id;
		this.function = function;
		this.depth = depth;
		this.nodeA = null;
		this.nodeB = null;
	}
	
	public void setNodeA(Node nodeA)
	{
		this.nodeA = nodeA;
	}
	
	public void setNodeB(Node nodeB)
	{
		this.nodeB = nodeB;
	}
	
	public Node getNodeA()
	{
		return this.nodeA;
	}
	
	public Node getNodeB()
	{
		return this.nodeB;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getFunction()
	{
		return this.function;
	}
	
	public int getDepth()
	{
		return this.depth;
	}
	
	public String toString()
	{
		return "ID: " + this.id + " Func: " + this.function + " Depth: " + this.depth + "\n";
	}
}
