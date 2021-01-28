package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Mail extends DFA {
	public Mail(String name) {
		super("Mail",4 ,2,3);

		add(0, 0, 'a','z');
		add(0, 0, 'A', 'Z');
		add(0, 0, '.');
		add(0, 0, '-');
		add(0, 0, '_');


		add(0, 1, '@');

		add(1, 1, 'a','z');
		add(1, 1, 'A', 'Z');

		add(1, 2, '.');

		add(2, 2, 'a','z');
		add(2, 2, 'A', 'Z');
		add(2, 2, '.');

		add(2, 3, '.');

		add(3, 3, 'a','z');
		add(3, 3, 'A', 'Z');


	}
	public Mail() {
		this("Mail");
	}


}
