package com.esisa.compiler.scanner;

import java.util.Vector;

import com.esisa.compiler.scanner.dfa.Blank;
import com.esisa.compiler.scanner.dfa.Identifier;
import com.esisa.compiler.scanner.dfa.LitteralString;
import com.esisa.compiler.scanner.dfa.Number;
import com.esisa.compiler.scanner.dfa.Operator;
import com.esisa.compiler.scanner.dfa.Oprel;
import com.esisa.compiler.scanner.dfa.Separaator;
import com.esisa.compiler.scanner.dfa.Tel;

import javafx.scene.control.Separator;

public class Scanner {	
	public static final Token EOF = new Token("$", "$");
	
	private Vector<DFA> A; // vecteur d'automates
	private Vector<Error> errorList;
	private Error error; // l erreur actuelle;
	private Vector<Token> tokenList;
	private Vector<ReservedWords> reservedwords;


	public Scanner()
	{
		A=new Vector<>();
		errorList= new Vector<>();
		tokenList= new Vector<>();
		reservedwords= new Vector<>();
		
		add(new Identifier());
		add(new Number());
		add(new Oprel());
		add(new Tel());
		add(new LitteralString());
		add(new Blank());
		add(new Separaator());
		add(new Operator());
		
		addReservedWords("type", "byte", "short", "int", "float", "double" ,"char", "boolean");
		addReservedWords("modifiers", "private", "public", "protected", "static", "final" ,"synchronized");
	}

	public void add(DFA a){
		A.add(a);
	}
	
	public void addReservedWords(ReservedWords list) {
		this.reservedwords.add(list);
	}
	
	public void addReservedWords(String nom, String...words) {
		this.reservedwords.add(new ReservedWords(nom, words));
	}
	
	public void scanReservedWord(Token token) {
		for (ReservedWords rw : reservedwords) {
			if(rw.contains(token.getValue())) {
				token.setLexicalUnit(rw.getNom());
			}
		}
	}
	
	public Token next(InputTape inputTape){	 //ruban d'entree
		if(inputTape.eof()) {
			return EOF;
		}
		for (DFA a : A) //token prochain
		{
			Token t=a.extract(inputTape);
			if(t != null){	
				if (t.getLexicalUnit().equals("blank")) { //eliminer le cas d'espace!!! 
					if (!inputTape.eof()) {
						return next(inputTape);
					}
					else {
						return null;
					}
				}
				else {
					if (t.getLexicalUnit().equals("id")) {
						scanReservedWord(t);
					}
					tokenList.add(t);
					return t;
				}	
			}	
		}
		error = new Error(errorList.size() + 1 , ErrorType.LEXICAL, inputTape.cuurent(),inputTape.getReadHead() );
		errorList.add(error);
		inputTape.Next();
		return null; //erreur lexicale
	}
	
	public void scan(InputTape inputTape)
	{
		errorList.clear();
		tokenList.clear();
		while(!inputTape.eof())  next(inputTape);
	}
	
	public void scan(String text)
	{
		scan(new InputTape(text));
	}
	
	public Vector<Error> getErrorList() {
		return errorList;
	}
	
	public Error getError() {
		return error;
	}
	
	public Vector<Token> getTokenList() {
		return tokenList;
	}

}
