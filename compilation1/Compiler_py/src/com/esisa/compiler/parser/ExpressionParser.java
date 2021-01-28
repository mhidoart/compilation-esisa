package com.esisa.compiler.parser;

import com.esisa.compiler.scanner.Scanner;


public class ExpressionParser extends Parser{

	private Error error;
	
	public ExpressionParser()
	{
		
	}
	
	public ExpressionParser(Scanner scanner)
	{
		super(scanner);
	}
	
	
	public boolean parse() 
	{
		error = null;
		if(E()) 
		{
			if(getToken() == Scanner.EOT)
			{
			System.out.println("Syntaxe Juste "); 
			return true;
			}
			else
			{
				error = new Error(
						100,
						"syntaxique",
						0,  //position
						getToken().getValue(),
						"Fin de tampon attendue"
						
						);
				System.out.println("Erreur syntaxique ; Fin de tampon attendue : "
						+getToken().getValue());
				return false;
			}
		}
		else {
			if(getToken() == Scanner.EOT)
			{
			System.out.println("Errerur de syntaxe ; Symbole inattendu ; Fin de tampon inattendue"); 
			}
			else
			System.out.println("Errerur de syntaxe ; Symbole inattendue : "
					+getToken().getValue());
		}
		return false;
		
	}

	public Error getError() {
		return error;
	}

	private boolean E()
	{
		if(T()) return E1();
		return false;
	}
	
	private boolean E1()
	{
		next();
		if(is("+") || is("-"))
		{
			if(T()) return E1();
			return false;
		}
		undo();
		return true;
	}
	
	private boolean T()
	{
		if(F()) return T1();
		return false;
	}
	
	private boolean T1()
	{
		next();
		if(is("*") || is("/"))
		{
			if(F()) return T1();
			return false;
		}
		undo();
		return true;
	}
	
	private boolean F()
	{
		next();
		if(is("("))
		{
			if(E())
			{
				next();
				return is(")");
			}
		}
		else if(is("id") || is("nb"))
		{
			return true;
		}
		
	    return false;
		
	}


}
