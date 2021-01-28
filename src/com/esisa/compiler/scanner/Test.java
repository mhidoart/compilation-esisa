package com.esisa.compiler.scanner;

public class Test {

	public Test() {
		exp03();
	}

	void exp01()
	{
		DFA id = new DFA(2, 1); //2 etats
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
		DFA nb = new DFA(4 ,3, 1); //automate avec 4 etats ;;avec les etats accepteurs
		nb.add(0, 1, '0', '9');
		nb.add(0, 2, '.');
		nb.add(1, 1, '0', '9');
		nb.add(1, 3, '.');
		nb.add(2, 3, '0', '9');
		nb.add(3, 3, '0', '9');
	}
	void exp03()
	{
		DFA oprel = new DFA(4, 1, 2); 
		oprel.add(0, 1, "<>");
		oprel.add(0, 3, "!=");
		oprel.add(1, 2, '=');
		oprel.add(3, 2, '=');
	}
	
	public static void main(String[] args) {
		new Test();

	}

}
