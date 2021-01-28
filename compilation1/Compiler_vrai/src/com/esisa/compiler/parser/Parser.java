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
	private String error;
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
	public String getResult(boolean result) {
		
		if (result) {
			next();
			if(getToken() == Scanner.EOF) {
				error="";
				return "syntax just";
			}
			else {
				error= "Error : Expected End Of File at [" + getToken().getValue() + "]";
				result=false;
			}
		}
		else {
			if(getToken() == Scanner.EOF) {
				error="Error : Unexpected End Of File";
			}
			else {
				error="Error : Unexpected symbol [" + getToken().getValue() + "]";
			}
		}
		return "";
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
	
	public Scanner getScanner() {
		return scanner;
	}
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	public InputTape getInputTape() {
		return inputTape;
	}
	public void setInputTape(InputTape inputTape) {
		this.inputTape = inputTape;
	}
	public void setToken(Token token) {
		this.token = token;
	}

	public boolean isFlag() {
		return flag;
	}

	public void setFlag(boolean flag) {
		this.flag = flag;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}
}
