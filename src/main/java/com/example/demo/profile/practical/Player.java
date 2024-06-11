package com.example.demo.profile.practical;

public class Player {
	int age;
	String name;
	int grade;

	public Player(int age, String name, int grade) {
		super();
		this.age = age;
		this.name = name;
		this.grade = grade;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	@Override
	public String toString() {
		return "Player [age=" + age + ", name=" + name + ", grade=" + grade + "]";
	}
}