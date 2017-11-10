package main;

import java.util.ArrayList;
import java.util.Random;

public class Generator 
{	
	/****** Sensors/Threshold ******/
	private static final int[] sensors = {0, 1, 2, 3};
	
	//picks a random sensor
	private static int randomSensor()
	{
		return sensors[(int)(sensors.length * Math.random() - 1)];
	}
	
	//picks a random threshold
	private static int randomThreshold()
	{
		return (int)(255 * Math.random());
	}
	
	/****** Components ******/
	private static final ArrayList<String> components = componentsInit();
	
	//initializes component
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
		result.add("turnParallelToPosition()");
		result.add("turnSquareWithWall()");
		return result;
	}
	
	//ids
	private static int getId(String func)
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
			case "turnParallelToPosition()":
			{
				return 11;
			}
			case "turnSquareWithWall()":
			{
				return 12;
			}
		}
		return -1;
	}
	
	//random component
	private static String randomComponent()
	{
		return components.get((int)(components.size() * Math.random() - 1));
	}
	
	/****** Children Components ******/
	private static final ArrayList<String> childComponents = childComponentsInit();
	
	//init child component
	private static ArrayList<String> childComponentsInit()
	{
		ArrayList<String> result = new ArrayList<String>();
		result.add("forward()");
		result.add("right()");
		result.add("left()");
		result.add("backup()");
		return result;
	}
	
	/****** Parent Components ******/
	private static final ArrayList<String> parentComponents = parentComponentsInit();
	
	//init parent component
	private static ArrayList<String> parentComponentsInit()
	{
		ArrayList<String> result = new ArrayList<String>();
		result.add("closeToWall()");
		result.add("farFromWall()");
		result.add("doTwoFarFar()");
		result.add("doTwoCloseClose()");
		result.add("doTwoFarClose()");
		result.add("doTwoCloseFar()");
		return result;
	}

	//picks random child
	public static String randomChildComponent()
	{
		return childComponents.get((int)(childComponents.size() * Math.random() - 1));
	}
	
	//picks random parent
	private static String randomParentComponent()
	{
		return parentComponents.get((int)(parentComponents.size() * Math.random() - 1));
	}
	
	/****** Generator ******/
	private static TreeBuilder mgr = new TreeBuilder();
	
	//gets tree builder
	public static TreeBuilder getTree()
	{
		return mgr;
	}
	
	//creates new tree builder
	public static void resetTree()
	{
		mgr = new TreeBuilder();
	}
	
	//generates main
	public static String generateMain()
	{
		//\ncloseToWall();\n farFromWall();\n doTwoFarFar();\n doTwoCloseClose();\n doTwoFarClose();\n doTwoCloseFar();\n
		String component = randomParentComponent();
		mgr.insert(new Component("main()", getId("main()"), component, getId(component)));
		return "int score = 0;\n void main()\n { while(1) {" + component + "} }\n";
	}
	
	//generates close to wall
	public static String generateCloseToWall()
	{
		String component = randomComponent();
		mgr.insert(new Component("closeToWall()", getId("closeToWall()"), component, getId(component)));
		return "void closeToWall() { \nwhile(analog(" + randomSensor() + ") < " + randomThreshold() + ")\n" +
				"{" + component + ";} }\n";
	}
	
	//generates far from wall
	public static String generateFarFromWall()
	{
		String component = randomComponent();
		mgr.insert(new Component("farFromWall()", getId("farFromWall()"), component, getId(component)));
		return "void farFromWall() { \nwhile(analog(" + randomSensor() + ") > " + randomThreshold() + ")\n" +
				"{" + component + ";} }\n";
	}
	
	//generates doTwoFarFar
	public static String generateDoTwoFarFar()
	{
		String component1 = randomComponent();
		String component2 = randomComponent();
		mgr.insert(new Component("doTwoFarFar()", getId("doTwoFarFar()"), component1, getId(component1), component2, getId(component2)));
		return "void doTwoFarFar() { \nwhile(analog(" + randomSensor() + ") > " + randomThreshold() + ")\n" +
				"{" + component1 + ";}\n" +
				"while(analog(" + randomSensor() + ") > " + randomThreshold() + ")\n" +
				"{" + component2 + ";} }\n";
	}
	
	//generates doTwoCloseClose
	public static String generateDoTwoCloseClose()
	{
		String component1 = randomComponent();
		String component2 = randomComponent();
		mgr.insert(new Component("doTwoCloseClose()", getId("doTwoCloseClose()"), component1, getId(component1), component2, getId(component2)));
		return "void doTwoCloseClose() { \nwhile(analog(" + randomSensor() + ") < " + randomThreshold() + ")\n" +
				"{" + component1 + ";}\n" +
				"while(analog(" + randomSensor() + ") < " + randomThreshold() + ")\n" +
				"{" + component2 + ";} }\n";
	}
	
	//generatesDoTwoFarClose
	public static String generateDoTwoFarClose()
	{
		String component1 = randomComponent();
		String component2 = randomComponent();
		mgr.insert(new Component("doTwoFarClose()", getId("doTwoFarClose()"), component1, getId(component1), component2, getId(component2)));
		return "void doTwoFarClose() {\n" +
				"while(analog(" + randomSensor() + ") > " + randomThreshold() + ")\n" +
				"{" + component1 + ";}\n" +
				"while(analog(" + randomSensor() + ") < " + randomThreshold() + ")\n" +
				"{" + component2 + ";} }\n"; 
	}
	
	//generates doTwoCloseFar
	public static String generateDoTwoCloseFar()
	{
		String component1 = randomComponent();
		String component2 = randomComponent();
		mgr.insert(new Component("doTwoCloseFar()", getId("doTwoCloseFar()"), component1, getId(component1), component2, getId(component2)));
		return "void doTwoFarClose() {\n" +
				"while(analog(" + randomSensor() + ") < " + randomThreshold() + ")\n" +
				"{" + component1 + ";}\n" +
				"while(analog(" + randomSensor() + ") > " + randomThreshold() + ")\n" +
				"{" + component2 + ";} }\n"; 
	}
	
	//generates forward
	public static String generateForward()
	{
		mgr.insert(new Component("forward()", getId("forward()")));
		return "void forward() \n{ motor(0, 50); motor(3, 50); }\n";
	}
	
	//generates right
	public static String generateRight()
	{
		mgr.insert(new Component("right()", getId("right()")));
		//75,-25
		return "void right() \n{ motor(0, 75); motor(3, -25); }\n";
	}
	
	//generates left
	public static String generateLeft()
	{
		mgr.insert(new Component("left()", getId("left()")));
		//-25,75
		return "void left() \n{ motor(0, -25); motor(3, 75); }\n";
	}
	
	//generates backup
	public static String generateBackup()
	{
		mgr.insert(new Component("backup()", getId("backup()")));
		return "void backup() \n{ motor(0, -50); motor(3, -50); }\n";
	}
	
	//generates turnParallelToPosition
	public static String generateTurnParallelToPosition()
	{
		String component = randomComponent();
		//TreeManager.insert(new TreeNode(id++, component));
		mgr.insert(new Component("turnParallelToPostion()", getId("turnParallelToPosition()"), component, getId(component)));
		return "void turnParallelToPosition() \n{ backup();\n sleep(0.5);  left();\n sleep(0.5);\n " + component + "}";
	}
	
	//generates turnSquareWithWall
	public static String generateTurnSquareWithWall()
	{
		//change leftfront and rightfront
		mgr.insert(new Component("turnSquareWithWall()", getId("turnSquareWithWall()")));
		return "void turnSquareWithWall() \n { \n if(analog(leftFront) > analog(rightFront)) \n	{  \n while(analog(LeftFront) > analog(rightFront)) \n { \n turnRight(); \n	} \n } \n if(analog(rightFront) > analog(leftFront)) \n	{ \n while(analog(rightFront) > analog(leftFront)) \n { \n turnLeft(); \n } \n }}";
	}
}
