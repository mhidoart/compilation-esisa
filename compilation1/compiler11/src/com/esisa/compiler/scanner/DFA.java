package com.esisa.compiler.scanner;



public class DFA {
	private String name;
	private int T[][];
	private boolean E[]; //etats!!
	
	public DFA(String name,int statesCount, int...accepting) {
		/////////transition
		this.name=name;
		T = new int [statesCount][256];
		for (int i = 0; i < T.length; i++) { //etat
			for (int j = 0; j < 256; j++) { //caract
				T[i][j] = -1;
			}
		}
		
		E = new boolean[statesCount];
		for (int i = 0; i < E.length; i++) { //indice c'est l'etat
			E[i] = false;
		}
		///pointée les etats accepteurs un par un !!!
		for (int i = 0; i < accepting.length; i++) { //indice num d'etats
			E[accepting[i]] = true;
			
		}
	}
	
	public void add(int e1, int e2, int s) {
		T[e1][s] = e2;
	}
	
	public void add(int e1, int e2, int min, int max) {
		for (int s = min; s <=max; s++) {
			T[e1][s] = e2;
		}
	}
	
	public void add(int e1, int e2, String set) {
		for (int i = 0; i < set.length(); i++) { //i indice du caract
			T[e1][set.charAt(i)] = e2;
		}
	}
	
	public int get(int e, int s) {
		return T[e][s];
	}
	
	public boolean isAccepting(int e) {
		return E[e];
	}
	
	public Token extract(InputTape inputTape) { 
		int e = 0;
		inputTape.mark();
		
		char s=inputTape.current();
		while(T[e][s]!=-1) {
			e=T[e][s];
			s=inputTape.next();
		}
		if(isAccepting(e)) {
			String value=inputTape.getToken();//deja cette fonction s'arret a readhead-1
			Token t =new Token(value,name);
			return t;
		}
		inputTape.reset();
		return null;
	}
}
