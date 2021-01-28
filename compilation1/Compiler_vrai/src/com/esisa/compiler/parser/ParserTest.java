package com.esisa.compiler.parser;

import com.esisa.compiler.scanner.InputTape;
import com.esisa.compiler.scanner.Scanner;

public class ParserTest {

	public ParserTest() {
		exp04();
	}

	void exp01() {
		InputTape e1 = new InputTape("int x, y, z;");
		InputTape e2 = new InputTape("int x, 2, z;");


		ExampleParser parser = new ExampleParser();
		boolean result = parser.parse(e1);
		if (result) {
			System.out.println("Syntaxe juste");
		}
		else {
			System.out.println("Erreur de syntaxe");
		}
	}

	void exp02() {
		InputTape e1 = new InputTape("2 + 3 * x / (1 + a) + (5 - x) * 3");
		InputTape e2 = new InputTape("2 + 3 * x / (1 + a) + (5 - x * 3");
		InputTape e3 = new InputTape("2 + 3 * x / ;1 + a) + 5 - x) * 3");
		InputTape e4 = new InputTape("x=2+3;");


		ExpressionParser parser = new ExpressionParser();
		boolean result = parser.parse(e2);
		if (result) {
			if(parser.getToken() == Scanner.EOF) {
				System.out.println("Syntaxe juste");
			}
			else {
				System.out.println("Error : Expected End Of File at [" + parser.getToken().getValue() + "]");
			}
		}
		else {
			if(parser.getToken() == Scanner.EOF) {
				System.out.println("Error : Unexpected End Of File");
			}
			else {
				System.out.println("Error : Unexpected symbol [" + parser.getToken().getValue() + "]");
			}
		}
	}

	void exp03() {
		InputTape e4 = new InputTape("z=2 + 3 * x / (1 + a) + (5 - x) * 3;");


		AssignmentParser parser =  new AssignmentParser(new ExpressionParser());
		boolean result = parser.parse(e4);
		if (result) {
			parser.next();
			if(parser.getToken() == Scanner.EOF) {
				System.out.println("Syntaxe juste");
			}
			else {
				System.out.println("Error : Expected End Of File at [" + parser.getToken().getValue() + "]");
			}
		}
		else {
			if(parser.getToken() == Scanner.EOF) {
				System.out.println("Error : Unexpected End Of File");
			}
			else {
				System.out.println("Error : Unexpected symbol [" + parser.getToken().getValue() + "]");
			}
		}
	}
	void exp04() {

		InputTape e4 = new InputTape("int x,y,z;");


		Dec parser =  new Dec(new Lid());
		boolean result = parser.parse(e4);
		String msg=parser.getResult(result);
		
		System.out.println(msg +parser.getError());
	}
	public static void main(String[] args) {
		new ParserTest();
	}
}
