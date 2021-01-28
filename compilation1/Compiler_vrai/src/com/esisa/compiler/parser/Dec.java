package com.esisa.compiler.parser;

public class Dec extends Parser{
	private Lid lid;
	public Dec() {
		// TODO Auto-generated constructor stub
	}
		public Dec(Lid lid) {
			// TODO Auto-generated constructor stub
			super(lid.getScanner());
			this.lid=lid;
		}
		@Override
		public boolean axiom() {
			if(next("type")) {
				if(next("id")) {
					if(lid.parse(getInputTape())) {
						setToken(lid.getToken());
						return next(";");
					}
				}
				setToken(lid.getToken());
			}
			return false;
		}
		
}
