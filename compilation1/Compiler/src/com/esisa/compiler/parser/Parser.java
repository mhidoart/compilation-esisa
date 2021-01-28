package com.esisa.compiler.parser;

import com.esisa.compiler.scanner.InputTape;
import com.esisa.compiler.scanner.Scanner;
import com.esisa.compiler.scanner.Token;
/*
* Analyseur descendant récursif avec rebroussement(ADRR)
* == analyseur par descente recursive(ADR)
*/

abstract public class Parser {
	private Scanner scanner;
	private InputTape inputTape;
	private Token token;
	private boolean flag = false;

	public Parser() {
		scanner = new Scanner();
	}
	
	public Parser(Scanner scanner) {
		super();
		this.scanner = scanner;
	}

	public boolean parse(InputTape tape) {
		this.inputTape = tape;
		return axiom();
	}
	//$******************************************
	abstract public boolean axiom();
	
	//avancer et comparer!!
	public boolean next(String terminal) {
		next();
		return (token.equals(terminal));
	}
	
	//avancer sans comparer!!
	public void next() {
		if(flag) {
			flag = false;
		}
		else {
			token = scanner.next(inputTape);
			System.out.println(" - " + token);
		}
	}
	
	//comparer le dernier token déjà lu avec next!!
	public boolean is(String terminal) {
		return (token.equals(terminal));
    }
	
	public void undo() {
		flag = true;
	}
	
	public Token getToken() {
		return token;
	}
}
