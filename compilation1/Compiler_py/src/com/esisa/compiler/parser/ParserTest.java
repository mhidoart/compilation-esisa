package com.esisa.compiler.parser;

import com.esisa.compiler.scanner.InputTape;

public class ParserTest {

	public ParserTest() {
		// TODO Auto-generated constructor stub
		exp01();
	}
	void exp01()
	{
		InputTape e1= new InputTape("int x,y,z;");
		InputTape e2= new InputTape("int x,2,z;");

		Parser parser= new Parser();
		boolean result = parser.parse(e2);
		if (result)
		{
			System.out.println("Syntaxe Juste");
		}
		else
		{
			System.out.println("Errorrrrrr a bandem ");
		}
	}
	public static void main(String[] args) {
		new ParserTest();
	}

}
