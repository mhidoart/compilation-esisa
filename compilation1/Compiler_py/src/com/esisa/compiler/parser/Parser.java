package com.esisa.compiler.parser;

import com.esisa.compiler.scanner.InputTape;
import com.esisa.compiler.scanner.Scanner;
import com.esisa.compiler.scanner.Token;
/*
 * Dec->type id Lid;
 * Lid-> , id Lid | eps
 * Analyseur Descendent Recursif avec Rembourssement(ADRR)
 * == Analyse par descente Recursive(ADR)
 * associe a achaque nom terminal une boolean
 * la partie droite de chaque regle constituera le corps a identifier dans  la fonction
 */
public class Parser {

	private Scanner scanner;
	private InputTape inputTape;
	private Token token ;
	private boolean flag=false;
	
	public Parser() {
		scanner= new Scanner();
	}
	public Parser(Scanner scanner2) {
		// TODO Auto-generated constructor stub
		this.scanner=scanner2;
	}
	public boolean parse(InputTape tape)
	{
		this.inputTape=tape;
		return Dec();
		
	}
	public boolean next(String terminal)
	{
		if(flag)
		{
			flag=false;
		}
		else
		{
		 token = scanner.next(inputTape);
		}
		 return token.equals( terminal);

		
	}
	 
    public void undo() {
    	flag = true;
    }
	public boolean Dec()
	{
		if(next("type"))
		{
			if ( next("id"))
			{
				if(Lid())
				{
					return next(";");
				}
			}
		}
		return false;
	}
	public boolean Lid()
	{

		if(next(","))
		{
			if ( next("id"))
			{
				return Lid();
			}
			else
			{
				return false;
			}
		}
		//cas eps
		undo();
		return true;
	}
	public Scanner getScanner() {
		return scanner;
	}
	public boolean is(String terminal) {
    	if (token.getLexicalUnit().equals(terminal)) return true;
    	if (token.getValue().equals(terminal)) return true;
    	return false;
    }
}
