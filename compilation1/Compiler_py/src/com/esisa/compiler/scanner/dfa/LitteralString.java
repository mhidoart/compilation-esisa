package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class LitteralString extends DFA
{
// " = 34
// \ = 92  code ascii
	public LitteralString() 
	{
		this("Chaine Litterale");
		// TODO Auto-generated constructor stub
	}
	public LitteralString(String name)
	{
		super(name,4,2);
		add(0,1,'\"'); //char
		add(1,2,'\"');//transition de 0 sur les lettres 
		add(1,3,'\\');
		add(3,1,1,255);
		add(1,1,1,'\"'-1 ); // tte les car sauf " et \
		add(1,1,'\"'+1,'\\' -1 ); // tte les car sauf " et \
		add(1,1,'\\' +1,255 ); // tte les car sauf " et \


	}

}
