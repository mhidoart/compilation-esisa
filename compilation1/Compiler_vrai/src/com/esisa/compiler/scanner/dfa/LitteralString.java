package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class LitteralString extends DFA{

	public LitteralString() 
	{
		this("String");
	}
	public LitteralString(String name)
	{
		super(name, 4, 2);
		
		add(0,1,'\"');
		add(1,2,'\"'); 
		add(1,3,'\\');
		add(3, 1, 1 ,255);
		
		add(1, 1, 1 , '\"' - 1);
		add(1, 1, '\"' + 1 , '\\' - 1);
		add(1, 1, '\\' + 1 ,255);
	}
	

}
