package com.esisa.compiler.scanner;

import java.util.Vector;

public class Tests 
{
	public Tests() 
	{
		test();
	}
	
	void test() {
		System.out.println((int) '\"');
		System.out.println((int) '\\');
	}
	public void exp01()
	{
		DFA id= new DFA("id",2,1);
		id.add(0,1,'a','z');//transition de 0 sur les lettres 
		id.add(0,1,'A','Z');
		id.add(0,1,'_');
		id.add(1,1,'a','z');//transition de 0 sur les lettres 
		id.add(1,1,'A','Z');
		id.add(1,1,'_');
		id.add(1,1,'0','9');
	}

	public void exp02()
	{
		DFA nb= new DFA("nb",4,1,3);
		nb.add(0,1,'0','9');
		nb.add(0,2,'.');
		nb.add(1,1,'0','9');
		nb.add(1,3,'.');
		nb.add(2,3,'0','9');
		nb.add(3,3,'0','9');
	}
	public void exp03()
	{
		DFA oprel= new DFA("oprel",4,1,2);
		oprel.add(0,1, "<>");
		oprel.add(1, 2, '=');
		oprel.add(0, 3, "!=");
		oprel.add(3,2, '=');
	}
	public void exp04()
	{
		String s1="ao1=20 * 40 + alpha / 2;";
		String s2="3.14 > alpha;";
		String s3="<=10;";
		Scanner scanner = new Scanner();
		InputTape it= new InputTape(s2);
		while(!it.eof())
		{
			Token t = scanner.next(it);
			if(t!=null) System.out.println(t);
		}
	}
	public void exp05()
	{

		Scanner scanner = new Scanner();
		scanner.scan("ao1=20 * 40 + alpha / 2;");


		//if(t!=null) System.out.println(t);
		Vector<Token>  tokenList = scanner.getTokenList();
		Vector<Error>  errorList= scanner.getErrorList();
		System.out.println("Unites Lexicales : ");
		for (Token token : tokenList) 
		{
			System.out.println(token);
		}

		System.out.println("Erreurs Lexicales : ");
		for (Error error : errorList) 
		{
			System.out.println(error.getMessage());
		}

	}
	public void exp06()
	{
		
	}
	public static void main(String[] args)
	{
		new Tests();
	}
}
