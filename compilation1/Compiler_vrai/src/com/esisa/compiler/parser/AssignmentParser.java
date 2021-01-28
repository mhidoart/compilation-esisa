package com.esisa.compiler.parser;

/*
 * A -> id = E;
 * 
 */
public class AssignmentParser extends Parser {
	private ExpressionParser E;
	
	public AssignmentParser() {
		
	}

	
	public AssignmentParser(ExpressionParser E) {
		super(E.getScanner());
		this.E = E;
	}


	@Override
	public boolean axiom() {
		return A();
	}
	
	public boolean A() {
		if(next("id")) {
			if(next("=")) {
				if(E.parse(getInputTape())) {
					System.out.println("----------------s");
					setToken(E.getToken());
					return (is(";"));
				}
				else {
					setToken(E.getToken());
				}
			}
		}
		return false;
	}
	
}
