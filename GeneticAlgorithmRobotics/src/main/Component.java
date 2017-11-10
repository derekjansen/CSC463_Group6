package main;

public class Component 
{
	private String function;
	private int functionId;
	private String randomComponent1;
	private int c1id;
	private String randomComponent2;
	private int c2id;
	
	public Component(String function, int functionId)
	{
		this.function = function;
		this.functionId = functionId;
		this.randomComponent1 = null;
		this.c1id = -1;
		this.randomComponent2 = null;
		this.c2id = -1;
	}
	
	public Component(String function, int functionId, String rc1, int c1id)
	{
		this.function = function;
		this.functionId = functionId;
		this.randomComponent1 = rc1;
		this.c1id = c1id;
		this.randomComponent2 = null;
		this.c2id = -1;
	}
	
	public Component(String function, int functionId, String rc1, int c1id, String rc2, int c2id)
	{
		this.function = function;
		this.functionId = functionId;
		this.randomComponent1 = rc1;
		this.c1id = c1id;
		this.randomComponent2 = rc2;
		this.c2id = c2id;
	}

	public String getFunction() 
	{
		return function;
	}

	public void setFunction(String function) 
	{
		this.function = function;
	}

	public int getFunctionId() 
	{
		return functionId;
	}

	public void setFunctionId(int functionId) 
	{
		this.functionId = functionId;
	}

	public String getRandomComponent1()
	{
		return randomComponent1;
	}

	public void setRandomComponent1(String randomComponent1)
	{
		this.randomComponent1 = randomComponent1;
	}

	public int getC1id() 
	{
		return c1id;
	}

	public void setC1id(int c1id) 
	{
		this.c1id = c1id;
	}

	public String getRandomComponent2() 
	{
		return randomComponent2;
	}

	public void setRandomComponent2(String randomComponent2) 
	{
		this.randomComponent2 = randomComponent2;
	}

	public int getC2id() 
	{
		return c2id;
	}

	public void setC2id(int c2id) 
	{
		this.c2id = c2id;
	}
	
	public String toString()
	{
		String components;
		if(this.randomComponent2 != null)
		{	
			components = " " + this.c1id + this.randomComponent1 + "\n " + this.c2id + this.randomComponent2;
		}
		else if(this.randomComponent1 != null)
		{
			components = " " + this.c1id + this.randomComponent1;
		}
		else
		{
			components = "";
		}
		return this.functionId + this.function + "\n" + components;
	}
}
