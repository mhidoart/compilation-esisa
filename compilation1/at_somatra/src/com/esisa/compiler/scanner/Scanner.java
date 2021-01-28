package com.esisa.compiler.scanner;


import java.util.Vector;

import com.esisa.compiler.scanner.dfa.Blank;
import com.esisa.compiler.scanner.dfa.Identifier;
import com.esisa.compiler.scanner.dfa.LitteralString;
import com.esisa.compiler.scanner.dfa.Mail;
import com.esisa.compiler.scanner.dfa.Number;
import com.esisa.compiler.scanner.dfa.Oparth;
import com.esisa.compiler.scanner.dfa.Oprel;
import com.esisa.compiler.scanner.dfa.Separator;

public class Scanner {
	private Vector<DFA> A;   
	private Vector<Error> errorList;
	private Error error;
	private Vector<Token> tokenlist;

	public Scanner() {
		A = new Vector<>();
		errorList=new Vector<>();
		tokenlist=new Vector<>();
		//add(new Identifier());
		add(new Number());
		add(new Oprel());
		/// thats me
		add(new Oparth());
		add(new Blank());
		add(new LitteralString());
		add(new Separator());
		add(new Mail());
	}

	public void add(DFA a) {
		A.add(a);
	}

	public Token next(InputTape inputTape) { //ruban d'entrée!!
		for (DFA a : A) {
			Token t=	a.extract(inputTape);
			if(t!= null) {
				if(t.getLexicalUnit().equals("Blank")) {
					if(!inputTape.eof())
					{
						return next(inputTape);
					}
					else
					{
						return null;
					}
					
				}
				else
				{
					tokenlist.add(t);
				}
				



				return t;
			}
		}
		error=new Error(errorList.size()+1,ErrorType.LEXICAL,inputTape.current(),inputTape.getReadhead());
		errorList.add(error);
		inputTape.next();
		return null;
	}
	public void scan(InputTape inputtape) {
		errorList.clear();
		tokenlist.clear();
		while(!inputtape.eof()) next(inputtape);

	}
	public void scan(String text)
	{
		scan(new InputTape(text));
	}
	public Error getError() {
		return error;
	}
	public Vector<Error> getErrorList() {
		return errorList;
	}
	public Vector<Token> getTokenlist() {
		return tokenlist;
	}
}
