package com.esisa.compiler.parser;

public class AssignmentParser extends Parser{
	private ExpressionParser E;
	public AssignmentParser() {
		// TODO Auto-generated constructor stub
	}
	public AssignmentParser(ExpressionParser E) {
		super(E.getScanner());
		this.E=E;
	}
	public boolean axiom() {
		return A();
	}
	public boolean A() {
		if(next("id")) {
			if(next("=")) {
				if(E.axi)
			}
		}
	}
}
