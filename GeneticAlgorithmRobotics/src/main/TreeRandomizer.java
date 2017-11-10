package main;

import java.util.ArrayList;

public class TreeRandomizer 
{	
	//components
	private static ArrayList<String> components = componentsInit();
	
	//initializes components
	private static ArrayList<String> componentsInit()
	{
		ArrayList<String> result = new ArrayList<String>();
		result.add("swapNodeA()");
		result.add("swapNodeB()");
		result.add("swapSubTreeA()");
		result.add("swapSubTreeB()");
		return result;
	}
	
	//gets random component
	private static String randomComponent()
	{
		return components.get((int)(Math.random() * components.size() - 1));
	}
	
	//gets random node
	private static Node randomNode(Node root)
	{
		int randNode = ((int)(Math.random() * 20 - 1));
		Node child = root;
		for(int i1 = 0; i1 < randNode; i1++)
		{
			int randChild = ((int)Math.random() * 2 + 1);
			if(randChild == 1)
			{
				child = root.getNodeA();
			}
			else
			{
				child = root.getNodeB();
			}
		}
		return child;
	}
	
	//selects random subtree
	public static Node randomize(Node root)
	{
		Node result = root;
		Node randNode = randomNode(root);
		String randFunc = randomComponent();
		switch(randFunc)
		{
			case "swapNodeA()":
			{
				TreeManager.swapNodeA(randomNode(root), randNode);
			}
			case "swapNodeB()":
			{
				TreeManager.swapNodeB(randomNode(root), randNode);
			}
			case "swapSubTreeA()":
			{
				TreeManager.swapSubTreeA(randomNode(root), randNode);
			}
			case "swapSubTreeB()":
			{
				TreeManager.swapSubTreeB(randomNode(root), randNode);
			}
		}
		return result;
	}
}
