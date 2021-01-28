package com.esisa.compiler.parser;

import com.esisa.compiler.scanner.InputTape;

public class ParserTest {

	public ParserTest() {
		exp01();
	}
	
	void exp01() {
		InputTape e1 = new InputTape("int x, y, z;");
		InputTape e2 = new InputTape("int x, 2, z;");
		
		ExpressionParser parser = new ExpressionParser();
		boolean result = parser.par
		if (result) {
			System.out.println("Syntaxe juste");
		}
		else {
			System.out.println("Erreur de syntaxe");
		}
	}
	
	public static void main(String[] args) {
		new ParserTest();
	}

}
