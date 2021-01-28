package com.esisa.compiler.parser;

import com.esisa.compiler.scanner.InputTape;
import com.esisa.compiler.scanner.Scanner;
import com.esisa.compiler.scanner.Token;

/*
 * Dec -> type id Lid ;
 * Lid -> , id Lid | eps
 * 
 * Analyseur Descendant Récursif Avec Rebroussement (ADRR)
 * == Analyse par Descente Récursive (ADR)
 */
abstract public class Parser {

	private Scanner scanner;
	private InputTape inputTape;
	private Token token;
	private boolean flag = false;
	
	public Parser() {
		scanner = new Scanner();
	}
	
	public Parser(Scanner scanner2) {
		// TODO Auto-generated constructor stub
		this.scanner=scanner2;
	}

	public boolean parse(InputTape tape) {
		this.inputTape = tape;
		return Dec();
	}
	
	public boolean next(String terminal) {
		if(flag) {
			flag = false;
		}
		else {
			token = scanner.next(inputTape);
		}
		return (token.equals(terminal));
	}
	
	public void undo() {
		flag = true;
	}
	
	private boolean Dec() {
		if(next("type")) {
			if(next("id")) {
				if(Lid()) {
					return next(";");
				}
			}
		}
		return false;
	}
	
	private boolean Lid() {
		if(next(",")) {
			if(next("id")) {
				return Lid();
			}
			return false;
		}
		//Cas Epsilon:
		undo();
		return true;
	}

	abstract boolean axiom();

}
