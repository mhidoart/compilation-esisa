package com.esisa.compiler.parser;

import com.esisa.compiler.scanner.Scanner;

/*
 * Dec -> type id(beta) Lid;
 * Lid -> , id Lid(alpha) | eps
 * 

 */

public class ExampleParser extends Parser {
	
	public ExampleParser() {
		
	}
	
	public ExampleParser(Scanner scanner) {
		super(scanner);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean axiom() {
		return Dec();
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
				return (Lid());
			}
			return false;
		}
		//cas epsilon:!!
		undo();
		return true;
	}
	

	
	
}
