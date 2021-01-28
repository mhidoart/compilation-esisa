package com.esisa.compiler.parser;

import com.esisa.compiler.scanner.Scanner;
/*
 * E -> T E'
 * E' -> +T E' | -T E' | eps
 * T -> F T'
 * T' -> *F T' | /F T' | eps
 * F ->(E) | id | nb
 */
public class ExpressionParser extends Parser{

	public ExpressionParser() {
		
	}
	
	public ExpressionParser(Scanner scanner) {
		super(scanner);
	}

	@Override
	public boolean axiom() {
		return E();
	}

	private boolean E() {
		if(T()) return E1();
		return false;
	}
	
	private boolean E1() {
		next();
		if(is("+") || is("-")) {
			if (T()) return E1();
			return false;
		}
		undo();
		return true;
	}
	
	private boolean T() {
		if(F()) return T1();
		return false;
	}
	
	private boolean T1() {
		next();
		if(is("*") || is("/")){
			if(F()) return T1();
			return false;
		}
		undo();
		return true;
	}
	
	private boolean F() {
		next();
		if(is("id") || is("nb")) return true;
		if(is("(")) {
			if (E()) return next(")");
		}
	    return false;
	}
	
	
}
