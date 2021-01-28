package com.esisa.compilation.parser;

import com.esisa.compilation.scanner.Scanner;
import com.esisa.compilation.scanner.Token;

public class Example1Parser extends Parser {
	
/*
 * Analyseur Descendant Récursif avec rebroussement (ADRAR)
 */
/*
 * F -> type id (P){ }
 * P -> type id S | eps
 * S -> , type id S | eps
 */
	
	
	public Example1Parser(Scanner scanner) {
		super(scanner);
	}
	
	
	public boolean parse(){
		return F();
	}
	
	private boolean F() {
		if(sequence("type","id","(")==3) {
					if(P()) {
						if(sequence(")","{","}")==3) {
									return true;
								}
							}
						}	

		         return false;
	}
	
    private boolean P() {
		int s = sequence("type","id");
		if(s == 2) {
			return S();
		}
		if (s == 0) {
			undo();
		    return true;
		}
		
		return false;
	}
	
    private boolean S() {
    	int s = sequence(",","type","id");
		if(s == 3) {
			return S();
		}
		if(s == 0) {
			undo();
			return true;
		}
		return false;
    }
    
   
}
