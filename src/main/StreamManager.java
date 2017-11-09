package main;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamManager
{
	private FileOutputStream writer;
	private String filePath;
	
	public StreamManager(String filePath) throws FileNotFoundException
	{
		this.writer = new FileOutputStream(filePath, true);
		this.filePath = filePath;
	}
	
	public void append(String text) throws IOException
	{
		writer.write(text.getBytes("UTF-8"));
	}
	
	public void close() throws IOException
	{
		this.writer.close();
	}
	
	public void clear() throws IOException
	{
		this.writer = new FileOutputStream(this.filePath, false);
		writer.write(new String().getBytes());
		this.writer = new FileOutputStream(this.filePath, true);
	}
}
