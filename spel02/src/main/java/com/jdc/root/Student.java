package com.jdc.root;

import java.util.List;

public class Student {
	public String name;
	public int age;
	public List<String> interests;
	
	public Student(String name, int age, List<String> interests) {
		this.name = name;
		this.age = age;
		this.interests = interests;
	}
}
