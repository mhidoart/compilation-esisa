package com.esisa.compiler.scanner;

import java.util.Iterator;
import java.util.Vector;

public class Scanner {
	private Vector<DFA> A;   
	
	public Scanner() {
		A = new Vector<>();
	}
	
	public void add(DFA a) {
		A.add(a);
	}

	public void scan(String inputTape) { //ruban d'entrée!!
		for (DFA a : A) {
			a.extract(inputTape);
		}
	}
}
