package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Runner Class For Genetic Algorithm
 * @author Jake Moore
 */
public class Runnable 
{
	/**
	 * Main
	 * @param args
	 */
	public static void main(String[] args)
	{
		try 
		{
			ArrayList<Node> trees = new ArrayList<Node>();
			
			StreamManager mgr = new StreamManager("src\\botfile.c");
			mgr.clear();
			mgr.append(Generator.generateMain());
			mgr.append(Generator.generateCloseToWall());
			mgr.append(Generator.generateFarFromWall());
			mgr.append(Generator.generateDoTwoFarFar());
			mgr.append(Generator.generateDoTwoCloseClose());
			mgr.append(Generator.generateDoTwoCloseFar());
			mgr.append(Generator.generateDoTwoFarClose());
			mgr.append(Generator.generateForward());
			mgr.append(Generator.generateLeft());
			mgr.append(Generator.generateRight());
			mgr.append(Generator.generateBackup());
			mgr.append(Generator.generateTurnParallelToPosition());
			mgr.append(Generator.generateTurnSquareWithWall());
			mgr.close();
			
			System.out.println("Component List");
			for(int i1 = 0; i1 < Generator.getTree().getComponents().size(); i1++)
			{
				System.out.println(Generator.getTree().getComponents().get(i1).toString());
			}
			
			Generator.getTree().buildTree();
			Node root = Generator.getTree().getRoot();
			trees.add(root);
			System.out.println("Deepest Node: " + TreeManager.findDeepestDFS(root));
			//printTree(root);
			
			for(int i1 = 0; i1 < 20; i1++)
			{
				System.out.println(TreeRandomizer.randomize(root).toString());
			}
			
		} 
		catch (IOException e) 
		{
			System.out.println("IOException");
			System.out.println(e);
		}	
	}
	
	/**
	 * Uses DFS to print tree
	 * @param root
	 */
	private static void printTree(Node root)
	{
		Stack<Node> stack = new Stack<Node>();
		stack.add(root);
		while(!stack.isEmpty())
		{
			Node x = stack.pop();
			if(x.getNodeA() != null && !x.isHit())
			{
				System.out.println(x.getNodeA());
				stack.add(x.getNodeA());
			}
			if(x.getNodeB() != null && !x.isHit())
			{
				System.out.println(x.getNodeB());
				stack.add(x.getNodeB());
			}
			x.hit();
		}
	}
}
