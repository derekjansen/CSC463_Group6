package main;

import java.io.IOException;

/**
 * Runner Class For Genetic Algorithm
 * @author Jake Moore
 */
public class Runnable 
{
	public static void main(String[] args)
	{
		try 
		{
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
			mgr.close();
			
			for(int i1 = 0; i1 < TreeManager.getQueue().size(); i1++)
			{
				System.out.println(TreeManager.getQueue().get(i1).toString());
			}
			
			TreeManager.buildTree();
			Node root = TreeManager.getRoot();
			while(root.getNodeA() != null)
			{
				Node nodeA = root.getNodeA();
				Node nodeB = root.getNodeB();
				if(nodeA != null)
				{
					System.out.println(nodeA.toString());
				}
				if(nodeB != null)
				{
					System.out.println(nodeB.toString());
				}
				root = root.getNodeA();
			}
		} 
		catch (IOException e) 
		{
			System.out.println("IOException");
			System.out.println(e);
		}	
	}
}
