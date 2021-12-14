package com.example.model;

public class Model {
	private int id;
	private String name;
	private String category;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Model(int id, String name, String category) {
		this.id = id;
		this.name = name;
		this.category = category;
	}
	@Override
	public String toString() {
		return "Model [id=" + id + ", name=" + name + ", category=" + category + "]";
	}
	
	
	
	}


