package main;

import java.util.ArrayList;

public class Generator 
{	
	/****** Sensors/Threshold ******/
	private static final int[] sensors = {0, 1, 2, 3};
	
	private static int randomSensor()
	{
		return sensors[(int)(sensors.length * Math.random())];
	}
	
	private static int randomThreshold()
	{
		return (int)(255 * Math.random());
	}
	
	/****** Components ******/
	private static final ArrayList<String> components = componentsInit();
	
	private static ArrayList<String> componentsInit()
	{
		ArrayList<String> result = new ArrayList<String>();
		result.add("closeToWall()");
		result.add("farFromWall()");
		result.add("doTwoFarFar()");
		result.add("doTwoCloseClose()");
		result.add("doTwoFarClose()");
		result.add("doTwoCloseFar()");
		result.add("forward()");
		result.add("right()");
		result.add("left()");
		result.add("backup()");
		//result.add("turnParallelToPosition()");
		//result.add("turnSquareWithWall()");
		return result;
	}
	
	//ids
	public static int getId(String func)
	{
		switch(func)
		{
			case "main()":
			{
				return 0;
			}
			case "closeToWall()":
			{
				return 1;
			}
			case "farFromWall()":
			{
				return 2;
			}
			case "doTwoFarFar()":
			{
				return 3;
			}
			case "doTwoCloseClose()":
			{
				return 4;
			}
			case "doTwoFarClose()":
			{
				return 5;
			}
			case "doTwoCloseFar()":
			{
				return 6;
			}
			case "forward()":
			{
				return 7;
			}
			case "right()":
			{
				return 8;
			}
			case "left()":
			{
				return 9;
			}
			case "backup()":
			{
				return 10;
			}
		}
		return -1;
	}
	
	private static String randomComponent()
	{
		return components.get((int)(components.size() * Math.random()));
	}
	
	/****** Children Components ******/
	private static final ArrayList<String> childComponents = childComponentsInit();
	
	private static ArrayList<String> childComponentsInit()
	{
		ArrayList<String> result = new ArrayList<String>();
		result.add("forward()");
		result.add("right()");
		result.add("left()");
		result.add("backup()");
		return result;
	}

	public static String randomChildComponent()
	{
		return childComponents.get((int)(childComponents.size() * Math.random()));
	}
	
	/*private static ArrayList<Integer> idList = idListInit();
	
	private static ArrayList<Integer> idListInit()
	{
		ArrayList<Integer> result = new ArrayList<Integer>();
		for(int i1 = 0; i1 < 10; i1++)
		{
			result.add(i1);
		}
		return result;
	}*/
	
	/****** Generator ******/
	public static String generateMain()
	{
		//\ncloseToWall();\n farFromWall();\n doTwoFarFar();\n doTwoCloseClose();\n doTwoFarClose();\n doTwoCloseFar();\n
		String component = randomComponent();
		TreeManager.insert(new QueueObject("main()", getId("main()"), component, getId(component)));
		return "int score = 0;\n void main()\n { while(1) {" + component + "} }\n";
	}
	
	public static String generateCloseToWall()
	{
		String component = randomComponent();
		TreeManager.insert(new QueueObject("closeToWall()", getId("closeToWall()"), component, getId(component)));
		return "void closeToWall() { \nwhile(analog(" + randomSensor() + ") < " + randomThreshold() + ")\n" +
				"{" + component + ";} }\n";
	}
	
	public static String generateFarFromWall()
	{
		String component = randomComponent();
		TreeManager.insert(new QueueObject("farFromWall()", getId("farFromWall()"), component, getId(component)));
		return "void farFromWall() { \nwhile(analog(" + randomSensor() + ") > " + randomThreshold() + ")\n" +
				"{" + component + ";} }\n";
	}
	
	public static String generateDoTwoFarFar()
	{
		String component1 = randomComponent();
		//TreeManager.insert(new TreeNode(id++, component1));
		String component2 = randomComponent();
		TreeManager.insert(new QueueObject("doTwoFarFar()", getId("doTwoFarFar()"), component1, getId(component1), component2, getId(component2)));
		return "void doTwoFarFar() { \nwhile(analog(" + randomSensor() + ") > " + randomThreshold() + ")\n" +
				"{" + component1 + ";}\n" +
				"while(analog(" + randomSensor() + ") > " + randomThreshold() + ")\n" +
				"{" + component2 + ";} }\n";
	}
	
	public static String generateDoTwoCloseClose()
	{
		String component1 = randomComponent();
		//TreeManager.insert(new TreeNode(id++, component1));
		String component2 = randomComponent();
		TreeManager.insert(new QueueObject("doTwoCloseClose()", getId("doTwoCloseClose()"), component1, getId(component1), component2, getId(component2)));
		return "void doTwoCloseClose() { \nwhile(analog(" + randomSensor() + ") < " + randomThreshold() + ")\n" +
				"{" + component1 + ";}\n" +
				"while(analog(" + randomSensor() + ") < " + randomThreshold() + ")\n" +
				"{" + component2 + ";} }\n";
	}
	
	public static String generateDoTwoFarClose()
	{
		String component1 = randomComponent();
		//TreeManager.insert(new TreeNode(id++, component1));
		String component2 = randomComponent();
		TreeManager.insert(new QueueObject("doTwoFarClose()", getId("doTwoFarClose()"), component1, getId(component1), component2, getId(component2)));
		return "void doTwoFarClose() {\n" +
				"while(analog(" + randomSensor() + ") > " + randomThreshold() + ")\n" +
				"{" + component1 + ";}\n" +
				"while(analog(" + randomSensor() + ") < " + randomThreshold() + ")\n" +
				"{" + component2 + ";} }\n"; 
	}
	
	public static String generateDoTwoCloseFar()
	{
		String component1 = randomComponent();
		//TreeManager.insert(new TreeNode(id++, component1));
		String component2 = randomComponent();
		TreeManager.insert(new QueueObject("doTwoCloseFar()", getId("doTwoCloseFar()"), component1, getId(component1), component2, getId(component2)));
		return "void doTwoFarClose() {\n" +
				"while(analog(" + randomSensor() + ") < " + randomThreshold() + ")\n" +
				"{" + component1 + ";}\n" +
				"while(analog(" + randomSensor() + ") > " + randomThreshold() + ")\n" +
				"{" + component2 + ";} }\n"; 
	}
	
	public static String generateForward()
	{
		TreeManager.insert(new QueueObject("forward()", getId("forward()")));
		return "void forward() \n{ motor(0, 50); motor(3, 50); }\n";
	}
	
	public static String generateRight()
	{
		TreeManager.insert(new QueueObject("right()", getId("right()")));
		//75,-25
		return "void right() \n{ motor(0, 75); motor(3, -25); }\n";
	}
	
	public static String generateLeft()
	{
		TreeManager.insert(new QueueObject("left()", getId("left()")));
		//-25,75
		return "void left() \n{ motor(0, -25); motor(3, 75); }\n";
	}
	
	public static String generateBackup()
	{
		TreeManager.insert(new QueueObject("backup()", getId("backup()")));
		return "void backup() \n{ motor(0, -50); motor(3, -50); }\n";
	}
	
	/*public static String generateTurnParallelToPosition()
	{
		String component = randomComponent();
		TreeManager.insert(new TreeNode(id++, component));
		return "void turnParallelToPosition() \n{ backup();\n sleep(0.5);\n left();\n sleep(0.5);\n " + randomComponent() + "}";
	}
	
	public static String generateTurnSquareWithWall()
	{
		
	}*/
}
