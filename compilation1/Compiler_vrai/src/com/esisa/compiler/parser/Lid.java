package com.esisa.compiler.parser;

import com.esisa.compiler.scanner.Scanner;

public class Lid extends Parser{
	public Lid() {
		// TODO Auto-generated constructor stub
	}
	
	 public Lid(Scanner scanner) {
		// TODO Auto-generated constructor stub$
		 super(scanner);
	}
	
	@Override
	public boolean axiom() {
		if(next(",")) {
			if(next("id")) {
				return (axiom());
			}
			return false;
		}
		//cas epsilon:!!
		undo();
		return true;
	}
	
}
