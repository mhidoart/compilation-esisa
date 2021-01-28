package com.esisa.compiler.scanner;

public class ReservedWords {
	private String name;
	private String list;
	public ReservedWords() {
		list="";
	}
	public ReservedWords(String name) {
		super();
		this.name = name;
	}
	public ReservedWords(String name ,String ...words) {
		super();
		this.name = name;
		list="";
		for (int i = 0; i < words.length; i++) {
			add(words[i]);
		}
	}
	public void add(String word) {
		list=list + "[" + word + "]";
	}
	public boolean contains(String word) {
		// TODO Auto-generated method stub
		return list.contains("["+word+"]");
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getList() {
		return list;
	}
	public void setList(String list) {
		this.list = list;
	}
	
	
	
}
