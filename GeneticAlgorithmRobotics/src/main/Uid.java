package main;

public class Uid 
{
	private static int uid = 0;
	
	public static int newUid()
	{
		uid = uid + 1;
		return uid;
	}
}
