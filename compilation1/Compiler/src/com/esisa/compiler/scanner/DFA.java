package com.esisa.compiler.scanner;

public class DFA 
{	private String name;
	private int T[][];
	private boolean E[]; //pour chaque E[i] on indique si  cest un etat accepteur ou pas

	public DFA(String name,int statesCount , int ...accepting) //256 colonnes et statesCount lignes + les etats accepteurs
	{
		this.name=name;
		T= new int[statesCount][256];
		//init du matrice
		for (int i = 0; i < T.length; i++) 
		{
			for (int j = 0; j < 256; j++)
			{
				T[i][j]=-1;
			}
		}
		//init ensembles des etats
		E=new boolean[statesCount];
		for (int i = 0; i < E.length; i++) 
		{
			E[i]=false;
		}
		for (int i = 0; i < accepting.length; i++) 
		{
			E[accepting[i]]=true; //init des etats accepteurs.
		}
	}

	public void add(int e1,int e2, int s) //symbole
	{
		T[e1][s]=e2;
	}
	public void add(int e1,int e2, int min , int max) // un intervalle
	{
		for (int s = min; s <= max; s++) 
		{
			T[e1][s]=e2;
		}
	}
	//la meilleure facon pour representer un ensemble de char cest un STRING
	//set[i] existe pas => charAt(i)
	public void add(int e1,int e2, String set)
	{
		for (int i = 0; i <set.length(); i++)
		{
			T[e1][set.charAt(i)]=e2; 
		}
	}
	public int get(int e ,int s)
	{
		return T[e][s];
	}
	public boolean isAccepting(int e)
	{
		return E[e];
	}
	public Token extract(InputTape inputTape)
	{
		int e=0; //etat initial
		inputTape.mark();
		char s=inputTape.cuurent();
		while(T[e][s]!= -1) //tq il existe une transition
		{
			e=T[e][s];
			s=inputTape.Next();
		}
		if(isAccepting(e))
		{
			String value =inputTape.getToken();//pas la peine de  readhead-1 cest implicite
			Token t=new Token(value,name); // le nom de l 'automate qui a servit a extraire le token
			return t;
		}
		inputTape.reset();
		return null;
	}

}
