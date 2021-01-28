package com.esisa.compiler.scanner;

public class ReservedWords {
	private String nom;
	private String list;

	public ReservedWords() {
		list = "";
	}

	public ReservedWords(String nom, String...words) {
		super();
		this.nom = nom;
		list = "";
		for (int i = 0; i < words.length; i++) {
			add(words[i]);
			
		}
	}

	public void add(String word) {
		list = list + "[" + word + "]";
	}
	
	public boolean contains(String word) {
		return list.contains("[" + word + "]");
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
}
