package com.esisa.compiler.scanner;

public class InputTape {
	private String buffer;
	private int readhead=0;
	private int start=0;
	public InputTape(String buffer) {
		super();
		this.buffer = buffer;
	}
	public void mark() {
		start=readhead;
	}
	public char current() {
		return buffer.charAt(readhead);
	}
	public char next() {
		readhead++;
		if(eof()) return 0;
		return buffer.charAt(readhead);
	}
	public String getToken() {
		return buffer.substring(start,readhead);
	}
	public void reset() {
		readhead=start;
	}
	public int getReadhead() {
		return readhead;
	}
	public boolean eof() {
		return (readhead >=buffer.length());
	}

}
