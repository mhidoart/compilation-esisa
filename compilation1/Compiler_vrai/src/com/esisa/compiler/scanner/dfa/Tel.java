package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Tel extends DFA{

	public Tel() {
		this("Telephone");
	}
	
	public Tel(String name) {
		super(name,19,18);
		add(0,1,"+");
		add(1,2,'2');
		add(2,3,'1');
		add(3,4,'2');
		add(4,5,'"');
		add(5,6,'0','9');
		add(6,7,"|");
		add(7,8,'0','9');
		add(8,9,'0','9');
		add(9,10,"|");
		add(10,11,'0','9');
		add(11,12,'0','9');
		add(12,13,"|");
		add(13,14,'0','9');
		add(14,15,'0','9');
		add(15,16,"|");
		add(16,17,'0','9');
		add(17,18,'0','9');
	}
}
