package com.esisa.compiler.scanner;

import java.util.Vector;

public class Test {

	public Test() {
		exp05();
	}

	void exp01()
	{
		DFA id = new DFA("id",2, 1); //2 etats
		id.add(0 , 1, 'a', 'z');
		id.add(0 , 1, 'A', 'Z');//lettres
		id.add(0 , 1, '_');

		id.add(1 , 1, 'a', 'z');
		id.add(1 , 1, 'A', 'Z');
		id.add(1 , 1, '_');

		id.add(1 , 1, '0', '9');
	}

	void exp02()
	{
		DFA nb = new DFA("nb",4 ,3, 1); //automate avec 4 etats ;;avec les etats accepteurs
		nb.add(0, 1, '0', '9');
		nb.add(0, 2, '.');
		nb.add(1, 1, '0', '9');
		nb.add(1, 3, '.');
		nb.add(2, 3, '0', '9');
		nb.add(3, 3, '0', '9');
	}
	void exp03()
	{
		DFA oprel = new DFA("oprel",4, 1, 2); 
		oprel.add(0, 1, "<>");
		oprel.add(0, 3, "!=");
		oprel.add(1, 2, '=');
		oprel.add(3, 2, '=');
	}
	void exp04() {
		String s1="a01 = 20 * alpha + beta / 3.14;";
		String s2="3.14 > alpha";
		String s3="<=10";
		Scanner scanner=new Scanner();
		InputTape it =new InputTape(s1);
		while(!it.eof()) {
			Token t=scanner.next(it);
			if(t!= null)System.out.println(t);

		}

	}
	void exp05() {
		Scanner scanner=new Scanner();
		String s1="a01 = 20 * alpha + beta / 3.14;";
		InputTape it =new InputTape(s1);
		while(!it.eof()) scanner.next(it);
			Vector<Error> errorlist=scanner.getErrorList();
			Vector<Token> tokens= scanner.getTokenlist();
			System.out.println("Unite Lexicales : ");
			for(Token token:tokens)
			{
				System.out.println(token);
			}
			System.out.println("erreurs Lexicales : ");
			for(Error error : errorlist)
			{
				System.out.println(error.getMessage());
			}

		

	}
	public static void main(String[] args) {
		new Test();

	}

}
