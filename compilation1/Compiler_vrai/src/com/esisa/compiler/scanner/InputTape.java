package com.esisa.compiler.scanner;

public class InputTape
{
	private String buffer;
	private int readHead=0;
	private int start=0;
	public InputTape(String buffer) 
	{
		super();
		this.buffer = buffer;
		
	}
	public void mark()
	{
		start=readHead;
	}
	public char cuurent()
	{
		return buffer.charAt(readHead);
	}
	public char Next()
	{
		readHead++;
		if(eof()) return 0;
		return buffer.charAt(readHead);
	}
	public String getToken()
	{
		return buffer.substring(start, readHead);
	}
	public void reset()
	{
		readHead=start;
	}
	public boolean eof()
	{
		return readHead>= buffer.length();
		
	}
	public int getReadHead() {
		return readHead;
	}
}
